package editor.optionsui.layerpaint.pattern;

import androidx.lifecycle.Observer;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: PatternsFragment.kt */
final class PatternsFragment$onViewCreated$2<T> implements Observer<LayerPaint.Pattern> {
    final /* synthetic */ PatternsFragment this$0;

    PatternsFragment$onViewCreated$2(PatternsFragment patternsFragment) {
        this.this$0 = patternsFragment;
    }

    public final void onChanged(LayerPaint.Pattern pattern) {
        this.this$0.getPatternsAdapter().setSelectedPattern(pattern);
    }
}
