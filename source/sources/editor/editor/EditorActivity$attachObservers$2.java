package editor.editor;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "wireframe", "Lwireframe/language/Wireframe;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$2<T> implements Observer<Wireframe> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$2(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(Wireframe wireframe2) {
        this.this$0.getFrame().applyWireframe(wireframe2);
    }
}
