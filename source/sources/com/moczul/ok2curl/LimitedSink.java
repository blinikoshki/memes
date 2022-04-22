package com.moczul.ok2curl;

import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public class LimitedSink implements Sink {
    private final Buffer limited;
    private long total;

    public LimitedSink(Buffer buffer, long j) {
        Objects.requireNonNull(buffer, "limited can not be null");
        if (j > 0) {
            this.limited = buffer;
            this.total = j;
            return;
        }
        throw new IllegalArgumentException("limit has to be grater than 0");
    }

    public void write(Buffer buffer, long j) throws IOException {
        long j2 = this.total;
        if (j2 > 0) {
            long min = Math.min(j2, j);
            this.limited.write(buffer, min);
            this.total -= min;
        }
    }

    public void flush() throws IOException {
        this.limited.flush();
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void close() throws IOException {
        this.limited.close();
    }
}
