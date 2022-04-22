package coil.bitmap;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SparseArrayCompat;
import coil.memory.WeakMemoryCache;
import coil.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 %2\u00020\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Lcoil/bitmap/RealBitmapReferenceCounter;", "Lcoil/bitmap/BitmapReferenceCounter;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "logger", "Lcoil/util/Logger;", "(Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapPool;Lcoil/util/Logger;)V", "operationsSinceCleanUp", "", "getOperationsSinceCleanUp$coil_base_release$annotations", "()V", "getOperationsSinceCleanUp$coil_base_release", "()I", "setOperationsSinceCleanUp$coil_base_release", "(I)V", "values", "Landroidx/collection/SparseArrayCompat;", "Lcoil/bitmap/RealBitmapReferenceCounter$Value;", "getValues$coil_base_release$annotations", "getValues$coil_base_release", "()Landroidx/collection/SparseArrayCompat;", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "decrement", "", "bitmap", "Landroid/graphics/Bitmap;", "getValue", "key", "getValueOrNull", "increment", "setValid", "isValid", "Companion", "Value", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BitmapReferenceCounter.kt */
public final class RealBitmapReferenceCounter implements BitmapReferenceCounter {
    private static final int CLEAN_UP_INTERVAL = 50;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final String TAG = "RealBitmapReferenceCounter";
    /* access modifiers changed from: private */
    public final BitmapPool bitmapPool;
    private final Logger logger;
    private int operationsSinceCleanUp;
    private final SparseArrayCompat<Value> values = new SparseArrayCompat<>();
    private final WeakMemoryCache weakMemoryCache;

    public static /* synthetic */ void getOperationsSinceCleanUp$coil_base_release$annotations() {
    }

    public static /* synthetic */ void getValues$coil_base_release$annotations() {
    }

    public RealBitmapReferenceCounter(WeakMemoryCache weakMemoryCache2, BitmapPool bitmapPool2, Logger logger2) {
        Intrinsics.checkNotNullParameter(weakMemoryCache2, "weakMemoryCache");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        this.weakMemoryCache = weakMemoryCache2;
        this.bitmapPool = bitmapPool2;
        this.logger = logger2;
    }

    public final SparseArrayCompat<Value> getValues$coil_base_release() {
        return this.values;
    }

    public final int getOperationsSinceCleanUp$coil_base_release() {
        return this.operationsSinceCleanUp;
    }

    public final void setOperationsSinceCleanUp$coil_base_release(int i) {
        this.operationsSinceCleanUp = i;
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 50) {
            cleanUp$coil_base_release();
        }
    }

    public final void cleanUp$coil_base_release() {
        ArrayList arrayList = new ArrayList();
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (this.values.valueAt(i).getBitmap().get() == null) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        List list = arrayList;
        SparseArrayCompat<Value> sparseArrayCompat = this.values;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            sparseArrayCompat.removeAt(((Number) list.get(i2)).intValue());
        }
    }

    private final Value getValue(int i, Bitmap bitmap) {
        Value valueOrNull = getValueOrNull(i, bitmap);
        if (valueOrNull != null) {
            return valueOrNull;
        }
        Value value = new Value(new WeakReference(bitmap), 0, false);
        this.values.put(i, value);
        return value;
    }

    private final Value getValueOrNull(int i, Bitmap bitmap) {
        Value value = this.values.get(i);
        if (value != null) {
            if (((Bitmap) value.getBitmap().get()) == bitmap) {
                return value;
            }
        }
        return null;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, mo26107d2 = {"Lcoil/bitmap/RealBitmapReferenceCounter$Value;", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "count", "", "isValid", "", "(Ljava/lang/ref/WeakReference;IZ)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getCount", "()I", "setCount", "(I)V", "()Z", "setValid", "(Z)V", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: BitmapReferenceCounter.kt */
    public static final class Value {
        private final WeakReference<Bitmap> bitmap;
        private int count;
        private boolean isValid;

        public Value(WeakReference<Bitmap> weakReference, int i, boolean z) {
            Intrinsics.checkNotNullParameter(weakReference, "bitmap");
            this.bitmap = weakReference;
            this.count = i;
            this.isValid = z;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public final void setValid(boolean z) {
            this.isValid = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcoil/bitmap/RealBitmapReferenceCounter$Companion;", "", "()V", "CLEAN_UP_INTERVAL", "", "MAIN_HANDLER", "Landroid/os/Handler;", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: BitmapReferenceCounter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public synchronized void increment(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int identityHashCode = System.identityHashCode(bitmap);
        Value value = getValue(identityHashCode, bitmap);
        value.setCount(value.getCount() + 1);
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 2) {
            logger2.log(TAG, 2, "INCREMENT: [" + identityHashCode + ", " + value.getCount() + ", " + value.isValid() + ']', (Throwable) null);
        }
        cleanUpIfNecessary();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean decrement(android.graphics.Bitmap r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch:{ all -> 0x00ad }
            int r0 = java.lang.System.identityHashCode(r10)     // Catch:{ all -> 0x00ad }
            coil.bitmap.RealBitmapReferenceCounter$Value r1 = r9.getValueOrNull(r0, r10)     // Catch:{ all -> 0x00ad }
            r2 = 0
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L_0x0083
            int r5 = r1.getCount()     // Catch:{ all -> 0x00ad }
            int r5 = r5 + -1
            r1.setCount(r5)     // Catch:{ all -> 0x00ad }
            coil.util.Logger r5 = r9.logger     // Catch:{ all -> 0x00ad }
            if (r5 == 0) goto L_0x0059
            java.lang.String r6 = "RealBitmapReferenceCounter"
            int r7 = r5.getLevel()     // Catch:{ all -> 0x00ad }
            if (r7 > r3) goto L_0x0059
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r7.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = "DECREMENT: ["
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            r7.append(r0)     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = ", "
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            int r8 = r1.getCount()     // Catch:{ all -> 0x00ad }
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = ", "
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            boolean r8 = r1.isValid()     // Catch:{ all -> 0x00ad }
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            r8 = 93
            r7.append(r8)     // Catch:{ all -> 0x00ad }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ad }
            r5.log(r6, r3, r7, r2)     // Catch:{ all -> 0x00ad }
        L_0x0059:
            int r2 = r1.getCount()     // Catch:{ all -> 0x00ad }
            if (r2 > 0) goto L_0x0066
            boolean r1 = r1.isValid()     // Catch:{ all -> 0x00ad }
            if (r1 == 0) goto L_0x0066
            r4 = 1
        L_0x0066:
            if (r4 == 0) goto L_0x007e
            androidx.collection.SparseArrayCompat<coil.bitmap.RealBitmapReferenceCounter$Value> r1 = r9.values     // Catch:{ all -> 0x00ad }
            r1.remove(r0)     // Catch:{ all -> 0x00ad }
            coil.memory.WeakMemoryCache r0 = r9.weakMemoryCache     // Catch:{ all -> 0x00ad }
            r0.remove((android.graphics.Bitmap) r10)     // Catch:{ all -> 0x00ad }
            android.os.Handler r0 = MAIN_HANDLER     // Catch:{ all -> 0x00ad }
            coil.bitmap.RealBitmapReferenceCounter$decrement$2 r1 = new coil.bitmap.RealBitmapReferenceCounter$decrement$2     // Catch:{ all -> 0x00ad }
            r1.<init>(r9, r10)     // Catch:{ all -> 0x00ad }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x00ad }
            r0.post(r1)     // Catch:{ all -> 0x00ad }
        L_0x007e:
            r9.cleanUpIfNecessary()     // Catch:{ all -> 0x00ad }
            monitor-exit(r9)
            return r4
        L_0x0083:
            r10 = r9
            coil.bitmap.RealBitmapReferenceCounter r10 = (coil.bitmap.RealBitmapReferenceCounter) r10     // Catch:{ all -> 0x00ad }
            coil.util.Logger r10 = r10.logger     // Catch:{ all -> 0x00ad }
            if (r10 == 0) goto L_0x00ab
            java.lang.String r1 = "RealBitmapReferenceCounter"
            int r5 = r10.getLevel()     // Catch:{ all -> 0x00ad }
            if (r5 > r3) goto L_0x00ab
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r5.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r6 = "DECREMENT: ["
            r5.append(r6)     // Catch:{ all -> 0x00ad }
            r5.append(r0)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = ", UNKNOWN, UNKNOWN]"
            r5.append(r0)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00ad }
            r10.log(r1, r3, r0, r2)     // Catch:{ all -> 0x00ad }
        L_0x00ab:
            monitor-exit(r9)
            return r4
        L_0x00ad:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.bitmap.RealBitmapReferenceCounter.decrement(android.graphics.Bitmap):boolean");
    }

    public synchronized void setValid(Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int identityHashCode = System.identityHashCode(bitmap);
        if (!z) {
            getValue(identityHashCode, bitmap).setValid(false);
        } else if (getValueOrNull(identityHashCode, bitmap) == null) {
            this.values.put(identityHashCode, new Value(new WeakReference(bitmap), 0, true));
        }
        cleanUpIfNecessary();
    }
}
