package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.p009ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final Set<String> eligibleEvents = new HashSet();
    /* access modifiers changed from: private */
    public static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new HashSet();

    public static synchronized void enable() {
        synchronized (SuggestedEventsManager.class) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    if (!SuggestedEventsManager.enabled.get()) {
                        SuggestedEventsManager.enabled.set(true);
                        SuggestedEventsManager.initialize();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void initialize() {
        String suggestedEventsSetting;
        File ruleFile;
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                populateEventsFromRawJsonString(suggestedEventsSetting);
                if ((!productionEvents.isEmpty() || !eligibleEvents.isEmpty()) && (ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION)) != null) {
                    FeatureExtractor.initialize(ruleFile);
                    Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                    if (currentActivity != null) {
                        trackActivity(currentActivity);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    protected static void populateEventsFromRawJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(PRODUCTION_EVENTS_KEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY);
                for (int i = 0; i < jSONArray.length(); i++) {
                    productionEvents.add(jSONArray.getString(i));
                }
            }
            if (jSONObject.has(ELIGIBLE_EVENTS_KEY)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    eligibleEvents.add(jSONArray2.getString(i2));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void trackActivity(Activity activity) {
        try {
            if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                ViewObserver.stopTrackingActivity(activity);
            } else {
                ViewObserver.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isEnabled() {
        return enabled.get();
    }

    static boolean isProductionEvents(String str) {
        return productionEvents.contains(str);
    }

    static boolean isEligibleEvents(String str) {
        return eligibleEvents.contains(str);
    }
}
