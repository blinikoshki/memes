package editor.editor;

import editor.optionsui.layout.wireframes.WireframeProvider;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$applyExtraMediaContents$1 implements Runnable {
    final /* synthetic */ ArrayList $contents;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$applyExtraMediaContents$1(EditorActivity editorActivity, ArrayList arrayList) {
        this.this$0 = editorActivity;
        this.$contents = arrayList;
    }

    public final void run() {
        if (this.$contents.size() == 1) {
            this.this$0.getFrame().applyWireframe(WireframeProvider.Companion.getDefaultWireframe());
        }
    }
}
