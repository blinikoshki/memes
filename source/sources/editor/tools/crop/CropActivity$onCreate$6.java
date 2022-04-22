package editor.tools.crop;

import android.content.Intent;
import androidx.lifecycle.Observer;
import editor.editor.equipment.media.content.CropSpec;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "content", "Leditor/editor/equipment/media/content/CropSpec;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
final class CropActivity$onCreate$6<T> implements Observer<CropSpec> {
    final /* synthetic */ CropActivity this$0;

    CropActivity$onCreate$6(CropActivity cropActivity) {
        this.this$0 = cropActivity;
    }

    public final void onChanged(CropSpec cropSpec) {
        Intent intent = new Intent();
        intent.putExtra(CropActivity.EXTRA_CROP_SPEC, cropSpec);
        this.this$0.setResult(-1, intent);
        this.this$0.finish();
    }
}
