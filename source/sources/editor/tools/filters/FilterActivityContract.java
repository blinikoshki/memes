package editor.tools.filters;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.share.internal.ShareConstants;
import com.memes.crashreporter.CrashLog;
import editor.tools.filters.conflation.FilterRequest;
import editor.tools.filters.conflation.FilterResult;
import editor.util.ExternalProxy;
import editor.util.exceptions.NParcelableException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, mo26107d2 = {"Leditor/tools/filters/FilterActivityContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Leditor/tools/filters/conflation/FilterRequest;", "Leditor/tools/filters/conflation/FilterResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "request", "parseResult", "resultCode", "", "intent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FilterActivityContract.kt */
public final class FilterActivityContract extends ActivityResultContract<FilterRequest, FilterResult> {
    public Intent createIntent(Context context, FilterRequest filterRequest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filterRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intent intent = new Intent(context, ActivityProxyBridge.INSTANCE.getFiltersPageClass());
        intent.putExtra(FiltersActivity.EXTRA_FILTER_REQUEST, filterRequest);
        return intent;
    }

    public FilterResult parseResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            return null;
        }
        try {
            return (FilterResult) intent.getParcelableExtra(FiltersActivity.EXTRA_FILTER_RESULT);
        } catch (Exception e) {
            CrashLog.Builder markHarmless = new CrashLog.Builder(new NParcelableException()).markHarmless();
            ExternalProxy.INSTANCE.getCrashReporter().report(markHarmless.addMessage(this + " has encountered an issue.").addStackTraceFor(e).build());
            return null;
        }
    }
}
