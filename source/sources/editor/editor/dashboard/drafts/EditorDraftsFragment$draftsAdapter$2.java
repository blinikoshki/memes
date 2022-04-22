package editor.editor.dashboard.drafts;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/editor/dashboard/drafts/EditorDraftsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsFragment.kt */
final class EditorDraftsFragment$draftsAdapter$2 extends Lambda implements Function0<EditorDraftsAdapter> {
    final /* synthetic */ EditorDraftsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsFragment$draftsAdapter$2(EditorDraftsFragment editorDraftsFragment) {
        super(0);
        this.this$0 = editorDraftsFragment;
    }

    public final EditorDraftsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new EditorDraftsAdapter(requireContext, new Function1<EditorDraft, Unit>(this) {
            final /* synthetic */ EditorDraftsFragment$draftsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((EditorDraft) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(EditorDraft editorDraft) {
                Intrinsics.checkNotNullParameter(editorDraft, "draft");
                this.this$0.this$0.showDraftPreview(editorDraft);
            }
        });
    }
}