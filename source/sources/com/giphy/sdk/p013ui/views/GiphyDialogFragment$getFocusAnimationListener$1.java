package com.giphy.sdk.p013ui.views;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$getFocusAnimationListener$1 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$getFocusAnimationListener$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$getFocusAnimationListener$1(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            View access$getGifResultsOverlay$p = this.this$0.gifResultsOverlay;
            if (access$getGifResultsOverlay$p != null) {
                access$getGifResultsOverlay$p.setAlpha(floatValue);
            }
            View access$getSearchDimOverlay$p = this.this$0.searchDimOverlay;
            if (access$getSearchDimOverlay$p != null) {
                access$getSearchDimOverlay$p.setAlpha(floatValue);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
