package editor.editor.entry;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ExtensionsKt;
import editor.optionsui.layout.templates.Template;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "template", "Leditor/optionsui/layout/templates/Template;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$attachObservers$3<T> implements Observer<Template> {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    EditorEntrySelectionActivity$attachObservers$3(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public final void onChanged(Template template) {
        if (template == null) {
            ExtensionsKt.toast((Context) this.this$0, "Unable to download template. Please try again.");
        } else {
            this.this$0.onTemplateSelectedListener.onTemplateTapped(template);
        }
    }
}
