package com.appsflyer.internal.event.uninstall;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.AFDateFormat;
import com.appsflyer.AFFacebookDeferredDeeplink;
import com.appsflyer.AFLogger;
import com.appsflyer.AdvertisingIdObject;
import com.appsflyer.AdvertisingIdUtil;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.BackgroundHttpTask;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.Installation;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.iid.ServiceStarter;
import com.memes.eventtracker.util.Util;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

public final class Register extends BackgroundEvent {
    public static final String TOKEN_PAYLOAD_KEY = "af_gcm_token";
    public static final String TOKEN_PERSIST_KEY = "afUninstallToken";
    public static final String TOKEN_RECEIVED_TIME_PERSIST_KEY = "afUninstallToken_received_time";
    public static String URL;
    private final SharedPreferences getDataFormatter;

    static {
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(AppsFlyerLibCore.BUILD_URL_SUFFIX);
        URL = sb.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Register(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = URL
            java.lang.String r1 = com.appsflyer.ServerConfigHandler.getUrl(r1)
            r0.append(r1)
            java.lang.String r1 = r10.getPackageName()
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            android.content.SharedPreferences r10 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r10)
            r9.getDataFormatter = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.event.uninstall.Register.<init>(android.content.Context):void");
    }

    public static boolean didConfiguredFirebaseMessagingServiceListener(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
            if (AndroidUtils.isServiceAvailable(context, new Intent(ServiceStarter.ACTION_MESSAGING_EVENT, (Uri) null, context, FirebaseMessagingServiceListener.class))) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
    }

    public static boolean isSent(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public final void send(String str) {
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            AFFacebookDeferredDeeplink $$b = $$b();
            if ($$b == null || !str.equals($$b.AFDateFormat)) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = AppsFlyerLibCore.firstCallSent(this.getDataFormatter) && ($$b == null || currentTimeMillis - $$b.$$b > TimeUnit.SECONDS.toMillis(2));
                AFFacebookDeferredDeeplink aFFacebookDeferredDeeplink = new AFFacebookDeferredDeeplink(str, currentTimeMillis, !z);
                this.getDataFormatter.edit().putString(TOKEN_PERSIST_KEY, aFFacebookDeferredDeeplink.AFDateFormat).putLong(TOKEN_RECEIVED_TIME_PERSIST_KEY, aFFacebookDeferredDeeplink.$$b).putBoolean("afUninstallToken_queued", aFFacebookDeferredDeeplink.AFDateFormat()).apply();
                if (z) {
                    $$b(str);
                }
            }
        }
    }

    public final void sendIfQueued() {
        AFFacebookDeferredDeeplink $$b = $$b();
        if ($$b != null && $$b.AFDateFormat()) {
            String str = $$b.AFDateFormat;
            AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
            $$b(str);
        }
    }

    private AFFacebookDeferredDeeplink $$b() {
        String string;
        String string2;
        String string3 = this.getDataFormatter.getString(TOKEN_PERSIST_KEY, (String) null);
        long j = this.getDataFormatter.getLong(TOKEN_RECEIVED_TIME_PERSIST_KEY, 0);
        boolean z = this.getDataFormatter.getBoolean("afUninstallToken_queued", false);
        this.getDataFormatter.edit().putBoolean("afUninstallToken_queued", false).apply();
        if (string3 == null && (string2 = AppsFlyerProperties.getInstance().getString(TOKEN_PERSIST_KEY)) != null) {
            String[] split = string2.split(Util.EVENT_ID_SEPARATOR);
            string3 = split[split.length - 1];
        }
        if (j == 0 && (string = AppsFlyerProperties.getInstance().getString(TOKEN_PERSIST_KEY)) != null) {
            String[] split2 = string.split(Util.EVENT_ID_SEPARATOR);
            if (split2.length >= 2) {
                try {
                    j = Long.parseLong(split2[split2.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (string3 != null) {
            return new AFFacebookDeferredDeeplink(string3, j, z);
        }
        return null;
    }

    private void $$b(String str) {
        Application context = context();
        final AppsFlyerLibCore instance = AppsFlyerLibCore.getInstance();
        if (instance.waitingForId()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        String property = instance.getProperty(AppsFlyerProperties.AF_KEY);
        if (property == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            this.params.put(ServerParameters.APP_VERSION_CODE, Integer.toString(packageInfo.versionCode));
            this.params.put(ServerParameters.APP_VERSION_NAME, packageInfo.versionName);
            this.params.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            this.params.put(ServerParameters.INSTALL_DATE, instance.dateFormatUTC(AFDateFormat.getDataFormatter(AppsFlyerLibCore.INSTALL_UPDATE_DATE_FORMAT), j));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        instance.addNetworkData(context, this.params);
        String customerUserId = instance.getCustomerUserId();
        if (customerUserId != null) {
            this.params.put(ServerParameters.APP_USER_ID, customerUserId);
        }
        try {
            this.params.put(ServerParameters.MODEL, Build.MODEL);
            this.params.put(ServerParameters.BRAND, Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean("deviceTrackingDisabled", false)) {
            this.params.put("deviceTrackingDisabled", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        AdvertisingIdObject amazonAID = AdvertisingIdUtil.getAmazonAID(context.getContentResolver());
        if (amazonAID != null) {
            this.params.put(ServerParameters.AMAZON_AID, amazonAID.getAdvertisingId());
            this.params.put(ServerParameters.AMAZON_AID_LIMIT, String.valueOf(amazonAID.isLimitAdTracking()));
        }
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string != null) {
            this.params.put(ServerParameters.ADVERTISING_ID_PARAM, string);
        }
        this.params.put(ServerParameters.DEV_KEY, property);
        this.params.put(ServerParameters.AF_USER_ID, Installation.m25id(new WeakReference(context)));
        this.params.put("af_gcm_token", str);
        this.params.put(ServerParameters.LAUNCH_COUNTER, Integer.toString(instance.getLaunchCounter(this.getDataFormatter, false)));
        this.params.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String configuredChannel = instance.getConfiguredChannel(context);
        if (configuredChannel != null) {
            this.params.put("channel", configuredChannel);
        }
        new Thread(new Runnable() {
            public final void run() {
                try {
                    HttpURLConnection doInBackground = new BackgroundHttpTask(Register.this.trackingStopped(instance.isStopped())).doInBackground();
                    if (doInBackground != null) {
                        if (doInBackground.getResponseCode() == 200) {
                            Register.$$a(Register.this);
                        }
                        doInBackground.disconnect();
                    }
                } catch (Throwable th) {
                    AFLogger.afErrorLog(th.getMessage(), th);
                }
            }
        }).start();
    }

    static /* synthetic */ void $$a(Register register) {
        register.getDataFormatter.edit().putBoolean("sentRegisterRequestToAF", true).apply();
        AFLogger.afDebugLog("Successfully registered for Uninstall Tracking");
    }
}
