package editor.optionsui.text.textadjust;

import androidx.lifecycle.Observer;
import editor.custom.valueslider.ValueSlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Float;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextAdjustFragment.kt */
final class TextAdjustFragment$onViewCreated$1<T> implements Observer<Float> {
    final /* synthetic */ TextAdjustFragment this$0;

    TextAdjustFragment$onViewCreated$1(TextAdjustFragment textAdjustFragment) {
        this.this$0 = textAdjustFragment;
    }

    public final void onChanged(Float f) {
        ValueSlider valueSlider = TextAdjustFragment.access$getBinding$p(this.this$0).opacitySlider;
        Intrinsics.checkNotNullExpressionValue(f, "value");
        valueSlider.setValue(f.floatValue());
    }
}
