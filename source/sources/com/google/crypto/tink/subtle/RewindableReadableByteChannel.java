package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer = null;
    boolean canRewind = true;
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.baseChannel = readableByteChannel;
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    public synchronized void rewind() throws IOException {
        if (this.canRewind) {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer != null) {
                byteBuffer.position(0);
            }
        } else {
            throw new IOException("Cannot rewind anymore.");
        }
    }

    private synchronized void setBufferLimit(int i) {
        if (this.buffer.capacity() < i) {
            int position = this.buffer.position();
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.buffer.capacity() * 2, i));
            this.buffer.rewind();
            allocate.put(this.buffer);
            allocate.position(position);
            this.buffer = allocate;
        }
        this.buffer.limit(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0075, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c8, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.directRead     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x000d
            java.nio.channels.ReadableByteChannel r0 = r6.baseChannel     // Catch:{ all -> 0x00c9 }
            int r7 = r0.read(r7)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r6)
            return r7
        L_0x000d:
            int r0 = r7.remaining()     // Catch:{ all -> 0x00c9 }
            if (r0 != 0) goto L_0x0016
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x0016:
            java.nio.ByteBuffer r1 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r2 = 1
            if (r1 != 0) goto L_0x0043
            boolean r1 = r6.canRewind     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x0029
            r6.directRead = r2     // Catch:{ all -> 0x00c9 }
            java.nio.channels.ReadableByteChannel r0 = r6.baseChannel     // Catch:{ all -> 0x00c9 }
            int r7 = r0.read(r7)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r6)
            return r7
        L_0x0029:
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x00c9 }
            r6.buffer = r0     // Catch:{ all -> 0x00c9 }
            java.nio.channels.ReadableByteChannel r1 = r6.baseChannel     // Catch:{ all -> 0x00c9 }
            int r0 = r1.read(r0)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r1 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r1.flip()     // Catch:{ all -> 0x00c9 }
            if (r0 <= 0) goto L_0x0041
            java.nio.ByteBuffer r1 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r7.put(r1)     // Catch:{ all -> 0x00c9 }
        L_0x0041:
            monitor-exit(r6)
            return r0
        L_0x0043:
            int r1 = r1.remaining()     // Catch:{ all -> 0x00c9 }
            r3 = 0
            if (r1 < r0) goto L_0x0076
            java.nio.ByteBuffer r1 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r1 = r1.limit()     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r4 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r5 = r4.position()     // Catch:{ all -> 0x00c9 }
            int r5 = r5 + r0
            r4.limit(r5)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r4 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r7.put(r4)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r7 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r7.limit(r1)     // Catch:{ all -> 0x00c9 }
            boolean r7 = r6.canRewind     // Catch:{ all -> 0x00c9 }
            if (r7 != 0) goto L_0x0074
            java.nio.ByteBuffer r7 = r6.buffer     // Catch:{ all -> 0x00c9 }
            boolean r7 = r7.hasRemaining()     // Catch:{ all -> 0x00c9 }
            if (r7 != 0) goto L_0x0074
            r6.buffer = r3     // Catch:{ all -> 0x00c9 }
            r6.directRead = r2     // Catch:{ all -> 0x00c9 }
        L_0x0074:
            monitor-exit(r6)
            return r0
        L_0x0076:
            java.nio.ByteBuffer r1 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r1 = r1.remaining()     // Catch:{ all -> 0x00c9 }
            int r0 = r0 - r1
            java.nio.ByteBuffer r4 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r4 = r4.position()     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r5 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r5 = r5.limit()     // Catch:{ all -> 0x00c9 }
            int r0 = r0 + r5
            r6.setBufferLimit(r0)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r0 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r0.position(r5)     // Catch:{ all -> 0x00c9 }
            java.nio.channels.ReadableByteChannel r0 = r6.baseChannel     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r5 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r0 = r0.read(r5)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r5 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r5.flip()     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r5 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r5.position(r4)     // Catch:{ all -> 0x00c9 }
            java.nio.ByteBuffer r5 = r6.buffer     // Catch:{ all -> 0x00c9 }
            r7.put(r5)     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x00b0
            if (r0 >= 0) goto L_0x00b0
            r7 = -1
            monitor-exit(r6)
            return r7
        L_0x00b0:
            java.nio.ByteBuffer r7 = r6.buffer     // Catch:{ all -> 0x00c9 }
            int r7 = r7.position()     // Catch:{ all -> 0x00c9 }
            int r7 = r7 - r4
            boolean r0 = r6.canRewind     // Catch:{ all -> 0x00c9 }
            if (r0 != 0) goto L_0x00c7
            java.nio.ByteBuffer r0 = r6.buffer     // Catch:{ all -> 0x00c9 }
            boolean r0 = r0.hasRemaining()     // Catch:{ all -> 0x00c9 }
            if (r0 != 0) goto L_0x00c7
            r6.buffer = r3     // Catch:{ all -> 0x00c9 }
            r6.directRead = r2     // Catch:{ all -> 0x00c9 }
        L_0x00c7:
            monitor-exit(r6)
            return r7
        L_0x00c9:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.RewindableReadableByteChannel.read(java.nio.ByteBuffer):int");
    }

    public synchronized void close() throws IOException {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }
}
