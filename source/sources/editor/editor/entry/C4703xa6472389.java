package editor.editor.entry;

import android.content.Intent;
import editor.editor.dashboard.drafts.EditorDraft;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tools.activityproxy.ActivityExtra;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Landroid/content/Intent;", "key", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.entry.EditorEntrySelectionActivity$onDraftSelectedListener$1$onEditorDraftSelected$1 */
/* compiled from: EditorEntrySelectionActivity.kt */
final class C4703xa6472389 extends Lambda implements Function2<Intent, String, Unit> {
    final /* synthetic */ EditorDraft $draft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4703xa6472389(EditorDraft editorDraft) {
        super(2);
        this.$draft = editorDraft;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Intent) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Intent intent, String str) {
        Intrinsics.checkNotNullParameter(intent, "$receiver");
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.DRAFT_ID)) {
            intent.putExtra(str, this.$draft.getUid());
        }
    }
}
