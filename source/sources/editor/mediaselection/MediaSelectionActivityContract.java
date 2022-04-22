package editor.mediaselection;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.memes.commons.media.MediaContent;
import com.memes.crashreporter.CrashLog;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0010"}, mo26107d2 = {"Leditor/mediaselection/MediaSelectionActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Leditor/mediaselection/MediaSelectionConfig;", "", "Lcom/memes/commons/media/MediaContent;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "parseResult", "resultCode", "", "intent", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivityContract.kt */
public final class MediaSelectionActivityContract extends ActivityResultContract<MediaSelectionConfig, List<? extends MediaContent>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_CONFIG = "intent_extra_media_selection_config";
    public static final String EXTRA_RESULT = "intent_extra_media_selection_result";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/mediaselection/MediaSelectionActivityContract$Companion;", "", "()V", "EXTRA_CONFIG", "", "EXTRA_RESULT", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionActivityContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Intent createIntent(Context context, MediaSelectionConfig mediaSelectionConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaSelectionConfig, "config");
        Intent intent = new Intent(context, MediaSelectionActivity.class);
        intent.putExtra("intent_extra_media_selection_config", mediaSelectionConfig);
        return intent;
    }

    public List<MediaContent> parseResult(int i, Intent intent) {
        ArrayList arrayList;
        if (i != -1) {
            if (i != 0) {
                try {
                    throw new RuntimeException("Unknown activity-result " + i);
                } catch (Exception e) {
                    ExternalProxy.INSTANCE.getCrashReporter().report(new CrashLog.Builder(new NParcelableException()).markHarmless().addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
                    return null;
                }
            }
        } else if (intent != null) {
            arrayList = intent.getParcelableArrayListExtra(EXTRA_RESULT);
            return arrayList;
        }
        arrayList = null;
        return arrayList;
    }
}
