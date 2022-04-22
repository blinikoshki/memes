package coil.bitmap;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, mo26107d2 = {"Lcoil/bitmap/EmptyBitmapReferenceCounter;", "Lcoil/bitmap/BitmapReferenceCounter;", "()V", "decrement", "", "bitmap", "Landroid/graphics/Bitmap;", "increment", "", "setValid", "isValid", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BitmapReferenceCounter.kt */
public final class EmptyBitmapReferenceCounter implements BitmapReferenceCounter {
    public static final EmptyBitmapReferenceCounter INSTANCE = new EmptyBitmapReferenceCounter();

    public boolean decrement(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return false;
    }

    public void increment(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    public void setValid(Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    private EmptyBitmapReferenceCounter() {
    }
}
