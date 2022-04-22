package editor.mediaselection;

import androidx.lifecycle.Observer;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "gradients", "", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$onCreate$3<T> implements Observer<List<? extends LayerPaint.Gradient>> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$onCreate$3(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onChanged(List<LayerPaint.Gradient> list) {
        this.this$0.showGradients(list);
    }
}
