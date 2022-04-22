package coil.bitmap;

import android.graphics.Bitmap;
import coil.collection.LinkedMultimap;
import coil.util.Bitmaps;
import coil.util.Utils;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J$\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcoil/bitmap/SizeStrategy;", "Lcoil/bitmap/BitmapPoolStrategy;", "()V", "entries", "Lcoil/collection/LinkedMultimap;", "", "Landroid/graphics/Bitmap;", "sizes", "Ljava/util/TreeMap;", "decrementSize", "", "size", "get", "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "bitmap", "removeLast", "stringify", "", "toString", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BitmapPoolStrategy.kt */
public final class SizeStrategy implements BitmapPoolStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SIZE_MULTIPLE = 4;
    private final LinkedMultimap<Integer, Bitmap> entries = new LinkedMultimap<>();
    private final TreeMap<Integer, Integer> sizes = new TreeMap<>();

    public void put(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int allocationByteCountCompat = Bitmaps.getAllocationByteCountCompat(bitmap);
        this.entries.put(Integer.valueOf(allocationByteCountCompat), bitmap);
        Integer num = this.sizes.get(Integer.valueOf(allocationByteCountCompat));
        Map map = this.sizes;
        Integer valueOf = Integer.valueOf(allocationByteCountCompat);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        int calculateAllocationByteCount = Utils.INSTANCE.calculateAllocationByteCount(i, i2, config);
        Integer ceilingKey = this.sizes.ceilingKey(Integer.valueOf(calculateAllocationByteCount));
        if (ceilingKey != null) {
            if (!(ceilingKey.intValue() <= calculateAllocationByteCount * 4)) {
                ceilingKey = null;
            }
            if (ceilingKey != null) {
                calculateAllocationByteCount = ceilingKey.intValue();
            }
        }
        Bitmap removeLast = this.entries.removeLast(Integer.valueOf(calculateAllocationByteCount));
        if (removeLast != null) {
            decrementSize(calculateAllocationByteCount);
            removeLast.reconfigure(i, i2, config);
        }
        return removeLast;
    }

    public Bitmap removeLast() {
        Bitmap removeLast = this.entries.removeLast();
        if (removeLast != null) {
            decrementSize(removeLast.getAllocationByteCount());
        }
        return removeLast;
    }

    private final void decrementSize(int i) {
        int intValue = ((Number) MapsKt.getValue(this.sizes, Integer.valueOf(i))).intValue();
        if (intValue == 1) {
            this.sizes.remove(Integer.valueOf(i));
        } else {
            this.sizes.put(Integer.valueOf(i), Integer.valueOf(intValue - 1));
        }
    }

    public String stringify(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Bitmaps.getAllocationByteCountCompat(bitmap));
        sb.append(']');
        return sb.toString();
    }

    public String stringify(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Utils.INSTANCE.calculateAllocationByteCount(i, i2, config));
        sb.append(']');
        return sb.toString();
    }

    public String toString() {
        return "SizeStrategy: entries=" + this.entries + ", sizes=" + this.sizes;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/bitmap/SizeStrategy$Companion;", "", "()V", "MAX_SIZE_MULTIPLE", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: BitmapPoolStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
