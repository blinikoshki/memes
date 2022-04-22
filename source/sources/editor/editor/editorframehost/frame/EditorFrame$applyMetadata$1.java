package editor.editor.editorframehost.frame;

import android.animation.ValueAnimator;
import android.view.View;
import editor.editor.equipment.core.CoreLayer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$applyMetadata$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ int $absoluteHeight;
    final /* synthetic */ int $absoluteWidth;
    final /* synthetic */ CoreLayer $layer;
    final /* synthetic */ View $view;

    EditorFrame$applyMetadata$1(int i, View view, int i2, CoreLayer coreLayer) {
        this.$absoluteWidth = i;
        this.$view = view;
        this.$absoluteHeight = i2;
        this.$layer = coreLayer;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this.$layer.changeWidthHeightBy(MathKt.roundToInt(((float) (this.$absoluteWidth - this.$view.getWidth())) * floatValue), MathKt.roundToInt(((float) (this.$absoluteHeight - this.$view.getHeight())) * floatValue));
    }
}
