package editor.editor.entry;

import com.facebook.share.internal.MessengerShareContentUtility;
import editor.optionsui.layout.templates.Template;
import editor.optionsui.layout.templates.TemplatesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "template", "Leditor/optionsui/layout/templates/Template;", "onTemplateTapped"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.editor.entry.EditorEntrySelectionActivity$showTrendingTemplates$templatesAdapter$1 */
/* compiled from: EditorEntrySelectionActivity.kt */
final class C4707x8189b51e implements TemplatesAdapter.Callback {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    C4707x8189b51e(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public final void onTemplateTapped(Template template) {
        Intrinsics.checkNotNullParameter(template, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        this.this$0.getTemplatesViewModel().downloadTemplate(template);
    }
}
