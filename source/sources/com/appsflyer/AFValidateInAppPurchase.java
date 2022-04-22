package com.appsflyer;

import android.content.Context;
import com.appsflyer.internal.C1048ac;
import com.appsflyer.internal.model.event.Purchase;
import com.appsflyer.internal.model.event.SdkServices;
import com.appsflyer.internal.model.event.Validate;
import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class AFValidateInAppPurchase implements Runnable {
    private static String $$b = "https://%ssdk-services.%s/validate-android-signature";
    private static String values;
    private String $$a;
    /* access modifiers changed from: private */
    public WeakReference<Context> AFDateFormat;
    private String AFDeepLinkManager;
    private String collectIntentsFromActivities;
    /* access modifiers changed from: private */
    public Map<String, String> dateFormatUTC;
    private String getDataFormatter;
    private String getInstance;
    private String valueOf;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AppsFlyerLibCore.SERVER_BUILD_NUMBER);
        sb.append("/androidevent?buildnumber=6.2.0&app_id=");
        values = sb.toString();
    }

    AFValidateInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.AFDateFormat = new WeakReference<>(context);
        this.valueOf = str;
        this.$$a = str2;
        this.getInstance = str4;
        this.AFDeepLinkManager = str5;
        this.collectIntentsFromActivities = str6;
        this.dateFormatUTC = map;
        this.getDataFormatter = str3;
    }

    public static void setUrl(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getValue();
            String str2 = (String) next.getKey();
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1421272810) {
                if (hashCode == 454162577 && str2.equals("sdk-services")) {
                    c = 0;
                }
            } else if (str2.equals("validate")) {
                c = 1;
            }
            if (c == 0) {
                $$b = str;
            } else if (c == 1) {
                values = str;
            }
        }
    }

    public void run() {
        String str = this.valueOf;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.AFDateFormat.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.$$a);
                    hashMap.put("sig-data", this.getInstance);
                    hashMap.put("signature", this.getDataFormatter);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            AFValidateInAppPurchase aFValidateInAppPurchase = AFValidateInAppPurchase.this;
                            AFValidateInAppPurchase.valueOf(aFValidateInAppPurchase, hashMap2, aFValidateInAppPurchase.dateFormatUTC, AFValidateInAppPurchase.this.AFDateFormat);
                        }
                    }).start();
                    hashMap.put("dev_key", this.valueOf);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put(ServerParameters.AF_USER_ID, AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl($$b);
                    C1048ac.AFDateFormat().AFDateFormat("server_request", url, jSONObject);
                    HttpURLConnection AFDateFormat2 = AFDateFormat((Purchase) new SdkServices().addParams(hashMap).urlString(url));
                    int i = -1;
                    if (AFDateFormat2 != null) {
                        i = AFDateFormat2.getResponseCode();
                    }
                    String readServerResponse = AppsFlyerLibCore.getInstance().readServerResponse(AFDateFormat2);
                    C1048ac.AFDateFormat().AFDateFormat("server_response", url, String.valueOf(i), readServerResponse);
                    JSONObject jSONObject2 = new JSONObject(readServerResponse);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        AFDateFormat(jSONObject2.optBoolean("result"), this.getInstance, this.AFDeepLinkManager, this.collectIntentsFromActivities, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        AFDateFormat(false, this.getInstance, this.AFDeepLinkManager, this.collectIntentsFromActivities, jSONObject2.toString());
                    }
                    if (AFDateFormat2 != null) {
                        AFDateFormat2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    private static HttpURLConnection AFDateFormat(Purchase purchase) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(purchase.urlString());
        AFLogger.afDebugLog(sb.toString());
        return new BackgroundHttpTask(purchase.trackingStopped(AppsFlyerLib.getInstance().isStopped())).doInBackground();
    }

    private static void AFDateFormat(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLibCore.valueOf != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(StringUtils.SPACE);
            sb.append(str2);
            sb.append(StringUtils.SPACE);
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLibCore.valueOf.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLibCore.valueOf;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    static /* synthetic */ void valueOf(AFValidateInAppPurchase aFValidateInAppPurchase, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(values));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = AppsFlyerLibCore.getSharedPreferences((Context) weakReference.get()).getString(Payload.RFR, "");
            AFEvent key = new Validate((Context) weakReference.get()).key(aFValidateInAppPurchase.valueOf);
            key.valueOf = string;
            Validate validate = (Validate) key;
            AppsFlyerLibCore instance = AppsFlyerLibCore.getInstance();
            Map<String, Object> valueOf2 = instance.valueOf((AFEvent) validate);
            valueOf2.put(FirebaseAnalytics.Param.PRICE, aFValidateInAppPurchase.AFDeepLinkManager);
            valueOf2.put(FirebaseAnalytics.Param.CURRENCY, aFValidateInAppPurchase.collectIntentsFromActivities);
            valueOf2.put("receipt_data", map);
            if (map2 != null) {
                valueOf2.put("extra_prms", map2);
            }
            valueOf2.putAll(instance.valueOf());
            String jSONObject = new JSONObject(valueOf2).toString();
            C1048ac.AFDateFormat().AFDateFormat("server_request", obj, jSONObject);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection AFDateFormat2 = AFDateFormat((Purchase) validate.addParams(valueOf2).urlString(obj));
                int i = -1;
                if (AFDateFormat2 != null) {
                    i = AFDateFormat2.getResponseCode();
                }
                String readServerResponse = instance.readServerResponse(AFDateFormat2);
                C1048ac.AFDateFormat().AFDateFormat("server_response", obj, String.valueOf(i), readServerResponse);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(i);
                sb2.append(": ");
                sb2.append(new JSONObject(readServerResponse).toString());
                AFLogger.afInfoLog(sb2.toString());
                if (AFDateFormat2 != null) {
                    AFDateFormat2.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
