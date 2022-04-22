package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

public final class RestrictiveDataManager {
    private static final String PROCESS_EVENT_NAME = "process_event_name";
    private static final String REPLACEMENT_STRING = "_removed_";
    private static final String RESTRICTIVE_PARAM = "restrictive_param";
    private static final String RESTRICTIVE_PARAM_KEY = "_restrictedParams";
    private static final String TAG = "com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager";
    private static boolean enabled = false;
    private static final Set<String> restrictedEvents = new CopyOnWriteArraySet();
    private static final List<RestrictiveParamFilter> restrictiveParamFilters = new ArrayList();

    public static void enable() {
        enabled = true;
        initialize();
    }

    private static void initialize() {
        String restrictiveDataSetting;
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null && (restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting()) != null) {
                if (!restrictiveDataSetting.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                    restrictiveParamFilters.clear();
                    restrictedEvents.clear();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        if (jSONObject2 != null) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject(RESTRICTIVE_PARAM);
                            RestrictiveParamFilter restrictiveParamFilter = new RestrictiveParamFilter(next, new HashMap());
                            if (optJSONObject != null) {
                                restrictiveParamFilter.restrictiveParams = Utility.convertJSONObjectToStringMap(optJSONObject);
                                restrictiveParamFilters.add(restrictiveParamFilter);
                            }
                            if (jSONObject2.has(PROCESS_EVENT_NAME)) {
                                restrictedEvents.add(restrictiveParamFilter.eventName);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String processEvent(String str) {
        return (!enabled || !isRestrictedEvent(str)) ? str : REPLACEMENT_STRING;
    }

    public static void processParameters(Map<String, String> map, String str) {
        if (enabled) {
            HashMap hashMap = new HashMap();
            for (String str2 : new ArrayList(map.keySet())) {
                String matchedRuleType = getMatchedRuleType(str, str2);
                if (matchedRuleType != null) {
                    hashMap.put(str2, matchedRuleType);
                    map.remove(str2);
                }
            }
            if (hashMap.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    map.put(RESTRICTIVE_PARAM_KEY, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    private static String getMatchedRuleType(String str, String str2) {
        try {
            for (RestrictiveParamFilter restrictiveParamFilter : new ArrayList(restrictiveParamFilters)) {
                if (restrictiveParamFilter != null) {
                    if (str.equals(restrictiveParamFilter.eventName)) {
                        for (String next : restrictiveParamFilter.restrictiveParams.keySet()) {
                            if (str2.equals(next)) {
                                return restrictiveParamFilter.restrictiveParams.get(next);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Log.w(TAG, "getMatchedRuleType failed", e);
            return null;
        }
    }

    private static boolean isRestrictedEvent(String str) {
        return restrictedEvents.contains(str);
    }

    static class RestrictiveParamFilter {
        String eventName;
        Map<String, String> restrictiveParams;

        RestrictiveParamFilter(String str, Map<String, String> map) {
            this.eventName = str;
            this.restrictiveParams = map;
        }
    }
}
