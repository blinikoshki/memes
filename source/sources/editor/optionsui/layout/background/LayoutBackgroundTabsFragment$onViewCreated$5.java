package editor.optionsui.layout.background;

import androidx.lifecycle.Observer;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "background", "Leditor/optionsui/layerpaint/LayerPaint;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LayoutBackgroundTabsFragment.kt */
final class LayoutBackgroundTabsFragment$onViewCreated$5<T> implements Observer<LayerPaint> {
    final /* synthetic */ LayoutBackgroundTabsFragment this$0;

    LayoutBackgroundTabsFragment$onViewCreated$5(LayoutBackgroundTabsFragment layoutBackgroundTabsFragment) {
        this.this$0 = layoutBackgroundTabsFragment;
    }

    public final void onChanged(LayerPaint layerPaint) {
        if (layerPaint instanceof LayerPaint.Color) {
            this.this$0.onColorSelected((LayerPaint.Color) layerPaint);
        } else if (layerPaint instanceof LayerPaint.Gradient) {
            this.this$0.onGradientSelected((LayerPaint.Gradient) layerPaint);
        } else if (layerPaint instanceof LayerPaint.Pattern) {
            this.this$0.onPatternSelected((LayerPaint.Pattern) layerPaint);
        } else {
            this.this$0.getColorsViewModel().changeSelectedColorPaint((LayerPaint.Color) null);
            this.this$0.getGradientsViewModel().changeSelectedGradientPaint((LayerPaint.Gradient) null);
            this.this$0.getPatternsViewModel().changeSelectedPatternPaint((LayerPaint.Pattern) null);
        }
    }
}
