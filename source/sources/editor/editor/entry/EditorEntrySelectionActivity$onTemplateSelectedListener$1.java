package editor.editor.entry;

import android.content.Intent;
import com.facebook.share.internal.MessengerShareContentUtility;
import editor.optionsui.layout.templates.Template;
import editor.optionsui.layout.templates.TemplatesAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityExtra;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "template", "Leditor/optionsui/layout/templates/Template;", "onTemplateTapped"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$onTemplateSelectedListener$1 implements TemplatesAdapter.Callback {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    EditorEntrySelectionActivity$onTemplateSelectedListener$1(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public final void onTemplateTapped(final Template template) {
        Intrinsics.checkNotNullParameter(template, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        ActivityProxyBridge.INSTANCE.launchEditorPage(this.this$0, new Function2<Intent, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Intent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Intent intent, String str) {
                Intrinsics.checkNotNullParameter(intent, "$receiver");
                Intrinsics.checkNotNullParameter(str, "key");
                if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.TRENDING_TEMPLATE)) {
                    intent.putExtra(str, template);
                }
            }
        });
    }
}
