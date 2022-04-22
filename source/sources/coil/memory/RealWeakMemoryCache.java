package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0003()*B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J(\u0010#\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0016RX\u0010\u0005\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\u000b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, mo26107d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "cache", "Ljava/util/HashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$WeakValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getCache$coil_base_release$annotations", "()V", "getCache$coil_base_release", "()Ljava/util/HashMap;", "operationsSinceCleanUp", "", "getOperationsSinceCleanUp$coil_base_release$annotations", "getOperationsSinceCleanUp$coil_base_release", "()I", "setOperationsSinceCleanUp$coil_base_release", "(I)V", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "clearMemory", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "trimMemory", "level", "Companion", "StrongValue", "WeakValue", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: WeakMemoryCache.kt */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RealWeakMemoryCache";
    private final HashMap<MemoryCache.Key, ArrayList<WeakValue>> cache = new HashMap<>();
    private final Logger logger;
    private int operationsSinceCleanUp;

    public static /* synthetic */ void getCache$coil_base_release$annotations() {
    }

    public static /* synthetic */ void getOperationsSinceCleanUp$coil_base_release$annotations() {
    }

    public RealWeakMemoryCache(Logger logger2) {
        this.logger = logger2;
    }

    public final HashMap<MemoryCache.Key, ArrayList<WeakValue>> getCache$coil_base_release() {
        return this.cache;
    }

    public final int getOperationsSinceCleanUp$coil_base_release() {
        return this.operationsSinceCleanUp;
    }

    public final void setOperationsSinceCleanUp$coil_base_release(int i) {
        this.operationsSinceCleanUp = i;
    }

    public synchronized RealMemoryCache.Value get(MemoryCache.Key key) {
        StrongValue strongValue;
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList arrayList = this.cache.get(key);
        StrongValue strongValue2 = null;
        if (arrayList == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(arrayList, "cache[key] ?: return null");
        List list = arrayList;
        int i = 0;
        int size = list.size();
        while (true) {
            if (i >= size) {
                break;
            }
            WeakValue weakValue = (WeakValue) list.get(i);
            Bitmap bitmap = (Bitmap) weakValue.getBitmap().get();
            if (bitmap != null) {
                Intrinsics.checkNotNullExpressionValue(bitmap, "it");
                strongValue = new StrongValue(bitmap, weakValue.isSampled());
            } else {
                strongValue = null;
            }
            if (strongValue != null) {
                strongValue2 = strongValue;
                break;
            }
            i++;
        }
        cleanUpIfNecessary();
        return strongValue2;
    }

    public synchronized void set(MemoryCache.Key key, Bitmap bitmap, boolean z, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Map map = this.cache;
        Object obj = map.get(key);
        if (obj == null) {
            obj = new ArrayList();
            map.put(key, obj);
        }
        ArrayList arrayList = (ArrayList) obj;
        RealWeakMemoryCache realWeakMemoryCache = this;
        int identityHashCode = System.identityHashCode(bitmap);
        WeakValue weakValue = new WeakValue(identityHashCode, new WeakReference(bitmap), z, i);
        int i2 = 0;
        int size = arrayList.size();
        while (true) {
            if (i2 >= size) {
                arrayList.add(weakValue);
                break;
            }
            Object obj2 = arrayList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj2, "values[index]");
            WeakValue weakValue2 = (WeakValue) obj2;
            if (i < weakValue2.getSize()) {
                i2++;
            } else if (weakValue2.getIdentityHashCode() == identityHashCode && ((Bitmap) weakValue2.getBitmap().get()) == bitmap) {
                arrayList.set(i2, weakValue);
            } else {
                arrayList.add(i2, weakValue);
            }
        }
        cleanUpIfNecessary();
    }

    public synchronized boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.remove(key) != null;
    }

    public synchronized void clearMemory() {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 2) {
            logger2.log(TAG, 2, "clearMemory", (Throwable) null);
        }
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    public synchronized void trimMemory(int i) {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 2) {
            logger2.log(TAG, 2, "trimMemory, level=" + i, (Throwable) null);
        }
        if (i >= 10 && i != 20) {
            cleanUp$coil_base_release();
        }
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_base_release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0032, code lost:
        r2 = r2.getBitmap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cleanUp$coil_base_release() {
        /*
            r10 = this;
            r0 = 0
            r10.operationsSinceCleanUp = r0
            java.util.HashMap<coil.memory.MemoryCache$Key, java.util.ArrayList<coil.memory.RealWeakMemoryCache$WeakValue>> r1 = r10.cache
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r1.next()
            java.lang.String r3 = "iterator.next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = 1
            if (r3 > r4) goto L_0x0046
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            coil.memory.RealWeakMemoryCache$WeakValue r2 = (coil.memory.RealWeakMemoryCache.WeakValue) r2
            if (r2 == 0) goto L_0x003f
            java.lang.ref.WeakReference r2 = r2.getBitmap()
            if (r2 == 0) goto L_0x003f
            java.lang.Object r2 = r2.get()
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            if (r2 != 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x0046:
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r3 < r5) goto L_0x0054
            coil.memory.RealWeakMemoryCache$cleanUp$1 r3 = coil.memory.RealWeakMemoryCache$cleanUp$1.INSTANCE
            java.util.function.Predicate r3 = (java.util.function.Predicate) r3
            r2.removeIf(r3)
            goto L_0x0081
        L_0x0054:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            int r5 = r5.size()
            r6 = 0
            r7 = 0
        L_0x0060:
            if (r6 >= r5) goto L_0x0081
            int r8 = r6 - r7
            java.lang.Object r9 = r3.get(r8)
            coil.memory.RealWeakMemoryCache$WeakValue r9 = (coil.memory.RealWeakMemoryCache.WeakValue) r9
            java.lang.ref.WeakReference r9 = r9.getBitmap()
            java.lang.Object r9 = r9.get()
            if (r9 != 0) goto L_0x0076
            r9 = 1
            goto L_0x0077
        L_0x0076:
            r9 = 0
        L_0x0077:
            if (r9 == 0) goto L_0x007e
            r3.remove(r8)
            int r7 = r7 + 1
        L_0x007e:
            int r6 = r6 + 1
            goto L_0x0060
        L_0x0081:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.RealWeakMemoryCache.cleanUp$coil_base_release():void");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, mo26107d2 = {"Lcoil/memory/RealWeakMemoryCache$WeakValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "isSampled", "", "size", "(ILjava/lang/ref/WeakReference;ZI)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getIdentityHashCode", "()I", "()Z", "getSize", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: WeakMemoryCache.kt */
    public static final class WeakValue {
        private final WeakReference<Bitmap> bitmap;
        private final int identityHashCode;
        private final boolean isSampled;
        private final int size;

        public WeakValue(int i, WeakReference<Bitmap> weakReference, boolean z, int i2) {
            Intrinsics.checkNotNullParameter(weakReference, "bitmap");
            this.identityHashCode = i;
            this.bitmap = weakReference;
            this.isSampled = z;
            this.size = i2;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final int getSize() {
            return this.size;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, mo26107d2 = {"Lcoil/memory/RealWeakMemoryCache$StrongValue;", "Lcoil/memory/RealMemoryCache$Value;", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "", "(Landroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: WeakMemoryCache.kt */
    private static final class StrongValue implements RealMemoryCache.Value {
        private final Bitmap bitmap;
        private final boolean isSampled;

        public StrongValue(Bitmap bitmap2, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
            this.bitmap = bitmap2;
            this.isSampled = z;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public boolean isSampled() {
            return this.isSampled;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcoil/memory/RealWeakMemoryCache$Companion;", "", "()V", "CLEAN_UP_INTERVAL", "", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: WeakMemoryCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(android.graphics.Bitmap r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x0053 }
            int r6 = java.lang.System.identityHashCode(r6)     // Catch:{ all -> 0x0053 }
            r0 = r5
            coil.memory.RealWeakMemoryCache r0 = (coil.memory.RealWeakMemoryCache) r0     // Catch:{ all -> 0x0053 }
            java.util.HashMap<coil.memory.MemoryCache$Key, java.util.ArrayList<coil.memory.RealWeakMemoryCache$WeakValue>> r0 = r0.cache     // Catch:{ all -> 0x0053 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "cache.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x0053 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0053 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0053 }
        L_0x001e:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0053 }
            r2 = 0
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0053 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x0053 }
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x0053 }
            int r3 = r3.size()     // Catch:{ all -> 0x0053 }
        L_0x0038:
            if (r2 >= r3) goto L_0x001e
            java.lang.Object r4 = r1.get(r2)     // Catch:{ all -> 0x0053 }
            coil.memory.RealWeakMemoryCache$WeakValue r4 = (coil.memory.RealWeakMemoryCache.WeakValue) r4     // Catch:{ all -> 0x0053 }
            int r4 = r4.getIdentityHashCode()     // Catch:{ all -> 0x0053 }
            if (r4 != r6) goto L_0x004b
            r1.remove(r2)     // Catch:{ all -> 0x0053 }
            r2 = 1
            goto L_0x004e
        L_0x004b:
            int r2 = r2 + 1
            goto L_0x0038
        L_0x004e:
            r5.cleanUpIfNecessary()     // Catch:{ all -> 0x0053 }
            monitor-exit(r5)
            return r2
        L_0x0053:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.RealWeakMemoryCache.remove(android.graphics.Bitmap):boolean");
    }
}
