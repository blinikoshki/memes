package editor.editor.dashboard.draftpreview;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import editor.editor.dashboard.deleteconfirmation.DeleteDraftBottomSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftPreviewActivity.kt */
final class EditorDraftPreviewActivity$onCreate$4 implements View.OnClickListener {
    final /* synthetic */ EditorDraftPreviewActivity this$0;

    EditorDraftPreviewActivity$onCreate$4(EditorDraftPreviewActivity editorDraftPreviewActivity) {
        this.this$0 = editorDraftPreviewActivity;
    }

    public final void onClick(View view) {
        DeleteDraftBottomSheet deleteDraftBottomSheet = new DeleteDraftBottomSheet();
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        deleteDraftBottomSheet.show(supportFragmentManager, new Function0<Unit>(this) {
            final /* synthetic */ EditorDraftPreviewActivity$onCreate$4 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.getViewModel().deleteDraft(this.this$0.this$0.getDraftId());
            }
        });
    }
}
