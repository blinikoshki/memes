package com.giphy.sdk.p013ui.drawables;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.GPHBrandingDrawer$startAnimation$1 */
/* compiled from: GPHBrandingDrawer.kt */
final class GPHBrandingDrawer$startAnimation$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ GPHBrandingDrawer this$0;

    GPHBrandingDrawer$startAnimation$1(GPHBrandingDrawer gPHBrandingDrawer) {
        this.this$0 = gPHBrandingDrawer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable access$getDrawable$p = this.this$0.drawable;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            access$getDrawable$p.setAlpha(((Integer) animatedValue).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
