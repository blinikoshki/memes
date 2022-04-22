package editor.editor.entry;

import androidx.fragment.app.FragmentManager;
import editor.editor.dashboard.deleteconfirmation.DeleteDraftBottomSheet;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.entry.drafts.EditorDraftEntriesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo26107d2 = {"editor/editor/entry/EditorEntrySelectionActivity$onDraftSelectedListener$1", "Leditor/editor/entry/drafts/EditorDraftEntriesAdapter$Callback;", "onDeleteEditorDraftSelected", "", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "onEditorDraftSelected", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
public final class EditorEntrySelectionActivity$onDraftSelectedListener$1 implements EditorDraftEntriesAdapter.Callback {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    EditorEntrySelectionActivity$onDraftSelectedListener$1(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public void onEditorDraftSelected(EditorDraft editorDraft) {
        Intrinsics.checkNotNullParameter(editorDraft, "draft");
        ActivityProxyBridge.INSTANCE.launchEditorPage(this.this$0, new C4703xa6472389(editorDraft));
    }

    public void onDeleteEditorDraftSelected(EditorDraft editorDraft) {
        Intrinsics.checkNotNullParameter(editorDraft, "draft");
        DeleteDraftBottomSheet deleteDraftBottomSheet = new DeleteDraftBottomSheet();
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        deleteDraftBottomSheet.show(supportFragmentManager, new C4702xf992e8de(this, editorDraft));
    }
}
