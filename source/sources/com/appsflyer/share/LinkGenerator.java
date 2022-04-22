package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

public class LinkGenerator {
    String $$a;
    private String $$b;
    String AFDateFormat;
    private String AFDeepLinkManager;
    private Map<String, String> AFEvent = new HashMap();
    private String collectIntentsFromActivities;
    private Map<String, String> context = new HashMap();
    private String dateFormatUTC;
    private String getDataFormatter;
    private String getInstance;
    private String requestListener;
    private String urlString;
    private String valueOf;
    private String values;

    public LinkGenerator(String str) {
        this.values = str;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.urlString = str;
        return this;
    }

    public String getBrandDomain() {
        return this.urlString;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.getDataFormatter = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.requestListener = str;
        return this;
    }

    public String getChannel() {
        return this.valueOf;
    }

    public LinkGenerator setChannel(String str) {
        this.valueOf = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.getInstance = str;
        return this;
    }

    public String getMediaSource() {
        return this.values;
    }

    public Map<String, String> getParameters() {
        return this.context;
    }

    public String getCampaign() {
        return this.$$b;
    }

    public LinkGenerator setCampaign(String str) {
        this.$$b = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.context.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.context.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.AFDeepLinkManager = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.collectIntentsFromActivities = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.dateFormatUTC = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFDateFormat = String.format("https://%s/%s", new Object[]{ServerConfigHandler.getUrl("%sapp.%s"), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.AFDateFormat = String.format("https://%s/%s", new Object[]{str2, str});
        }
        return this;
    }

    private StringBuilder $$b() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFDateFormat;
        if (str == null || !str.startsWith("http")) {
            sb.append(ServerConfigHandler.getUrl(Constants.AFDateFormat));
        } else {
            sb.append(this.AFDateFormat);
        }
        if (this.$$a != null) {
            sb.append('/');
            sb.append(this.$$a);
        }
        this.AFEvent.put(Constants.URL_MEDIA_SOURCE, this.values);
        sb.append('?');
        sb.append("pid=");
        sb.append(values(this.values, "media source"));
        String str2 = this.AFDeepLinkManager;
        if (str2 != null) {
            this.AFEvent.put("af_referrer_uid", str2);
            sb.append(Typography.amp);
            sb.append("af_referrer_uid=");
            sb.append(values(this.AFDeepLinkManager, "referrerUID"));
        }
        String str3 = this.valueOf;
        if (str3 != null) {
            this.AFEvent.put("af_channel", str3);
            sb.append(Typography.amp);
            sb.append("af_channel=");
            sb.append(values(this.valueOf, "channel"));
        }
        String str4 = this.getInstance;
        if (str4 != null) {
            this.AFEvent.put("af_referrer_customer_id", str4);
            sb.append(Typography.amp);
            sb.append("af_referrer_customer_id=");
            sb.append(values(this.getInstance, "referrerCustomerId"));
        }
        String str5 = this.$$b;
        if (str5 != null) {
            this.AFEvent.put(Constants.URL_CAMPAIGN, str5);
            sb.append(Typography.amp);
            sb.append("c=");
            sb.append(values(this.$$b, "campaign"));
        }
        String str6 = this.collectIntentsFromActivities;
        if (str6 != null) {
            this.AFEvent.put("af_referrer_name", str6);
            sb.append(Typography.amp);
            sb.append("af_referrer_name=");
            sb.append(values(this.collectIntentsFromActivities, "referrerName"));
        }
        String str7 = this.dateFormatUTC;
        if (str7 != null) {
            this.AFEvent.put("af_referrer_image_url", str7);
            sb.append(Typography.amp);
            sb.append("af_referrer_image_url=");
            sb.append(values(this.dateFormatUTC, "referrerImageURL"));
        }
        if (this.requestListener != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.requestListener);
            String str8 = "";
            sb2.append(this.requestListener.endsWith("/") ? str8 : "/");
            String str9 = this.getDataFormatter;
            if (str9 != null) {
                sb2.append(str9);
            }
            this.AFEvent.put("af_dp", sb2.toString());
            sb.append(Typography.amp);
            sb.append("af_dp=");
            sb.append(values(this.requestListener, "baseDeeplink"));
            if (this.getDataFormatter != null) {
                if (!this.requestListener.endsWith("/")) {
                    str8 = "%2F";
                }
                sb.append(str8);
                sb.append(values(this.getDataFormatter, "deeplinkPath"));
            }
        }
        for (String next : this.context.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(next);
            sb3.append("=");
            sb3.append(values(this.context.get(next), next));
            if (!obj.contains(sb3.toString())) {
                sb.append(Typography.amp);
                sb.append(next);
                sb.append('=');
                sb.append(values(this.context.get(next), next));
            }
        }
        return sb;
    }

    private static String values(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afErrorLog(sb.toString(), e);
            return "";
        } catch (Throwable th) {
            AFLogger.afErrorLog(th);
            return "";
        }
    }

    public String generateLink() {
        return $$b().toString();
    }

    public void generateLink(Context context2, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.context.isEmpty()) {
            for (Map.Entry next : this.context.entrySet()) {
                this.AFEvent.put(next.getKey(), next.getValue());
            }
        }
        $$b();
        String str = this.urlString;
        Map<String, String> map = this.AFEvent;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, AppsFlyerLibCore.getInstance(), context2, AppsFlyerLib.getInstance().isStopped());
        createOneLinkHttpTask.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        createOneLinkHttpTask.setListener(responseListener);
        createOneLinkHttpTask.setBrandDomain(str);
        AFExecutor.getInstance().getThreadPoolExecutor().execute(createOneLinkHttpTask);
    }
}
