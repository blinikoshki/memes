package coil.memory;

import android.graphics.Bitmap;
import coil.bitmap.BitmapReferenceCounter;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\b\u0002\u0018\u0000  2\u00020\u0001:\u0002 !B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007H\u0016R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcoil/memory/RealStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "maxSize", "", "logger", "Lcoil/util/Logger;", "(Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapReferenceCounter;ILcoil/util/Logger;)V", "cache", "coil/memory/RealStrongMemoryCache$cache$1", "Lcoil/memory/RealStrongMemoryCache$cache$1;", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealStrongMemoryCache$InternalValue;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "Companion", "InternalValue", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: StrongMemoryCache.kt */
final class RealStrongMemoryCache implements StrongMemoryCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RealStrongMemoryCache";
    private final RealStrongMemoryCache$cache$1 cache;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final BitmapReferenceCounter referenceCounter;
    /* access modifiers changed from: private */
    public final WeakMemoryCache weakMemoryCache;

    public RealStrongMemoryCache(WeakMemoryCache weakMemoryCache2, BitmapReferenceCounter bitmapReferenceCounter, int i, Logger logger2) {
        Intrinsics.checkNotNullParameter(weakMemoryCache2, "weakMemoryCache");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.weakMemoryCache = weakMemoryCache2;
        this.referenceCounter = bitmapReferenceCounter;
        this.logger = logger2;
        this.cache = new RealStrongMemoryCache$cache$1(this, i, i);
    }

    public int getSize() {
        return this.cache.size();
    }

    public int getMaxSize() {
        return this.cache.maxSize();
    }

    public synchronized InternalValue get(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (InternalValue) this.cache.get(key);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void set(coil.memory.MemoryCache.Key r4, android.graphics.Bitmap r5, boolean r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch:{ all -> 0x0037 }
            int r0 = coil.util.Bitmaps.getAllocationByteCountCompat(r5)     // Catch:{ all -> 0x0037 }
            int r1 = r3.getMaxSize()     // Catch:{ all -> 0x0037 }
            if (r0 <= r1) goto L_0x0026
            coil.memory.RealStrongMemoryCache$cache$1 r1 = r3.cache     // Catch:{ all -> 0x0037 }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x0037 }
            coil.memory.RealStrongMemoryCache$InternalValue r1 = (coil.memory.RealStrongMemoryCache.InternalValue) r1     // Catch:{ all -> 0x0037 }
            if (r1 != 0) goto L_0x0024
            coil.memory.WeakMemoryCache r1 = r3.weakMemoryCache     // Catch:{ all -> 0x0037 }
            r1.set(r4, r5, r6, r0)     // Catch:{ all -> 0x0037 }
        L_0x0024:
            monitor-exit(r3)
            return
        L_0x0026:
            coil.bitmap.BitmapReferenceCounter r1 = r3.referenceCounter     // Catch:{ all -> 0x0037 }
            r1.increment(r5)     // Catch:{ all -> 0x0037 }
            coil.memory.RealStrongMemoryCache$cache$1 r1 = r3.cache     // Catch:{ all -> 0x0037 }
            coil.memory.RealStrongMemoryCache$InternalValue r2 = new coil.memory.RealStrongMemoryCache$InternalValue     // Catch:{ all -> 0x0037 }
            r2.<init>(r5, r6, r0)     // Catch:{ all -> 0x0037 }
            r1.put(r4, r2)     // Catch:{ all -> 0x0037 }
            monitor-exit(r3)
            return
        L_0x0037:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.RealStrongMemoryCache.set(coil.memory.MemoryCache$Key, android.graphics.Bitmap, boolean):void");
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
        this.cache.trimToSize(-1);
    }

    public synchronized void trimMemory(int i) {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 2) {
            logger2.log(TAG, 2, "trimMemory, level=" + i, (Throwable) null);
        }
        if (i >= 40) {
            clearMemory();
        } else if (10 <= i) {
            if (20 > i) {
                this.cache.trimToSize(getSize() / 2);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, mo26107d2 = {"Lcoil/memory/RealStrongMemoryCache$InternalValue;", "Lcoil/memory/RealMemoryCache$Value;", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "", "size", "", "(Landroid/graphics/Bitmap;ZI)V", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "getSize", "()I", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: StrongMemoryCache.kt */
    private static final class InternalValue implements RealMemoryCache.Value {
        private final Bitmap bitmap;
        private final boolean isSampled;
        private final int size;

        public InternalValue(Bitmap bitmap2, boolean z, int i) {
            Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
            this.bitmap = bitmap2;
            this.isSampled = z;
            this.size = i;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public boolean isSampled() {
            return this.isSampled;
        }

        public final int getSize() {
            return this.size;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/memory/RealStrongMemoryCache$Companion;", "", "()V", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: StrongMemoryCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
