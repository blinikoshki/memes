package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

final class C2Mp3TimestampTracker {
    private static final long DECODER_DELAY_SAMPLES = 529;
    private static final String TAG = "C2Mp3TimestampTracker";
    private long anchorTimestampUs;
    private long processedSamples;
    private boolean seenInvalidMpegAudioHeader;

    C2Mp3TimestampTracker() {
    }

    public void reset() {
        this.processedSamples = 0;
        this.anchorTimestampUs = 0;
        this.seenInvalidMpegAudioHeader = false;
    }

    public long updateAndGetPresentationTimeUs(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.seenInvalidMpegAudioHeader) {
            return decoderInputBuffer.timeUs;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        byte b = 0;
        for (int i = 0; i < 4; i++) {
            b = (b << 8) | (byteBuffer.get(i) & 255);
        }
        int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(b);
        if (parseMpegAudioFrameSampleCount == -1) {
            this.seenInvalidMpegAudioHeader = true;
            Log.m358w(TAG, "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        } else if (this.processedSamples == 0) {
            long j = decoderInputBuffer.timeUs;
            this.anchorTimestampUs = j;
            this.processedSamples = ((long) parseMpegAudioFrameSampleCount) - DECODER_DELAY_SAMPLES;
            return j;
        } else {
            long processedDurationUs = getProcessedDurationUs(format);
            this.processedSamples += (long) parseMpegAudioFrameSampleCount;
            return this.anchorTimestampUs + processedDurationUs;
        }
    }

    private long getProcessedDurationUs(Format format) {
        return (this.processedSamples * 1000000) / ((long) format.sampleRate);
    }
}
