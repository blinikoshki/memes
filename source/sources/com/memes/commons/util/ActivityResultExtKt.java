package com.memes.commons.util;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0006"}, mo26107d2 = {"getDataIfOkResult", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "isCancelled", "", "isOk", "commons_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ActivityResultExt.kt */
public final class ActivityResultExtKt {
    public static final boolean isOk(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "$this$isOk");
        return activityResult.getResultCode() == -1;
    }

    public static final boolean isCancelled(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "$this$isCancelled");
        return activityResult.getResultCode() == 0;
    }

    public static final Intent getDataIfOkResult(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "$this$getDataIfOkResult");
        if (isOk(activityResult)) {
            return activityResult.getData();
        }
        return null;
    }
}
