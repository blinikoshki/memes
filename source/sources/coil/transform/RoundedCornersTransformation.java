package coil.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import coil.bitmap.BitmapPool;
import coil.decode.DecodeUtils;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Scale;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, mo26107d2 = {"Lcoil/transform/RoundedCornersTransformation;", "Lcoil/transform/Transformation;", "radius", "", "(F)V", "topLeft", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "equals", "", "other", "", "hashCode", "", "key", "", "toString", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "input", "size", "Lcoil/size/Size;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RoundedCornersTransformation.kt */
public final class RoundedCornersTransformation implements Transformation {
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public RoundedCornersTransformation() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, (DefaultConstructorMarker) null);
    }

    public RoundedCornersTransformation(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomLeft = f3;
        this.bottomRight = f4;
        boolean z = false;
        float f5 = (float) 0;
        if (f >= f5 && f2 >= f5 && f3 >= f5 && f4 >= f5) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("All radii must be >= 0.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedCornersTransformation(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
    }

    public RoundedCornersTransformation(float f) {
        this(f, f, f, f);
    }

    public String key() {
        return RoundedCornersTransformation.class.getName() + '-' + this.topLeft + ',' + this.topRight + ',' + this.bottomLeft + ',' + this.bottomRight;
    }

    public Object transform(BitmapPool bitmapPool, Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        int i;
        int i2;
        Paint paint = new Paint(3);
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), pixelSize.getWidth(), pixelSize.getHeight(), Scale.FILL);
            i2 = MathKt.roundToInt(((double) pixelSize.getWidth()) / computeSizeMultiplier);
            i = MathKt.roundToInt(((double) pixelSize.getHeight()) / computeSizeMultiplier);
        } else if (size instanceof OriginalSize) {
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Bitmap bitmap2 = bitmapPool.get(i2, i, Bitmaps.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (i2 - bitmap.getWidth())) / 2.0f, ((float) (i - bitmap.getHeight())) / 2.0f);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f = this.topLeft;
        float f2 = this.topRight;
        float f3 = this.bottomRight;
        float f4 = this.bottomLeft;
        float[] fArr = {f, f, f2, f2, f3, f3, f4, f4};
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return bitmap2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (this.topLeft == roundedCornersTransformation.topLeft && this.topRight == roundedCornersTransformation.topRight && this.bottomLeft == roundedCornersTransformation.bottomLeft && this.bottomRight == roundedCornersTransformation.bottomRight) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.topLeft) * 31) + Float.floatToIntBits(this.topRight)) * 31) + Float.floatToIntBits(this.bottomLeft)) * 31) + Float.floatToIntBits(this.bottomRight);
    }

    public String toString() {
        return "RoundedCornersTransformation(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", " + "bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ')';
    }
}
