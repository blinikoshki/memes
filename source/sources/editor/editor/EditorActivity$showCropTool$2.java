package editor.editor;

import androidx.activity.result.ActivityResultCallback;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "outputCropSpec", "Leditor/editor/equipment/media/content/CropSpec;", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showCropTool$2<O> implements ActivityResultCallback<CropSpec> {
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showCropTool$2(EditorActivity editorActivity, String str) {
        this.this$0 = editorActivity;
        this.$token = str;
    }

    public final void onActivityResult(CropSpec cropSpec) {
        if (cropSpec != null) {
            MediaProperty.Crop crop = new MediaProperty.Crop(cropSpec);
            this.this$0.getFrame().updateEntity(NicoPropertyBundle.Companion.from(this.$token, crop));
        }
    }
}
