package editor.editor.entry;

import editor.editor.entry.drafts.EditorDraftEntriesAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/editor/entry/drafts/EditorDraftEntriesAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$draftsAdapter$2 extends Lambda implements Function0<EditorDraftEntriesAdapter> {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorEntrySelectionActivity$draftsAdapter$2(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        super(0);
        this.this$0 = editorEntrySelectionActivity;
    }

    public final EditorDraftEntriesAdapter invoke() {
        EditorEntrySelectionActivity editorEntrySelectionActivity = this.this$0;
        return new EditorDraftEntriesAdapter(editorEntrySelectionActivity, editorEntrySelectionActivity.onDraftSelectedListener);
    }
}
