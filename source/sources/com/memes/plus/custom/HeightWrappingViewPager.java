package com.memes.plus.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.memes.plus.C4199R;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u001dH\u0002J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001dH\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/custom/HeightWrappingViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationDuration", "", "animator", "Landroid/animation/ValueAnimator;", "<set-?>", "", "enableAnimation", "getEnableAnimation", "()Z", "setEnableAnimation", "(Z)V", "enableAnimation$delegate", "Lkotlin/properties/ReadWriteProperty;", "onPageChangeListener", "com/memes/plus/custom/HeightWrappingViewPager$onPageChangeListener$1", "Lcom/memes/plus/custom/HeightWrappingViewPager$onPageChangeListener$1;", "animateContentHeight", "", "childView", "Landroid/view/View;", "fromHeight", "", "toHeight", "findViewByPosition", "position", "init", "measureView", "view", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: HeightWrappingViewPager.kt */
public final class HeightWrappingViewPager extends ViewPager {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(HeightWrappingViewPager.class, "enableAnimation", "getEnableAnimation()Z", 0))};
    private long animationDuration;
    private ValueAnimator animator;
    private final ReadWriteProperty enableAnimation$delegate;
    /* access modifiers changed from: private */
    public final HeightWrappingViewPager$onPageChangeListener$1 onPageChangeListener;

    private final boolean getEnableAnimation() {
        return ((Boolean) this.enableAnimation$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setEnableAnimation(boolean z) {
        this.enableAnimation$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightWrappingViewPager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Delegates delegates = Delegates.INSTANCE;
        this.enableAnimation$delegate = new HeightWrappingViewPager$$special$$inlined$observable$1(false, false, this);
        this.onPageChangeListener = new HeightWrappingViewPager$onPageChangeListener$1(this);
        init(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightWrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Delegates delegates = Delegates.INSTANCE;
        this.enableAnimation$delegate = new HeightWrappingViewPager$$special$$inlined$observable$2(false, false, this);
        this.onPageChangeListener = new HeightWrappingViewPager$onPageChangeListener$1(this);
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4199R.styleable.HeightWrappingViewPager, 0, 0);
        try {
            setEnableAnimation(obtainStyledAttributes.getBoolean(1, getEnableAnimation()));
            this.animationDuration = (long) obtainStyledAttributes.getInteger(0, obtainStyledAttributes.getResources().getInteger(17694720));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x000d
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            goto L_0x0030
        L_0x000d:
            int r2 = r4.getCurrentItem()
            android.view.View r2 = r4.findViewByPosition(r2)
            if (r2 == 0) goto L_0x0021
            r4.measureView(r2)
            if (r2 == 0) goto L_0x0021
            int r2 = r2.getMeasuredHeight()
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r3) goto L_0x0028
            r6 = r2
            goto L_0x0030
        L_0x0028:
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r6 = java.lang.Math.min(r2, r6)
        L_0x0030:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r1)
            super.onMeasure(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.custom.HeightWrappingViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: private */
    public final void measureView(View view) {
        int i;
        int i2;
        int i3 = view.getLayoutParams().width;
        int i4 = 1073741824;
        int i5 = 0;
        if (i3 != -2) {
            i2 = i3 != -1 ? view.getLayoutParams().width : getMeasuredWidth();
            i = 1073741824;
        } else {
            i2 = 0;
            i = 0;
        }
        int i6 = view.getLayoutParams().height;
        if (i6 != -2) {
            i5 = i6 != -1 ? view.getLayoutParams().height : getMeasuredHeight();
        } else {
            i4 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, i), View.MeasureSpec.makeMeasureSpec(i5, i4));
    }

    /* access modifiers changed from: private */
    public final View findViewByPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt, "childView");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
            ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) layoutParams;
            Lazy lazy = LazyKt.lazy(new HeightWrappingViewPager$findViewByPosition$childPosition$2(layoutParams2));
            if (!layoutParams2.isDecor && i == ((Number) lazy.getValue()).intValue()) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void animateContentHeight(View view, int i, int i2) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new C4211x576f4acb(ofInt, this, view, i2));
            ofInt.setDuration(this.animationDuration);
            ofInt.start();
            Unit unit = Unit.INSTANCE;
            this.animator = ofInt;
        }
    }
}
