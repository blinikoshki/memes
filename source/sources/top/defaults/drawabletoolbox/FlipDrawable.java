package top.defaults.drawabletoolbox;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/FlipDrawable;", "Landroid/graphics/drawable/Drawable;", "drawable", "orientation", "", "(Landroid/graphics/drawable/Drawable;I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "onLevelChange", "", "level", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: FlipDrawable.kt */
public final class FlipDrawable extends Drawable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private Drawable drawable;
    private int orientation;

    public FlipDrawable(Drawable drawable2, int i) {
        Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
        this.drawable = drawable2;
        this.orientation = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlipDrawable(Drawable drawable2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable2, (i2 & 2) != 0 ? 0 : i);
    }

    @Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/FlipDrawable$Companion;", "", "()V", "ORIENTATION_HORIZONTAL", "", "ORIENTATION_VERTICAL", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
    /* compiled from: FlipDrawable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        int save = canvas.save();
        if (this.orientation == 1) {
            canvas.scale(1.0f, -1.0f, (float) (canvas.getWidth() / 2), (float) (canvas.getHeight() / 2));
        } else {
            canvas.scale(-1.0f, 1.0f, (float) (canvas.getWidth() / 2), (float) (canvas.getHeight() / 2));
        }
        this.drawable.setBounds(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()));
        this.drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        this.drawable.setLevel(i);
        invalidateSelf();
        return true;
    }

    public int getIntrinsicWidth() {
        return this.drawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.drawable.getIntrinsicHeight();
    }

    public void setAlpha(int i) {
        this.drawable.setAlpha(i);
    }

    public int getOpacity() {
        return this.drawable.getOpacity();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter);
    }
}
