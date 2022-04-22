package com.facebook.appevents.aam;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;

public final class MetadataIndexer {
    private static final String TAG = "com.facebook.appevents.aam.MetadataIndexer";
    /* access modifiers changed from: private */
    public static Boolean enabled = false;

    public static void onActivityResumed(Activity activity) {
        try {
            if (!enabled.booleanValue()) {
                return;
            }
            if (!MetadataRule.getRules().isEmpty()) {
                MetadataViewObserver.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void updateRules() {
        String rawAamRules;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null && (rawAamRules = queryAppSettings.getRawAamRules()) != null) {
            MetadataRule.updateRules(rawAamRules);
        }
    }

    public static void enable() {
        try {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    if (!AttributionIdentifiers.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                        MetadataIndexer.updateRules();
                        Boolean unused = MetadataIndexer.enabled = true;
                    }
                }
            });
        } catch (Exception e) {
            Utility.logd(TAG, e);
        }
    }
}
