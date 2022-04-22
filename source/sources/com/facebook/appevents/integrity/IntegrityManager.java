package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.p009ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public final class IntegrityManager {
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    public static final String INTEGRITY_TYPE_NONE = "none";
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled = false;
    private static boolean isSampleEnabled = false;

    public static void enable() {
        enabled = true;
        isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
    }

    public static void processParameters(Map<String, String> map) {
        if (enabled && map.size() != 0) {
            try {
                ArrayList<String> arrayList = new ArrayList<>(map.keySet());
                JSONObject jSONObject = new JSONObject();
                for (String str : arrayList) {
                    String str2 = map.get(str);
                    if (shouldFilter(str) || shouldFilter(str2)) {
                        map.remove(str);
                        if (!isSampleEnabled) {
                            str2 = "";
                        }
                        jSONObject.put(str, str2);
                    }
                }
                if (jSONObject.length() != 0) {
                    map.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObject.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean shouldFilter(String str) {
        return !"none".equals(getIntegrityPredictionResult(str));
    }

    private static String getIntegrityPredictionResult(String str) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
        if (predict == null) {
            return "none";
        }
        return predict[0];
    }
}
