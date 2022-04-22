package editor.optionsui.layerpaint.gradient;

import androidx.lifecycle.Observer;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GradientsFragment.kt */
final class GradientsFragment$onViewCreated$2<T> implements Observer<LayerPaint.Gradient> {
    final /* synthetic */ GradientsFragment this$0;

    GradientsFragment$onViewCreated$2(GradientsFragment gradientsFragment) {
        this.this$0 = gradientsFragment;
    }

    public final void onChanged(LayerPaint.Gradient gradient) {
        this.this$0.getGradientsAdapter().setSelectedGradient(gradient);
    }
}
