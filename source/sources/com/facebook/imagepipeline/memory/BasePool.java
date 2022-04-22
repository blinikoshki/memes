package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class BasePool<V> implements Pool<V> {
    private final Class<?> TAG;
    private boolean mAllowNewBuckets;
    final SparseArray<Bucket<V>> mBuckets;
    final Counter mFree;
    private boolean mIgnoreHardCap;
    final Set<V> mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    final Counter mUsed;

    /* access modifiers changed from: protected */
    public abstract V alloc(int i);

    /* access modifiers changed from: protected */
    public abstract void free(V v);

    /* access modifiers changed from: protected */
    public abstract int getBucketedSize(int i);

    /* access modifiers changed from: protected */
    public abstract int getBucketedSizeForValue(V v);

    /* access modifiers changed from: protected */
    public abstract int getSizeInBytes(int i);

    /* access modifiers changed from: protected */
    public void onParamsChanged() {
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        PoolParams poolParams2 = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolParams = poolParams2;
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray<>();
        if (poolParams2.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(0));
        }
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.mIgnoreHardCap = z;
    }

    /* access modifiers changed from: protected */
    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public synchronized V getValue(Bucket<V> bucket) {
        return bucket.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = alloc(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5.mUsed.decrement(r2);
        r4 = getBucket(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r4 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r4.decrementInUseCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        com.facebook.common.internal.Throwables.propagateIfPossible(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.facebook.common.internal.Preconditions.checkState(r5.mInUseValues.add(r0));
        trimToSoftCap();
        r5.mPoolStatsTracker.onAlloc(r2);
        logStats();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (com.facebook.common.logging.FLog.isLoggable(2) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        com.facebook.common.logging.FLog.m79v(r5.TAG, "get (alloc) (object, size) = (%x, %s)", (java.lang.Object) java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), (java.lang.Object) java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(int r6) {
        /*
            r5 = this;
            r5.ensurePoolSizeInvariant()
            int r6 = r5.getBucketedSize(r6)
            monitor-enter(r5)
            com.facebook.imagepipeline.memory.Bucket r0 = r5.getBucket(r6)     // Catch:{ all -> 0x00ca }
            r1 = 2
            if (r0 == 0) goto L_0x0053
            java.lang.Object r2 = r5.getValue(r0)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0053
            java.util.Set<V> r6 = r5.mInUseValues     // Catch:{ all -> 0x00ca }
            boolean r6 = r6.add(r2)     // Catch:{ all -> 0x00ca }
            com.facebook.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x00ca }
            int r6 = r5.getBucketedSizeForValue(r2)     // Catch:{ all -> 0x00ca }
            int r0 = r5.getSizeInBytes(r6)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mFree     // Catch:{ all -> 0x00ca }
            r3.decrement(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r5.mPoolStatsTracker     // Catch:{ all -> 0x00ca }
            r3.onValueReuse(r0)     // Catch:{ all -> 0x00ca }
            r5.logStats()     // Catch:{ all -> 0x00ca }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0051
            java.lang.Class<?> r0 = r5.TAG     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "get (reuse) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r2)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00ca }
            com.facebook.common.logging.FLog.m79v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x00ca }
        L_0x0051:
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            return r2
        L_0x0053:
            int r2 = r5.getSizeInBytes(r6)     // Catch:{ all -> 0x00ca }
            boolean r3 = r5.canAllocate(r2)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x00b8
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r2)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0067
            r0.incrementInUseCount()     // Catch:{ all -> 0x00ca }
        L_0x0067:
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            r0 = 0
            java.lang.Object r0 = r5.alloc(r6)     // Catch:{ all -> 0x006e }
            goto L_0x0082
        L_0x006e:
            r3 = move-exception
            monitor-enter(r5)
            com.facebook.imagepipeline.memory.BasePool$Counter r4 = r5.mUsed     // Catch:{ all -> 0x00b5 }
            r4.decrement(r2)     // Catch:{ all -> 0x00b5 }
            com.facebook.imagepipeline.memory.Bucket r4 = r5.getBucket(r6)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x007e
            r4.decrementInUseCount()     // Catch:{ all -> 0x00b5 }
        L_0x007e:
            monitor-exit(r5)     // Catch:{ all -> 0x00b5 }
            com.facebook.common.internal.Throwables.propagateIfPossible(r3)
        L_0x0082:
            monitor-enter(r5)
            java.util.Set<V> r3 = r5.mInUseValues     // Catch:{ all -> 0x00b2 }
            boolean r3 = r3.add(r0)     // Catch:{ all -> 0x00b2 }
            com.facebook.common.internal.Preconditions.checkState(r3)     // Catch:{ all -> 0x00b2 }
            r5.trimToSoftCap()     // Catch:{ all -> 0x00b2 }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r5.mPoolStatsTracker     // Catch:{ all -> 0x00b2 }
            r3.onAlloc(r2)     // Catch:{ all -> 0x00b2 }
            r5.logStats()     // Catch:{ all -> 0x00b2 }
            boolean r1 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00b2 }
            if (r1 == 0) goto L_0x00b0
            java.lang.Class<?> r1 = r5.TAG     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = "get (alloc) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00b2 }
            com.facebook.common.logging.FLog.m79v((java.lang.Class<?>) r1, (java.lang.String) r2, (java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r5)     // Catch:{ all -> 0x00b2 }
            return r0
        L_0x00b2:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b2 }
            throw r6
        L_0x00b5:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b5 }
            throw r6
        L_0x00b8:
            com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException r6 = new com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolParams r0 = r5.mPoolParams     // Catch:{ all -> 0x00ca }
            int r0 = r0.maxSizeHardCap     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r5.mUsed     // Catch:{ all -> 0x00ca }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mFree     // Catch:{ all -> 0x00ca }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x00ca }
            r6.<init>(r0, r1, r3, r2)     // Catch:{ all -> 0x00ca }
            throw r6     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.get(int):java.lang.Object");
    }

    public void release(V v) {
        Preconditions.checkNotNull(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (!this.mInUseValues.remove(v)) {
                FLog.m55e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                if (bucketIfPresent != null && !bucketIfPresent.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded()) {
                    if (isReusable(v)) {
                        bucketIfPresent.release(v);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.m79v(this.TAG, "release (reuse) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v)), (Object) Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                }
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (FLog.isLoggable(2)) {
                    FLog.m79v(this.TAG, "release (free) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v)), (Object) Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            }
            logStats();
        }
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(V v) {
        Preconditions.checkNotNull(v);
        return true;
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        if (isMaxSizeSoftCapExceeded()) {
            if (this.mFree.mNumBytes != 0) {
                z = false;
                Preconditions.checkState(z);
            }
        }
        z = true;
        Preconditions.checkState(z);
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        Preconditions.checkNotNull(sparseIntArray);
        this.mBuckets.clear();
        SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i = 0; i < sparseIntArray2.size(); i++) {
                int keyAt = sparseIntArray2.keyAt(i);
                this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
            }
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private synchronized void initBuckets() {
        SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        ArrayList arrayList = new ArrayList(this.mBuckets.size());
        int size = this.mBuckets.size();
        for (int i = 0; i < size; i++) {
            Bucket valueAt = this.mBuckets.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.mMaxLength;
            int inUseCount = valueAt.getInUseCount();
            if (valueAt.getFreeListSize() > 0) {
                arrayList.add(valueAt);
            }
            this.mBuckets.setValueAt(i, new Bucket(getSizeInBytes(i2), i3, inUseCount, this.mPoolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void trimToNothing() {
        int i;
        List list;
        synchronized (this) {
            if (this.mPoolParams.fixBucketsReinitialization) {
                list = refillBuckets();
            } else {
                list = new ArrayList(this.mBuckets.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                    Bucket valueAt = this.mBuckets.valueAt(i2);
                    if (valueAt.getFreeListSize() > 0) {
                        list.add(valueAt);
                    }
                    sparseIntArray.put(this.mBuckets.keyAt(i2), valueAt.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
            }
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (i = 0; i < list.size(); i++) {
            Bucket bucket = (Bucket) list.get(i);
            while (true) {
                Object pop = bucket.pop();
                if (pop == null) {
                    break;
                }
                free(pop);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trimToSize(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.BasePool$Counter r0 = r7.mUsed     // Catch:{ all -> 0x0090 }
            int r0 = r0.mNumBytes     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r7.mFree     // Catch:{ all -> 0x0090 }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x0090 }
            int r0 = r0 + r1
            int r0 = r0 - r8
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r7.mFree     // Catch:{ all -> 0x0090 }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x0090 }
            int r0 = java.lang.Math.min(r0, r1)     // Catch:{ all -> 0x0090 }
            if (r0 > 0) goto L_0x0017
            monitor-exit(r7)
            return
        L_0x0017:
            r1 = 2
            boolean r2 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x003b
            java.lang.Class<?> r2 = r7.TAG     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.BasePool$Counter r5 = r7.mUsed     // Catch:{ all -> 0x0090 }
            int r5 = r5.mNumBytes     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.BasePool$Counter r6 = r7.mFree     // Catch:{ all -> 0x0090 }
            int r6 = r6.mNumBytes     // Catch:{ all -> 0x0090 }
            int r5 = r5 + r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0090 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0090 }
            com.facebook.common.logging.FLog.m80v((java.lang.Class<?>) r2, (java.lang.String) r3, (java.lang.Object) r4, (java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x0090 }
        L_0x003b:
            r7.logStats()     // Catch:{ all -> 0x0090 }
            r2 = 0
        L_0x003f:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x0090 }
            int r3 = r3.size()     // Catch:{ all -> 0x0090 }
            if (r2 >= r3) goto L_0x006c
            if (r0 > 0) goto L_0x004a
            goto L_0x006c
        L_0x004a:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x0090 }
            java.lang.Object r3 = r3.valueAt(r2)     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.Bucket r3 = (com.facebook.imagepipeline.memory.Bucket) r3     // Catch:{ all -> 0x0090 }
        L_0x0052:
            if (r0 <= 0) goto L_0x0069
            java.lang.Object r4 = r3.pop()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x005b
            goto L_0x0069
        L_0x005b:
            r7.free(r4)     // Catch:{ all -> 0x0090 }
            int r4 = r3.mItemSize     // Catch:{ all -> 0x0090 }
            int r0 = r0 - r4
            com.facebook.imagepipeline.memory.BasePool$Counter r4 = r7.mFree     // Catch:{ all -> 0x0090 }
            int r5 = r3.mItemSize     // Catch:{ all -> 0x0090 }
            r4.decrement(r5)     // Catch:{ all -> 0x0090 }
            goto L_0x0052
        L_0x0069:
            int r2 = r2 + 1
            goto L_0x003f
        L_0x006c:
            r7.logStats()     // Catch:{ all -> 0x0090 }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x008e
            java.lang.Class<?> r0 = r7.TAG     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "trimToSize: TargetSize = %d; Final Size = %d"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.BasePool$Counter r2 = r7.mUsed     // Catch:{ all -> 0x0090 }
            int r2 = r2.mNumBytes     // Catch:{ all -> 0x0090 }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r7.mFree     // Catch:{ all -> 0x0090 }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x0090 }
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0090 }
            com.facebook.common.logging.FLog.m79v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r8, (java.lang.Object) r2)     // Catch:{ all -> 0x0090 }
        L_0x008e:
            monitor-exit(r7)
            return
        L_0x0090:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.trimToSize(int):void");
    }

    private synchronized Bucket<V> getBucketIfPresent(int i) {
        return this.mBuckets.get(i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucket(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r0 = r3.mBuckets     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002f }
            com.facebook.imagepipeline.memory.Bucket r0 = (com.facebook.imagepipeline.memory.Bucket) r0     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x002d
            boolean r1 = r3.mAllowNewBuckets     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0010
            goto L_0x002d
        L_0x0010:
            r0 = 2
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r0)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0022
            java.lang.Class<?> r0 = r3.TAG     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "creating new bucket %s"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002f }
            com.facebook.common.logging.FLog.m78v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x002f }
        L_0x0022:
            com.facebook.imagepipeline.memory.Bucket r0 = r3.newBucket(r4)     // Catch:{ all -> 0x002f }
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r1 = r3.mBuckets     // Catch:{ all -> 0x002f }
            r1.put(r4, r0)     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return r0
        L_0x002d:
            monitor-exit(r3)
            return r0
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.getBucket(int):com.facebook.imagepipeline.memory.Bucket");
    }

    /* access modifiers changed from: package-private */
    public Bucket<V> newBucket(int i) {
        return new Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean canAllocate(int i) {
        if (this.mIgnoreHardCap) {
            return true;
        }
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.m81v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", (Object) Integer.valueOf(this.mUsed.mCount), (Object) Integer.valueOf(this.mUsed.mNumBytes), (Object) Integer.valueOf(this.mFree.mCount), (Object) Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    public synchronized Map<String, Integer> getStats() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (int i = 0; i < this.mBuckets.size(); i++) {
            int keyAt = this.mBuckets.keyAt(i);
            hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(this.mBuckets.valueAt(i).getInUseCount()));
        }
        hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
        hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));
        hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));
        hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));
        hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));
        hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));
        return hashMap;
    }

    static class Counter {
        private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void decrement(int i) {
            int i2;
            int i3 = this.mNumBytes;
            if (i3 < i || (i2 = this.mCount) <= 0) {
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
                return;
            }
            this.mCount = i2 - 1;
            this.mNumBytes = i3 - i;
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
