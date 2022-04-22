package coil.bitmap;

import android.graphics.Bitmap;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, mo26107d2 = {"Lcoil/bitmap/EmptyBitmapPool;", "Lcoil/bitmap/BitmapPool;", "()V", "assertNotHardware", "", "config", "Landroid/graphics/Bitmap$Config;", "clear", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "getDirty", "getDirtyOrNull", "getOrNull", "put", "bitmap", "trimMemory", "level", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: EmptyBitmapPool.kt */
public final class EmptyBitmapPool implements BitmapPool {
    public void clear() {
    }

    public void trimMemory(int i) {
    }

    public void put(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        bitmap.recycle();
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return getDirty(i, i2, config);
    }

    public Bitmap getOrNull(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return getDirtyOrNull(i, i2, config);
    }

    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        assertNotHardware(config);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public Bitmap getDirtyOrNull(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        assertNotHardware(config);
        return null;
    }

    private final void assertNotHardware(Bitmap.Config config) {
        if (!(!Bitmaps.isHardware(config))) {
            throw new IllegalArgumentException("Cannot create a mutable hardware bitmap.".toString());
        }
    }
}
