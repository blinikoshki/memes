package coil.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import coil.util.Bitmaps;
import coil.util.Logger;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J$\u0010\u0018\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J$\u0010\u001c\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0003H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo26107d2 = {"Lcoil/bitmap/RealBitmapPool;", "Lcoil/bitmap/BitmapPool;", "maxSize", "", "allowedConfigs", "", "Landroid/graphics/Bitmap$Config;", "strategy", "Lcoil/bitmap/BitmapPoolStrategy;", "logger", "Lcoil/util/Logger;", "(ILjava/util/Set;Lcoil/bitmap/BitmapPoolStrategy;Lcoil/util/Logger;)V", "bitmaps", "Ljava/util/HashSet;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashSet;", "currentSize", "evictions", "hits", "misses", "puts", "clear", "", "clearMemory", "get", "width", "height", "config", "getDirty", "getDirtyOrNull", "getOrNull", "logStats", "", "normalize", "bitmap", "put", "trimMemory", "level", "trimToSize", "size", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RealBitmapPool.kt */
public final class RealBitmapPool implements BitmapPool {
    private static final Set<Bitmap.Config> ALLOWED_CONFIGS;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RealBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private final HashSet<Bitmap> bitmaps;
    private int currentSize;
    private int evictions;
    private int hits;
    private final Logger logger;
    private final int maxSize;
    private int misses;
    private int puts;
    private final BitmapPoolStrategy strategy;

    public RealBitmapPool(int i, Set<? extends Bitmap.Config> set, BitmapPoolStrategy bitmapPoolStrategy, Logger logger2) {
        Intrinsics.checkNotNullParameter(set, "allowedConfigs");
        Intrinsics.checkNotNullParameter(bitmapPoolStrategy, "strategy");
        this.maxSize = i;
        this.allowedConfigs = set;
        this.strategy = bitmapPoolStrategy;
        this.logger = logger2;
        this.bitmaps = new HashSet<>();
        if (!(i >= 0)) {
            throw new IllegalArgumentException("maxSize must be >= 0.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealBitmapPool(int i, Set<Bitmap.Config> set, BitmapPoolStrategy bitmapPoolStrategy, Logger logger2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? ALLOWED_CONFIGS : set, (i2 & 4) != 0 ? BitmapPoolStrategy.Companion.invoke() : bitmapPoolStrategy, (i2 & 8) != 0 ? null : logger2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(android.graphics.Bitmap r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)     // Catch:{ all -> 0x0133 }
            boolean r0 = r9.isRecycled()     // Catch:{ all -> 0x0133 }
            r1 = 6
            r2 = 0
            if (r0 == 0) goto L_0x0030
            coil.util.Logger r0 = r8.logger     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x002e
            java.lang.String r3 = "RealBitmapPool"
            int r4 = r0.getLevel()     // Catch:{ all -> 0x0133 }
            if (r4 > r1) goto L_0x002e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r4.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "Rejecting recycled bitmap from pool; bitmap: "
            r4.append(r5)     // Catch:{ all -> 0x0133 }
            r4.append(r9)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0133 }
            r0.log(r3, r1, r9, r2)     // Catch:{ all -> 0x0133 }
        L_0x002e:
            monitor-exit(r8)
            return
        L_0x0030:
            int r0 = coil.util.Bitmaps.getAllocationByteCountCompat(r9)     // Catch:{ all -> 0x0133 }
            boolean r3 = r9.isMutable()     // Catch:{ all -> 0x0133 }
            r4 = 1
            r5 = 2
            if (r3 == 0) goto L_0x00cd
            int r3 = r8.maxSize     // Catch:{ all -> 0x0133 }
            if (r0 > r3) goto L_0x00cd
            java.util.Set<android.graphics.Bitmap$Config> r3 = r8.allowedConfigs     // Catch:{ all -> 0x0133 }
            android.graphics.Bitmap$Config r6 = r9.getConfig()     // Catch:{ all -> 0x0133 }
            boolean r3 = r3.contains(r6)     // Catch:{ all -> 0x0133 }
            if (r3 != 0) goto L_0x004e
            goto L_0x00cd
        L_0x004e:
            java.util.HashSet<android.graphics.Bitmap> r3 = r8.bitmaps     // Catch:{ all -> 0x0133 }
            boolean r3 = r3.contains(r9)     // Catch:{ all -> 0x0133 }
            if (r3 == 0) goto L_0x007e
            coil.util.Logger r0 = r8.logger     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x007c
            java.lang.String r3 = "RealBitmapPool"
            int r4 = r0.getLevel()     // Catch:{ all -> 0x0133 }
            if (r4 > r1) goto L_0x007c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r4.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "Rejecting duplicate bitmap from pool; bitmap: "
            r4.append(r5)     // Catch:{ all -> 0x0133 }
            coil.bitmap.BitmapPoolStrategy r5 = r8.strategy     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r5.stringify(r9)     // Catch:{ all -> 0x0133 }
            r4.append(r9)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0133 }
            r0.log(r3, r1, r9, r2)     // Catch:{ all -> 0x0133 }
        L_0x007c:
            monitor-exit(r8)
            return
        L_0x007e:
            coil.bitmap.BitmapPoolStrategy r1 = r8.strategy     // Catch:{ all -> 0x0133 }
            r1.put(r9)     // Catch:{ all -> 0x0133 }
            java.util.HashSet<android.graphics.Bitmap> r1 = r8.bitmaps     // Catch:{ all -> 0x0133 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0133 }
            r1.add(r9)     // Catch:{ all -> 0x0133 }
            int r1 = r8.currentSize     // Catch:{ all -> 0x0133 }
            int r1 = r1 + r0
            r8.currentSize = r1     // Catch:{ all -> 0x0133 }
            int r0 = r8.puts     // Catch:{ all -> 0x0133 }
            int r0 = r0 + r4
            r8.puts = r0     // Catch:{ all -> 0x0133 }
            coil.util.Logger r0 = r8.logger     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x00c6
            java.lang.String r1 = "RealBitmapPool"
            int r3 = r0.getLevel()     // Catch:{ all -> 0x0133 }
            if (r3 > r5) goto L_0x00c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r3.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "Put bitmap="
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            coil.bitmap.BitmapPoolStrategy r4 = r8.strategy     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r4.stringify(r9)     // Catch:{ all -> 0x0133 }
            r3.append(r9)     // Catch:{ all -> 0x0133 }
            r9 = 10
            r3.append(r9)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r8.logStats()     // Catch:{ all -> 0x0133 }
            r3.append(r9)     // Catch:{ all -> 0x0133 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0133 }
            r0.log(r1, r5, r9, r2)     // Catch:{ all -> 0x0133 }
        L_0x00c6:
            int r9 = r8.maxSize     // Catch:{ all -> 0x0133 }
            r8.trimToSize(r9)     // Catch:{ all -> 0x0133 }
            monitor-exit(r8)
            return
        L_0x00cd:
            coil.util.Logger r1 = r8.logger     // Catch:{ all -> 0x0133 }
            if (r1 == 0) goto L_0x012e
            java.lang.String r3 = "RealBitmapPool"
            int r6 = r1.getLevel()     // Catch:{ all -> 0x0133 }
            if (r6 > r5) goto L_0x012e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r6.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "Rejecting bitmap from pool; bitmap: "
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            coil.bitmap.BitmapPoolStrategy r7 = r8.strategy     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = r7.stringify(r9)     // Catch:{ all -> 0x0133 }
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = ", "
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "is mutable: "
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            boolean r7 = r9.isMutable()     // Catch:{ all -> 0x0133 }
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = ", "
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            java.lang.String r7 = "is greater than max size: "
            r6.append(r7)     // Catch:{ all -> 0x0133 }
            int r7 = r8.maxSize     // Catch:{ all -> 0x0133 }
            if (r0 <= r7) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r4 = 0
        L_0x010d:
            r6.append(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r0 = ", "
            r6.append(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r0 = "is allowed config: "
            r6.append(r0)     // Catch:{ all -> 0x0133 }
            java.util.Set<android.graphics.Bitmap$Config> r0 = r8.allowedConfigs     // Catch:{ all -> 0x0133 }
            android.graphics.Bitmap$Config r4 = r9.getConfig()     // Catch:{ all -> 0x0133 }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0133 }
            r6.append(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0133 }
            r1.log(r3, r5, r0, r2)     // Catch:{ all -> 0x0133 }
        L_0x012e:
            r9.recycle()     // Catch:{ all -> 0x0133 }
            monitor-exit(r8)
            return
        L_0x0133:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.bitmap.RealBitmapPool.put(android.graphics.Bitmap):void");
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap orNull = getOrNull(i, i2, config);
        if (orNull != null) {
            return orNull;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public Bitmap getOrNull(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull == null) {
            return null;
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull != null) {
            return dirtyOrNull;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public synchronized Bitmap getDirtyOrNull(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(config, "config");
        if (!Bitmaps.isHardware(config)) {
            bitmap = this.strategy.get(i, i2, config);
            if (bitmap == null) {
                Logger logger2 = this.logger;
                if (logger2 != null && logger2.getLevel() <= 2) {
                    logger2.log(TAG, 2, "Missing bitmap=" + this.strategy.stringify(i, i2, config), (Throwable) null);
                }
                this.misses++;
            } else {
                this.bitmaps.remove(bitmap);
                this.currentSize -= Bitmaps.getAllocationByteCountCompat(bitmap);
                this.hits++;
                normalize(bitmap);
            }
            Logger logger3 = this.logger;
            if (logger3 != null && logger3.getLevel() <= 2) {
                logger3.log(TAG, 2, "Get bitmap=" + this.strategy.stringify(i, i2, config) + 10 + logStats(), (Throwable) null);
            }
        } else {
            throw new IllegalArgumentException("Cannot create a mutable hardware bitmap.".toString());
        }
        return bitmap;
    }

    public void clear() {
        clearMemory();
    }

    public final void clearMemory() {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 2) {
            logger2.log(TAG, 2, "clearMemory", (Throwable) null);
        }
        trimToSize(-1);
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
                trimToSize(this.currentSize / 2);
            }
        }
    }

    private final void normalize(Bitmap bitmap) {
        bitmap.setDensity(0);
        bitmap.setHasAlpha(true);
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private final synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                Logger logger2 = this.logger;
                if (logger2 != null && logger2.getLevel() <= 5) {
                    logger2.log(TAG, 5, "Size mismatch, resetting.\n" + logStats(), (Throwable) null);
                }
                this.currentSize = 0;
                return;
            }
            this.bitmaps.remove(removeLast);
            this.currentSize -= Bitmaps.getAllocationByteCountCompat(removeLast);
            this.evictions++;
            Logger logger3 = this.logger;
            if (logger3 != null && logger3.getLevel() <= 2) {
                logger3.log(TAG, 2, "Evicting bitmap=" + this.strategy.stringify(removeLast) + 10 + logStats(), (Throwable) null);
            }
            removeLast.recycle();
        }
    }

    private final String logStats() {
        return "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", " + "currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + ", strategy=" + this.strategy;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcoil/bitmap/RealBitmapPool$Companion;", "", "()V", "ALLOWED_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "getALLOWED_CONFIGS$annotations", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: RealBitmapPool.kt */
    public static final class Companion {
        private static /* synthetic */ void getALLOWED_CONFIGS$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set createSetBuilder = SetsKt.createSetBuilder();
        createSetBuilder.add(Bitmap.Config.ALPHA_8);
        createSetBuilder.add(Bitmap.Config.RGB_565);
        createSetBuilder.add(Bitmap.Config.ARGB_4444);
        createSetBuilder.add(Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 26) {
            createSetBuilder.add(Bitmap.Config.RGBA_F16);
        }
        ALLOWED_CONFIGS = SetsKt.build(createSetBuilder);
    }
}
