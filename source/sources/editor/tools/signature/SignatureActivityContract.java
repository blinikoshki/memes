package editor.tools.signature;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.memes.commons.media.MediaContent;
import com.memes.crashreporter.CrashLog;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, mo26107d2 = {"Leditor/tools/signature/SignatureActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/io/File;", "Lcom/memes/commons/media/MediaContent;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SignatureActivityContract.kt */
public final class SignatureActivityContract extends ActivityResultContract<File, MediaContent> {
    public Intent createIntent(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "input");
        Intent intent = new Intent(context, SignatureActivity.class);
        intent.putExtra(SignatureActivity.EXTRA_OUTPUT_PATH, file.getAbsolutePath());
        return intent;
    }

    public MediaContent parseResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            return null;
        }
        try {
            return (MediaContent) intent.getParcelableExtra(SignatureActivity.EXTRA_MEDIA_CONTENT);
        } catch (Exception e) {
            CrashLog.Builder markHarmless = new CrashLog.Builder(new NParcelableException()).markHarmless();
            ExternalProxy.INSTANCE.getCrashReporter().report(markHarmless.addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
            return null;
        }
    }
}
