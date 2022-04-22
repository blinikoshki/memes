package editor.tools.crop;

import android.net.Uri;
import androidx.lifecycle.Observer;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "file", "Ljava/io/File;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropActivity.kt */
final class CropActivity$onCreate$4<T> implements Observer<File> {
    final /* synthetic */ CropActivity this$0;

    CropActivity$onCreate$4(CropActivity cropActivity) {
        this.this$0 = cropActivity;
    }

    public final void onChanged(File file) {
        this.this$0.getBinding().cropImageView.setImageUriAsync(Uri.fromFile(file));
    }
}
