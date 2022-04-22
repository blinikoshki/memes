package editor.optionsui.text.textpaint;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "target", "Leditor/optionsui/text/textpaint/TextPaintSelectionTarget;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: TextPaintsFragment.kt */
final class TextPaintsFragment$onViewCreated$4<T> implements Observer<TextPaintSelectionTarget> {
    final /* synthetic */ TextPaintsFragment this$0;

    TextPaintsFragment$onViewCreated$4(TextPaintsFragment textPaintsFragment) {
        this.this$0 = textPaintsFragment;
    }

    public final void onChanged(TextPaintSelectionTarget textPaintSelectionTarget) {
        TextPaintsFragment.access$getBinding$p(this.this$0).tabLayout.selectTab(TextPaintsFragment.access$getBinding$p(this.this$0).tabLayout.getTabAt(textPaintSelectionTarget.ordinal()));
    }
}
