package editor.tools.videotrim;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.memes.crashreporter.CrashLog;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivityContract.kt */
public final class VideoTrimActivityContract extends ActivityResultContract<String, String> {
    public Intent createIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "input");
        Intent intent = new Intent(context, ActivityProxyBridge.INSTANCE.getVideoTrimPageClass());
        intent.putExtra(VideoTrimActivity.EXTRA_VIDEO_PATH, str);
        return intent;
    }

    public String parseResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(VideoTrimActivity.EXTRA_VIDEO_PATH);
        } catch (Exception e) {
            CrashLog.Builder markHarmless = new CrashLog.Builder(new NParcelableException()).markHarmless();
            ExternalProxy.INSTANCE.getCrashReporter().report(markHarmless.addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
            return null;
        }
    }
}
