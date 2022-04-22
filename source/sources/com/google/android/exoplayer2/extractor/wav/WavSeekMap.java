package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

final class WavSeekMap implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavHeader wavHeader;

    public boolean isSeekable() {
        return true;
    }

    public WavSeekMap(WavHeader wavHeader2, int i, long j, long j2) {
        this.wavHeader = wavHeader2;
        this.framesPerBlock = i;
        this.firstBlockPosition = j;
        long j3 = (j2 - j) / ((long) wavHeader2.blockSize);
        this.blockCount = j3;
        this.durationUs = blockIndexToTimeUs(j3);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j) {
        long constrainValue = Util.constrainValue((((long) this.wavHeader.frameRateHz) * j) / (((long) this.framesPerBlock) * 1000000), 0, this.blockCount - 1);
        long j2 = this.firstBlockPosition + (((long) this.wavHeader.blockSize) * constrainValue);
        long blockIndexToTimeUs = blockIndexToTimeUs(constrainValue);
        SeekPoint seekPoint = new SeekPoint(blockIndexToTimeUs, j2);
        if (blockIndexToTimeUs >= j || constrainValue == this.blockCount - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j3 = constrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(blockIndexToTimeUs(j3), this.firstBlockPosition + (((long) this.wavHeader.blockSize) * j3)));
    }

    private long blockIndexToTimeUs(long j) {
        return Util.scaleLargeTimestamp(j * ((long) this.framesPerBlock), 1000000, (long) this.wavHeader.frameRateHz);
    }
}
