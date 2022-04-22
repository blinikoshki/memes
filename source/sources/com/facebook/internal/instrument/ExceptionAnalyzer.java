package com.facebook.internal.instrument;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ExceptionAnalyzer {
    private static boolean enabled = false;

    public static void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendExceptionAnalysisReports();
        }
    }

    public static void execute(Throwable th) {
        if (enabled) {
            HashSet hashSet = new HashSet();
            for (StackTraceElement className : th.getStackTrace()) {
                FeatureManager.Feature feature = FeatureManager.getFeature(className.getClassName());
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            if (FacebookSdk.getAutoLogAppEventsEnabled() && !hashSet.isEmpty()) {
                InstrumentData.Builder.build(new JSONArray(hashSet)).save();
            }
        }
    }

    private static void sendExceptionAnalysisReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            ArrayList arrayList = new ArrayList();
            for (File load : listExceptionAnalysisReportFiles) {
                final InstrumentData load2 = InstrumentData.Builder.load(load);
                if (load2.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", load2.toString());
                        arrayList.add(GraphRequest.newPostRequest((AccessToken) null, String.format("%s/instruments", new Object[]{FacebookSdk.getApplicationId()}), jSONObject, new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse graphResponse) {
                                try {
                                    if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                                        load2.clear();
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                        }));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
            }
        }
    }
}
