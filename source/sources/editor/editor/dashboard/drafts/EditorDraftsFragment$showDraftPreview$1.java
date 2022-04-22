package editor.editor.dashboard.drafts;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "Landroid/content/Intent;", "draftIdKey", "", "draftThumbnailPathKey", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsFragment.kt */
final class EditorDraftsFragment$showDraftPreview$1 extends Lambda implements Function3<Intent, String, String, Unit> {
    final /* synthetic */ EditorDraft $draft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsFragment$showDraftPreview$1(EditorDraft editorDraft) {
        super(3);
        this.$draft = editorDraft;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Intent) obj, (String) obj2, (String) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(Intent intent, String str, String str2) {
        Intrinsics.checkNotNullParameter(intent, "$receiver");
        Intrinsics.checkNotNullParameter(str, "draftIdKey");
        Intrinsics.checkNotNullParameter(str2, "draftThumbnailPathKey");
        intent.putExtra(str, this.$draft.getUid());
        intent.putExtra(str2, this.$draft.getThumbnailPath());
    }
}
