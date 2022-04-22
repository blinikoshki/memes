package editor.editor;

import androidx.lifecycle.Observer;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$4<T> implements Observer<NicoPropertyBundle> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$4(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(NicoPropertyBundle nicoPropertyBundle) {
        EditorFrame access$getFrame = this.this$0.getFrame();
        Intrinsics.checkNotNullExpressionValue(nicoPropertyBundle, "bundle");
        access$getFrame.updateEntity(nicoPropertyBundle);
    }
}
