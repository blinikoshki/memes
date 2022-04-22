package editor.editor;

import editor.common.choicesbottomsheet.Choice;
import editor.common.choicesbottomsheet.ChoicesBottomSheet;
import editor.editor.equipment.media.MediaStyle;
import editor.optionsui.addcontent.AddContentChoice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "selectedChoice", "Leditor/common/choicesbottomsheet/Choice;", "onChoiceSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$onBottomOptionTabTapped$1 implements ChoicesBottomSheet.Callback {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$onBottomOptionTabTapped$1(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "selectedChoice");
        String id = choice.getId();
        switch (id.hashCode()) {
            case 56593:
                if (id.equals(AddContentChoice.TEXT)) {
                    EditorActivity.showEditTextPage$default(this.this$0, (String) null, (String) null, false, 7, (Object) null);
                    return;
                }
                return;
            case 56594:
                if (id.equals(AddContentChoice.MEDIA)) {
                    EditorActivity.showMediaSelectionPage$default(this.this$0, (String) null, (MediaStyle) null, 3, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
