package coil.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import coil.bitmap.BitmapPool;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, mo26107d2 = {"Lcoil/transform/CircleCropTransformation;", "Lcoil/transform/Transformation;", "()V", "equals", "", "other", "", "hashCode", "", "key", "", "toString", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "input", "size", "Lcoil/size/Size;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: CircleCropTransformation.kt */
public final class CircleCropTransformation implements Transformation {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PorterDuffXfermode XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    public String toString() {
        return "CircleCropTransformation()";
    }

    public String key() {
        String name = CircleCropTransformation.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "CircleCropTransformation::class.java.name");
        return name;
    }

    public Object transform(BitmapPool bitmapPool, Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f = ((float) min) / 2.0f;
        Bitmap bitmap2 = bitmapPool.get(min, min, Bitmaps.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(XFERMODE);
        canvas.drawBitmap(bitmap, f - (((float) bitmap.getWidth()) / 2.0f), f - (((float) bitmap.getHeight()) / 2.0f), paint);
        return bitmap2;
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCropTransformation;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcoil/transform/CircleCropTransformation$Companion;", "", "()V", "XFERMODE", "Landroid/graphics/PorterDuffXfermode;", "getXFERMODE", "()Landroid/graphics/PorterDuffXfermode;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: CircleCropTransformation.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PorterDuffXfermode getXFERMODE() {
            return CircleCropTransformation.XFERMODE;
        }
    }
}
