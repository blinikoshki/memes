package coil.bitmap;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: BitmapReferenceCounter.kt */
final class RealBitmapReferenceCounter$decrement$2 implements Runnable {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ RealBitmapReferenceCounter this$0;

    RealBitmapReferenceCounter$decrement$2(RealBitmapReferenceCounter realBitmapReferenceCounter, Bitmap bitmap) {
        this.this$0 = realBitmapReferenceCounter;
        this.$bitmap = bitmap;
    }

    public final void run() {
        this.this$0.bitmapPool.put(this.$bitmap);
    }
}
