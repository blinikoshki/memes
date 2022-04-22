package editor.custom.overlayboundary;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryCornerTouchListener.kt */
final class BoundaryCornerTouchListener$animate$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ View $targetView;

    BoundaryCornerTouchListener$animate$1(View view) {
        this.$targetView = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.$targetView;
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        view.setPadding(intValue, intValue, intValue, intValue);
    }
}
