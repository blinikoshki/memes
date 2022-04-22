package editor.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/util/OpenMediaUtil;", "", "()V", "open", "", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "type", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OpenMediaUtil.kt */
public final class OpenMediaUtil {
    public static final OpenMediaUtil INSTANCE = new OpenMediaUtil();

    private OpenMediaUtil() {
    }

    public final void open(Context context, File file, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Uri uriForFile = FileProvider.getUriForFile(context, "memes.editor.provider", file);
        String str = i != 1231 ? i != 1232 ? "*/*" : "video/*" : "image/*";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, str);
        intent.addFlags(1);
        context.startActivity(intent);
    }
}
