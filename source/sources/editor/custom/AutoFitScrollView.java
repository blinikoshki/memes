package editor.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016JR\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u001fH\u0017J\u001a\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\tH\u0002JS\u0010/\u001a\u00020\u00162K\u00100\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000RU\u0010\u0010\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, mo26107d2 = {"Leditor/custom/AutoFitScrollView;", "Landroid/widget/ScrollView;", "Landroid/view/View$OnLayoutChangeListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canScroll", "", "childView", "Landroid/view/View;", "childViewRect", "Landroid/graphics/Rect;", "scaleFactor", "", "subscription", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "childRect", "scale", "", "applyScale", "computeScrollDeltaToGetChildRectOnScreen", "", "rect", "invokeSubscribedUpdate", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayoutChange", "view", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onTouchEvent", "event", "scaleTo", "factor", "useAnimation", "subscribeToLayoutUpdates", "block", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AutoFitScrollView.kt */
public class AutoFitScrollView extends ScrollView implements View.OnLayoutChangeListener {
    private final boolean canScroll;
    /* access modifiers changed from: private */
    public View childView;
    /* access modifiers changed from: private */
    public final Rect childViewRect = new Rect();
    /* access modifiers changed from: private */
    public float scaleFactor = 1.0f;
    /* access modifiers changed from: private */
    public Function3<? super View, ? super Rect, ? super Float, Unit> subscription;

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    public static final /* synthetic */ View access$getChildView$p(AutoFitScrollView autoFitScrollView) {
        View view = autoFitScrollView.childView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childView");
        }
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoFitScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
            this.childView = childAt;
            super.onFinishInflate();
            View view = this.childView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            view.addOnLayoutChangeListener(this);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            return;
        }
        throw new RuntimeException("ScrollView must have one child");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        return this.canScroll && super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.canScroll && super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view != null) {
            int id = view.getId();
            View view2 = this.childView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            if (id == view2.getId()) {
                this.childViewRect.left = i;
                this.childViewRect.top = i2;
                this.childViewRect.right = i3;
                this.childViewRect.bottom = i4;
                applyScale();
            }
        }
    }

    public final void subscribeToLayoutUpdates(Function3<? super View, ? super Rect, ? super Float, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.subscription = function3;
        invokeSubscribedUpdate();
    }

    private final void applyScale() {
        View view = this.childView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childView");
        }
        float width = (float) view.getWidth();
        View view2 = this.childView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childView");
        }
        float height = (float) view2.getHeight();
        float height2 = (float) getHeight();
        if (height > height2) {
            float f = height2 / height;
            float f2 = height * f;
            scaleTo$default(this, f, false, 2, (Object) null);
            float f3 = (float) 2;
            scrollTo((int) ((width - (width * f)) / f3), (int) ((height - f2) / f3));
            return;
        }
        scaleTo$default(this, 1.0f, false, 2, (Object) null);
    }

    static /* synthetic */ void scaleTo$default(AutoFitScrollView autoFitScrollView, float f, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            autoFitScrollView.scaleTo(f, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleTo");
    }

    private final void scaleTo(float f, boolean z) {
        if (z) {
            View view = this.childView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            view.animate().scaleX(f).scaleY(f).setDuration(500).start();
        } else {
            View view2 = this.childView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            view2.setScaleX(f);
            View view3 = this.childView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            view3.setScaleY(f);
        }
        this.scaleFactor = f;
        invokeSubscribedUpdate();
    }

    private final void invokeSubscribedUpdate() {
        post(new AutoFitScrollView$invokeSubscribedUpdate$1(this));
    }
}
