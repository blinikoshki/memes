package editor.editor.dashboard.draftpreview;

import android.content.Intent;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityExtra;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftPreviewActivity.kt */
final class EditorDraftPreviewActivity$onCreate$2 implements View.OnClickListener {
    final /* synthetic */ EditorDraftPreviewActivity this$0;

    EditorDraftPreviewActivity$onCreate$2(EditorDraftPreviewActivity editorDraftPreviewActivity) {
        this.this$0 = editorDraftPreviewActivity;
    }

    public final void onClick(View view) {
        ActivityProxyBridge.INSTANCE.launchEditorPage(this.this$0, new Function2<Intent, String, Unit>(this) {
            final /* synthetic */ EditorDraftPreviewActivity$onCreate$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Intent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Intent intent, String str) {
                Intrinsics.checkNotNullParameter(intent, "$receiver");
                Intrinsics.checkNotNullParameter(str, "key");
                if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.DRAFT_ID)) {
                    intent.putExtra(str, this.this$0.this$0.getDraftId());
                }
                intent.setFlags(67108864);
            }
        });
        this.this$0.finish();
    }
}
