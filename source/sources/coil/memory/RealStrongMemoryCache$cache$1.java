package coil.memory;

import androidx.collection.LruCache;
import coil.memory.MemoryCache;
import coil.memory.RealStrongMemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0014¨\u0006\u000e"}, mo26107d2 = {"coil/memory/RealStrongMemoryCache$cache$1", "Landroidx/collection/LruCache;", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/RealStrongMemoryCache$InternalValue;", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "sizeOf", "", "value", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: StrongMemoryCache.kt */
public final class RealStrongMemoryCache$cache$1 extends LruCache<MemoryCache.Key, RealStrongMemoryCache.InternalValue> {
    final /* synthetic */ int $maxSize;
    final /* synthetic */ RealStrongMemoryCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealStrongMemoryCache$cache$1(RealStrongMemoryCache realStrongMemoryCache, int i, int i2) {
        super(i2);
        this.this$0 = realStrongMemoryCache;
        this.$maxSize = i;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue, RealStrongMemoryCache.InternalValue internalValue2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(internalValue, "oldValue");
        if (!this.this$0.referenceCounter.decrement(internalValue.getBitmap())) {
            this.this$0.weakMemoryCache.set(key, internalValue.getBitmap(), internalValue.isSampled(), internalValue.getSize());
        }
    }

    /* access modifiers changed from: protected */
    public int sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(internalValue, "value");
        return internalValue.getSize();
    }
}
