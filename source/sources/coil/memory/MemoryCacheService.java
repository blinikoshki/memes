package coil.memory;

import coil.bitmap.BitmapReferenceCounter;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcoil/memory/MemoryCacheService;", "", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;)V", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: MemoryCacheService.kt */
public final class MemoryCacheService {
    private final BitmapReferenceCounter referenceCounter;
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public MemoryCacheService(BitmapReferenceCounter bitmapReferenceCounter, StrongMemoryCache strongMemoryCache2, WeakMemoryCache weakMemoryCache2) {
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(strongMemoryCache2, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(weakMemoryCache2, "weakMemoryCache");
        this.referenceCounter = bitmapReferenceCounter;
        this.strongMemoryCache = strongMemoryCache2;
        this.weakMemoryCache = weakMemoryCache2;
    }

    public final RealMemoryCache.Value get(MemoryCache.Key key) {
        if (key == null) {
            return null;
        }
        RealMemoryCache.Value value = this.strongMemoryCache.get(key);
        if (value == null) {
            value = this.weakMemoryCache.get(key);
        }
        if (value != null) {
            this.referenceCounter.increment(value.getBitmap());
        }
        return value;
    }
}
