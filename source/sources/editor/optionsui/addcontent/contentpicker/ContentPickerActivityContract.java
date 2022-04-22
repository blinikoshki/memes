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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J(\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentPickerActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Leditor/optionsui/addcontent/contentpicker/ContentPickerTarget;", "Lkotlin/Pair;", "Lcom/memes/commons/media/MediaContent;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivityContract.kt */
public final class ContentPickerActivityContract extends ActivityResultContract<ContentPickerTarget, Pair<? extends MediaContent, ? extends Boolean>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_PICKER_ERROR = "intent_extra_picker_error";
    public static final String EXTRA_PICKER_RESULT = "intent_extra_picker_result";
    public static final String EXTRA_PICKER_TARGET = "intent_extra_picker_target";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentPickerActivityContract$Companion;", "", "()V", "EXTRA_PICKER_ERROR", "", "EXTRA_PICKER_RESULT", "EXTRA_PICKER_TARGET", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ContentPickerActivityContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Intent createIntent(Context context, ContentPickerTarget contentPickerTarget) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentPickerTarget, "input");
        Intent intent = new Intent(context, ContentPickerActivity.class);
        intent.putExtra(EXTRA_PICKER_TARGET, contentPickerTarget);
        return intent;
    }

    public Pair<MediaContent, Boolean> parseResult(int i, Intent intent) {
        String str;
        boolean z = false;
        if (i == -1) {
            return new Pair<>(intent != null ? (MediaContent) intent.getParcelableExtra(EXTRA_PICKER_RESULT) : null, false);
        } else if (i == 0) {
            if (intent != null) {
                try {
                    str = intent.getStringExtra(EXTRA_PICKER_ERROR);
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
