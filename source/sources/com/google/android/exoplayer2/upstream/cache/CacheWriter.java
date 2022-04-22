package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    private final boolean allowShortContent;
    private long bytesCached;
    private final Cache cache;
    private final String cacheKey;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private long endPosition;
    private boolean initialized;
    private volatile boolean isCanceled;
    private long nextPosition;
    private final ProgressListener progressListener;
    private final byte[] temporaryBuffer;

    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec2, boolean z, byte[] bArr, ProgressListener progressListener2) {
        this.dataSource = cacheDataSource;
        this.cache = cacheDataSource.getCache();
        this.dataSpec = dataSpec2;
        this.allowShortContent = z;
        this.temporaryBuffer = bArr == null ? new byte[131072] : bArr;
        this.progressListener = progressListener2;
        this.cacheKey = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec2);
        this.nextPosition = dataSpec2.position;
    }

    public void cancel() {
        this.isCanceled = true;
    }

    public void cache() throws IOException {
        throwIfCanceled();
        if (!this.initialized) {
            if (this.dataSpec.length != -1) {
                this.endPosition = this.dataSpec.position + this.dataSpec.length;
            } else {
                long contentLength = ContentMetadata.CC.getContentLength(this.cache.getContentMetadata(this.cacheKey));
                if (contentLength == -1) {
                    contentLength = -1;
                }
                this.endPosition = contentLength;
            }
            this.bytesCached = this.cache.getCachedBytes(this.cacheKey, this.dataSpec.position, this.dataSpec.length);
            ProgressListener progressListener2 = this.progressListener;
            if (progressListener2 != null) {
                progressListener2.onProgress(getLength(), this.bytesCached, 0);
            }
            this.initialized = true;
        }
        while (true) {
            long j = this.endPosition;
            if (j == -1 || this.nextPosition < j) {
                throwIfCanceled();
                long j2 = this.endPosition;
                long cachedLength = this.cache.getCachedLength(this.cacheKey, this.nextPosition, j2 == -1 ? Long.MAX_VALUE : j2 - this.nextPosition);
                if (cachedLength > 0) {
                    this.nextPosition += cachedLength;
                } else {
                    long j3 = -cachedLength;
                    if (j3 == Long.MAX_VALUE) {
                        j3 = -1;
                    }
                    long j4 = this.nextPosition;
                    this.nextPosition = j4 + readBlockToCache(j4, j3);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[Catch:{ IOException -> 0x0033, all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ IOException -> 0x0033, all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b A[Catch:{ IOException -> 0x0033, all -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long readBlockToCache(long r10, long r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.endPosition
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0013
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0047
            com.google.android.exoplayer2.upstream.DataSpec r1 = r9.dataSpec     // Catch:{ IOException -> 0x0033 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.buildUpon()     // Catch:{ IOException -> 0x0033 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.setPosition(r10)     // Catch:{ IOException -> 0x0033 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r1.setLength(r12)     // Catch:{ IOException -> 0x0033 }
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.build()     // Catch:{ IOException -> 0x0033 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.dataSource     // Catch:{ IOException -> 0x0033 }
            long r12 = r13.open(r12)     // Catch:{ IOException -> 0x0033 }
            goto L_0x0049
        L_0x0031:
            r10 = move-exception
            goto L_0x0091
        L_0x0033:
            r12 = move-exception
            boolean r13 = r9.allowShortContent     // Catch:{ all -> 0x0031 }
            if (r13 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x0046
            boolean r13 = com.google.android.exoplayer2.upstream.DataSourceException.isCausedByPositionOutOfRange(r12)     // Catch:{ all -> 0x0031 }
            if (r13 == 0) goto L_0x0046
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.dataSource     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r12)     // Catch:{ all -> 0x0031 }
            goto L_0x0047
        L_0x0046:
            throw r12     // Catch:{ all -> 0x0031 }
        L_0x0047:
            r12 = r6
            r4 = 0
        L_0x0049:
            if (r4 != 0) goto L_0x0066
            r9.throwIfCanceled()     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.DataSpec r12 = r9.dataSpec     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.buildUpon()     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.setPosition(r10)     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.setLength(r6)     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.build()     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.dataSource     // Catch:{ all -> 0x0031 }
            long r12 = r13.open(r12)     // Catch:{ all -> 0x0031 }
        L_0x0066:
            if (r0 == 0) goto L_0x0070
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0070
            long r12 = r12 + r10
            r9.onRequestEndPosition(r12)     // Catch:{ all -> 0x0031 }
        L_0x0070:
            r12 = 0
            r13 = 0
        L_0x0072:
            r1 = -1
            if (r12 == r1) goto L_0x0089
            r9.throwIfCanceled()     // Catch:{ all -> 0x0031 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.dataSource     // Catch:{ all -> 0x0031 }
            byte[] r2 = r9.temporaryBuffer     // Catch:{ all -> 0x0031 }
            int r3 = r2.length     // Catch:{ all -> 0x0031 }
            int r12 = r12.read(r2, r5, r3)     // Catch:{ all -> 0x0031 }
            if (r12 == r1) goto L_0x0072
            long r1 = (long) r12     // Catch:{ all -> 0x0031 }
            r9.onNewBytesCached(r1)     // Catch:{ all -> 0x0031 }
            int r13 = r13 + r12
            goto L_0x0072
        L_0x0089:
            if (r0 == 0) goto L_0x0097
            long r0 = (long) r13     // Catch:{ all -> 0x0031 }
            long r10 = r10 + r0
            r9.onRequestEndPosition(r10)     // Catch:{ all -> 0x0031 }
            goto L_0x0097
        L_0x0091:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r11 = r9.dataSource
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r11)
            throw r10
        L_0x0097:
            long r10 = (long) r13
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.dataSource
            com.google.android.exoplayer2.util.Util.closeQuietly((com.google.android.exoplayer2.upstream.DataSource) r12)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheWriter.readBlockToCache(long, long):long");
    }

    private void onRequestEndPosition(long j) {
        if (this.endPosition != j) {
            this.endPosition = j;
            ProgressListener progressListener2 = this.progressListener;
            if (progressListener2 != null) {
                progressListener2.onProgress(getLength(), this.bytesCached, 0);
            }
        }
    }

    private void onNewBytesCached(long j) {
        this.bytesCached += j;
        ProgressListener progressListener2 = this.progressListener;
        if (progressListener2 != null) {
            progressListener2.onProgress(getLength(), this.bytesCached, j);
        }
    }

    private long getLength() {
        long j = this.endPosition;
        if (j == -1) {
            return -1;
        }
        return j - this.dataSpec.position;
    }

    private void throwIfCanceled() throws InterruptedIOException {
        if (this.isCanceled) {
            throw new InterruptedIOException();
        }
    }
}
