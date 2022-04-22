package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u00106\u001a\u0004\u0018\u00010\u001e2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0002J\u001a\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u001e2\u0006\u0010;\u001a\u00020<H\u0002J \u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u001e2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u0012\u0010=\u001a\u00020\u00162\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J,\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010<2\b\u0010A\u001a\u0004\u0018\u00010<2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\fH\u0016J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010E\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J,\u0010F\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010<2\b\u0010A\u001a\u0004\u0018\u00010<2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0016J\u0012\u0010I\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010J\u001a\u00020\u00162\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010K\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010<H\u0016R5\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R(\u0010.\u001a\u0004\u0018\u00010\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u000e\u00101\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R \u00103\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001c¨\u0006L"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GPHTouchInterceptor;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragAccumulator", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "drag", "", "getDragAccumulator", "()Lkotlin/jvm/functions/Function1;", "setDragAccumulator", "(Lkotlin/jvm/functions/Function1;)V", "dragLock", "", "dragRelease", "Lkotlin/Function0;", "getDragRelease", "()Lkotlin/jvm/functions/Function0;", "setDragRelease", "(Lkotlin/jvm/functions/Function0;)V", "dragView", "Landroid/view/View;", "getDragView", "()Landroid/view/View;", "setDragView", "(Landroid/view/View;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "setGestureDetector", "(Landroid/view/GestureDetector;)V", "globalRect", "Landroid/graphics/Rect;", "lastMoveX", "lastMoveY", "value", "slideView", "getSlideView", "setSlideView", "startX", "startY", "touchOutside", "getTouchOutside", "setTouchOutside", "findTopChildUnder", "x", "y", "isViewUnder", "view", "event", "Landroid/view/MotionEvent;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", "onInterceptTouchEvent", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHTouchInterceptor */
/* compiled from: GPHTouchInterceptor.kt */
public final class GPHTouchInterceptor extends FrameLayout implements GestureDetector.OnGestureListener {
    private HashMap _$_findViewCache;
    private Function1<? super Float, Unit> dragAccumulator;
    private boolean dragLock;
    private Function0<Unit> dragRelease;
    private View dragView;
    private GestureDetector gestureDetector;
    private final Rect globalRect;
    private float lastMoveX;
    private float lastMoveY;
    private View slideView;
    private float startX;
    private float startY;
    private Function0<Unit> touchOutside;

    public GPHTouchInterceptor(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GPHTouchInterceptor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHTouchInterceptor(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GPHTouchInterceptor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.gestureDetector = new GestureDetector(context, this);
        this.dragAccumulator = GPHTouchInterceptor$dragAccumulator$1.INSTANCE;
        this.dragRelease = GPHTouchInterceptor$dragRelease$1.INSTANCE;
        this.touchOutside = GPHTouchInterceptor$touchOutside$1.INSTANCE;
        this.globalRect = new Rect();
    }

    public final View getDragView() {
        return this.dragView;
    }

    public final void setDragView(View view) {
        this.dragView = view;
    }

    public final View getSlideView() {
        return this.slideView;
    }

    public final void setSlideView(View view) {
        this.slideView = view;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
        if (view != null) {
            view.setClickable(true);
        }
        if (view != null) {
            view.setFocusableInTouchMode(false);
        }
        if (view != null) {
            view.setFocusable(false);
        }
    }

    public final GestureDetector getGestureDetector() {
        return this.gestureDetector;
    }

    public final void setGestureDetector(GestureDetector gestureDetector2) {
        Intrinsics.checkParameterIsNotNull(gestureDetector2, "<set-?>");
        this.gestureDetector = gestureDetector2;
    }

    public final Function1<Float, Unit> getDragAccumulator() {
        return this.dragAccumulator;
    }

    public final void setDragAccumulator(Function1<? super Float, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.dragAccumulator = function1;
    }

    public final Function0<Unit> getDragRelease() {
        return this.dragRelease;
    }

    public final void setDragRelease(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.dragRelease = function0;
    }

    public final Function0<Unit> getTouchOutside() {
        return this.touchOutside;
    }

    public final void setTouchOutside(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.touchOutside = function0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r1 != 3) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "onInterceptTouchEvent"
            timber.log.Timber.m300d(r2, r1)
            r6.getX()
            r6.getY()
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0076
            r2 = 1
            if (r1 == r2) goto L_0x0073
            r3 = 2
            if (r1 == r3) goto L_0x0023
            r2 = 3
            if (r1 == r2) goto L_0x0073
            goto L_0x008d
        L_0x0023:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r3 = "onInterceptTouch move"
            timber.log.Timber.m300d(r3, r1)
            float r1 = r6.getX()
            float r3 = r5.startX
            float r1 = r1 - r3
            r5.lastMoveX = r1
            float r1 = r6.getY()
            float r3 = r5.startY
            float r1 = r1 - r3
            r5.lastMoveY = r1
            android.view.View r1 = r5.dragView
            boolean r1 = r5.isViewUnder(r1, r6)
            if (r1 == 0) goto L_0x008d
            float r1 = r5.lastMoveY
            float r1 = java.lang.Math.abs(r1)
            android.content.Context r3 = r5.getContext()
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            java.lang.String r4 = "ViewConfiguration.get(context)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r3 = r3.getScaledTouchSlop()
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x008d
            boolean r1 = r5.dragLock
            if (r1 != 0) goto L_0x0070
            float r1 = r6.getX()
            r5.startX = r1
            float r1 = r6.getY()
            r5.startY = r1
        L_0x0070:
            r5.dragLock = r2
            goto L_0x008d
        L_0x0073:
            r5.dragLock = r0
            goto L_0x008d
        L_0x0076:
            float r1 = r6.getX()
            r5.startX = r1
            float r1 = r6.getY()
            r5.startY = r1
            android.view.View r1 = r5.dragView
            boolean r1 = r5.isViewUnder(r1, r6)
            if (r1 == 0) goto L_0x008d
            r5.dragLock = r0
            return r0
        L_0x008d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onInterceptTouch "
            r1.append(r2)
            int r2 = r6.getAction()
            r1.append(r2)
            r2 = 32
            r1.append(r2)
            int r3 = r6.getActionMasked()
            r1.append(r3)
            r1.append(r2)
            float r6 = r6.getY()
            r1.append(r6)
            r1.append(r2)
            boolean r6 = r5.dragLock
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            timber.log.Timber.m300d(r6, r0)
            boolean r6 = r5.dragLock
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GPHTouchInterceptor.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Timber.m300d("onTouchEvent " + this.dragLock, new Object[0]);
        this.gestureDetector.onTouchEvent(motionEvent);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float abs = Math.abs(this.lastMoveY);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
            if (abs > ((float) viewConfiguration.getScaledTouchSlop())) {
                if (!this.dragLock) {
                    this.startX = motionEvent.getX();
                    this.startY = motionEvent.getY();
                }
                this.dragLock = true;
            }
            Timber.m300d("onMove " + motionEvent.getX() + ' ' + motionEvent.getY(), new Object[0]);
            this.lastMoveX = motionEvent.getX() - this.startX;
            this.lastMoveY = motionEvent.getY() - this.startY;
            if (this.dragLock) {
                this.lastMoveX = motionEvent.getX() - this.startX;
                float y = motionEvent.getY() - this.startY;
                this.lastMoveY = y;
                this.dragAccumulator.invoke(Float.valueOf(y));
                this.startX = motionEvent.getX();
                this.startY = motionEvent.getY();
            }
        } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
            this.dragRelease.invoke();
            this.dragLock = false;
        }
        return this.dragLock;
    }

    public final boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    private final boolean isViewUnder(View view, MotionEvent motionEvent) {
        if (view == null || view.getGlobalVisibleRect(this.globalRect)) {
            return this.globalRect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
        return false;
    }

    private final View findTopChildUnder(int i, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null || isViewUnder(this.slideView, motionEvent)) {
            return false;
        }
        Timber.m300d("user tapped outside", new Object[0]);
        this.touchOutside.invoke();
        return true;
    }
}
