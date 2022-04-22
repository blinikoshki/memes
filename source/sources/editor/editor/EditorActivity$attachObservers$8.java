package editor.editor;

import androidx.lifecycle.Observer;
import editor.optionsui.addcontent.contentpicker.ContentPickerTarget;
import editor.optionsui.watermark.home.WatermarkOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "option", "Leditor/optionsui/watermark/home/WatermarkOption;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$attachObservers$8<T> implements Observer<WatermarkOption> {
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$attachObservers$8(EditorActivity editorActivity) {
        this.this$0 = editorActivity;
    }

    public final void onChanged(WatermarkOption watermarkOption) {
        if (watermarkOption instanceof WatermarkOption.OfficialWatermarkVisibility) {
            this.this$0.getFrame().getWatermarkEntity().changeVisibility(((WatermarkOption.OfficialWatermarkVisibility) watermarkOption).getVisible());
        } else if (Intrinsics.areEqual((Object) watermarkOption, (Object) WatermarkOption.Text.INSTANCE)) {
            EditorActivity.showEditTextPage$default(this.this$0, (String) null, (String) null, true, 3, (Object) null);
        } else if (Intrinsics.areEqual((Object) watermarkOption, (Object) WatermarkOption.Signature.INSTANCE)) {
            EditorActivity.showSignatureWatermarkTool$default(this.this$0, (String) null, 1, (Object) null);
        } else if (Intrinsics.areEqual((Object) watermarkOption, (Object) WatermarkOption.Logo.INSTANCE)) {
            EditorActivity.showContentPicker$default(this.this$0, ContentPickerTarget.PHOTO, (String) null, true, 2, (Object) null);
        } else if (Intrinsics.areEqual((Object) watermarkOption, (Object) WatermarkOption.Saved.INSTANCE)) {
            this.this$0.getFragmentManagerUtil().showSavedWatermarkFragment();
        }
    }
}
