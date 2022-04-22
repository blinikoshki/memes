package top.defaults.drawabletoolbox;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.util.StateSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/RippleDrawableBuilder;", "Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "()V", "color", "", "colorStateList", "Landroid/content/res/ColorStateList;", "radius", "build", "Landroid/graphics/drawable/Drawable;", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: RippleDrawableBuilder.kt */
public final class RippleDrawableBuilder extends DrawableWrapperBuilder<RippleDrawableBuilder> {
    private int color = Constants.DEFAULT_COLOR;
    private ColorStateList colorStateList;
    private int radius = -1;

    public final RippleDrawableBuilder color(int i) {
        RippleDrawableBuilder rippleDrawableBuilder = this;
        rippleDrawableBuilder.color = i;
        return rippleDrawableBuilder;
    }

    public final RippleDrawableBuilder colorStateList(ColorStateList colorStateList2) {
        RippleDrawableBuilder rippleDrawableBuilder = this;
        rippleDrawableBuilder.colorStateList = colorStateList2;
        return rippleDrawableBuilder;
    }

    public final RippleDrawableBuilder radius(int i) {
        RippleDrawableBuilder rippleDrawableBuilder = this;
        rippleDrawableBuilder.radius = i;
        return rippleDrawableBuilder;
    }

    public Drawable build() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return drawable;
        }
        ColorStateList colorStateList2 = this.colorStateList;
        if (colorStateList2 == null) {
            colorStateList2 = new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{this.color});
        }
        Drawable current = drawable instanceof DrawableContainer ? drawable.getCurrent() : drawable;
        if (current instanceof ShapeDrawable) {
            Drawable.ConstantState constantState = current.getConstantState();
            if (constantState != null) {
                Drawable mutate = constantState.newDrawable().mutate();
                if (mutate != null) {
                    ShapeDrawable shapeDrawable = (ShapeDrawable) mutate;
                    Paint paint = shapeDrawable.getPaint();
                    Intrinsics.checkExpressionValueIsNotNull(paint, "temp.paint");
                    paint.setColor(-16777216);
                    current = shapeDrawable;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
                }
            }
        } else if (current instanceof GradientDrawable) {
            Drawable.ConstantState constantState2 = current.getConstantState();
            if (constantState2 != null) {
                Drawable mutate2 = constantState2.newDrawable().mutate();
                if (mutate2 != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) mutate2;
                    gradientDrawable.setColor(-16777216);
                    current = gradientDrawable;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            }
        } else {
            current = new ColorDrawable(-16777216);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList2, drawable, current);
        CompatibleKt.setRadius(rippleDrawable, this.radius);
        rippleDrawable.invalidateSelf();
        return rippleDrawable;
    }
}
