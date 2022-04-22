package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import com.giphy.sdk.analytics.network.api.GPHPingbackClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.v */
public final class C1082v extends OneLinkHttpTask {
    private static List<String> values = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});
    public C1083d $$a;
    public boolean $$b = false;
    private String AFDateFormat;
    private String valueOf;

    /* renamed from: com.appsflyer.internal.v$d */
    public interface C1083d {
        void $$b(String str);

        void valueOf(Map<String, String> map);
    }

    public C1082v(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        super(appsFlyerLibCore);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : values) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            if (AFDeepLinkManager.AFDateFormat != null) {
                StringBuilder sb = new StringBuilder("Validate if link ");
                sb.append(uri);
                sb.append(" belongs to custom domains: ");
                sb.append(Arrays.asList(AFDeepLinkManager.AFDateFormat));
                AFLogger.afRDLog(sb.toString());
                for (String str : AFDeepLinkManager.AFDateFormat) {
                    if (uri.getHost().contains(str) && !TextUtils.isEmpty(str)) {
                        AFLogger.afDebugLog("Link matches custom domain: ".concat(String.valueOf(str)));
                        this.$$b = true;
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z && split.length == 3) {
                this.oneLinkId = split[1];
                this.AFDateFormat = split[2];
                this.valueOf = uri.toString();
            }
        }
    }

    public final boolean $$a() {
        return !TextUtils.isEmpty(this.oneLinkId) && !TextUtils.isEmpty(this.AFDateFormat) && !this.oneLinkId.equals("app");
    }

    public final void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod(GPHPingbackClient.HTTP_GET);
    }

    public final String getOneLinkUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl(BASE_URL));
        sb.append("/");
        sb.append(this.oneLinkId);
        sb.append("?id=");
        sb.append(this.AFDateFormat);
        return sb.toString();
    }

    public final void handleResponse(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.$$a.valueOf(hashMap);
        } catch (JSONException e) {
            this.$$a.$$b("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    public final void onErrorResponse() {
        String str = this.valueOf;
        if (str == null) {
            str = "Can't get one link data";
        }
        this.$$a.$$b(str);
    }
}
