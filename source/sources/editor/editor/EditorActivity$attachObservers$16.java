package editor.editor;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ExtensionsKt;
import editor.editor.dashboard.drafts.EditorDraft;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Leditor/editor/dashboard/drafts/EditorDraft;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$16<T> implements Observer<EditorDraft> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$16(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(EditorDraft editorDraft) {
        ExtensionsKt.toast((Context) this.this$0, "Draft saved.");
        if (this.this$0.exitAfterDraftIsSaved) {
            this.this$0.finish();
        }
    }
}
