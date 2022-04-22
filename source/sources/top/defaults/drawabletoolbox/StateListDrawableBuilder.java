package top.defaults.drawabletoolbox;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/StateListDrawableBuilder;", "", "()V", "disabled", "Landroid/graphics/drawable/Drawable;", "normal", "pressed", "selected", "build", "Landroid/graphics/drawable/StateListDrawable;", "setupStateListDrawable", "", "stateListDrawable", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: StateListDrawableBuilder.kt */
public final class StateListDrawableBuilder {
    private Drawable disabled;
    private Drawable normal = new ColorDrawable(0);
    private Drawable pressed;
    private Drawable selected;

    public final StateListDrawableBuilder pressed(Drawable drawable) {
        StateListDrawableBuilder stateListDrawableBuilder = this;
        stateListDrawableBuilder.pressed = drawable;
        return stateListDrawableBuilder;
    }

    public final StateListDrawableBuilder disabled(Drawable drawable) {
        StateListDrawableBuilder stateListDrawableBuilder = this;
        stateListDrawableBuilder.disabled = drawable;
        return stateListDrawableBuilder;
    }

    public final StateListDrawableBuilder selected(Drawable drawable) {
        StateListDrawableBuilder stateListDrawableBuilder = this;
        stateListDrawableBuilder.selected = drawable;
        return stateListDrawableBuilder;
    }

    public final StateListDrawableBuilder normal(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "normal");
        StateListDrawableBuilder stateListDrawableBuilder = this;
        stateListDrawableBuilder.normal = drawable;
        return stateListDrawableBuilder;
    }

    public final StateListDrawable build() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        setupStateListDrawable(stateListDrawable);
        return stateListDrawable;
    }

    private final void setupStateListDrawable(StateListDrawable stateListDrawable) {
        Drawable drawable = this.pressed;
        if (drawable != null) {
            stateListDrawable.addState(new int[]{16842919}, drawable);
        }
        Drawable drawable2 = this.disabled;
        if (drawable2 != null) {
            stateListDrawable.addState(new int[]{-16842910}, drawable2);
        }
        Drawable drawable3 = this.selected;
        if (drawable3 != null) {
            stateListDrawable.addState(new int[]{16842913}, drawable3);
        }
        stateListDrawable.addState(StateSet.WILD_CARD, this.normal);
    }
}
