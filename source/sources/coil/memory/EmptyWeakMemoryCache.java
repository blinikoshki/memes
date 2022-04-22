package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, mo26107d2 = {"Lcoil/memory/EmptyWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "()V", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "", "trimMemory", "level", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: WeakMemoryCache.kt */
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    public static final EmptyWeakMemoryCache INSTANCE = new EmptyWeakMemoryCache();

    public void clearMemory() {
    }

    public RealMemoryCache.Value get(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public boolean remove(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return false;
    }

    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    public void set(MemoryCache.Key key, Bitmap bitmap, boolean z, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    public void trimMemory(int i) {
    }

    private EmptyWeakMemoryCache() {
    }
}
