package editor.optionsui.text.textsize;

import android.widget.CompoundButton;
import editor.custom.valueslider.ValueSlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextSizeFragment.kt */
final class TextSizeFragment$initAutoSizeSwitch$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ TextSizeFragment this$0;

    TextSizeFragment$initAutoSizeSwitch$1(TextSizeFragment textSizeFragment) {
        this.this$0 = textSizeFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ValueSlider valueSlider = TextSizeFragment.access$getBinding$p(this.this$0).textSizeSlider;
        Intrinsics.checkNotNullExpressionValue(valueSlider, "binding.textSizeSlider");
        valueSlider.setEnabled(!z);
        this.this$0.getTextSizeViewModel().changeTextAutoSizeEnabled(z);
        if (!z) {
            this.this$0.resetTextSizeSlider();
        }
    }
}
