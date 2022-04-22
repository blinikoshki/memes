package editor.optionsui.addcontent.contentpicker;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.memes.commons.media.MediaContent;
import com.memes.crashreporter.CrashLog;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentResolverActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/memes/commons/media/MediaContent;", "Lkotlin/Pair;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentResolverActivityContract.kt */
public final class ContentResolverActivityContract extends ActivityResultContract<MediaContent, Pair<? extends MediaContent, ? extends Boolean>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_TARGET_CONTENT = "intent_extra_target_content";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentResolverActivityContract$Companion;", "", "()V", "EXTRA_TARGET_CONTENT", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ContentResolverActivityContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Intent createIntent(Context context, MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaContent, "input");
        Intent intent = new Intent(context, ContentPickerActivity.class);
        intent.putExtra(EXTRA_TARGET_CONTENT, mediaContent);
        return intent;
    }

    public Pair<MediaContent, Boolean> parseResult(int i, Intent intent) {
        String str;
        boolean z = false;
        if (i == -1) {
            return new Pair<>(intent != null ? (MediaContent) intent.getParcelableExtra(ContentPickerActivityContract.EXTRA_PICKER_RESULT) : null, false);
        } else if (i == 0) {
            if (intent != null) {
                try {
                    str = intent.getStringExtra(ContentPickerActivityContract.EXTRA_PICKER_ERROR);
                } catch (Exception e) {
                    ExternalProxy.INSTANCE.getCrashReporter().report(new CrashLog.Builder(new NParcelableException()).markHarmless().addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
                    return new Pair<>(null, true);
                }
            } else {
                str = null;
            }
            if (str == null) {
                z = true;
            }
            return new Pair<>(null, Boolean.valueOf(z));
        } else {
            throw new RuntimeException("Unknown activity-result " + i);
        }
    }
}
