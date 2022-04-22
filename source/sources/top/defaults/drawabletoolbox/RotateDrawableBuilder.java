package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/RotateDrawableBuilder;", "Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "()V", "fromDegrees", "", "pivotX", "pivotY", "toDegrees", "build", "Landroid/graphics/drawable/Drawable;", "degree", "x", "y", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: RotateDrawableBuilder.kt */
public final class RotateDrawableBuilder extends DrawableWrapperBuilder<RotateDrawableBuilder> {
    private float fromDegrees;
    private float pivotX = 0.5f;
    private float pivotY = 0.5f;
    private float toDegrees = 360.0f;

    public final RotateDrawableBuilder pivotX(float f) {
        RotateDrawableBuilder rotateDrawableBuilder = this;
        rotateDrawableBuilder.pivotX = f;
        return rotateDrawableBuilder;
    }

    public final RotateDrawableBuilder pivotY(float f) {
        RotateDrawableBuilder rotateDrawableBuilder = this;
        rotateDrawableBuilder.pivotY = f;
        return rotateDrawableBuilder;
    }

    public final RotateDrawableBuilder fromDegrees(float f) {
        RotateDrawableBuilder rotateDrawableBuilder = this;
        rotateDrawableBuilder.fromDegrees = f;
        return rotateDrawableBuilder;
    }

    public final RotateDrawableBuilder toDegrees(float f) {
        RotateDrawableBuilder rotateDrawableBuilder = this;
        rotateDrawableBuilder.toDegrees = f;
        return rotateDrawableBuilder;
    }

    public Drawable build() {
        RotateDrawable rotateDrawable = new RotateDrawable();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            CompatibleKt.setDrawable(rotateDrawable, drawable);
            RotateDrawableBuilder rotateDrawableBuilder = this;
            CompatibleKt.setPivotX(rotateDrawable, rotateDrawableBuilder.pivotX);
            CompatibleKt.setPivotY(rotateDrawable, rotateDrawableBuilder.pivotY);
            CompatibleKt.setFromDegrees(rotateDrawable, rotateDrawableBuilder.fromDegrees);
            CompatibleKt.setToDegrees(rotateDrawable, rotateDrawableBuilder.toDegrees);
        }
        return rotateDrawable;
    }
}
