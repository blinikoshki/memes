package editor.editor.entry;

import androidx.lifecycle.Observer;
import editor.editor.entry.drafts.EditorDraftEntriesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "draftId", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$attachObservers$6<T> implements Observer<String> {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    EditorEntrySelectionActivity$attachObservers$6(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public final void onChanged(String str) {
        EditorDraftEntriesAdapter access$getDraftsAdapter$p = this.this$0.getDraftsAdapter();
        Intrinsics.checkNotNullExpressionValue(str, "draftId");
        access$getDraftsAdapter$p.removeDraftById(str);
        if (this.this$0.getDraftsAdapter().getItemCount() == 0) {
            this.this$0.getBinding().draftsCategoryView.hide();
        }
    }
}
