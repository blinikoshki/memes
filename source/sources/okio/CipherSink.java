package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "blockSize", "", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "close", "", "doFinal", "", "flush", "timeout", "Lokio/Timeout;", "update", "source", "Lokio/Buffer;", "remaining", "", "write", "byteCount", "okio"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: CipherSink.kt */
public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink bufferedSink, Cipher cipher2) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Intrinsics.checkNotNullParameter(cipher2, "cipher");
        this.sink = bufferedSink;
        this.cipher = cipher2;
        int blockSize2 = cipher2.getBlockSize();
        this.blockSize = blockSize2;
        if (!(blockSize2 > 0)) {
            throw new IllegalArgumentException(("Block cipher required " + cipher2).toString());
        }
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public void write(Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j);
        if (!this.closed) {
            while (j > 0) {
                j -= (long) update(buffer, j);
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    private final int update(Buffer buffer, long j) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
        Buffer buffer2 = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(min);
        while (outputSize > 8192) {
            int i = this.blockSize;
            if (min > i) {
                min -= i;
                outputSize = this.cipher.getOutputSize(min);
            } else {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + min).toString());
            }
        }
        Segment writableSegment$okio = buffer2.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
        writableSegment$okio.limit += update;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer2.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        this.sink.emitCompleteSegments();
        buffer.setSize$okio(buffer.size() - ((long) min));
        segment.pos += min;
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public void flush() {
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            Throwable doFinal = doFinal();
            try {
                this.sink.close();
            } catch (Throwable th) {
                if (doFinal == null) {
                    doFinal = th;
                }
            }
            if (doFinal != null) {
                throw doFinal;
            }
        }
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return null;
        }
        Throwable th = null;
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal;
            buffer.setSize$okio(buffer.size() + ((long) doFinal));
        } catch (Throwable th2) {
            th = th2;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }
}
