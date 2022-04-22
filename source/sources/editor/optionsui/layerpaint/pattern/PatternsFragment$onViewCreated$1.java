package editor.optionsui.layerpaint.pattern;

import androidx.lifecycle.Observer;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "items", "", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: PatternsFragment.kt */
final class PatternsFragment$onViewCreated$1<T> implements Observer<List<? extends LayerPaint.Pattern>> {
    final /* synthetic */ PatternsFragment this$0;

    PatternsFragment$onViewCreated$1(PatternsFragment patternsFragment) {
        this.this$0 = patternsFragment;
    }

    public final void onChanged(List<LayerPaint.Pattern> list) {
        this.this$0.getPatternsAdapter().setItems(list);
    }
}
