package editor.mediaselection.targetedmediabrowser;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.memes.crashreporter.CrashLog;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2 \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0010"}, mo26107d2 = {"Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionConfig;", "Lkotlin/Pair;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "config", "parseResult", "resultCode", "", "intent", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TargetedMediaSelectionActivityContract.kt */
public final class TargetedMediaSelectionActivityContract extends ActivityResultContract<TargetedMediaSelectionConfig, Pair<? extends String, ? extends String>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_CONFIG = "intent_extra_media_selection_config";
    public static final String EXTRA_NEWLY_SELECTED_ITEMS_JSON = "intent_extra_newly_selected_items_json";
    public static final String EXTRA_SELECTED_ITEM_IDS_JSON = "intent_extra_selected_item_ids_json";

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionActivityContract$Companion;", "", "()V", "EXTRA_CONFIG", "", "EXTRA_NEWLY_SELECTED_ITEMS_JSON", "EXTRA_SELECTED_ITEM_IDS_JSON", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TargetedMediaSelectionActivityContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Intent createIntent(Context context, TargetedMediaSelectionConfig targetedMediaSelectionConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(targetedMediaSelectionConfig, "config");
        Intent intent = new Intent(context, TargetedMediaSelectionActivity.class);
        intent.putExtra("intent_extra_media_selection_config", targetedMediaSelectionConfig);
        return intent;
    }

    public Pair<String, String> parseResult(int i, Intent intent) {
        if (i == -1) {
            return new Pair<>(intent != null ? intent.getStringExtra(EXTRA_NEWLY_SELECTED_ITEMS_JSON) : null, intent != null ? intent.getStringExtra(EXTRA_SELECTED_ITEM_IDS_JSON) : null);
        } else if (i == 0) {
            return null;
        } else {
            try {
                throw new RuntimeException("Unknown activity-result " + i);
            } catch (Exception e) {
                CrashLog.Builder markHarmless = new CrashLog.Builder(new NParcelableException()).markHarmless();
                ExternalProxy.INSTANCE.getCrashReporter().report(markHarmless.addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
                return null;
            }
        }
    }
}
