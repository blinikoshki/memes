package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/ScaleDrawableBuilder;", "Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "()V", "level", "", "scaleGravity", "scaleHeight", "", "scaleWidth", "build", "Landroid/graphics/drawable/Drawable;", "gravity", "scale", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: ScaleDrawableBuilder.kt */
public final class ScaleDrawableBuilder extends DrawableWrapperBuilder<ScaleDrawableBuilder> {
    private int level = 10000;
    private int scaleGravity = 17;
    private float scaleHeight;
    private float scaleWidth;

    public final ScaleDrawableBuilder level(int i) {
        ScaleDrawableBuilder scaleDrawableBuilder = this;
        scaleDrawableBuilder.level = i;
        return scaleDrawableBuilder;
    }

    public final ScaleDrawableBuilder scaleGravity(int i) {
        ScaleDrawableBuilder scaleDrawableBuilder = this;
        scaleDrawableBuilder.scaleGravity = i;
        return scaleDrawableBuilder;
    }

    public final ScaleDrawableBuilder scaleWidth(float f) {
        ScaleDrawableBuilder scaleDrawableBuilder = this;
        scaleDrawableBuilder.scaleWidth = f;
        return scaleDrawableBuilder;
    }

    public final ScaleDrawableBuilder scaleHeight(float f) {
        ScaleDrawableBuilder scaleDrawableBuilder = this;
        scaleDrawableBuilder.scaleHeight = f;
        return scaleDrawableBuilder;
    }

    public Drawable build() {
        ScaleDrawable scaleDrawable = new ScaleDrawable(getDrawable(), this.scaleGravity, this.scaleWidth, this.scaleHeight);
        scaleDrawable.setLevel(this.level);
        return scaleDrawable;
    }
}
