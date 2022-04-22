package editor.editor.equipment.core;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.common.corners.NicoCornerType;
import editor.common.corners.NicoCornerUtil;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J.\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rJ.\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0019H\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u0019J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\rJ\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u0006\u00103\u001a\u000201J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\u0014\u00106\u001a\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b08J\u001c\u00109\u001a\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b082\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000201J\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u00020\u000bJ\u0010\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010A\u001a\u00020\u000b2\b\b\u0001\u0010B\u001a\u00020\u0019J\u000e\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u000201J\u000e\u0010H\u001a\u00020\u000b2\u0006\u0010G\u001a\u000201J\u000e\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\rJ\u0016\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\rJ\u000e\u0010N\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010O\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010P\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010Q\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010R\u001a\u00020\u000bJ\u0016\u0010S\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ\u000b\u0010T\u001a\u00028\u0000¢\u0006\u0002\u0010UR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006V"}, mo26107d2 = {"Leditor/editor/equipment/core/CoreLayer;", "V", "Landroid/view/View;", "Leditor/editor/equipment/core/CoreLayerLifecycle;", "view", "(Landroid/view/View;)V", "drawingRect", "Landroid/graphics/Rect;", "hitRect", "Landroid/view/View;", "animateBy", "", "deltaX", "", "deltaY", "deltaScale", "deltaRotation", "animateTo", "x", "y", "scale", "rotation", "bringToFront", "changeWidthHeight", "width", "", "height", "changeWidthHeightBy", "flipHorizontally", "flipVertically", "getBackground", "Landroid/graphics/drawable/Drawable;", "getBackgroundColor", "getDrawingRect", "getHeight", "getHitRect", "getLifecycle", "getOpacity", "getPivotPoint", "Landroid/graphics/PointF;", "getRotation", "getScale", "getWidth", "getX", "getY", "halfHeight", "halfWidth", "hide", "isFlippedHorizontally", "", "isFlippedVertically", "isVisible", "onAdding", "onRemoving", "post", "function", "Lkotlin/Function0;", "postDelayed", "delayMillis", "", "remove", "reset", "resetPivot", "setBackground", "drawable", "setBackgroundColor", "color", "setCornerType", "type", "Leditor/common/corners/NicoCornerType;", "setFlippedHorizontally", "flipped", "setFlippedVertically", "setOpacity", "opacity", "setPivot", "pivotX", "pivotY", "setRotation", "setScale", "setX", "setY", "show", "translateBy", "underlyingView", "()Landroid/view/View;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoreLayer.kt */
public class CoreLayer<V extends View> implements CoreLayerLifecycle {
    private final Rect drawingRect = new Rect();
    private final Rect hitRect = new Rect();
    private final V view;

    public void onAdding() {
    }

    public void onRemoving() {
    }

    public CoreLayer(V v) {
        Intrinsics.checkNotNullParameter(v, ViewHierarchyConstants.VIEW_KEY);
        this.view = v;
    }

    public final V underlyingView() {
        return this.view;
    }

    public final CoreLayerLifecycle getLifecycle() {
        return this;
    }

    public final float getX() {
        return this.view.getX();
    }

    public final void setX(float f) {
        this.view.setX(f);
    }

    public final float getY() {
        return this.view.getY();
    }

    public final void setY(float f) {
        this.view.setY(f);
    }

    public final int getWidth() {
        return this.view.getWidth();
    }

    public final float halfWidth() {
        return ((float) this.view.getWidth()) / 2.0f;
    }

    public final int getHeight() {
        return this.view.getHeight();
    }

    public final float halfHeight() {
        return ((float) this.view.getHeight()) / 2.0f;
    }

    public final void changeWidthHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.view.setLayoutParams(layoutParams);
    }

    public final void changeWidthHeightBy(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.width += i;
        layoutParams.height += i2;
        this.view.setLayoutParams(layoutParams);
    }

    public final Rect getHitRect() {
        this.view.getHitRect(this.hitRect);
        return this.hitRect;
    }

    public final Rect getDrawingRect() {
        this.view.getDrawingRect(this.drawingRect);
        return this.drawingRect;
    }

    public static /* synthetic */ void animateTo$default(CoreLayer coreLayer, float f, float f2, float f3, float f4, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                f = Float.NaN;
            }
            if ((i & 2) != 0) {
                f2 = Float.NaN;
            }
            if ((i & 4) != 0) {
                f3 = Float.NaN;
            }
            if ((i & 8) != 0) {
                f4 = Float.NaN;
            }
            coreLayer.animateTo(f, f2, f3, f4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }

    public final void animateTo(float f, float f2, float f3, float f4) {
        ViewPropertyAnimator animator$default = ExtKt.animator$default(this.view, 0, 1, (Object) null);
        if (!Float.isNaN(f)) {
            animator$default.x(f);
        }
        if (!Float.isNaN(f2)) {
            animator$default.y(f2);
        }
        if (!Float.isNaN(f3)) {
            animator$default.scaleX(f3);
            animator$default.scaleY(f3);
        }
        if (!Float.isNaN(f4)) {
            animator$default.rotation(f4);
        }
    }

    public static /* synthetic */ void animateBy$default(CoreLayer coreLayer, float f, float f2, float f3, float f4, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                f = 0.0f;
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            if ((i & 4) != 0) {
                f3 = 0.0f;
            }
            if ((i & 8) != 0) {
                f4 = 0.0f;
            }
            coreLayer.animateBy(f, f2, f3, f4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateBy");
    }

    public final void animateBy(float f, float f2, float f3, float f4) {
        ViewPropertyAnimator animator$default = ExtKt.animator$default(this.view, 0, 1, (Object) null);
        if (f != 0.0f) {
            animator$default.xBy(f);
        }
        if (f2 != 0.0f) {
            animator$default.yBy(f2);
        }
        if (f3 != 0.0f) {
            animator$default.scaleXBy(f3);
            animator$default.scaleYBy(f3);
        }
        if (f4 != 0.0f) {
            animator$default.rotationBy(f4);
        }
    }

    public final PointF getPivotPoint() {
        return new PointF(this.view.getPivotX(), this.view.getPivotY());
    }

    public final void setPivot(float f, float f2) {
        this.view.setPivotX(f);
        this.view.setPivotY(f2);
    }

    public final void resetPivot() {
        float left = ((float) this.view.getLeft()) + halfWidth();
        float top2 = ((float) this.view.getTop()) + halfHeight();
        if (left != 0.0f && top2 != 0.0f) {
            this.view.setPivotX(left);
            this.view.setPivotY(top2);
        }
    }

    public final void translateBy(float f, float f2) {
        ExtKt.animator$default(this.view, 0, 1, (Object) null).setDuration(0).xBy(f).yBy(f2);
    }

    public final float getRotation() {
        return this.view.getRotation();
    }

    public final void setRotation(float f) {
        this.view.setRotation(f);
    }

    public final float getScale() {
        return this.view.getScaleX();
    }

    public final void setScale(float f) {
        this.view.setScaleX(f);
        this.view.setScaleY(f);
    }

    public final float getOpacity() {
        return this.view.getAlpha();
    }

    public final void setOpacity(float f) {
        this.view.setAlpha(f);
    }

    public final int getBackgroundColor() {
        Drawable background = this.view.getBackground();
        if (background instanceof ColorDrawable) {
            return ((ColorDrawable) background).getColor();
        }
        Timber.m300d("Layer background color is not set. Returning transparent color;", new Object[0]);
        return 0;
    }

    public final void setBackgroundColor(int i) {
        this.view.setBackgroundColor(i);
    }

    public final Drawable getBackground() {
        Drawable background = this.view.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "view.background");
        return background;
    }

    public final void setBackground(Drawable drawable) {
        this.view.setBackground(drawable);
    }

    public final boolean isFlippedHorizontally() {
        return this.view.getRotationY() != 0.0f;
    }

    public final void flipHorizontally() {
        setFlippedHorizontally(!isFlippedHorizontally());
    }

    public final void setFlippedHorizontally(boolean z) {
        resetPivot();
        this.view.setRotationY(z ? 180.0f : 0.0f);
    }

    public final boolean isFlippedVertically() {
        return this.view.getRotationX() != 0.0f;
    }

    public final void flipVertically() {
        setFlippedVertically(!isFlippedVertically());
    }

    public final void setFlippedVertically(boolean z) {
        resetPivot();
        this.view.setRotationX(z ? 180.0f : 0.0f);
    }

    public final void setCornerType(NicoCornerType nicoCornerType) {
        Intrinsics.checkNotNullParameter(nicoCornerType, "type");
        NicoCornerUtil.INSTANCE.setCornerType(this.view, nicoCornerType);
    }

    public final void post(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "function");
        this.view.post(new CoreLayer$post$1(function0));
    }

    public final void postDelayed(Function0<Unit> function0, long j) {
        Intrinsics.checkNotNullParameter(function0, "function");
        this.view.postDelayed(new CoreLayer$sam$java_lang_Runnable$0(function0), j);
    }

    public final boolean isVisible() {
        return this.view.getVisibility() == 0;
    }

    public final void bringToFront() {
        this.view.bringToFront();
    }

    public final void show() {
        this.view.setVisibility(0);
    }

    public final void hide() {
        this.view.setVisibility(8);
    }

    public final void reset() {
        setRotation(0.0f);
        setScale(1.0f);
        setFlippedHorizontally(false);
        setFlippedVertically(false);
    }

    public final boolean remove() {
        ViewParent parent = this.view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup == null) {
            return false;
        }
        onRemoving();
        viewGroup.removeView(this.view);
        return true;
    }
}
