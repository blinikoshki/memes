package editor.editor.dashboard.draftpreview;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tools.activityproxy.ActivityExtra;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftPreviewActivity.kt */
final class EditorDraftPreviewActivity$draftThumbnailPath$2 extends Lambda implements Function0<String> {
    final /* synthetic */ EditorDraftPreviewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftPreviewActivity$draftThumbnailPath$2(EditorDraftPreviewActivity editorDraftPreviewActivity) {
        super(0);
        this.this$0 = editorDraftPreviewActivity;
    }

    public final String invoke() {
        Intent intent = this.this$0.getIntent();
        if (intent != null) {
            return intent.getStringExtra(ActivityExtra.DRAFT_THUMB_PATH);
        }
        return null;
    }
}
