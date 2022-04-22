package coil.memory;

import android.graphics.Bitmap;
import coil.bitmap.BitmapReferenceCounter;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0002R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcoil/memory/RealMemoryCache;", "Lcoil/memory/MemoryCache;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "(Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapReferenceCounter;)V", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clear", "", "get", "Landroid/graphics/Bitmap;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Value", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RealMemoryCache.kt */
public final class RealMemoryCache implements MemoryCache {
    private final BitmapReferenceCounter referenceCounter;
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcoil/memory/RealMemoryCache$Value;", "", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "isSampled", "", "()Z", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: RealMemoryCache.kt */
    public interface Value {
        Bitmap getBitmap();

        boolean isSampled();
    }

    public RealMemoryCache(StrongMemoryCache strongMemoryCache2, WeakMemoryCache weakMemoryCache2, BitmapReferenceCounter bitmapReferenceCounter) {
        Intrinsics.checkNotNullParameter(strongMemoryCache2, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(weakMemoryCache2, "weakMemoryCache");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.strongMemoryCache = strongMemoryCache2;
        this.weakMemoryCache = weakMemoryCache2;
        this.referenceCounter = bitmapReferenceCounter;
    }

    public int getSize() {
        return this.strongMemoryCache.getSize();
    }

    public int getMaxSize() {
        return this.strongMemoryCache.getMaxSize();
    }

    public Bitmap get(MemoryCache.Key key) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = this.strongMemoryCache.get(key);
        if (value == null) {
            value = this.weakMemoryCache.get(key);
        }
        if (value == null || (bitmap = value.getBitmap()) == null) {
            return null;
        }
        this.referenceCounter.setValid(bitmap, false);
        return bitmap;
    }

    public void set(MemoryCache.Key key, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.referenceCounter.setValid(bitmap, false);
        this.strongMemoryCache.set(key, bitmap, false);
        this.weakMemoryCache.remove(key);
    }

    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.strongMemoryCache.remove(key) || this.weakMemoryCache.remove(key);
    }

    public void clear() {
        this.strongMemoryCache.clearMemory();
        this.weakMemoryCache.clearMemory();
    }
}
