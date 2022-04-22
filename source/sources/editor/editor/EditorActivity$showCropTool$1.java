package editor.editor;

import com.memes.commons.media.MediaContent;
import editor.common.choicesbottomsheet.Choice;
import editor.common.choicesbottomsheet.ChoicesBottomSheet;
import editor.common.choicesbottomsheet.categories.CropChoice;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.tools.crop.CropBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "choice", "Leditor/common/choicesbottomsheet/Choice;", "onChoiceSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showCropTool$1 implements ChoicesBottomSheet.Callback {
    final /* synthetic */ MediaStyle $style;
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showCropTool$1(EditorActivity editorActivity, MediaStyle mediaStyle, String str) {
        this.this$0 = editorActivity;
        this.$style = mediaStyle;
        this.$token = str;
    }

    public final void onChoiceSelected(Choice choice) {
        MediaContent mediaContent;
        Intrinsics.checkNotNullParameter(choice, "choice");
        String id = choice.getId();
        switch (id.hashCode()) {
            case 56599:
                if (id.equals(CropChoice.ORIGINAL)) {
                    mediaContent = this.$style.getOriginalContent();
                    break;
                } else {
                    return;
                }
            case 56600:
                if (id.equals(CropChoice.CURRENT)) {
                    mediaContent = this.$style.getContent();
                    break;
                } else {
                    return;
                }
            default:
                return;
        }
        if (mediaContent != null) {
            this.this$0.showCropTool(this.$token, new CropSpec(mediaContent, (CropBounds) null, 2, (DefaultConstructorMarker) null));
        }
    }
}
