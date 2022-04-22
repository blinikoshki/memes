package com.memes.eventtracker.trackers.appsflyer;

import android.util.Log;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLibCore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006H\u0016¨\u0006\r"}, mo26107d2 = {"Lcom/memes/eventtracker/trackers/appsflyer/DefaultAppsFlyerConversionListener;", "Lcom/appsflyer/AppsFlyerConversionListener;", "()V", "onAppOpenAttribution", "", "conversionData", "", "", "onAttributionFailure", "errorMessage", "onConversionDataFail", "onConversionDataSuccess", "", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DefaultAppsFlyerConversionListener.kt */
public final class DefaultAppsFlyerConversionListener implements AppsFlyerConversionListener {
    public void onConversionDataSuccess(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "conversionData");
        for (String next : map.keySet()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, "attribute: " + next + " = " + map.get(next));
        }
    }

    public void onConversionDataFail(String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Log.d(AppsFlyerLibCore.LOG_TAG, "onConversionDataFail(): " + str);
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "conversionData");
        for (String next : map.keySet()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, "attribute: " + next + " = " + map.get(next));
        }
    }

    public void onAttributionFailure(String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Log.d(AppsFlyerLibCore.LOG_TAG, "onAttributionFailure(): " + str);
    }
}
