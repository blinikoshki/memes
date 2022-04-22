package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/FlipDrawableBuilder;", "Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "()V", "orientation", "", "build", "Landroid/graphics/drawable/Drawable;", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: FlipDrawableBuilder.kt */
public final class FlipDrawableBuilder extends DrawableWrapperBuilder<FlipDrawableBuilder> {
    private int orientation;

    public final FlipDrawableBuilder orientation(int i) {
        FlipDrawableBuilder flipDrawableBuilder = this;
        flipDrawableBuilder.orientation = i;
        return flipDrawableBuilder;
    }

    public Drawable build() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        return new FlipDrawable(drawable, this.orientation);
    }
}
