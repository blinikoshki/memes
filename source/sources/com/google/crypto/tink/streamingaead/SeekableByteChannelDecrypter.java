package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayDeque;
import java.util.Deque;

final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    SeekableByteChannel attemptingChannel = null;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    SeekableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();
    long startingPosition;

    public SeekableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        for (PrimitiveSet.Entry<StreamingAead> primitive : primitiveSet.getRawPrimitives()) {
            this.remainingPrimitives.add((StreamingAead) primitive.getPrimitive());
        }
        this.ciphertextChannel = seekableByteChannel;
        this.cachedPosition = -1;
        this.startingPosition = seekableByteChannel.position();
        this.associatedData = (byte[]) bArr.clone();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:5:0x0018, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.nio.channels.SeekableByteChannel nextAttemptingChannel() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
        L_0x0001:
            java.util.Deque<com.google.crypto.tink.StreamingAead> r0 = r6.remainingPrimitives     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x002d
            java.nio.channels.SeekableByteChannel r0 = r6.ciphertextChannel     // Catch:{ all -> 0x0035 }
            long r1 = r6.startingPosition     // Catch:{ all -> 0x0035 }
            r0.position(r1)     // Catch:{ all -> 0x0035 }
            java.util.Deque<com.google.crypto.tink.StreamingAead> r0 = r6.remainingPrimitives     // Catch:{ all -> 0x0035 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0035 }
            com.google.crypto.tink.StreamingAead r0 = (com.google.crypto.tink.StreamingAead) r0     // Catch:{ all -> 0x0035 }
            java.nio.channels.SeekableByteChannel r1 = r6.ciphertextChannel     // Catch:{ GeneralSecurityException -> 0x0001 }
            byte[] r2 = r6.associatedData     // Catch:{ GeneralSecurityException -> 0x0001 }
            java.nio.channels.SeekableByteChannel r0 = r0.newSeekableDecryptingChannel(r1, r2)     // Catch:{ GeneralSecurityException -> 0x0001 }
            long r1 = r6.cachedPosition     // Catch:{ GeneralSecurityException -> 0x0001 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x002b
            r0.position(r1)     // Catch:{ GeneralSecurityException -> 0x0001 }
        L_0x002b:
            monitor-exit(r6)
            return r0
        L_0x002d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "No matching key found for the ciphertext in the stream."
            r0.<init>(r1)     // Catch:{ all -> 0x0035 }
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.SeekableByteChannelDecrypter.nextAttemptingChannel():java.nio.channels.SeekableByteChannel");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0030, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r4.remaining()     // Catch:{ all -> 0x0038 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            java.nio.channels.SeekableByteChannel r0 = r3.matchingChannel     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0014
            int r4 = r0.read(r4)     // Catch:{ all -> 0x0038 }
            monitor-exit(r3)
            return r4
        L_0x0014:
            java.nio.channels.SeekableByteChannel r0 = r3.attemptingChannel     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x001e
            java.nio.channels.SeekableByteChannel r0 = r3.nextAttemptingChannel()     // Catch:{ all -> 0x0038 }
            r3.attemptingChannel = r0     // Catch:{ all -> 0x0038 }
        L_0x001e:
            java.nio.channels.SeekableByteChannel r0 = r3.attemptingChannel     // Catch:{ IOException -> 0x0031 }
            int r0 = r0.read(r4)     // Catch:{ IOException -> 0x0031 }
            if (r0 != 0) goto L_0x0028
            monitor-exit(r3)
            return r1
        L_0x0028:
            java.nio.channels.SeekableByteChannel r2 = r3.attemptingChannel     // Catch:{ IOException -> 0x0031 }
            r3.matchingChannel = r2     // Catch:{ IOException -> 0x0031 }
            r2 = 0
            r3.attemptingChannel = r2     // Catch:{ IOException -> 0x0031 }
            monitor-exit(r3)
            return r0
        L_0x0031:
            java.nio.channels.SeekableByteChannel r0 = r3.nextAttemptingChannel()     // Catch:{ all -> 0x0038 }
            r3.attemptingChannel = r0     // Catch:{ all -> 0x0038 }
            goto L_0x001e
        L_0x0038:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.SeekableByteChannelDecrypter.read(java.nio.ByteBuffer):int");
    }

    public synchronized SeekableByteChannel position(long j) throws IOException {
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            seekableByteChannel.position(j);
        } else if (j >= 0) {
            this.cachedPosition = j;
            SeekableByteChannel seekableByteChannel2 = this.attemptingChannel;
            if (seekableByteChannel2 != null) {
                seekableByteChannel2.position(j);
            }
        } else {
            throw new IllegalArgumentException("Position must be non-negative");
        }
        return this;
    }

    public synchronized long position() throws IOException {
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            return seekableByteChannel.position();
        }
        return this.cachedPosition;
    }

    public synchronized long size() throws IOException {
        SeekableByteChannel seekableByteChannel;
        seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
        } else {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return seekableByteChannel.size();
    }

    public SeekableByteChannel truncate(long j) throws IOException {
        throw new NonWritableChannelException();
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        throw new NonWritableChannelException();
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}
