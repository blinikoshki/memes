package editor.custom.overlayboundary;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R>\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Leditor/custom/overlayboundary/BoundaryCornerTouchListener;", "Landroid/view/View$OnTouchListener;", "initialPadding", "", "touchAnimationEnabled", "", "onCornerMoved", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "(IZLkotlin/jvm/functions/Function2;)V", "lastTouchX", "lastTouchY", "animate", "targetView", "Landroid/view/View;", "reverse", "collapse", "expand", "onTouch", "view", "event", "Landroid/view/MotionEvent;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryCornerTouchListener.kt */
public final class BoundaryCornerTouchListener implements View.OnTouchListener {
    private final int initialPadding;
    private float lastTouchX;
    private float lastTouchY;
    private final Function2<Float, Float, Unit> onCornerMoved;
    private final boolean touchAnimationEnabled;

    public BoundaryCornerTouchListener(int i, boolean z, Function2<? super Float, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onCornerMoved");
        this.initialPadding = i;
        this.touchAnimationEnabled = z;
        this.onCornerMoved = function2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastTouchX = motionEvent.getRawX();
            this.lastTouchY = motionEvent.getRawY();
            expand(view);
        } else if (action == 1) {
            collapse(view);
        } else if (action == 2) {
            float rawX = motionEvent.getRawX() - this.lastTouchX;
            float rawY = motionEvent.getRawY() - this.lastTouchY;
            this.lastTouchX = motionEvent.getRawX();
            this.lastTouchY = motionEvent.getRawY();
            this.onCornerMoved.invoke(Float.valueOf(rawX), Float.valueOf(rawY));
        }
        return true;
    }

    private final void expand(View view) {
        animate(view, false);
    }

    private final void collapse(View view) {
        animate(view, true);
    }

    private final void animate(View view, boolean z) {
        if (this.touchAnimationEnabled && view != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.initialPadding, 0});
            ofInt.addUpdateListener(new BoundaryCornerTouchListener$animate$1(view));
            if (z) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
        }
    }
}
