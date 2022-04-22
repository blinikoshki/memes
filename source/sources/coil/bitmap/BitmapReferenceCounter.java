package coil.bitmap;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, mo26107d2 = {"Lcoil/bitmap/BitmapReferenceCounter;", "", "decrement", "", "bitmap", "Landroid/graphics/Bitmap;", "increment", "", "setValid", "isValid", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BitmapReferenceCounter.kt */
public interface BitmapReferenceCounter {
    boolean decrement(Bitmap bitmap);

    void increment(Bitmap bitmap);

    void setValid(Bitmap bitmap, boolean z);
}
