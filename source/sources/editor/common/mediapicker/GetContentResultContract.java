package editor.common.mediapicker;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"Leditor/common/mediapicker/GetContentResultContract;", "Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GetContentResultContract.kt */
public final class GetContentResultContract extends ActivityResultContracts.GetContent {
    public Intent createIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "input");
        int hashCode = str.hashCode();
        if (hashCode != -879267568) {
            if (hashCode != -879264467) {
                if (hashCode == 1331848029 && str.equals("video/mp4")) {
                    Intent createIntent = super.createIntent(context, "video/mp4");
                    Intrinsics.checkNotNullExpressionValue(createIntent, "super.createIntent(context, \"video/mp4\")");
                    return createIntent;
                }
            } else if (str.equals("image/jpg")) {
                Intent createIntent2 = super.createIntent(context, "image/jpg");
                createIntent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/png", "image/jpeg", "image/bmp"});
                Intrinsics.checkNotNullExpressionValue(createIntent2, "super.createIntent(conte…peg\", \"image/bmp\"))\n\t\t\t\t}");
                return createIntent2;
            }
        } else if (str.equals("image/gif")) {
            Intent createIntent3 = super.createIntent(context, "image/gif");
            Intrinsics.checkNotNullExpressionValue(createIntent3, "super.createIntent(context, \"image/gif\")");
            return createIntent3;
        }
        Intent createIntent4 = super.createIntent(context, "*/*");
        Intrinsics.checkNotNullExpressionValue(createIntent4, "super.createIntent(context, \"*/*\")");
        return createIntent4;
    }
}
