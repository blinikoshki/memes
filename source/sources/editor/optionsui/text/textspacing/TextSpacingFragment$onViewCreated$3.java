package editor.optionsui.text.textspacing;

import androidx.lifecycle.Observer;
import editor.custom.valueslider.ValueSlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "lineCount", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextSpacingFragment.kt */
final class TextSpacingFragment$onViewCreated$3<T> implements Observer<Integer> {
    final /* synthetic */ TextSpacingFragment this$0;

    TextSpacingFragment$onViewCreated$3(TextSpacingFragment textSpacingFragment) {
        this.this$0 = textSpacingFragment;
    }

    public final void onChanged(Integer num) {
        if (num.intValue() > 1) {
            ValueSlider valueSlider = TextSpacingFragment.access$getBinding$p(this.this$0).lineSpacingSlider;
            Intrinsics.checkNotNullExpressionValue(valueSlider, "binding.lineSpacingSlider");
            valueSlider.setVisibility(0);
            return;
        }
        ValueSlider valueSlider2 = TextSpacingFragment.access$getBinding$p(this.this$0).lineSpacingSlider;
        Intrinsics.checkNotNullExpressionValue(valueSlider2, "binding.lineSpacingSlider");
        valueSlider2.setVisibility(8);
    }
}
