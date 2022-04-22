package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class BatchBuffer extends DecoderInputBuffer {
    private static final int BATCH_SIZE_BYTES = 3072000;
    public static final int DEFAULT_BATCH_SIZE_ACCESS_UNITS = 32;
    private int accessUnitCount;
    private long firstAccessUnitTimeUs;
    private boolean hasPendingAccessUnit;
    private int maxAccessUnitCount;
    private final DecoderInputBuffer nextAccessUnitBuffer = new DecoderInputBuffer(2);

    public BatchBuffer() {
        super(2);
        clear();
    }

    public void setMaxAccessUnitCount(int i) {
        Assertions.checkArgument(i > 0);
        this.maxAccessUnitCount = i;
    }

    public int getMaxAccessUnitCount() {
        return this.maxAccessUnitCount;
    }

    public void clear() {
        flush();
        this.maxAccessUnitCount = 32;
    }

    public void flush() {
        clearMainBuffer();
        this.nextAccessUnitBuffer.clear();
        this.hasPendingAccessUnit = false;
    }

    public void batchWasConsumed() {
        clearMainBuffer();
        if (this.hasPendingAccessUnit) {
            putAccessUnit(this.nextAccessUnitBuffer);
            this.hasPendingAccessUnit = false;
        }
    }

    public DecoderInputBuffer getNextAccessUnitBuffer() {
        return this.nextAccessUnitBuffer;
    }

    public long getFirstAccessUnitTimeUs() {
        return this.firstAccessUnitTimeUs;
    }

    public long getLastAccessUnitTimeUs() {
        return this.timeUs;
    }

    public int getAccessUnitCount() {
        return this.accessUnitCount;
    }

    public boolean isEmpty() {
        return this.accessUnitCount == 0;
    }

    public boolean isFull() {
        return this.accessUnitCount >= this.maxAccessUnitCount || (this.data != null && this.data.position() >= BATCH_SIZE_BYTES) || this.hasPendingAccessUnit;
    }

    public void commitNextAccessUnit() {
        DecoderInputBuffer decoderInputBuffer = this.nextAccessUnitBuffer;
        boolean z = false;
        Assertions.checkState(!isFull() && !isEndOfStream());
        if (!decoderInputBuffer.isEncrypted() && !decoderInputBuffer.hasSupplementalData()) {
            z = true;
        }
        Assertions.checkArgument(z);
        if (!canBatch(decoderInputBuffer)) {
            this.hasPendingAccessUnit = true;
        } else {
            putAccessUnit(decoderInputBuffer);
        }
    }

    private boolean canBatch(DecoderInputBuffer decoderInputBuffer) {
        if (isEmpty()) {
            return true;
        }
        if (decoderInputBuffer.isDecodeOnly() != isDecodeOnly()) {
            return false;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer == null || this.data == null || this.data.position() + byteBuffer.limit() < BATCH_SIZE_BYTES) {
            return true;
        }
        return false;
    }

    private void putAccessUnit(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer != null) {
            decoderInputBuffer.flip();
            ensureSpaceForWrite(byteBuffer.remaining());
            this.data.put(byteBuffer);
        }
        if (decoderInputBuffer.isEndOfStream()) {
            setFlags(4);
        }
        if (decoderInputBuffer.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (decoderInputBuffer.isKeyFrame()) {
            setFlags(1);
        }
        this.accessUnitCount++;
        this.timeUs = decoderInputBuffer.timeUs;
        if (this.accessUnitCount == 1) {
            this.firstAccessUnitTimeUs = this.timeUs;
        }
        decoderInputBuffer.clear();
    }

    private void clearMainBuffer() {
        super.clear();
        this.accessUnitCount = 0;
        this.firstAccessUnitTimeUs = C1844C.TIME_UNSET;
        this.timeUs = C1844C.TIME_UNSET;
    }
}
