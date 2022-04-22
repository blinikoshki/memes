package editor.editor.entry;

import editor.editor.dashboard.drafts.EditorDraft;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.entry.EditorEntrySelectionActivity$onDraftSelectedListener$1$onDeleteEditorDraftSelected$1 */
/* compiled from: EditorEntrySelectionActivity.kt */
final class C4702xf992e8de extends Lambda implements Function0<Unit> {
    final /* synthetic */ EditorDraft $draft;
    final /* synthetic */ EditorEntrySelectionActivity$onDraftSelectedListener$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4702xf992e8de(EditorEntrySelectionActivity$onDraftSelectedListener$1 editorEntrySelectionActivity$onDraftSelectedListener$1, EditorDraft editorDraft) {
        super(0);
        this.this$0 = editorEntrySelectionActivity$onDraftSelectedListener$1;
        this.$draft = editorDraft;
    }

    public final void invoke() {
        this.this$0.this$0.getDraftsViewModel().deleteDraft(this.$draft.getUid());
    }
}
