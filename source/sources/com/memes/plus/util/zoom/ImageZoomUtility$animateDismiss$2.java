package com.memes.plus.util.zoom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, mo26107d2 = {"com/memes/plus/util/zoom/ImageZoomUtility$animateDismiss$2", "Landroid/animation/Animator$AnimatorListener;", "end", "", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImageZoomUtility.kt */
public final class ImageZoomUtility$animateDismiss$2 implements Animator.AnimatorListener {
    final /* synthetic */ int $leftMarginEnd;
    final /* synthetic */ int $leftMarginStart;
    final /* synthetic */ float $scaleXEnd;
    final /* synthetic */ float $scaleXStart;
    final /* synthetic */ float $scaleYEnd;
    final /* synthetic */ float $scaleYStart;
    final /* synthetic */ int $topMarginEnd;
    final /* synthetic */ int $topMarginStart;
    final /* synthetic */ ValueAnimator $valueAnimator;
    final /* synthetic */ ImageZoomUtility this$0;

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    ImageZoomUtility$animateDismiss$2(ImageZoomUtility imageZoomUtility, float f, float f2, int i, int i2, float f3, float f4, int i3, int i4, ValueAnimator valueAnimator) {
        this.this$0 = imageZoomUtility;
        this.$scaleYStart = f;
        this.$scaleXStart = f2;
        this.$leftMarginStart = i;
        this.$topMarginStart = i2;
        this.$scaleXEnd = f3;
        this.$scaleYEnd = f4;
        this.$leftMarginEnd = i3;
        this.$topMarginEnd = i4;
        this.$valueAnimator = valueAnimator;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        end();
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        end();
    }

    private final void end() {
        if (this.this$0.getZoomableView() != null) {
            this.this$0.updateZoomableView(1.0f, this.$scaleYStart, this.$scaleXStart, this.$leftMarginStart, this.$topMarginStart, this.$scaleXEnd, this.$scaleYEnd, this.$leftMarginEnd, this.$topMarginEnd);
        }
        this.this$0.dismissDialogAndViews();
        this.$valueAnimator.removeAllListeners();
        this.$valueAnimator.removeAllUpdateListeners();
    }
}
