package com.appsflyer.deeplink;

import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

public class DeepLinkCallbacks {
    public static void onDeepLinkingError(String str) {
        if (AFDeepLinkManager.getInstance().deepLinkListener != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            valueOf(new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.NETWORK));
        } else if (AppsFlyerLibCore.conversionDataListener != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                AppsFlyerLibCore.conversionDataListener.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void onDeepLinkingSuccess(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (AFDeepLinkManager.getInstance().deepLinkListener != null) {
            try {
                DeepLink values = DeepLink.values(map);
                values.AFDateFormat.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(values, (DeepLinkResult.Error) null);
            } catch (JSONException e) {
                AFLogger.afErrorLog("[DDL] Error occurred", e, true);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th) {
                valueOf(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th;
            }
            valueOf(deepLinkResult);
            return;
        }
        onAppOpenAttribution(map);
    }

    static void valueOf(DeepLinkResult deepLinkResult) {
        if (AFDeepLinkManager.getInstance().deepLinkListener != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.afDebugLog(sb.toString());
            try {
                AFDeepLinkManager.getInstance().deepLinkListener.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.afDebugLog("[DDL] skipping, no callback registered");
        }
    }

    public static void onAppOpenAttribution(Map<String, String> map) {
        if (AppsFlyerLibCore.conversionDataListener != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                AppsFlyerLibCore.conversionDataListener.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }
}
