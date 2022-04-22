package editor.tools.wftransformer;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: WfElementTransformer.kt */
final class WfElementTransformer$positionEntityToRect$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $elementRectHeight;
    final /* synthetic */ int $elementRectWidth;
    final /* synthetic */ View $elementView;
    final /* synthetic */ WfElementTransformer this$0;

    WfElementTransformer$positionEntityToRect$1(WfElementTransformer wfElementTransformer, int i, View view, int i2) {
        this.this$0 = wfElementTransformer;
        this.$elementRectWidth = i;
        this.$elementView = view;
        this.$elementRectHeight = i2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this.this$0.changeViewWidthHeightBy(this.$elementView, MathKt.roundToInt(((float) (this.$elementRectWidth - this.$elementView.getWidth())) * floatValue), MathKt.roundToInt(((float) (this.$elementRectHeight - this.$elementView.getHeight())) * floatValue));
    }
}
