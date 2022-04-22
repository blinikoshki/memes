package com.memes.plus.custom;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/memes/plus/custom/HeightWrappingViewPager$animateContentHeight$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.custom.HeightWrappingViewPager$animateContentHeight$$inlined$apply$lambda$1 */
/* compiled from: HeightWrappingViewPager.kt */
final class C4211x576f4acb implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ View $childView$inlined;
    final /* synthetic */ ValueAnimator $this_apply;
    final /* synthetic */ int $toHeight$inlined;
    final /* synthetic */ HeightWrappingViewPager this$0;

    C4211x576f4acb(ValueAnimator valueAnimator, HeightWrappingViewPager heightWrappingViewPager, View view, int i) {
        this.$this_apply = valueAnimator;
        this.this$0 = heightWrappingViewPager;
        this.$childView$inlined = view;
        this.$toHeight$inlined = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.measureView(this.$childView$inlined);
        if (this.$childView$inlined.getMeasuredHeight() != this.$toHeight$inlined) {
            HeightWrappingViewPager heightWrappingViewPager = this.this$0;
            heightWrappingViewPager.animateContentHeight(this.$childView$inlined, heightWrappingViewPager.getHeight(), this.$childView$inlined.getMeasuredHeight());
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
        Object animatedValue = this.$this_apply.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.this$0.requestLayout();
    }
}
