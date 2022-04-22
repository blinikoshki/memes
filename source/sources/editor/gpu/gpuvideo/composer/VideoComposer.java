package editor.gpu.gpuvideo.composer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Size;
import android.view.Surface;
import editor.gpu.gpuvideo.composer.MuxRender;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import java.io.IOException;
import java.nio.ByteBuffer;

class VideoComposer {
    private static final int DRAIN_STATE_CONSUMED = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SHOULD_RETRY_IMMEDIATELY = 1;
    private static final String TAG = "VideoComposer";
    private MediaFormat actualOutputFormat;
    private final MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec decoder;
    private ByteBuffer[] decoderInputBuffers;
    private boolean decoderStarted;
    private DecoderSurface decoderSurface;
    private MediaCodec encoder;
    private ByteBuffer[] encoderOutputBuffers;
    private boolean encoderStarted;
    private EncoderSurface encoderSurface;
    private boolean isDecoderEOS;
    private boolean isEncoderEOS;
    private boolean isExtractorEOS;
    private final MediaExtractor mediaExtractor;
    private final MuxRender muxRender;
    private final MediaFormat outputFormat;
    private final int timeScale;
    private final int trackIndex;
    private long writtenPresentationTimeUs;

    VideoComposer(MediaExtractor mediaExtractor2, int i, MediaFormat mediaFormat, MuxRender muxRender2, int i2) {
        this.mediaExtractor = mediaExtractor2;
        this.trackIndex = i;
        this.outputFormat = mediaFormat;
        this.muxRender = muxRender2;
        this.timeScale = i2;
    }

    /* access modifiers changed from: package-private */
    public void setUp(GlVideoFilter glVideoFilter, Rotation rotation, Size size, Size size2, FillMode fillMode, FillModeCustomItem fillModeCustomItem, boolean z, boolean z2) {
        this.mediaExtractor.selectTrack(this.trackIndex);
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.outputFormat.getString("mime"));
            this.encoder = createEncoderByType;
            createEncoderByType.configure(this.outputFormat, (Surface) null, (MediaCrypto) null, 1);
            EncoderSurface encoderSurface2 = new EncoderSurface(this.encoder.createInputSurface());
            this.encoderSurface = encoderSurface2;
            encoderSurface2.makeCurrent();
            this.encoder.start();
            this.encoderStarted = true;
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            MediaFormat trackFormat = this.mediaExtractor.getTrackFormat(this.trackIndex);
            if (trackFormat.containsKey("rotation-degrees")) {
                trackFormat.setInteger("rotation-degrees", 0);
            }
            DecoderSurface decoderSurface2 = new DecoderSurface(glVideoFilter);
            this.decoderSurface = decoderSurface2;
            decoderSurface2.setRotation(rotation);
            this.decoderSurface.setOutputResolution(size);
            this.decoderSurface.setInputResolution(size2);
            this.decoderSurface.setFillMode(fillMode);
            this.decoderSurface.setFillModeCustomItem(fillModeCustomItem);
            this.decoderSurface.setFlipHorizontal(z2);
            this.decoderSurface.setFlipVertical(z);
            this.decoderSurface.completeParams();
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                this.decoder = createDecoderByType;
                createDecoderByType.configure(trackFormat, this.decoderSurface.getSurface(), (MediaCrypto) null, 0);
                this.decoder.start();
                this.decoderStarted = true;
                this.decoderInputBuffers = this.decoder.getInputBuffers();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean stepPipeline() {
        int drainDecoder;
        boolean z = false;
        while (drainEncoder() != 0) {
            z = true;
        }
        do {
            drainDecoder = drainDecoder();
            if (drainDecoder != 0) {
                z = true;
                continue;
            }
        } while (drainDecoder == 1);
        while (drainExtractor() != 0) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public long getWrittenPresentationTimeUs() {
        return this.writtenPresentationTimeUs;
    }

    /* access modifiers changed from: package-private */
    public boolean isFinished() {
        return this.isEncoderEOS;
    }

    /* access modifiers changed from: package-private */
    public void release() {
        DecoderSurface decoderSurface2 = this.decoderSurface;
        if (decoderSurface2 != null) {
            decoderSurface2.release();
            this.decoderSurface = null;
        }
        EncoderSurface encoderSurface2 = this.encoderSurface;
        if (encoderSurface2 != null) {
            encoderSurface2.release();
            this.encoderSurface = null;
        }
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            if (this.decoderStarted) {
                mediaCodec.stop();
            }
            this.decoder.release();
            this.decoder = null;
        }
        MediaCodec mediaCodec2 = this.encoder;
        if (mediaCodec2 != null) {
            if (this.encoderStarted) {
                mediaCodec2.stop();
            }
            this.encoder.release();
            this.encoder = null;
        }
    }

    private int drainExtractor() {
        int dequeueInputBuffer;
        if (this.isExtractorEOS) {
            return 0;
        }
        int sampleTrackIndex = this.mediaExtractor.getSampleTrackIndex();
        if ((sampleTrackIndex >= 0 && sampleTrackIndex != this.trackIndex) || (dequeueInputBuffer = this.decoder.dequeueInputBuffer(0)) < 0) {
            return 0;
        }
        if (sampleTrackIndex < 0) {
            this.isExtractorEOS = true;
            this.decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
            return 0;
        }
        this.decoder.queueInputBuffer(dequeueInputBuffer, 0, this.mediaExtractor.readSampleData(this.decoderInputBuffers[dequeueInputBuffer], 0), this.mediaExtractor.getSampleTime() / ((long) this.timeScale), (this.mediaExtractor.getSampleFlags() & 1) != 0 ? 1 : 0);
        this.mediaExtractor.advance();
        return 2;
    }

    private int drainDecoder() {
        boolean z = false;
        if (this.isDecoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.bufferInfo, 0);
        if (dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2) {
            return 1;
        }
        if (dequeueOutputBuffer == -1) {
            return 0;
        }
        if ((this.bufferInfo.flags & 4) != 0) {
            this.encoder.signalEndOfInputStream();
            this.isDecoderEOS = true;
            this.bufferInfo.size = 0;
        }
        if (this.bufferInfo.size > 0) {
            z = true;
        }
        this.decoder.releaseOutputBuffer(dequeueOutputBuffer, z);
        if (!z) {
            return 2;
        }
        this.decoderSurface.awaitNewImage();
        this.decoderSurface.drawImage();
        this.encoderSurface.setPresentationTime(this.bufferInfo.presentationTimeUs * 1000);
        this.encoderSurface.swapBuffers();
        return 2;
    }

    private int drainEncoder() {
        if (this.isEncoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.bufferInfo, 0);
        if (dequeueOutputBuffer == -3) {
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            return 1;
        } else if (dequeueOutputBuffer != -2) {
            if (dequeueOutputBuffer == -1) {
                return 0;
            }
            if (this.actualOutputFormat != null) {
                if ((this.bufferInfo.flags & 4) != 0) {
                    this.isEncoderEOS = true;
                    MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                    bufferInfo2.set(0, 0, 0, bufferInfo2.flags);
                }
                if ((this.bufferInfo.flags & 2) != 0) {
                    this.encoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return 1;
                }
                this.muxRender.writeSampleData(MuxRender.SampleType.VIDEO, this.encoderOutputBuffers[dequeueOutputBuffer], this.bufferInfo);
                this.writtenPresentationTimeUs = this.bufferInfo.presentationTimeUs;
                this.encoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return 2;
            }
            throw new RuntimeException("Could not determine actual output format.");
        } else if (this.actualOutputFormat == null) {
            this.actualOutputFormat = this.encoder.getOutputFormat();
            this.muxRender.setOutputFormat(MuxRender.SampleType.VIDEO, this.actualOutputFormat);
            this.muxRender.onSetOutputFormat();
            return 1;
        } else {
            throw new RuntimeException("Video output format changed twice.");
        }
    }
}
