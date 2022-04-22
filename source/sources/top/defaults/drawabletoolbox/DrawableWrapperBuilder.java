package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import top.defaults.drawabletoolbox.DrawableWrapperBuilder;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H&J\u0013\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "T", "", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "build", "(Landroid/graphics/drawable/Drawable;)Ltop/defaults/drawabletoolbox/DrawableWrapperBuilder;", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: DrawableWrapperBuilder.kt */
public abstract class DrawableWrapperBuilder<T extends DrawableWrapperBuilder<T>> {
    private Drawable drawable;

    public abstract Drawable build();

    /* access modifiers changed from: protected */
    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* access modifiers changed from: protected */
    public final void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
    }

    public final T drawable(Drawable drawable2) {
        Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
        T t = this;
        t.drawable = drawable2;
        return t;
    }
}
