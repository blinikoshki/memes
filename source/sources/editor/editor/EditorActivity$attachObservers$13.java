package editor.editor;

import androidx.lifecycle.Observer;
import editor.common.commonslider.CommonSliderOutput;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "output", "Leditor/common/commonslider/CommonSliderOutput;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$13<T> implements Observer<CommonSliderOutput> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$13(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(CommonSliderOutput commonSliderOutput) {
        NicoProperty nicoProperty;
        float value = commonSliderOutput.getValue();
        int target = commonSliderOutput.getTarget();
        if (target == 6) {
            nicoProperty = new NicoProperty.Rotation(value);
        } else if (target == 7) {
            nicoProperty = new NicoProperty.Scale(value);
        } else if (target == 9) {
            nicoProperty = new NicoProperty.Opacity(value);
        } else {
            throw new RuntimeException("Unknown slider media-option: " + commonSliderOutput.getTarget());
        }
        this.this$0.getFrame().updateEntity(NicoPropertyBundle.Companion.from(commonSliderOutput.getIdentifier(), nicoProperty));
    }
}
