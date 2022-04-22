package com.memes.eventtracker.trackers.appsflyer;

import android.util.Log;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerTrackingRequestListener;", "Lcom/appsflyer/attribution/AppsFlyerRequestListener;", "()V", "onError", "", "code", "", "error", "", "onSuccess", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DefaultAppsFlyerTrackingRequestListener.kt */
public final class DefaultAppsFlyerTrackingRequestListener implements AppsFlyerRequestListener {
    public void onSuccess() {
        Log.d(AppsFlyerLibCore.LOG_TAG, "onAppsFlyerRequestSuccess()");
    }

    public void onError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Log.d(AppsFlyerLibCore.LOG_TAG, "onAppsFlyerRequestFailure(): " + str);
    }
}
