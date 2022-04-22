package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AFEvent {
    String $$a;
    Map<String, Object> $$b;
    String AFDateFormat;
    public int AFDeepLinkManager;
    private byte[] AFEvent;
    String collectIntentsFromActivities;
    boolean dateFormatUTC;
    private final boolean getDataFormatter;
    private AppsFlyerRequestListener getInstance;
    public final Map<String, Object> params;
    private Application requestListener;
    private String urlString;
    String valueOf;
    String values;

    public AFEvent() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public AFEvent(String str, String str2, Boolean bool, Context context) {
        this.params = new HashMap();
        this.values = str;
        this.collectIntentsFromActivities = str2;
        this.getDataFormatter = bool != null ? bool.booleanValue() : true;
        context(context);
    }

    /* access modifiers changed from: protected */
    public AFEvent context(Context context) {
        if (context != null) {
            this.requestListener = (Application) context.getApplicationContext();
        }
        return this;
    }

    public Application context() {
        return this.requestListener;
    }

    public AFEvent urlString(String str) {
        this.collectIntentsFromActivities = str;
        return this;
    }

    /* access modifiers changed from: protected */
    public String urlString() {
        return this.collectIntentsFromActivities;
    }

    public AFEvent requestListener(AppsFlyerRequestListener appsFlyerRequestListener) {
        this.getInstance = appsFlyerRequestListener;
        return this;
    }

    public AppsFlyerRequestListener getRequestListener() {
        return this.getInstance;
    }

    /* access modifiers changed from: protected */
    public AFEvent key(String str) {
        this.urlString = str;
        return this;
    }

    public String key() {
        return this.urlString;
    }

    /* access modifiers changed from: package-private */
    public final boolean values() {
        return this.dateFormatUTC;
    }

    /* access modifiers changed from: protected */
    public AFEvent addParams(Map<String, ?> map) {
        this.params.putAll(map);
        return this;
    }

    public Map<String, Object> params() {
        return this.params;
    }

    public AFEvent post(byte[] bArr) {
        this.AFEvent = bArr;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final byte[] AFDateFormat() {
        return this.AFEvent;
    }

    public boolean isEncrypt() {
        return this.getDataFormatter;
    }

    /* access modifiers changed from: protected */
    public String addChannel(String str) {
        String configuredChannel = AppsFlyerLibCore.getInstance().getConfiguredChannel(context());
        return configuredChannel != null ? Uri.parse(str).buildUpon().appendQueryParameter("channel", configuredChannel).build().toString() : str;
    }
}
