package editor.gpu.gpuvideo.composer;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import editor.gpu.gpuvideo.composer.MuxRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class AudioComposer implements IAudioComposer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MediaFormat actualOutputFormat;
    private ByteBuffer buffer;
    private final MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private int bufferSize;
    private boolean isEOS;
    private final MediaExtractor mediaExtractor;
    private final MuxRender muxRender;
    private final MuxRender.SampleType sampleType;
    private final int trackIndex;
    private long writtenPresentationTimeUs;

    public void release() {
    }

    public void setup() {
    }

    AudioComposer(MediaExtractor mediaExtractor2, int i, MuxRender muxRender2) {
        MuxRender.SampleType sampleType2 = MuxRender.SampleType.AUDIO;
        this.sampleType = sampleType2;
        this.mediaExtractor = mediaExtractor2;
        this.trackIndex = i;
        this.muxRender = muxRender2;
        MediaFormat trackFormat = mediaExtractor2.getTrackFormat(i);
        this.actualOutputFormat = trackFormat;
        muxRender2.setOutputFormat(sampleType2, trackFormat);
        int integer = this.actualOutputFormat.getInteger("max-input-size");
        this.bufferSize = integer;
        this.buffer = ByteBuffer.allocateDirect(integer).order(ByteOrder.nativeOrder());
    }

    public boolean stepPipeline() {
        if (this.isEOS) {
            return false;
        }
        int sampleTrackIndex = this.mediaExtractor.getSampleTrackIndex();
        if (sampleTrackIndex < 0) {
            this.buffer.clear();
            this.bufferInfo.set(0, 0, 0, 4);
            this.muxRender.writeSampleData(this.sampleType, this.buffer, this.bufferInfo);
            this.isEOS = true;
            return true;
        } else if (sampleTrackIndex != this.trackIndex) {
            return false;
        } else {
            this.buffer.clear();
            this.bufferInfo.set(0, this.mediaExtractor.readSampleData(this.buffer, 0), this.mediaExtractor.getSampleTime(), (this.mediaExtractor.getSampleFlags() & 1) != 0 ? 1 : 0);
            this.muxRender.writeSampleData(this.sampleType, this.buffer, this.bufferInfo);
            this.writtenPresentationTimeUs = this.bufferInfo.presentationTimeUs;
            this.mediaExtractor.advance();
            return true;
        }
    }

    public long getWrittenPresentationTimeUs() {
        return this.writtenPresentationTimeUs;
    }

    public boolean isFinished() {
        return this.isEOS;
    }
}
