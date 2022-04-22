package coil.drawable;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0017J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0013H\u0014J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0014J \u0010%\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u0013H\u0016J\u0012\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0017J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0013H\u0017J\u0012\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u000102H\u0017J\u0012\u00103\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u000105H\u0017J\u0012\u00106\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u000108H\u0017J\b\u00109\u001a\u00020\u000fH\u0016J\b\u0010:\u001a\u00020\u000fH\u0016J\u0018\u0010;\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, mo26107d2 = {"Lcoil/drawable/ScaleDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Animatable;", "child", "scale", "Lcoil/size/Scale;", "(Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;)V", "getChild", "()Landroid/graphics/drawable/Drawable;", "childDx", "", "childDy", "childScale", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "", "getColorFilter", "Landroid/graphics/ColorFilter;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "invalidateDrawable", "who", "isRunning", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLevelChange", "level", "onStateChange", "state", "", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "setTint", "tintColor", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "start", "stop", "unscheduleDrawable", "coil-gif_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ScaleDrawable.kt */
public final class ScaleDrawable extends Drawable implements Drawable.Callback, Animatable {
    private final Drawable child;
    private float childDx;
    private float childDy;
    private float childScale;
    private final Scale scale;

    public ScaleDrawable(Drawable drawable) {
        this(drawable, (Scale) null, 2, (DefaultConstructorMarker) null);
    }

    public final Drawable getChild() {
        return this.child;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScaleDrawable(Drawable drawable, Scale scale2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i & 2) != 0 ? Scale.FIT : scale2);
    }

    public ScaleDrawable(Drawable drawable, Scale scale2) {
        Intrinsics.checkNotNullParameter(drawable, "child");
        Intrinsics.checkNotNullParameter(scale2, "scale");
        this.child = drawable;
        this.scale = scale2;
        this.childScale = 1.0f;
        drawable.setCallback(this);
    }

    public int getAlpha() {
        return this.child.getAlpha();
    }

    public void setAlpha(int i) {
        this.child.setAlpha(i);
    }

    public int getOpacity() {
        return this.child.getOpacity();
    }

    public ColorFilter getColorFilter() {
        return this.child.getColorFilter();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.child.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        int intrinsicWidth = this.child.getIntrinsicWidth();
        int intrinsicHeight = this.child.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            this.child.setBounds(rect);
            this.childDx = 0.0f;
            this.childDy = 0.0f;
            this.childScale = 1.0f;
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, width, height, this.scale);
        double d = (double) 2;
        int roundToInt = MathKt.roundToInt((((double) width) - (((double) intrinsicWidth) * computeSizeMultiplier)) / d);
        int roundToInt2 = MathKt.roundToInt((((double) height) - (((double) intrinsicHeight) * computeSizeMultiplier)) / d);
        this.child.setBounds(roundToInt, roundToInt2, intrinsicWidth + roundToInt, intrinsicHeight + roundToInt2);
        this.childDx = (float) rect.left;
        this.childDy = (float) rect.top;
        this.childScale = (float) computeSizeMultiplier;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.child.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "state");
        return this.child.setState(iArr);
    }

    public int getIntrinsicWidth() {
        return this.child.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.child.getIntrinsicHeight();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
        unscheduleSelf(runnable);
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
        scheduleSelf(runnable, j);
    }

    public void setTint(int i) {
        this.child.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.child.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.child.setTintMode(mode);
    }

    public void setTintBlendMode(BlendMode blendMode) {
        this.child.setTintBlendMode(blendMode);
    }

    public boolean isRunning() {
        Drawable drawable = this.child;
        return (drawable instanceof Animatable) && ((Animatable) drawable).isRunning();
    }

    public void start() {
        Drawable drawable = this.child;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    public void stop() {
        Drawable drawable = this.child;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        try {
            canvas.translate(this.childDx, this.childDy);
            float f = this.childScale;
            canvas.scale(f, f);
            this.child.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}
