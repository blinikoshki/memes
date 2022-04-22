package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayDeque;
import java.util.Deque;

final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    ReadableByteChannel attemptingChannel = null;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        for (PrimitiveSet.Entry<StreamingAead> primitive : primitiveSet.getRawPrimitives()) {
            this.remainingPrimitives.add((StreamingAead) primitive.getPrimitive());
        }
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3.ciphertextChannel.rewind();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.nio.channels.ReadableByteChannel nextAttemptingChannel() throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
        L_0x0001:
            java.util.Deque<com.google.crypto.tink.StreamingAead> r0 = r3.remainingPrimitives     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0021
            java.util.Deque<com.google.crypto.tink.StreamingAead> r0 = r3.remainingPrimitives     // Catch:{ all -> 0x0029 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0029 }
            com.google.crypto.tink.StreamingAead r0 = (com.google.crypto.tink.StreamingAead) r0     // Catch:{ all -> 0x0029 }
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r1 = r3.ciphertextChannel     // Catch:{ GeneralSecurityException -> 0x001b }
            byte[] r2 = r3.associatedData     // Catch:{ GeneralSecurityException -> 0x001b }
            java.nio.channels.ReadableByteChannel r0 = r0.newDecryptingChannel(r1, r2)     // Catch:{ GeneralSecurityException -> 0x001b }
            monitor-exit(r3)
            return r0
        L_0x001b:
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r0 = r3.ciphertextChannel     // Catch:{ all -> 0x0029 }
            r0.rewind()     // Catch:{ all -> 0x0029 }
            goto L_0x0001
        L_0x0021:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = "No matching key found for the ciphertext in the stream."
            r0.<init>(r1)     // Catch:{ all -> 0x0029 }
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.ReadableByteChannelDecrypter.nextAttemptingChannel():java.nio.channels.ReadableByteChannel");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(java.nio.ByteBuffer r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r4.remaining()     // Catch:{ all -> 0x0042 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            java.nio.channels.ReadableByteChannel r0 = r3.matchingChannel     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0014
            int r4 = r0.read(r4)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return r4
        L_0x0014:
            java.nio.channels.ReadableByteChannel r0 = r3.attemptingChannel     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x001e
            java.nio.channels.ReadableByteChannel r0 = r3.nextAttemptingChannel()     // Catch:{ all -> 0x0042 }
            r3.attemptingChannel = r0     // Catch:{ all -> 0x0042 }
        L_0x001e:
            java.nio.channels.ReadableByteChannel r0 = r3.attemptingChannel     // Catch:{ IOException -> 0x0036 }
            int r0 = r0.read(r4)     // Catch:{ IOException -> 0x0036 }
            if (r0 != 0) goto L_0x0028
            monitor-exit(r3)
            return r1
        L_0x0028:
            java.nio.channels.ReadableByteChannel r2 = r3.attemptingChannel     // Catch:{ IOException -> 0x0036 }
            r3.matchingChannel = r2     // Catch:{ IOException -> 0x0036 }
            r2 = 0
            r3.attemptingChannel = r2     // Catch:{ IOException -> 0x0036 }
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r2 = r3.ciphertextChannel     // Catch:{ IOException -> 0x0036 }
            r2.disableRewinding()     // Catch:{ IOException -> 0x0036 }
            monitor-exit(r3)
            return r0
        L_0x0036:
            com.google.crypto.tink.subtle.RewindableReadableByteChannel r0 = r3.ciphertextChannel     // Catch:{ all -> 0x0042 }
            r0.rewind()     // Catch:{ all -> 0x0042 }
            java.nio.channels.ReadableByteChannel r0 = r3.nextAttemptingChannel()     // Catch:{ all -> 0x0042 }
            r3.attemptingChannel = r0     // Catch:{ all -> 0x0042 }
            goto L_0x001e
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.ReadableByteChannelDecrypter.read(java.nio.ByteBuffer):int");
    }

    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}
