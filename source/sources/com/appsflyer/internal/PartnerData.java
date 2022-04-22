package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PartnerData {
    public static final String KEY = "partner_data";
    private Map<String, Object> AFDateFormat = new HashMap();
    private final Map<String, Object> valueOf = new HashMap();

    public void set(String str, Map<String, Object> map) {
        if (str == null || str.isEmpty()) {
            AFLogger.afWarnLog("Partner ID is missing or `null`");
        } else if (map == null || map.isEmpty()) {
            AFLogger.afWarnLog(this.valueOf.remove(str) == null ? "Partner data is missing or `null`" : "Cleared partner data for ".concat(String.valueOf(str)));
        } else {
            StringBuilder sb = new StringBuilder("Setting partner data for ");
            sb.append(str);
            sb.append(": ");
            sb.append(map);
            AFLogger.afDebugLog(sb.toString());
            int length = new JSONObject(map).toString().length();
            if (length > 1000) {
                AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                HashMap hashMap = new HashMap();
                hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                this.AFDateFormat.put(str, hashMap);
                return;
            }
            this.valueOf.put(str, map);
            this.AFDateFormat.remove(str);
        }
    }

    public void add(Map<String, Object> map) {
        if (!this.valueOf.isEmpty()) {
            map.put(KEY, this.valueOf);
        }
        if (!this.AFDateFormat.isEmpty()) {
            AppsFlyerLibCore.getMetaFrom(map).put(KEY, this.AFDateFormat);
            this.AFDateFormat = new HashMap();
        }
    }
}
