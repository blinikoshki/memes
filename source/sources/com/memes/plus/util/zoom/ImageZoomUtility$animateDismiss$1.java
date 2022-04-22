package com.memes.plus.util.zoom;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ImageZoomUtility.kt */
final class ImageZoomUtility$animateDismiss$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float $alphaEnd;
    final /* synthetic */ float $alphaStart;
    final /* synthetic */ int $leftMarginEnd;
    final /* synthetic */ int $leftMarginStart;
    final /* synthetic */ float $scaleXEnd;
    final /* synthetic */ float $scaleXStart;
    final /* synthetic */ float $scaleYEnd;
    final /* synthetic */ float $scaleYStart;
    final /* synthetic */ int $topMarginEnd;
    final /* synthetic */ int $topMarginStart;
    final /* synthetic */ ImageZoomUtility this$0;

    ImageZoomUtility$animateDismiss$1(ImageZoomUtility imageZoomUtility, float f, float f2, int i, int i2, float f3, float f4, int i3, int i4, float f5, float f6) {
        this.this$0 = imageZoomUtility;
        this.$scaleYStart = f;
        this.$scaleXStart = f2;
        this.$leftMarginStart = i;
        this.$topMarginStart = i2;
        this.$scaleXEnd = f3;
        this.$scaleYEnd = f4;
        this.$leftMarginEnd = i3;
        this.$topMarginEnd = i4;
        this.$alphaEnd = f5;
        this.$alphaStart = f6;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View access$getShadowView$p;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        if (this.this$0.getZoomableView() != null) {
            this.this$0.updateZoomableView(animatedFraction, this.$scaleYStart, this.$scaleXStart, this.$leftMarginStart, this.$topMarginStart, this.$scaleXEnd, this.$scaleYEnd, this.$leftMarginEnd, this.$topMarginEnd);
        }
        if (this.this$0.shadowView != null && (access$getShadowView$p = this.this$0.shadowView) != null) {
            float maxShadowAlpha = this.this$0.getMaxShadowAlpha();
            float f = this.$alphaEnd;
            float f2 = this.$alphaStart;
            access$getShadowView$p.setAlpha(Math.max(Math.min(maxShadowAlpha, ((f - f2) * animatedFraction) + f2), 0.0f));
        }
    }
}
