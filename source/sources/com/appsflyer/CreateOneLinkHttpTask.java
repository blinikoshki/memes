package com.appsflyer;

import android.content.Context;
import com.appsflyer.share.Constants;
import com.appsflyer.share.LinkGenerator;
import com.giphy.sdk.analytics.network.api.GPHPingbackClient;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateOneLinkHttpTask extends OneLinkHttpTask {
    private static final String BRAND_DOMAIN = "brand_domain";
    private static final String TRACKING_LINK_DATA_KEY = "data";
    private static final String TRACKING_LINK_LIVE_TIME_KEY = "ttl";
    private String brandDomain;
    private Context context;
    private Map<String, String> data;
    private boolean mTrackingStopped = false;
    private String packageName = "";
    private ResponseListener responseListener;
    private String ttl;

    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(String str, Map<String, String> map, AppsFlyerLibCore appsFlyerLibCore, Context context2, boolean z) {
        super(appsFlyerLibCore);
        this.mTrackingStopped = z;
        this.context = context2;
        if (context2 != null) {
            this.packageName = context2.getPackageName();
        } else {
            AFLogger.afWarnLog("CreateOneLinkHttpTask: context can't be null");
        }
        this.oneLinkId = str;
        this.ttl = "-1";
        this.data = map;
    }

    public void setListener(ResponseListener responseListener2) {
        this.responseListener = responseListener2;
    }

    public void setBrandDomain(String str) {
        this.brandDomain = str;
    }

    /* access modifiers changed from: package-private */
    public void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        if (!this.mTrackingStopped) {
            httpsURLConnection.setRequestMethod(GPHPingbackClient.HTTP_POST);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(this.data);
            jSONObject.put("ttl", this.ttl);
            jSONObject.put("data", jSONObject2);
            String str = this.brandDomain;
            if (str != null) {
                jSONObject.put(BRAND_DOMAIN, str);
            }
            httpsURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.writeBytes(jSONObject.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    public String getOneLinkUrl() {
        return ServerConfigHandler.getUrl(BASE_URL) + "/" + this.oneLinkId;
    }

    /* access modifiers changed from: package-private */
    public void handleResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.responseListener.onResponse(jSONObject.optString(keys.next()));
            }
        } catch (JSONException e) {
            this.responseListener.onResponseError("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json " + str, e);
        }
    }

    /* access modifiers changed from: package-private */
    public void onErrorResponse() {
        LinkGenerator addParameters = new LinkGenerator(Constants.USER_INVITE_LINK_TYPE).setBaseURL(this.oneLinkId, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.packageName).addParameter(Constants.URL_SITE_ID, this.packageName).addParameters(this.data);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            addParameters.setReferrerCustomerId(string);
        }
        this.responseListener.onResponse(addParameters.generateLink());
    }
}
