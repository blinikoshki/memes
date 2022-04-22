package editor.gpu.gpuvideo.composer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import editor.gpu.gpuvideo.composer.MuxRender;
import java.io.IOException;

class RemixAudioComposer implements IAudioComposer {
    private static final int DRAIN_STATE_CONSUMED = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SHOULD_RETRY_IMMEDIATELY = 1;
    private static final MuxRender.SampleType SAMPLE_TYPE = MuxRender.SampleType.AUDIO;
    private MediaFormat actualOutputFormat;
    private AudioChannel audioChannel;
    private final MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec decoder;
    private MediaCodecBufferCompatWrapper decoderBuffers;
    private boolean decoderStarted;
    private MediaCodec encoder;
    private MediaCodecBufferCompatWrapper encoderBuffers;
    private boolean encoderStarted;
    private final MediaExtractor extractor;
    private boolean isDecoderEOS;
    private boolean isEncoderEOS;
    private boolean isExtractorEOS;
    private int muxCount = 1;
    private final MuxRender muxer;
    private final MediaFormat outputFormat;
    private final int timeScale;
    private final int trackIndex;
    private long writtenPresentationTimeUs;

    public RemixAudioComposer(MediaExtractor mediaExtractor, int i, MediaFormat mediaFormat, MuxRender muxRender, int i2) {
        this.extractor = mediaExtractor;
        this.trackIndex = i;
        this.outputFormat = mediaFormat;
        this.muxer = muxRender;
        this.timeScale = i2;
    }

    public void setup() {
        this.extractor.selectTrack(this.trackIndex);
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.outputFormat.getString("mime"));
            this.encoder = createEncoderByType;
            createEncoderByType.configure(this.outputFormat, (Surface) null, (MediaCrypto) null, 1);
            this.encoder.start();
            this.encoderStarted = true;
            this.encoderBuffers = new MediaCodecBufferCompatWrapper(this.encoder);
            MediaFormat trackFormat = this.extractor.getTrackFormat(this.trackIndex);
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                this.decoder = createDecoderByType;
                createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                this.decoder.start();
                this.decoderStarted = true;
                this.decoderBuffers = new MediaCodecBufferCompatWrapper(this.decoder);
                this.audioChannel = new AudioChannel(this.decoder, this.encoder, this.outputFormat);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public boolean stepPipeline() {
        int drainDecoder;
        boolean z = false;
        while (drainEncoder(0) != 0) {
            z = true;
        }
        do {
            drainDecoder = drainDecoder(0);
            if (drainDecoder != 0) {
                z = true;
                continue;
            }
        } while (drainDecoder == 1);
        while (this.audioChannel.feedEncoder(0)) {
            z = true;
        }
        while (drainExtractor(0) != 0) {
            z = true;
        }
        return z;
    }

    private int drainExtractor(long j) {
        int dequeueInputBuffer;
        if (this.isExtractorEOS) {
            return 0;
        }
        int sampleTrackIndex = this.extractor.getSampleTrackIndex();
        if ((sampleTrackIndex >= 0 && sampleTrackIndex != this.trackIndex) || (dequeueInputBuffer = this.decoder.dequeueInputBuffer(j)) < 0) {
            return 0;
        }
        if (sampleTrackIndex < 0) {
            this.isExtractorEOS = true;
            this.decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
            return 0;
        }
        this.decoder.queueInputBuffer(dequeueInputBuffer, 0, this.extractor.readSampleData(this.decoderBuffers.getInputBuffer(dequeueInputBuffer), 0), this.extractor.getSampleTime(), (this.extractor.getSampleFlags() & 1) != 0 ? 1 : 0);
        this.extractor.advance();
        return 2;
    }

    private int drainDecoder(long j) {
        if (this.isDecoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.bufferInfo, j);
        if (dequeueOutputBuffer != -3) {
            if (dequeueOutputBuffer == -2) {
                this.audioChannel.setActualDecodedFormat(this.decoder.getOutputFormat());
            } else if (dequeueOutputBuffer == -1) {
                return 0;
            } else {
                if ((this.bufferInfo.flags & 4) != 0) {
                    this.isDecoderEOS = true;
                    this.audioChannel.drainDecoderBufferAndQueue(-1, 0);
                    return 2;
                } else if (this.bufferInfo.size <= 0) {
                    return 2;
                } else {
                    this.audioChannel.drainDecoderBufferAndQueue(dequeueOutputBuffer, this.bufferInfo.presentationTimeUs / ((long) this.timeScale));
                    return 2;
                }
            }
        }
        return 1;
    }

    private int drainEncoder(long j) {
        if (this.isEncoderEOS) {
            return 0;
        }
        int dequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.bufferInfo, j);
        if (dequeueOutputBuffer == -3) {
            this.encoderBuffers = new MediaCodecBufferCompatWrapper(this.encoder);
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
                if (this.muxCount == 1) {
                    this.muxer.writeSampleData(SAMPLE_TYPE, this.encoderBuffers.getOutputBuffer(dequeueOutputBuffer), this.bufferInfo);
                }
                int i = this.muxCount;
                if (i < this.timeScale) {
                    this.muxCount = i + 1;
                } else {
                    this.muxCount = 1;
                }
                this.writtenPresentationTimeUs = this.bufferInfo.presentationTimeUs;
                this.encoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return 2;
            }
            throw new RuntimeException("Could not determine actual output format.");
        } else if (this.actualOutputFormat == null) {
            MediaFormat outputFormat2 = this.encoder.getOutputFormat();
            this.actualOutputFormat = outputFormat2;
            this.muxer.setOutputFormat(SAMPLE_TYPE, outputFormat2);
            return 1;
        } else {
            throw new RuntimeException("Audio output format changed twice.");
        }
    }

    public long getWrittenPresentationTimeUs() {
        return this.writtenPresentationTimeUs;
    }

    public boolean isFinished() {
        return this.isEncoderEOS;
    }

    public void release() {
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
}
