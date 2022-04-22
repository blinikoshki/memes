package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import com.appsflyer.AFFacebookDeferredDeeplink;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.Foreground;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DdlEvent;
import com.appsflyer.deeplink.DeepLinkCallbacks;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.internal.C1040a;
import com.appsflyer.internal.C1043aa;
import com.appsflyer.internal.C1048ac;
import com.appsflyer.internal.C1062o;
import com.appsflyer.internal.C1065p;
import com.appsflyer.internal.C1081u;
import com.appsflyer.internal.C1082v;
import com.appsflyer.internal.C1084w;
import com.appsflyer.internal.C1085x;
import com.appsflyer.internal.C1086y;
import com.appsflyer.internal.EventDataCollector;
import com.appsflyer.internal.Exlytics;
import com.appsflyer.internal.PartnerData;
import com.appsflyer.internal.attribution.RequestErrorMessage;
import com.appsflyer.internal.event.uninstall.Register;
import com.appsflyer.internal.model.event.AdRevenue;
import com.appsflyer.internal.model.event.Attr;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.appsflyer.internal.model.event.BackgroundReferrerLaunch;
import com.appsflyer.internal.model.event.CachedEvent;
import com.appsflyer.internal.model.event.InAppEvent;
import com.appsflyer.internal.model.event.Launch;
import com.appsflyer.internal.model.event.Stats;
import com.appsflyer.internal.referrer.GoogleReferrer;
import com.appsflyer.internal.referrer.HuaweiReferrer;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.internal.referrer.Referrer;
import com.appsflyer.internal.referrer.SamsungReferrer;
import com.appsflyer.share.Constants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLibCore extends AppsFlyerLib {
    public static final String $$b = "91";
    private static String AFDeepLinkManager = null;
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static final String BUILD_NUMBER = "6.2.0";
    public static final String BUILD_URL_SUFFIX;
    public static String FIRST_LAUNCHES_URL = null;
    public static final String INSTALL_REFERRER_PREF = "rfr";
    public static final String INSTALL_UPDATE_DATE_FORMAT = "yyyy-MM-dd_HHmmssZ";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_6.2.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";
    public static String REFERRER_TRACKING_URL = null;
    public static final String SERVER_BUILD_NUMBER = "6.2";
    private static String collectIntentsFromActivities = null;
    public static AppsFlyerConversionListener conversionDataListener = null;
    private static String dateFormatUTC = "https://%sstats.%s/stats";
    private static final String getDataFormatter;
    private static String getInstance;
    public static AppsFlyerLibCore instance = new AppsFlyerLibCore();
    private static final List<String> urlString = Arrays.asList(new String[]{"is_cache"});
    static AppsFlyerInAppPurchaseValidatorListener valueOf = null;
    public String $$a;
    long AFDateFormat;
    private long AFEvent = TimeUnit.SECONDS.toMillis(5);
    private boolean AFExecutor;
    private boolean AFFacebookDeferredDeeplink$AppLinkFetchEvents;
    /* access modifiers changed from: private */
    public Application AFHelper;
    /* access modifiers changed from: private */
    public final JSONObject AFInAppEventParameterName = new JSONObject();
    /* access modifiers changed from: private */
    public Referrer[] AFInAppEventType;
    private String AFKeystoreWrapper;
    private boolean AFLogger = false;
    private C1043aa addChannel = new C1043aa();
    private boolean addParams = false;
    private PartnerData afErrorLog;
    /* access modifiers changed from: private */
    public SharedPreferences afInfoLog;
    /* access modifiers changed from: private */
    public boolean context = false;
    public EventDataCollector eventDataCollector;
    private long getRequestListener = -1;
    private Map<Long, String> getThreadPoolExecutor;
    /* access modifiers changed from: private */
    public long isEncrypt;
    /* access modifiers changed from: private */
    public long key;
    private boolean onAppLinkFetchFailed = false;
    private boolean onAppLinkFetchFinished = false;
    private String params;
    /* access modifiers changed from: private */
    public ScheduledExecutorService post = null;
    private long requestListener = -1;
    public String[] sharingFilter;
    private boolean toJsonObject = false;
    /* access modifiers changed from: private */
    public Map<String, Object> toList;
    /* access modifiers changed from: private */
    public Map<String, Object> toMap;
    public String values;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_BUILD_NUMBER);
        sb.append("/androidevent?buildnumber=6.2.0&app_id=");
        BUILD_URL_SUFFIX = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb2.append(SERVER_BUILD_NUMBER);
        sb2.append("/android?buildnumber=6.2.0&app_id=");
        AFDeepLinkManager = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(SERVER_BUILD_NUMBER);
        sb3.append("/androidevent?app_id=");
        String obj = sb3.toString();
        getDataFormatter = obj;
        StringBuilder sb4 = new StringBuilder("https://%sconversions.%s/api/v");
        sb4.append(obj);
        FIRST_LAUNCHES_URL = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%slaunches.%s/api/v");
        sb5.append(obj);
        getInstance = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%sinapps.%s/api/v");
        sb6.append(obj);
        collectIntentsFromActivities = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sattr.%s/api/v");
        sb7.append(obj);
        REFERRER_TRACKING_URL = sb7.toString();
    }

    public AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return instance;
    }

    public void performOnAppAttribution(Context context2, URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            StringBuilder sb = new StringBuilder("Link is \"");
            sb.append(uri);
            sb.append("\"");
            DeepLinkCallbacks.onDeepLinkingError(sb.toString());
        } else if (context2 == null) {
            StringBuilder sb2 = new StringBuilder("Context is \"");
            sb2.append(context2);
            sb2.append("\"");
            DeepLinkCallbacks.onDeepLinkingError(sb2.toString());
        } else {
            AFDeepLinkManager.getInstance().valueOf(context2, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    public void setSharingFilter(String... strArr) {
        if (strArr != null && !Arrays.equals(this.sharingFilter, new String[]{TtmlNode.COMBINE_ALL})) {
            Pattern compile = Pattern.compile("[\\d\\w_]{1,45}");
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str == null || !compile.matcher(str).matches()) {
                    AFLogger.afWarnLog("Invalid partner name :".concat(String.valueOf(str)));
                } else {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                this.sharingFilter = (String[]) arrayList.toArray(new String[0]);
            } else {
                this.sharingFilter = null;
            }
        }
    }

    public void setSharingFilterForAllPartners() {
        this.sharingFilter = new String[]{TtmlNode.COMBINE_ALL};
    }

    public void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        AFDeepLinkManager instance2 = AFDeepLinkManager.getInstance();
        instance2.contains = str;
        instance2.parameters = map;
    }

    public void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        AFDeepLinkManager.getInstance().deepLinkListener = deepLinkListener;
    }

    public void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j) {
        DdlEvent.LISTENER_TIMEOUT = j;
        subscribeForDeepLink(deepLinkListener);
    }

    public void addPushNotificationDeepLinkPath(String... strArr) {
        List asList = Arrays.asList(strArr);
        List<List<String>> list = AFDeepLinkManager.getInstance().deepLinkSearchPaths;
        if (!list.contains(asList)) {
            list.add(asList);
        }
    }

    public void setPartnerData(String str, Map<String, Object> map) {
        if (this.afErrorLog == null) {
            this.afErrorLog = new PartnerData();
        }
        this.afErrorLog.set(str, map);
    }

    /* access modifiers changed from: package-private */
    public final void AFDateFormat(Context context2, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            AppsFlyerLibCore instance2 = getInstance();
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has(Constants.URL_MEDIA_SOURCE)) {
                    instance2.setProperty("preInstallName", stringExtra);
                } else {
                    AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e) {
                AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra(Payload.RFR);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
            edit.putString(Payload.RFR, stringExtra2);
            edit.apply();
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                AFEvent context3 = new BackgroundReferrerLaunch().context(context2);
                context3.valueOf = stringExtra2;
                if (stringExtra2 != null && stringExtra2.length() > 5 && $$a(context3, getSharedPreferences(context2))) {
                    $$b(AFExecutor.getInstance().valueOf(), new C1020c(this, context3, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    private static void $$b(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i2) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i2++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void $$b(Context context2, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = getSharedPreferences(context2).getString("extraReferrers", (String) null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                $$b(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject4 = jSONObject.toString();
            SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
            edit.putString("extraReferrers", jSONObject4);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    public void stop(boolean z, Context context2) {
        this.toJsonObject = z;
        C1085x.values();
        try {
            File AFDateFormat2 = C1085x.AFDateFormat(context2);
            if (!AFDateFormat2.exists()) {
                AFDateFormat2.mkdir();
            } else {
                for (File file : AFDateFormat2.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file.getName());
                    AFLogger.afInfoLog(sb.toString());
                    C1085x.$$b(C1085x.values(file).AFDateFormat, context2);
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("Could not cache request", e);
        }
        if (this.toJsonObject) {
            SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            edit.apply();
        }
    }

    public String getSdkVersion() {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 6.2.0 (build ");
        sb.append($$b);
        sb.append(")");
        return sb.toString();
    }

    public void onPause(Context context2) {
        if (Foreground.listener != null) {
            Foreground.listener.onBecameBackground(context2);
        }
    }

    public void updateServerUninstallToken(Context context2, String str) {
        new Register(context2).send(str);
    }

    public void setDebugLog(boolean z) {
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    public void setImeiData(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setImeiData", str);
        this.values = str;
    }

    public void setOaidData(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setOaidData", str);
        AdvertisingIdUtil.AFDateFormat = str;
    }

    public void setAndroidIdData(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setAndroidIdData", str);
        this.$$a = str;
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.addParams = z;
        return this;
    }

    /* access modifiers changed from: private */
    public void $$a(Context context2, String str, long j) {
        SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public void setProperty(String str, String str2) {
        AppsFlyerProperties.getInstance().set(str, str2);
    }

    public String getProperty(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    private static boolean values(String str, boolean z) {
        return AppsFlyerProperties.getInstance().getBoolean(str, z);
    }

    public boolean waitingForId() {
        return values(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && getProperty(AppsFlyerProperties.APP_USER_ID) == null;
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public void setCustomerIdAndLogSession(String str, Context context2) {
        if (context2 == null) {
            return;
        }
        if (waitingForId()) {
            setCustomerUserId(str);
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
            StringBuilder sb = new StringBuilder("CustomerUserId set: ");
            sb.append(str);
            sb.append(" - Initializing AppsFlyer Tacking");
            AFLogger.afInfoLog(sb.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
            String property = getProperty(AppsFlyerProperties.AF_KEY);
            if (referrer == null) {
                referrer = "";
            }
            if (context2 instanceof Activity) {
                ((Activity) context2).getIntent();
            }
            AFEvent context3 = new Launch().context(context2);
            context3.values = null;
            AFEvent key2 = context3.key(property);
            key2.$$b = null;
            key2.valueOf = referrer;
            key2.AFDateFormat = null;
            values(key2);
            return;
        }
        setCustomerUserId(str);
        AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public String getOutOfStore(Context context2) {
        String str;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        if (context2 == null) {
            str = null;
        } else {
            str = values("AF_STORE", context2.getPackageManager(), context2.getPackageName());
        }
        if (str != null) {
            return str;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.AFDateFormat("Cannot set setOutOfStore with null");
    }

    public void setAppInviteOneLink(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        setProperty(AppsFlyerProperties.ONELINK_ID, str);
    }

    public void setAdditionalData(Map<String, Object> map) {
        if (map != null) {
            C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            r3 = 1
            r4 = 0
            r5 = 2
            java.lang.String r6 = "public_api_call"
            java.lang.String r7 = "sendPushNotificationData"
            if (r17 == 0) goto L_0x003d
            android.content.Intent r8 = r17.getIntent()
            if (r8 == 0) goto L_0x003d
            com.appsflyer.internal.ac r8 = com.appsflyer.internal.C1048ac.AFDateFormat()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "activity_intent_"
            r4.<init>(r10)
            android.content.Intent r10 = r17.getIntent()
            java.lang.String r10 = r10.toString()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r9[r3] = r4
            r8.AFDateFormat(r6, r7, r9)
            goto L_0x0060
        L_0x003d:
            if (r17 == 0) goto L_0x0053
            com.appsflyer.internal.ac r8 = com.appsflyer.internal.C1048ac.AFDateFormat()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.String r4 = "activity_intent_null"
            r9[r3] = r4
            r8.AFDateFormat(r6, r7, r9)
            goto L_0x0060
        L_0x0053:
            com.appsflyer.internal.ac r3 = com.appsflyer.internal.C1048ac.AFDateFormat()
            java.lang.String r4 = "activity_null"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r3.AFDateFormat(r6, r7, r4)
        L_0x0060:
            java.lang.String r3 = $$b((android.app.Activity) r17)
            r1.params = r3
            if (r3 == 0) goto L_0x016d
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.getThreadPoolExecutor
            java.lang.String r7 = ")"
            if (r6 != 0) goto L_0x0081
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.getThreadPoolExecutor = r0
            r10 = r3
            goto L_0x012f
        L_0x0081:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r8 = r6.getLong(r8, r9)     // Catch:{ all -> 0x0114 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.getThreadPoolExecutor     // Catch:{ all -> 0x0114 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x0114 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0114 }
            r10 = r3
        L_0x0099:
            boolean r12 = r6.hasNext()     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x012f
            java.lang.Object r12 = r6.next()     // Catch:{ all -> 0x0112 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.lang.String r14 = r1.params     // Catch:{ all -> 0x0112 }
            r13.<init>(r14)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.getThreadPoolExecutor     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r15.get(r12)     // Catch:{ all -> 0x0112 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0112 }
            r14.<init>(r15)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r13.opt(r2)     // Catch:{ all -> 0x0112 }
            java.lang.Object r5 = r14.opt(r2)     // Catch:{ all -> 0x0112 }
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.Object r5 = r13.opt(r0)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r14.opt(r0)     // Catch:{ all -> 0x0112 }
            boolean r5 = r5.equals(r15)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r14)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r13)     // Catch:{ all -> 0x0112 }
            r0.append(r7)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0112 }
            r0 = 0
            r1.params = r0     // Catch:{ all -> 0x0112 }
            return
        L_0x00f5:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            long r13 = r3 - r13
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0104
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.getThreadPoolExecutor     // Catch:{ all -> 0x0112 }
            r5.remove(r12)     // Catch:{ all -> 0x0112 }
        L_0x0104:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x0110
            long r10 = r12.longValue()     // Catch:{ all -> 0x0112 }
        L_0x0110:
            r5 = 2
            goto L_0x0099
        L_0x0112:
            r0 = move-exception
            goto L_0x0116
        L_0x0114:
            r0 = move-exception
            r10 = r3
        L_0x0116:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error while handling push notification measurement: "
            r2.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x012f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r5 = 2
            int r0 = r0.getInt(r2, r5)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.getThreadPoolExecutor
            int r2 = r2.size()
            if (r2 != r0) goto L_0x015f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r10)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getThreadPoolExecutor
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r0.remove(r2)
        L_0x015f:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getThreadPoolExecutor
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r1.params
            r0.put(r2, r3)
            r16.start(r17)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    public void setUserEmails(String... strArr) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            if (C101310.values[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(HashUtils.toSha256(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    public void setCollectAndroidID(boolean z) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setCollectAndroidID", String.valueOf(z));
        setProperty(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        setProperty(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setCollectIMEI", String.valueOf(z));
        setProperty(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        setProperty(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectOaid(boolean z) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setCollectOaid", String.valueOf(z));
        setProperty(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.valueOf = strArr;
    }

    public void setOneLinkCustomDomain(String... strArr) {
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.AFDateFormat = strArr;
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context2) {
        if (this.AFExecutor) {
            return this;
        }
        this.AFExecutor = true;
        if (context2 != null) {
            eventDataCollector(context2).init();
            this.AFHelper = (Application) context2.getApplicationContext();
            final GoogleReferrer googleReferrer = new GoogleReferrer(new Runnable() {
                public final void run() {
                    try {
                        AFLogger.afDebugLog("Install Referrer collected locally");
                        AFEvent context = new Attr().context(AppsFlyerLibCore.this.AFHelper);
                        AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                        if (appsFlyerLibCore.$$a(context, AppsFlyerLibCore.getSharedPreferences(appsFlyerLibCore.AFHelper))) {
                            AppsFlyerLibCore.AFDateFormat(AppsFlyerLibCore.this, context);
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                }
            });
            C10153 r4 = new Runnable() {
                public final void run() {
                    SharedPreferences sharedPreferences = AppsFlyerLibCore.getSharedPreferences(AppsFlyerLibCore.this.AFHelper);
                    boolean z = false;
                    int launchCounter = AppsFlyerLibCore.this.getLaunchCounter(sharedPreferences, false);
                    boolean z2 = sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
                    if (googleReferrer.getState() == Referrer.State.NOT_STARTED) {
                        z = true;
                    }
                    if (launchCounter != 1) {
                        return;
                    }
                    if (z || z2) {
                        AppsFlyerLibCore.AFDateFormat(AppsFlyerLibCore.this, new Attr().context(AppsFlyerLibCore.this.AFHelper));
                    }
                }
            };
            Referrer[] referrerArr = {googleReferrer, new HuaweiReferrer(r4), new SamsungReferrer(r4)};
            this.AFInAppEventType = referrerArr;
            for (Referrer start : referrerArr) {
                start.start(this.AFHelper);
            }
            this.AFLogger = $$a(context2);
            Exlytics.setContext(this.AFHelper);
        } else {
            AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
        }
        C1048ac AFDateFormat2 = C1048ac.AFDateFormat();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        AFDateFormat2.AFDateFormat("public_api_call", "init", strArr);
        AFLogger.$$a(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.2.0", $$b}));
        setProperty(AppsFlyerProperties.AF_KEY, str);
        C1084w.$$b(str);
        conversionDataListener = appsFlyerConversionListener;
        return this;
    }

    public EventDataCollector eventDataCollector(Context context2) {
        if (this.eventDataCollector == null) {
            this.eventDataCollector = new EventDataCollector(context2);
        }
        return this.eventDataCollector;
    }

    private boolean $$a(Context context2) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.toMap = new ConcurrentHashMap();
            C10164 r4 = new C1062o.C1064a() {
                public final void values(String str, String str2) {
                    AppsFlyerLibCore.this.toMap.put("signedData", str);
                    AppsFlyerLibCore.this.toMap.put("signature", str2);
                    AppsFlyerLibCore.this.toMap.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                public final void $$b(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AppsFlyerLibCore.this.toMap.put("error", message);
                    AFLogger.afErrorLog(str, exc, true);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                C1062o.C10631 r7 = new InvocationHandler(r4) {
                    private /* synthetic */ C1064a values;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.o.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.o.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context2, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r7)});
            } catch (ClassNotFoundException e) {
                r4.$$b(e.getClass().getSimpleName(), e);
            } catch (NoSuchMethodException e2) {
                r4.$$b(e2.getClass().getSimpleName(), e2);
            } catch (IllegalAccessException e3) {
                r4.$$b(e3.getClass().getSimpleName(), e3);
            } catch (InvocationTargetException e4) {
                r4.$$b(e4.getClass().getSimpleName(), e4);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void enableFacebookDeferredApplinks(boolean z) {
        this.onAppLinkFetchFailed = z;
    }

    public void start(Context context2) {
        start(context2, (String) null);
    }

    public void start(Context context2, String str) {
        start(context2, str, (AppsFlyerRequestListener) null);
    }

    public void start(Context context2, String str, AppsFlyerRequestListener appsFlyerRequestListener) {
        final String str2 = str;
        final AppsFlyerRequestListener appsFlyerRequestListener2 = appsFlyerRequestListener;
        if (Foreground.listener == null) {
            if (!this.AFExecutor) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str2 == null) {
                    if (appsFlyerRequestListener2 != null) {
                        appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, RequestErrorMessage.NO_DEV_KEY);
                        return;
                    }
                    return;
                }
            }
            this.AFHelper = (Application) context2.getApplicationContext();
            C1048ac.AFDateFormat().AFDateFormat("public_api_call", TtmlNode.START, str2);
            String str3 = $$b;
            AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.2.0", str3}));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(str3);
            AFLogger.afInfoLog(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.AFHelper.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                setProperty(AppsFlyerProperties.AF_KEY, str2);
                C1084w.$$b(str);
            } else if (TextUtils.isEmpty(getProperty(AppsFlyerProperties.AF_KEY))) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener2 != null) {
                    appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, RequestErrorMessage.NO_DEV_KEY);
                    return;
                }
                return;
            }
            Context baseContext = this.AFHelper.getBaseContext();
            try {
                if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                    if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                        AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    } else {
                        AFLogger.AFDateFormat("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                    }
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
                sb2.append(e.toString());
                AFLogger.afRDLog(sb2.toString());
            }
            if (this.onAppLinkFetchFailed) {
                Context applicationContext = this.AFHelper.getApplicationContext();
                this.toList = new HashMap();
                final long currentTimeMillis = System.currentTimeMillis();
                C10121 r9 = new AFFacebookDeferredDeeplink.AppLinkFetchEvents() {
                    public final void onAppLinkFetchFinished(String str, String str2, String str3) {
                        if (str != null) {
                            AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(String.valueOf(str)));
                            AppsFlyerLibCore.this.toList.put("link", str);
                            if (str2 != null) {
                                AppsFlyerLibCore.this.toList.put("target_url", str2);
                            }
                            if (str3 != null) {
                                HashMap hashMap = new HashMap();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(ShareConstants.PROMO_CODE, str3);
                                hashMap.put(ShareConstants.DEEPLINK_CONTEXT, hashMap2);
                                AppsFlyerLibCore.this.toList.put("extras", hashMap);
                            }
                        } else {
                            AppsFlyerLibCore.this.toList.put("link", "");
                        }
                        AppsFlyerLibCore.this.toList.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }

                    public final void onAppLinkFetchFailed(String str) {
                        AppsFlyerLibCore.this.toList.put("error", str);
                    }
                };
                try {
                    Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{applicationContext});
                    Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                    Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                    Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
                    AFFacebookDeferredDeeplink.C10041 r13 = new InvocationHandler(cls, r9) {
                        private /* synthetic */ Class AFDateFormat;
                        private /* synthetic */ AppLinkFetchEvents values;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.AFFacebookDeferredDeeplink.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.AFFacebookDeferredDeeplink.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r13);
                    String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
                    if (TextUtils.isEmpty(string)) {
                        r9.onAppLinkFetchFailed("Facebook app id not defined in resources");
                    } else {
                        method.invoke((Object) null, new Object[]{applicationContext, string, newProxyInstance});
                    }
                } catch (NoSuchMethodException e2) {
                    r9.onAppLinkFetchFailed(e2.toString());
                } catch (InvocationTargetException e3) {
                    r9.onAppLinkFetchFailed(e3.toString());
                } catch (ClassNotFoundException e4) {
                    r9.onAppLinkFetchFailed(e4.toString());
                } catch (IllegalAccessException e5) {
                    r9.onAppLinkFetchFailed(e5.toString());
                }
            }
            Foreground.$$a(context2, new Foreground.Listener() {
                public final void onBecameForeground(Activity activity) {
                    long unused = AppsFlyerLibCore.this.key = System.currentTimeMillis();
                    AppsFlyerLibCore.this.eventDataCollector(activity).foreground();
                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                    if (appsFlyerLibCore.getLaunchCounter(appsFlyerLibCore.afInfoLog, false) == 0) {
                        try {
                            AppsFlyerLibCore.this.AFInAppEventParameterName.put(ServerParameters.INIT_TO_FG, AppsFlyerLibCore.this.key - AppsFlyerLibCore.this.eventDataCollector.getLong(ServerParameters.INIT_TS));
                        } catch (JSONException unused2) {
                        }
                    }
                    AFLogger.afInfoLog("onBecameForeground");
                    if (AppsFlyerLibCore.this.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(activity), false) < 2) {
                        AFSensorManager $$b2 = AFSensorManager.$$b((Context) activity);
                        $$b2.$$a.post($$b2.dateFormatUTC);
                        $$b2.$$a.post($$b2.values);
                    }
                    Launch launch = new Launch();
                    AFDeepLinkManager instance = AFDeepLinkManager.getInstance();
                    Map<String, Object> params = launch.params();
                    EventDataCollector eventDataCollector = AppsFlyerLibCore.this.eventDataCollector;
                    SharedPreferences sharedPreferences = AppsFlyerLibCore.getSharedPreferences(activity);
                    boolean z = sharedPreferences.getBoolean(AFDeepLinkManager.DDL_SENT, false);
                    int launchCounter = AppsFlyerLibCore.getInstance().getLaunchCounter(sharedPreferences, false);
                    if (!instance.$$b(activity.getIntent(), activity, params) && instance.deepLinkListener != null && launchCounter == 0 && !z) {
                        new DdlEvent(activity.getApplicationContext(), eventDataCollector).start();
                    }
                    AppsFlyerLibCore.this.$$a(launch.context(activity).key(str2).requestListener(appsFlyerRequestListener2), activity);
                }

                public final void onBecameBackground(Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    long unused = AppsFlyerLibCore.this.isEncrypt = System.currentTimeMillis();
                    long dataFormatter = AppsFlyerLibCore.this.isEncrypt - AppsFlyerLibCore.this.key;
                    if (dataFormatter > 0 && dataFormatter < 1000) {
                        dataFormatter = 1000;
                    }
                    AppsFlyerLibCore.this.eventDataCollector(context).set(ServerParameters.PREVIOUS_SESSION_DURATION, TimeUnit.MILLISECONDS.toSeconds(dataFormatter));
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AppsFlyerLibCore.this.$$b((WeakReference<Context>) new WeakReference(context));
                    C1048ac AFDateFormat = C1048ac.AFDateFormat();
                    if (AFDateFormat.collectIntentsFromActivities()) {
                        AFDateFormat.$$a();
                        if (context != null) {
                            C1048ac.values(context.getPackageName(), context.getPackageManager());
                        }
                        AFDateFormat.values();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFExecutor instance = AFExecutor.getInstance();
                    try {
                        AFExecutor.$$b(instance.values);
                        if (instance.$$b instanceof ThreadPoolExecutor) {
                            AFExecutor.$$b((ThreadPoolExecutor) instance.$$b);
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("failed to stop Executors", th);
                    }
                    AFSensorManager $$b2 = AFSensorManager.$$b(context);
                    $$b2.$$a.post($$b2.dateFormatUTC);
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void AFDateFormat(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = com.appsflyer.AndroidUtils.$$a()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00b9
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r1 = 1
            boolean r0 = values((java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "OS SDK is="
            r0.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r0.append(r2)
            java.lang.String r2 = "; use KeyStore"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r5)
            boolean r2 = r0.valueOf()
            if (r2 != 0) goto L_0x0056
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r5)
            java.lang.String r5 = com.appsflyer.Installation.m25id(r1)
            r0.$$b = r5
            r5 = 0
            r0.AFDateFormat = r5
            java.lang.String r5 = r0.values()
            r0.values(r5)
            goto L_0x009f
        L_0x0056:
            java.lang.String r5 = r0.values()
            java.lang.Object r2 = r0.$$a
            monitor-enter(r2)
            int r3 = r0.AFDateFormat     // Catch:{ all -> 0x00b6 }
            int r3 = r3 + r1
            r0.AFDateFormat = r3     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ all -> 0x00b6 }
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r1 = r0.$$a     // Catch:{ KeyStoreException -> 0x007c }
            monitor-enter(r1)     // Catch:{ KeyStoreException -> 0x007c }
            java.security.KeyStore r3 = r0.values     // Catch:{ all -> 0x0079 }
            r3.deleteEntry(r5)     // Catch:{ all -> 0x0079 }
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            goto L_0x0097
        L_0x0079:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ KeyStoreException -> 0x007c }
            throw r5     // Catch:{ KeyStoreException -> 0x007c }
        L_0x007c:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = "Exception "
            r1.<init>(r3)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = r5.getMessage()     // Catch:{ all -> 0x00b6 }
            r1.append(r3)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = " occurred"
            r1.append(r3)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b6 }
            com.appsflyer.AFLogger.afErrorLog(r1, r5)     // Catch:{ all -> 0x00b6 }
        L_0x0097:
            monitor-exit(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = r0.values()
            r0.values(r5)
        L_0x009f:
            java.lang.String r5 = "KSAppsFlyerId"
            java.lang.String r1 = r0.AFDateFormat()
            r4.setProperty(r5, r1)
            java.lang.String r5 = "KSAppsFlyerRICounter"
            int r0 = r0.$$a()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.setProperty(r5, r0)
            return
        L_0x00b6:
            r5 = move-exception
            monitor-exit(r2)
            throw r5
        L_0x00b9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r5.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r5.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afRDLog(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.AFDateFormat(android.content.Context):void");
    }

    public String getCustomerUserId() {
        return getProperty(AppsFlyerProperties.APP_USER_ID);
    }

    public void setCustomerUserId(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        setProperty(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setPhoneNumber(String str) {
        this.AFKeystoreWrapper = HashUtils.toSha256(str);
    }

    public void setAppId(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setAppId", str);
        setProperty(AppsFlyerProperties.APP_ID, str);
    }

    public void setExtension(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public void setIsUpdate(boolean z) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setCurrencyCode(String str) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void logLocation(Context context2, double d, double d2) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "logLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        $$b(context2, AFInAppEventType.LOCATION_COORDINATES, hashMap);
    }

    /* access modifiers changed from: package-private */
    public final void $$b(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences sharedPreferences = getSharedPreferences(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
            long j = this.isEncrypt - this.key;
            HashMap hashMap = new HashMap();
            String property = getProperty(AppsFlyerProperties.AF_KEY);
            if (property == null) {
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String property2 = getProperty("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean("deviceTrackingDisabled", false)) {
                hashMap.put("deviceTrackingDisabled", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            AdvertisingIdObject amazonAID = AdvertisingIdUtil.getAmazonAID(weakReference.get().getContentResolver());
            if (amazonAID != null) {
                hashMap.put(ServerParameters.AMAZON_AID, amazonAID.getAdvertisingId());
                hashMap.put(ServerParameters.AMAZON_AID_LIMIT, String.valueOf(amazonAID.isLimitAdTracking()));
            }
            String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
            if (string != null) {
                hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put(ServerParameters.DEV_KEY, property);
            hashMap.put(ServerParameters.AF_USER_ID, Installation.m25id(weakReference));
            hashMap.put(ServerParameters.TIME_SPENT_IN_APP, String.valueOf(j / 1000));
            hashMap.put(ServerParameters.STATUS_TYPE, "user_closed_app");
            hashMap.put(ServerParameters.PLATFORM, "Android");
            hashMap.put(ServerParameters.LAUNCH_COUNTER, Integer.toString(getLaunchCounter(sharedPreferences, false)));
            hashMap.put("channel", getConfiguredChannel(weakReference.get()));
            if (property2 == null) {
                property2 = "";
            }
            hashMap.put(ServerParameters.ORIGINAL_AF_UID, property2);
            if (this.onAppLinkFetchFinished) {
                try {
                    AFLogger.afDebugLog("Running callStats task");
                    new BackgroundHttpTask((BackgroundEvent) new Stats().trackingStopped(isStopped()).addParams(hashMap).urlString(ServerConfigHandler.getUrl(dateFormatUTC))).execute();
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Could not send callStats request", th);
                }
            } else {
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
            }
        }
    }

    public void logSession(Context context2) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "logSession", new String[0]);
        C1048ac.AFDateFormat().$$a = false;
        $$b(context2, (String) null, (Map<String, Object>) null);
    }

    public void logEvent(Context context2, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap;
        AFEvent context3 = new InAppEvent().context(context2);
        context3.values = str;
        Activity activity = null;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        context3.$$b = hashMap;
        AFEvent requestListener2 = context3.requestListener(appsFlyerRequestListener);
        C1048ac AFDateFormat2 = C1048ac.AFDateFormat();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject(requestListener2.$$b == null ? new HashMap() : requestListener2.$$b).toString();
        AFDateFormat2.AFDateFormat("public_api_call", "logEvent", strArr);
        if (str != null) {
            AFSensorManager $$b2 = AFSensorManager.$$b(context2);
            long currentTimeMillis = System.currentTimeMillis();
            if ($$b2.collectIntentsFromActivities != 0) {
                $$b2.getDataFormatter++;
                if ($$b2.collectIntentsFromActivities - currentTimeMillis < 500) {
                    $$b2.$$a.removeCallbacks($$b2.valueOf);
                    $$b2.$$a.post($$b2.values);
                }
            } else {
                $$b2.$$a.post($$b2.dateFormatUTC);
                $$b2.$$a.post($$b2.values);
            }
            $$b2.collectIntentsFromActivities = currentTimeMillis;
        }
        if (context2 instanceof Activity) {
            activity = (Activity) context2;
        }
        $$a(requestListener2, activity);
    }

    public void sendAdRevenue(Context context2, Map<String, Object> map) {
        AFEvent context3 = new AdRevenue().context(context2);
        context3.$$b = map;
        Application context4 = context3.context();
        String url = ServerConfigHandler.getUrl(AFDeepLinkManager);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(context4.getPackageName());
        String obj = sb.toString();
        SharedPreferences sharedPreferences = getSharedPreferences(context4);
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        int $$a2 = $$a(sharedPreferences, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put(ServerParameters.AD_REVENUE_PAYLOAD, context3.$$b);
        hashMap.put(ServerParameters.AD_REVENUE_COUNTER, Integer.valueOf($$a2));
        String property = getProperty(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", property);
        hashMap.put(ServerParameters.LAUNCH_COUNTER, Integer.valueOf(launchCounter));
        hashMap.put(ServerParameters.TIMESTAMP, Long.toString(new Date().getTime()));
        hashMap.put(ServerParameters.AF_USER_ID, Installation.m25id(new WeakReference(context4)));
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        hashMap.put(ServerParameters.ADVERTISING_ID_ENABLED_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_ENABLED_PARAM));
        if (string != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string);
        }
        hashMap.put(ServerParameters.DEVICE_KEY, Build.DEVICE);
        AFDateFormat((Context) context4, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = context4.getPackageManager().getPackageInfo(context4.getPackageName(), 0);
            hashMap.put(ServerParameters.APP_VERSION_CODE, Integer.toString(packageInfo.versionCode));
            SimpleDateFormat dataFormatter = AFDateFormat.getDataFormatter(INSTALL_UPDATE_DATE_FORMAT);
            hashMap.put("install_date", dateFormatUTC(dataFormatter, packageInfo.firstInstallTime));
            String string2 = sharedPreferences.getString("appsFlyerFirstInstall", (String) null);
            if (string2 == null) {
                string2 = $$a(dataFormatter, (Context) context4);
            }
            hashMap.put("first_launch_date", string2);
        } catch (Throwable th) {
            AFLogger.afErrorLog("AdRevenue - Exception while collecting app version data ", th);
        }
        AFEvent addParams2 = context3.urlString(obj).addParams(hashMap);
        addParams2.AFDeepLinkManager = launchCounter;
        $$b(AFExecutor.getInstance().valueOf(), new C1019b(this, addParams2.key(property), (byte) 0), 1, TimeUnit.MILLISECONDS);
    }

    public void logEvent(Context context2, String str, Map<String, Object> map) {
        logEvent(context2, str, map, (AppsFlyerRequestListener) null);
    }

    private void $$b(Context context2, String str, Map<String, Object> map) {
        AFEvent context3 = new InAppEvent().context(context2);
        context3.values = str;
        context3.$$b = map;
        $$a(context3, context2 instanceof Activity ? (Activity) context2 : null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r5 = com.appsflyer.internal.ActivityCompat.getReferrer(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void $$a(com.appsflyer.AFEvent r4, android.app.Activity r5) {
        /*
            r3 = this;
            android.app.Application r0 = r4.context()
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0013
            android.net.Uri r5 = com.appsflyer.internal.ActivityCompat.getReferrer(r5)
            if (r5 == 0) goto L_0x0013
            java.lang.String r5 = r5.toString()
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r3.getProperty(r2)
            if (r2 != 0) goto L_0x002f
            java.lang.String r5 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r5)
            com.appsflyer.attribution.AppsFlyerRequestListener r4 = r4.getRequestListener()
            if (r4 == 0) goto L_0x002e
            int r5 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.attribution.RequestErrorMessage.NO_DEV_KEY
            r4.onError(r5, r0)
        L_0x002e:
            return
        L_0x002f:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            r4.valueOf = r1
            r4.AFDateFormat = r5
            r3.values((com.appsflyer.AFEvent) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.$$a(com.appsflyer.AFEvent, android.app.Activity):void");
    }

    public void anonymizeUser(boolean z) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "anonymizeUser", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("deviceTrackingDisabled", z);
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> valueOf(Context context2) throws C1081u {
        String string = getSharedPreferences(context2).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return valueOf(string);
        }
        throw new C1081u();
    }

    public void registerConversionListener(Context context2, AppsFlyerConversionListener appsFlyerConversionListener) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            conversionDataListener = appsFlyerConversionListener;
        }
    }

    public void unregisterConversionListener() {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "unregisterConversionListener", new String[0]);
        conversionDataListener = null;
    }

    public void registerValidatorListener(Context context2, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            valueOf = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    public String dateFormatUTC(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(j));
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> valueOf(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!urlString.contains(next)) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return null;
        }
    }

    private boolean AFDateFormat() {
        if (this.requestListener > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.requestListener;
            SimpleDateFormat dataFormatter = AFDateFormat.getDataFormatter("yyyy/MM/dd HH:mm:ss.SSS Z");
            String dateFormatUTC2 = dateFormatUTC(dataFormatter, this.requestListener);
            String dateFormatUTC3 = dateFormatUTC(dataFormatter, this.getRequestListener);
            if (currentTimeMillis < this.AFEvent && !isStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{dateFormatUTC2, dateFormatUTC3, Long.valueOf(currentTimeMillis), Long.valueOf(this.AFEvent)}));
                return true;
            } else if (!isStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{dateFormatUTC2, dateFormatUTC3, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean $$a(AFEvent aFEvent, SharedPreferences sharedPreferences) {
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && launchCounter == 1) || (launchCounter == 1 && !(aFEvent instanceof Attr));
    }

    private boolean $$a() {
        Map<String, Object> map = this.toList;
        return map != null && !map.isEmpty();
    }

    private boolean $$b() {
        Map<String, Object> map = this.toMap;
        return map != null && !map.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0603, code lost:
        if (r10 != null) goto L_0x0605;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x020b */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0320 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0333 A[Catch:{ Exception -> 0x0339 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0376 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x037c A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03b1 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03c6 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0453 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0468 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0469 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x047d A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x048e A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0496 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x04af A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x04bd A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04c4 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x04d9 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x04ed A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x04fc A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0526 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0542 A[SYNTHETIC, Splitter:B:254:0x0542] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0561 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x057c A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x05d7 A[SYNTHETIC, Splitter:B:293:0x05d7] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x05e3 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x060a A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0620 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x063d A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0680 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0688 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x069e A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x06a9 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x06dc A[Catch:{ Exception -> 0x06e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0781 A[Catch:{ all -> 0x07d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x07fc A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0806 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x083b A[SYNTHETIC, Splitter:B:403:0x083b] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0883 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x08a5 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x08db A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x08dd A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x08ed  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0969 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x096b A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x09a6 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0a70 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0ad4 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x020f A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x021a A[SYNTHETIC, Splitter:B:81:0x021a] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0224 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0246 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0260 A[Catch:{ Exception -> 0x00b1, all -> 0x0ae7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> valueOf(com.appsflyer.AFEvent r32) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.lang.String r3 = "extraReferrers"
            java.lang.String r4 = "sdkExtension"
            java.lang.String r5 = "AppsFlyerTimePassedSincePrevLaunch"
            java.lang.String r6 = "yyyy-MM-dd_HHmmssZ"
            java.lang.String r7 = "use cached IMEI: "
            java.lang.String r8 = "appid"
            java.lang.String r9 = "INSTALL_STORE"
            java.lang.String r10 = "gcd"
            java.lang.String r11 = "prev_event_name"
            java.lang.String r12 = "preInstallName"
            android.app.Application r13 = r32.context()
            java.lang.String r14 = r32.key()
            java.lang.String r15 = r2.values
            r16 = r6
            org.json.JSONObject r6 = new org.json.JSONObject
            r17 = r7
            java.util.Map<java.lang.String, java.lang.Object> r7 = r2.$$b
            if (r7 != 0) goto L_0x0034
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            goto L_0x0036
        L_0x0034:
            java.util.Map<java.lang.String, java.lang.Object> r7 = r2.$$b
        L_0x0036:
            r6.<init>(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r2.valueOf
            r18 = r8
            android.content.SharedPreferences r8 = getSharedPreferences(r13)
            r19 = r14
            boolean r14 = r32.values()
            r20 = r12
            java.lang.String r12 = r2.AFDateFormat
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.params
            com.appsflyer.AdvertisingIdUtil.getGaid(r13, r2)
            java.util.Date r21 = new java.util.Date
            r21.<init>()
            r22 = r11
            r23 = r12
            long r11 = r21.getTime()
            r21 = r9
            java.lang.String r9 = java.lang.Long.toString(r11)
            r24 = r4
            java.lang.String r4 = "af_timestamp"
            r2.put(r4, r9)
            java.lang.String r4 = com.appsflyer.internal.C1040a.AFDateFormat(r13, r11)
            if (r4 == 0) goto L_0x0079
            java.lang.String r9 = "cksm_v1"
            r2.put(r9, r4)
        L_0x0079:
            boolean r9 = r31.isStopped()     // Catch:{ all -> 0x0ae7 }
            if (r9 != 0) goto L_0x0097
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ae7 }
            java.lang.String r11 = "******* sendTrackingWithEvent: "
            r9.<init>(r11)     // Catch:{ all -> 0x0ae7 }
            if (r14 == 0) goto L_0x008b
            java.lang.String r11 = "Launch"
            goto L_0x008c
        L_0x008b:
            r11 = r15
        L_0x008c:
            r9.append(r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afInfoLog(r9)     // Catch:{ all -> 0x0ae7 }
            goto L_0x009c
        L_0x0097:
            java.lang.String r9 = "Reporting has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r9)     // Catch:{ all -> 0x0ae7 }
        L_0x009c:
            com.appsflyer.internal.C1085x.values()     // Catch:{ all -> 0x0ae7 }
            java.io.File r9 = com.appsflyer.internal.C1085x.AFDateFormat(r13)     // Catch:{ Exception -> 0x00b1 }
            boolean r9 = r9.exists()     // Catch:{ Exception -> 0x00b1 }
            if (r9 != 0) goto L_0x00b8
            java.io.File r9 = com.appsflyer.internal.C1085x.AFDateFormat(r13)     // Catch:{ Exception -> 0x00b1 }
            r9.mkdir()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b8
        L_0x00b1:
            r0 = move-exception
            r9 = r0
            java.lang.String r11 = "Could not create cache directory"
            com.appsflyer.AFLogger.afErrorLog(r11, r9)     // Catch:{ all -> 0x0ae7 }
        L_0x00b8:
            android.content.pm.PackageManager r9 = r13.getPackageManager()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r11 = r13.getPackageName()     // Catch:{ Exception -> 0x00f4 }
            r12 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r11, r12)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String[] r9 = r9.requestedPermissions     // Catch:{ Exception -> 0x00f4 }
            java.util.List r9 = java.util.Arrays.asList(r9)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r11 = "android.permission.INTERNET"
            boolean r11 = r9.contains(r11)     // Catch:{ Exception -> 0x00f4 }
            if (r11 != 0) goto L_0x00d9
            java.lang.String r11 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r11)     // Catch:{ Exception -> 0x00f4 }
        L_0x00d9:
            java.lang.String r11 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r11 = r9.contains(r11)     // Catch:{ Exception -> 0x00f4 }
            if (r11 != 0) goto L_0x00e6
            java.lang.String r11 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r11)     // Catch:{ Exception -> 0x00f4 }
        L_0x00e6:
            java.lang.String r11 = "android.permission.ACCESS_WIFI_STATE"
            boolean r9 = r9.contains(r11)     // Catch:{ Exception -> 0x00f4 }
            if (r9 != 0) goto L_0x00fb
            java.lang.String r9 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00fb
        L_0x00f4:
            r0 = move-exception
            r9 = r0
            java.lang.String r11 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r11, r9)     // Catch:{ all -> 0x0ae7 }
        L_0x00fb:
            java.lang.String r9 = "af_events_api"
            java.lang.String r11 = "1"
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "brand"
            java.lang.String r11 = android.os.Build.BRAND     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "device"
            java.lang.String r11 = android.os.Build.DEVICE     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "product"
            java.lang.String r11 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "sdk"
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0ae7 }
            java.lang.String r11 = java.lang.Integer.toString(r11)     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "model"
            java.lang.String r11 = android.os.Build.MODEL     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "deviceType"
            java.lang.String r11 = android.os.Build.TYPE     // Catch:{ all -> 0x0ae7 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            AFDateFormat((android.content.Context) r13, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.internal.EventDataCollector r11 = r1.eventDataCollector(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r12 = "phone"
            r25 = r5
            if (r14 == 0) goto L_0x026d
            boolean r5 = r1.isAppsFlyerFirstLaunch(r13)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x0193
            boolean r5 = r9.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0ae7 }
            if (r5 != 0) goto L_0x015a
            float r5 = dateFormatUTC((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "batteryLevel"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x015a:
            r1.AFDateFormat((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0ae7 }
            r5 = 23
            if (r4 < r5) goto L_0x016c
            java.lang.Class<android.app.UiModeManager> r4 = android.app.UiModeManager.class
            java.lang.Object r4 = r13.getSystemService(r4)     // Catch:{ all -> 0x0ae7 }
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4     // Catch:{ all -> 0x0ae7 }
            goto L_0x0175
        L_0x016c:
            java.lang.String r4 = "uimode"
            java.lang.Object r4 = r13.getSystemService(r4)     // Catch:{ all -> 0x0ae7 }
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4     // Catch:{ all -> 0x0ae7 }
        L_0x0175:
            if (r4 == 0) goto L_0x0186
            int r4 = r4.getCurrentModeType()     // Catch:{ all -> 0x0ae7 }
            r5 = 4
            if (r4 != r5) goto L_0x0186
            java.lang.String r4 = "tv"
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0186:
            boolean r4 = com.appsflyer.internal.instant.AFInstantApps.isInstantApp(r13)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0193
            java.lang.String r4 = "inst_app"
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0193:
            java.lang.String r4 = "timepassedsincelastlaunch"
            android.content.SharedPreferences r5 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            r27 = r14
            r26 = r15
            r14 = 0
            r28 = r6
            r6 = r25
            long r29 = r5.getLong(r6, r14)     // Catch:{ all -> 0x0ae7 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0ae7 }
            r1.$$a((android.content.Context) r13, (java.lang.String) r6, (long) r14)     // Catch:{ all -> 0x0ae7 }
            r5 = 0
            int r22 = (r29 > r5 ? 1 : (r29 == r5 ? 0 : -1))
            if (r22 <= 0) goto L_0x01bc
            long r14 = r14 - r29
            r5 = 1000(0x3e8, double:4.94E-321)
            long r5 = r14 / r5
            goto L_0x01be
        L_0x01bc:
            r5 = -1
        L_0x01be:
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "oneLinkSlug"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "onelinkVersion"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x01e0
            java.lang.String r6 = "onelink_id"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x01e0:
            if (r5 == 0) goto L_0x01e7
            java.lang.String r4 = "onelink_ver"
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x01e7:
            com.appsflyer.internal.EventDataCollector r4 = r1.eventDataCollector     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = r4.getString(r10)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x020b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x020b }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x020b }
            java.util.Map r4 = com.appsflyer.AFHelper.toMap(r5)     // Catch:{ JSONException -> 0x020b }
            boolean r5 = r4.isEmpty()     // Catch:{ JSONException -> 0x020b }
            if (r5 != 0) goto L_0x020b
            java.util.Map r5 = getMetaFrom(r2)     // Catch:{ JSONException -> 0x020b }
            r5.put(r10, r4)     // Catch:{ JSONException -> 0x020b }
            com.appsflyer.internal.EventDataCollector r4 = r1.eventDataCollector     // Catch:{ JSONException -> 0x020b }
            r5 = 0
            r4.set((java.lang.String) r10, (java.lang.String) r5)     // Catch:{ JSONException -> 0x020b }
        L_0x020b:
            java.lang.String r4 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0212
            r2.put(r12, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0212:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "referrer"
            if (r4 != 0) goto L_0x021d
            r2.put(r5, r7)     // Catch:{ all -> 0x0ae7 }
        L_0x021d:
            r4 = 0
            java.lang.String r6 = r8.getString(r3, r4)     // Catch:{ all -> 0x0ae7 }
            if (r6 == 0) goto L_0x0227
            r2.put(r3, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x0227:
            java.lang.String r3 = r9.getReferrer(r13)     // Catch:{ all -> 0x0ae7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0ae7 }
            if (r4 != 0) goto L_0x023a
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x0ae7 }
            if (r4 != 0) goto L_0x023a
            r2.put(r5, r3)     // Catch:{ all -> 0x0ae7 }
        L_0x023a:
            java.lang.String r3 = "prev_session_dur"
            long r3 = r11.getLong(r3)     // Catch:{ all -> 0x0ae7 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x024f
            java.lang.String r5 = "prev_session_dur"
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0ae7 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0ae7 }
        L_0x024f:
            java.lang.String r3 = "exception_number"
            long r4 = com.appsflyer.internal.Exlytics.get()     // Catch:{ all -> 0x0ae7 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.internal.PartnerData r3 = r1.afErrorLog     // Catch:{ all -> 0x0ae7 }
            if (r3 == 0) goto L_0x0263
            r3.add(r2)     // Catch:{ all -> 0x0ae7 }
        L_0x0263:
            r22 = r11
            r25 = r12
            r3 = r26
            r5 = r28
            goto L_0x02f4
        L_0x026d:
            r28 = r6
            r27 = r14
            r26 = r15
            android.content.SharedPreferences r3 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ all -> 0x0ae7 }
            r5 = r22
            r6 = 0
            java.lang.String r7 = r3.getString(r5, r6)     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r6 = "prev_event_timestamp"
            java.lang.String r10 = "prev_event_value"
            if (r7 == 0) goto L_0x02c8
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x02bd }
            r14.<init>()     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r15.<init>()     // Catch:{ Exception -> 0x02bd }
            r22 = r11
            r25 = r12
            r11 = -1
            long r11 = r3.getLong(r6, r11)     // Catch:{ Exception -> 0x02bb }
            r15.append(r11)     // Catch:{ Exception -> 0x02bb }
            java.lang.String r11 = r15.toString()     // Catch:{ Exception -> 0x02bb }
            r14.put(r6, r11)     // Catch:{ Exception -> 0x02bb }
            r11 = 0
            java.lang.String r3 = r3.getString(r10, r11)     // Catch:{ Exception -> 0x02bb }
            r14.put(r10, r3)     // Catch:{ Exception -> 0x02bb }
            r14.put(r5, r7)     // Catch:{ Exception -> 0x02bb }
            java.lang.String r3 = "prev_event"
            java.lang.String r7 = r14.toString()     // Catch:{ Exception -> 0x02bb }
            r2.put(r3, r7)     // Catch:{ Exception -> 0x02bb }
            goto L_0x02cc
        L_0x02bb:
            r0 = move-exception
            goto L_0x02c2
        L_0x02bd:
            r0 = move-exception
            r22 = r11
            r25 = r12
        L_0x02c2:
            r4 = r0
            r3 = r26
            r5 = r28
            goto L_0x02ef
        L_0x02c8:
            r22 = r11
            r25 = r12
        L_0x02cc:
            r3 = r26
            r4.putString(r5, r3)     // Catch:{ Exception -> 0x02e3 }
            r5 = r28
            r4.putString(r10, r5)     // Catch:{ Exception -> 0x02e1 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02e1 }
            r4.putLong(r6, r10)     // Catch:{ Exception -> 0x02e1 }
            r4.apply()     // Catch:{ Exception -> 0x02e1 }
            goto L_0x02f4
        L_0x02e1:
            r0 = move-exception
            goto L_0x02ee
        L_0x02e3:
            r0 = move-exception
            goto L_0x02ec
        L_0x02e5:
            r0 = move-exception
            r22 = r11
            r25 = r12
            r3 = r26
        L_0x02ec:
            r5 = r28
        L_0x02ee:
            r4 = r0
        L_0x02ef:
            java.lang.String r6 = "Error while processing previous event."
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x02f4:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "KSAppsFlyerRICounter"
            java.lang.String r6 = r1.getProperty(r6)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0318
            if (r6 == 0) goto L_0x0318
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0ae7 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0ae7 }
            if (r7 <= 0) goto L_0x0318
            java.lang.String r7 = "reinstallCounter"
            r2.put(r7, r6)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "originalAppsflyerId"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0318:
            java.lang.String r4 = "additionalCustomData"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0325
            java.lang.String r6 = "customData"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0325:
            android.content.pm.PackageManager r4 = r13.getPackageManager()     // Catch:{ Exception -> 0x0339 }
            java.lang.String r6 = r13.getPackageName()     // Catch:{ Exception -> 0x0339 }
            java.lang.String r4 = r4.getInstallerPackageName(r6)     // Catch:{ Exception -> 0x0339 }
            if (r4 == 0) goto L_0x0340
            java.lang.String r6 = "installer_package"
            r2.put(r6, r4)     // Catch:{ Exception -> 0x0339 }
            goto L_0x0340
        L_0x0339:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0340:
            r4 = r24
            java.lang.String r6 = r9.getString(r4)     // Catch:{ all -> 0x0ae7 }
            if (r6 == 0) goto L_0x0351
            int r7 = r6.length()     // Catch:{ all -> 0x0ae7 }
            if (r7 <= 0) goto L_0x0351
            r2.put(r4, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x0351:
            java.lang.String r4 = r1.getConfiguredChannel(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = r1.AFDateFormat((android.content.Context) r13, (java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
            if (r6 == 0) goto L_0x0361
            boolean r7 = r6.equals(r4)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x0365
        L_0x0361:
            if (r6 != 0) goto L_0x036a
            if (r4 == 0) goto L_0x036a
        L_0x0365:
            java.lang.String r6 = "af_latestchannel"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x036a:
            android.content.SharedPreferences r4 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            r6 = r21
            boolean r7 = r4.contains(r6)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x037c
            r7 = 0
            java.lang.String r4 = r4.getString(r6, r7)     // Catch:{ all -> 0x0ae7 }
            goto L_0x03af
        L_0x037c:
            boolean r4 = r1.isAppsFlyerFirstLaunch(r13)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x03a0
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "api_store_value"
            java.lang.String r4 = r4.getString(r7)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x038f
            goto L_0x03a1
        L_0x038f:
            java.lang.String r4 = "AF_STORE"
            if (r13 == 0) goto L_0x03a0
            android.content.pm.PackageManager r7 = r13.getPackageManager()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r13.getPackageName()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = values(r4, r7, r10)     // Catch:{ all -> 0x0ae7 }
            goto L_0x03a1
        L_0x03a0:
            r4 = 0
        L_0x03a1:
            android.content.SharedPreferences r7 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ all -> 0x0ae7 }
            r7.putString(r6, r4)     // Catch:{ all -> 0x0ae7 }
            r7.apply()     // Catch:{ all -> 0x0ae7 }
        L_0x03af:
            if (r4 == 0) goto L_0x03ba
            java.lang.String r6 = "af_installstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x03ba:
            android.content.SharedPreferences r4 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            r6 = r20
            java.lang.String r7 = r1.getProperty(r6)     // Catch:{ all -> 0x0ae7 }
            if (r7 != 0) goto L_0x0451
            boolean r10 = r4.contains(r6)     // Catch:{ all -> 0x0ae7 }
            if (r10 == 0) goto L_0x03d4
            r7 = 0
            java.lang.String r4 = r4.getString(r6, r7)     // Catch:{ all -> 0x0ae7 }
            r7 = r4
            goto L_0x044c
        L_0x03d4:
            boolean r4 = r1.isAppsFlyerFirstLaunch(r13)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x043c
            java.lang.String r4 = "ro.appsflyer.preinstall.path"
            java.lang.String r4 = AFDateFormat((java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
            java.io.File r4 = values((java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
            boolean r7 = AFDateFormat((java.io.File) r4)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x03fc
            java.lang.String r4 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r7 = r13.getPackageManager()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r13.getPackageName()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = values(r4, r7, r10)     // Catch:{ all -> 0x0ae7 }
            java.io.File r4 = values((java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
        L_0x03fc:
            boolean r7 = AFDateFormat((java.io.File) r4)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x0408
            java.lang.String r4 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r4 = values((java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0408:
            boolean r7 = AFDateFormat((java.io.File) r4)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x0414
            java.lang.String r4 = "/etc/pre_install.appsflyer"
            java.io.File r4 = values((java.lang.String) r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0414:
            boolean r7 = AFDateFormat((java.io.File) r4)     // Catch:{ all -> 0x0ae7 }
            if (r7 != 0) goto L_0x0425
            java.lang.String r7 = r13.getPackageName()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = AFDateFormat((java.io.File) r4, (java.lang.String) r7)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0425
            goto L_0x0426
        L_0x0425:
            r4 = 0
        L_0x0426:
            if (r4 == 0) goto L_0x0429
            goto L_0x043b
        L_0x0429:
            java.lang.String r4 = "AF_PRE_INSTALL_NAME"
            if (r13 != 0) goto L_0x042f
            r4 = 0
            goto L_0x043b
        L_0x042f:
            android.content.pm.PackageManager r7 = r13.getPackageManager()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r13.getPackageName()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = values(r4, r7, r10)     // Catch:{ all -> 0x0ae7 }
        L_0x043b:
            r7 = r4
        L_0x043c:
            if (r7 == 0) goto L_0x044c
            android.content.SharedPreferences r4 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0ae7 }
            r4.putString(r6, r7)     // Catch:{ all -> 0x0ae7 }
            r4.apply()     // Catch:{ all -> 0x0ae7 }
        L_0x044c:
            if (r7 == 0) goto L_0x0451
            r1.setProperty(r6, r7)     // Catch:{ all -> 0x0ae7 }
        L_0x0451:
            if (r7 == 0) goto L_0x045c
            java.lang.String r4 = "af_preinstall_name"
            java.lang.String r6 = r7.toLowerCase()     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x045c:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "api_store_value"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0469
            goto L_0x047b
        L_0x0469:
            java.lang.String r4 = "AF_STORE"
            if (r13 != 0) goto L_0x046f
            r4 = 0
            goto L_0x047b
        L_0x046f:
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = r13.getPackageName()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = values(r4, r6, r7)     // Catch:{ all -> 0x0ae7 }
        L_0x047b:
            if (r4 == 0) goto L_0x0486
            java.lang.String r6 = "af_currentstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0486:
            if (r19 == 0) goto L_0x0496
            int r4 = r19.length()     // Catch:{ all -> 0x0ae7 }
            if (r4 <= 0) goto L_0x0496
            java.lang.String r4 = "appsflyerKey"
            r6 = r19
            r2.put(r4, r6)     // Catch:{ all -> 0x0ae7 }
            goto L_0x04a9
        L_0x0496:
            java.lang.String r4 = "AppsFlyerKey"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0adb
            int r6 = r4.length()     // Catch:{ all -> 0x0ae7 }
            if (r6 <= 0) goto L_0x0adb
            java.lang.String r6 = "appsflyerKey"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x04a9:
            java.lang.String r4 = r31.getCustomerUserId()     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x04b4
            java.lang.String r6 = "appUserId"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x04b4:
            java.lang.String r4 = "userEmails"
            java.lang.String r4 = r9.getString(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x04c4
            java.lang.String r6 = "user_emails"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
            goto L_0x04d7
        L_0x04c4:
            java.lang.String r4 = "userEmail"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x04d7
            java.lang.String r6 = "sha1_el"
            java.lang.String r4 = com.appsflyer.HashUtils.toSHA1(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x04d7:
            if (r3 == 0) goto L_0x04e5
            java.lang.String r4 = "eventName"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x04e5
            java.lang.String r4 = "eventValue"
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x04e5:
            r4 = r18
            java.lang.String r5 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x04f4
            java.lang.String r5 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x04f4:
            java.lang.String r4 = "currencyCode"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x051e
            int r5 = r4.length()     // Catch:{ all -> 0x0ae7 }
            r6 = 3
            if (r5 == r6) goto L_0x0519
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "WARNING: currency code should be 3 characters!!! '"
            r5.<init>(r6)     // Catch:{ all -> 0x0ae7 }
            r5.append(r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "' is not a legal value."
            r5.append(r6)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0519:
            java.lang.String r5 = "currency"
            r2.put(r5, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x051e:
            java.lang.String r4 = "IS_UPDATE"
            java.lang.String r4 = r1.getProperty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x052b
            java.lang.String r5 = "isUpdate"
            r2.put(r5, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x052b:
            boolean r4 = r1.isPreInstalledApp(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "af_preinstalled"
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "collectFacebookAttrId"
            r5 = 1
            boolean r4 = r9.getBoolean(r4, r5)     // Catch:{ all -> 0x0ae7 }
            r5 = 0
            if (r4 == 0) goto L_0x0566
            android.content.pm.PackageManager r4 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0559, all -> 0x0550 }
            java.lang.String r6 = "com.facebook.katana"
            r4.getApplicationInfo(r6, r5)     // Catch:{ NameNotFoundException -> 0x0559, all -> 0x0550 }
            java.lang.String r4 = r1.getAttributionId(r13)     // Catch:{ NameNotFoundException -> 0x0559, all -> 0x0550 }
            goto L_0x055f
        L_0x0550:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0557:
            r4 = 0
            goto L_0x055f
        L_0x0559:
            java.lang.String r4 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afWarnLog(r4)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0557
        L_0x055f:
            if (r4 == 0) goto L_0x0566
            java.lang.String r6 = "fb"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0566:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "deviceTrackingDisabled"
            boolean r6 = r4.getBoolean(r6, r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "true"
            if (r6 == 0) goto L_0x057c
            java.lang.String r4 = "deviceTrackingDisabled"
            r2.put(r4, r7)     // Catch:{ all -> 0x0ae7 }
            goto L_0x06d1
        L_0x057c:
            android.content.SharedPreferences r6 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "collectIMEI"
            r11 = 1
            boolean r10 = r4.getBoolean(r10, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r11 = "imeiCached"
            r12 = 0
            java.lang.String r11 = r6.getString(r11, r12)     // Catch:{ all -> 0x0ae7 }
            if (r10 == 0) goto L_0x0601
            java.lang.String r10 = r1.values     // Catch:{ all -> 0x0ae7 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0ae7 }
            if (r10 == 0) goto L_0x0601
            boolean r10 = $$b((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            if (r10 == 0) goto L_0x0607
            r10 = r25
            java.lang.Object r10 = r13.getSystemService(r10)     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.Class r12 = r10.getClass()     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.String r14 = "getDeviceId"
            java.lang.Class[] r15 = new java.lang.Class[r5]     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.reflect.Method r12 = r12.getMethod(r14, r15)     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.Object r10 = r12.invoke(r10, r14)     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            if (r10 == 0) goto L_0x05bd
            goto L_0x0605
        L_0x05bd:
            if (r11 == 0) goto L_0x0607
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ InvocationTargetException -> 0x05ea, Exception -> 0x05d1 }
            r12 = r17
            java.lang.String r10 = r12.concat(r10)     // Catch:{ InvocationTargetException -> 0x05cf, Exception -> 0x05cd }
            com.appsflyer.AFLogger.afDebugLog(r10)     // Catch:{ InvocationTargetException -> 0x05cf, Exception -> 0x05cd }
            goto L_0x0608
        L_0x05cd:
            r0 = move-exception
            goto L_0x05d4
        L_0x05cf:
            goto L_0x05ec
        L_0x05d1:
            r0 = move-exception
            r12 = r17
        L_0x05d4:
            r10 = r0
            if (r11 == 0) goto L_0x05e3
            java.lang.String r14 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r12 = r12.concat(r14)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afDebugLog(r12)     // Catch:{ all -> 0x0ae7 }
            goto L_0x05e4
        L_0x05e3:
            r11 = 0
        L_0x05e4:
            java.lang.String r12 = "WARNING: other reason: "
            com.appsflyer.AFLogger.afErrorLog(r12, r10)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0608
        L_0x05ea:
            r12 = r17
        L_0x05ec:
            if (r11 == 0) goto L_0x05fa
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r12.concat(r10)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afDebugLog(r10)     // Catch:{ all -> 0x0ae7 }
            goto L_0x05fb
        L_0x05fa:
            r11 = 0
        L_0x05fb:
            java.lang.String r10 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.afWarnLog(r10)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0608
        L_0x0601:
            java.lang.String r10 = r1.values     // Catch:{ all -> 0x0ae7 }
            if (r10 == 0) goto L_0x0607
        L_0x0605:
            r11 = r10
            goto L_0x0608
        L_0x0607:
            r11 = 0
        L_0x0608:
            if (r11 == 0) goto L_0x0620
            java.lang.String r10 = "imeiCached"
            android.content.SharedPreferences r12 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            android.content.SharedPreferences$Editor r12 = r12.edit()     // Catch:{ all -> 0x0ae7 }
            r12.putString(r10, r11)     // Catch:{ all -> 0x0ae7 }
            r12.apply()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "imei"
            r2.put(r10, r11)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0625
        L_0x0620:
            java.lang.String r10 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r10)     // Catch:{ all -> 0x0ae7 }
        L_0x0625:
            java.lang.String r10 = "collectAndroidId"
            r11 = 1
            boolean r4 = r4.getBoolean(r10, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "androidIdCached"
            r11 = 0
            java.lang.String r6 = r6.getString(r10, r11)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0680
            java.lang.String r4 = r1.$$a     // Catch:{ all -> 0x0ae7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0680
            boolean r4 = $$b((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0685
            android.content.ContentResolver r4 = r13.getContentResolver()     // Catch:{ Exception -> 0x0663 }
            java.lang.String r10 = "android_id"
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r10)     // Catch:{ Exception -> 0x0663 }
            if (r4 == 0) goto L_0x0650
            goto L_0x0686
        L_0x0650:
            if (r6 == 0) goto L_0x0661
            java.lang.String r4 = "use cached AndroidId: "
            java.lang.String r10 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0663 }
            java.lang.String r4 = r4.concat(r10)     // Catch:{ Exception -> 0x0663 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ Exception -> 0x0663 }
            goto L_0x067e
        L_0x0661:
            r6 = 0
            goto L_0x067e
        L_0x0663:
            r0 = move-exception
            r4 = r0
            if (r6 == 0) goto L_0x0676
            java.lang.String r10 = "use cached AndroidId: "
            java.lang.String r11 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r10.concat(r11)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afDebugLog(r10)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0677
        L_0x0676:
            r6 = 0
        L_0x0677:
            java.lang.String r10 = r4.getMessage()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afErrorLog(r10, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x067e:
            r4 = r6
            goto L_0x0686
        L_0x0680:
            java.lang.String r4 = r1.$$a     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0685
            goto L_0x0686
        L_0x0685:
            r4 = 0
        L_0x0686:
            if (r4 == 0) goto L_0x069e
            java.lang.String r6 = "androidIdCached"
            android.content.SharedPreferences r10 = getSharedPreferences(r13)     // Catch:{ all -> 0x0ae7 }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x0ae7 }
            r10.putString(r6, r4)     // Catch:{ all -> 0x0ae7 }
            r10.apply()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "android_id"
            r2.put(r6, r4)     // Catch:{ all -> 0x0ae7 }
            goto L_0x06a3
        L_0x069e:
            java.lang.String r4 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x0ae7 }
        L_0x06a3:
            com.appsflyer.AdvertisingIdObject r4 = com.appsflyer.AdvertisingIdUtil.getOaid(r13)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x06d1
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0ae7 }
            r6.<init>()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "isManual"
            java.lang.Boolean r11 = r4.isManual()     // Catch:{ all -> 0x0ae7 }
            r6.put(r10, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "val"
            java.lang.String r11 = r4.getAdvertisingId()     // Catch:{ all -> 0x0ae7 }
            r6.put(r10, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.Boolean r4 = r4.isLimitAdTracking()     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x06cc
            java.lang.String r10 = "isLat"
            r6.put(r10, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x06cc:
            java.lang.String r4 = "oaid"
            r2.put(r4, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x06d1:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x06e3 }
            r4.<init>(r13)     // Catch:{ Exception -> 0x06e3 }
            java.lang.String r4 = com.appsflyer.Installation.m25id(r4)     // Catch:{ Exception -> 0x06e3 }
            if (r4 == 0) goto L_0x06fa
            java.lang.String r6 = "uid"
            r2.put(r6, r4)     // Catch:{ Exception -> 0x06e3 }
            goto L_0x06fa
        L_0x06e3:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "ERROR: could not get uid "
            r6.<init>(r10)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = r4.getMessage()     // Catch:{ all -> 0x0ae7 }
            r6.append(r10)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x06fa:
            java.lang.String r4 = "lang"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0708 }
            java.lang.String r6 = r6.getDisplayLanguage()     // Catch:{ Exception -> 0x0708 }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x0708 }
            goto L_0x070f
        L_0x0708:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x070f:
            java.lang.String r4 = "lang_code"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x071d }
            java.lang.String r6 = r6.getLanguage()     // Catch:{ Exception -> 0x071d }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x071d }
            goto L_0x0724
        L_0x071d:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0724:
            java.lang.String r4 = "country"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0732 }
            java.lang.String r6 = r6.getCountry()     // Catch:{ Exception -> 0x0732 }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x0732 }
            goto L_0x0739
        L_0x0732:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r6, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0739:
            java.lang.String r4 = "platformextension"
            com.appsflyer.internal.aa r6 = r1.addChannel     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = r6.$$b()     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0ae7 }
            r1.addNetworkData(r13, r2)     // Catch:{ all -> 0x0ae7 }
            java.text.SimpleDateFormat r4 = com.appsflyer.AFDateFormat.getDataFormatter(r16)     // Catch:{ all -> 0x0ae7 }
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x0763 }
            java.lang.String r10 = r13.getPackageName()     // Catch:{ Exception -> 0x0763 }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r10, r5)     // Catch:{ Exception -> 0x0763 }
            long r10 = r6.firstInstallTime     // Catch:{ Exception -> 0x0763 }
            java.lang.String r6 = "installDate"
            java.lang.String r10 = r1.dateFormatUTC(r4, r10)     // Catch:{ Exception -> 0x0763 }
            r2.put(r6, r10)     // Catch:{ Exception -> 0x0763 }
            goto L_0x076a
        L_0x0763:
            r0 = move-exception
            r6 = r0
            java.lang.String r10 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r10, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x076a:
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ all -> 0x07d8 }
            java.lang.String r10 = r13.getPackageName()     // Catch:{ all -> 0x07d8 }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r10, r5)     // Catch:{ all -> 0x07d8 }
            java.lang.String r10 = "versionCode"
            int r10 = r8.getInt(r10, r5)     // Catch:{ all -> 0x07d8 }
            int r11 = r6.versionCode     // Catch:{ all -> 0x07d8 }
            if (r11 <= r10) goto L_0x0794
            java.lang.String r10 = "versionCode"
            int r11 = r6.versionCode     // Catch:{ all -> 0x07d8 }
            android.content.SharedPreferences r12 = getSharedPreferences(r13)     // Catch:{ all -> 0x07d8 }
            android.content.SharedPreferences$Editor r12 = r12.edit()     // Catch:{ all -> 0x07d8 }
            r12.putInt(r10, r11)     // Catch:{ all -> 0x07d8 }
            r12.apply()     // Catch:{ all -> 0x07d8 }
        L_0x0794:
            java.lang.String r10 = "app_version_code"
            int r11 = r6.versionCode     // Catch:{ all -> 0x07d8 }
            java.lang.String r11 = java.lang.Integer.toString(r11)     // Catch:{ all -> 0x07d8 }
            r2.put(r10, r11)     // Catch:{ all -> 0x07d8 }
            java.lang.String r10 = "app_version_name"
            java.lang.String r11 = r6.versionName     // Catch:{ all -> 0x07d8 }
            r2.put(r10, r11)     // Catch:{ all -> 0x07d8 }
            long r10 = r6.firstInstallTime     // Catch:{ all -> 0x07d8 }
            long r14 = r6.lastUpdateTime     // Catch:{ all -> 0x07d8 }
            java.lang.String r6 = "date1"
            java.text.SimpleDateFormat r12 = com.appsflyer.AFDateFormat.getDataFormatter(r16)     // Catch:{ all -> 0x07d8 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x07d8 }
            r5.<init>(r10)     // Catch:{ all -> 0x07d8 }
            java.lang.String r5 = r12.format(r5)     // Catch:{ all -> 0x07d8 }
            r2.put(r6, r5)     // Catch:{ all -> 0x07d8 }
            java.lang.String r5 = "date2"
            java.text.SimpleDateFormat r6 = com.appsflyer.AFDateFormat.getDataFormatter(r16)     // Catch:{ all -> 0x07d8 }
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x07d8 }
            r10.<init>(r14)     // Catch:{ all -> 0x07d8 }
            java.lang.String r6 = r6.format(r10)     // Catch:{ all -> 0x07d8 }
            r2.put(r5, r6)     // Catch:{ all -> 0x07d8 }
            java.lang.String r4 = r1.$$a((java.text.SimpleDateFormat) r4, (android.content.Context) r13)     // Catch:{ all -> 0x07d8 }
            java.lang.String r5 = "firstLaunchDate"
            r2.put(r5, r4)     // Catch:{ all -> 0x07d8 }
            goto L_0x07df
        L_0x07d8:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x07df:
            boolean r4 = com.appsflyer.internal.event.uninstall.Register.didConfiguredFirebaseMessagingServiceListener(r13)     // Catch:{ all -> 0x0ae7 }
            r1.AFFacebookDeferredDeeplink$AppLinkFetchEvents = r4     // Catch:{ all -> 0x0ae7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "didConfigureTokenRefreshService="
            r4.<init>(r5)     // Catch:{ all -> 0x0ae7 }
            boolean r5 = r1.AFFacebookDeferredDeeplink$AppLinkFetchEvents     // Catch:{ all -> 0x0ae7 }
            r4.append(r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x0ae7 }
            boolean r4 = r1.AFFacebookDeferredDeeplink$AppLinkFetchEvents     // Catch:{ all -> 0x0ae7 }
            if (r4 != 0) goto L_0x0804
            java.lang.String r4 = "tokenRefreshConfigured"
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0804:
            if (r27 == 0) goto L_0x0837
            java.lang.String r4 = r1.params     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x082d
            java.lang.String r4 = "af_deeplink"
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x0ae7 }
            if (r4 == 0) goto L_0x0818
            java.lang.String r4 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x0ae7 }
            goto L_0x082d
        L_0x0818:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = r1.params     // Catch:{ all -> 0x0ae7 }
            r4.<init>(r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "isPush"
            r4.put(r5, r7)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "af_deeplink"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0ae7 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x082d:
            r4 = 0
            r1.params = r4     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "open_referrer"
            r5 = r23
            r2.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0837:
            java.lang.String r4 = "sensors"
            if (r27 != 0) goto L_0x087b
            com.appsflyer.AFSensorManager r5 = com.appsflyer.AFSensorManager.$$b((android.content.Context) r13)     // Catch:{ Exception -> 0x0864 }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0864 }
            r6.<init>()     // Catch:{ Exception -> 0x0864 }
            java.util.List r5 = r5.valueOf()     // Catch:{ Exception -> 0x0864 }
            boolean r10 = r5.isEmpty()     // Catch:{ Exception -> 0x0864 }
            if (r10 != 0) goto L_0x085b
            com.appsflyer.internal.f r10 = new com.appsflyer.internal.f     // Catch:{ Exception -> 0x0864 }
            r10.<init>()     // Catch:{ Exception -> 0x0864 }
            java.util.Map r5 = r10.valueOf(r5)     // Catch:{ Exception -> 0x0864 }
            r6.put(r4, r5)     // Catch:{ Exception -> 0x0864 }
            goto L_0x0860
        L_0x085b:
            java.lang.String r5 = "na"
            r6.put(r4, r5)     // Catch:{ Exception -> 0x0864 }
        L_0x0860:
            r2.putAll(r6)     // Catch:{ Exception -> 0x0864 }
            goto L_0x087b
        L_0x0864:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ae7 }
            java.lang.String r10 = "Unexpected exception from AFSensorManager: "
            r6.<init>(r10)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0ae7 }
            r6.append(r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AFLogger.afRDLog(r5)     // Catch:{ all -> 0x0ae7 }
        L_0x087b:
            java.lang.String r5 = "advertiserId"
            java.lang.String r5 = r1.getProperty(r5)     // Catch:{ all -> 0x0ae7 }
            if (r5 != 0) goto L_0x089b
            com.appsflyer.AdvertisingIdUtil.getGaid(r13, r2)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "advertiserId"
            java.lang.String r5 = r1.getProperty(r5)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x0894
            java.lang.String r5 = "GAID_retry"
            r2.put(r5, r7)     // Catch:{ all -> 0x0ae7 }
            goto L_0x089b
        L_0x0894:
            java.lang.String r5 = "GAID_retry"
            java.lang.String r6 = "false"
            r2.put(r5, r6)     // Catch:{ all -> 0x0ae7 }
        L_0x089b:
            android.content.ContentResolver r5 = r13.getContentResolver()     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.AdvertisingIdObject r5 = com.appsflyer.AdvertisingIdUtil.getAmazonAID(r5)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x08bb
            java.lang.String r6 = "amazon_aid"
            java.lang.String r7 = r5.getAdvertisingId()     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r7)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "amazon_aid_limit"
            java.lang.Boolean r5 = r5.isLimitAdTracking()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x08bb:
            boolean r5 = com.appsflyer.internal.event.uninstall.Register.isSent(r8)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r6 = "registeredUninstall"
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0ae7 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0ae7 }
            r5 = r27
            int r6 = r1.getLaunchCounter(r8, r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "counter"
            java.lang.String r10 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0ae7 }
            r2.put(r7, r10)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "iaecounter"
            if (r3 == 0) goto L_0x08dd
            r3 = 1
            goto L_0x08de
        L_0x08dd:
            r3 = 0
        L_0x08de:
            java.lang.String r10 = "appsFlyerInAppEventCount"
            int r3 = $$a((android.content.SharedPreferences) r8, (java.lang.String) r10, (boolean) r3)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0ae7 }
            r2.put(r7, r3)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x095f
            java.lang.String r3 = "first_launch"
            r7 = 1
            if (r6 == r7) goto L_0x0915
            r7 = 2
            if (r6 == r7) goto L_0x08f6
            goto L_0x095f
        L_0x08f6:
            java.util.Map r7 = getMetaFrom(r2)     // Catch:{ all -> 0x0ae7 }
            r10 = r22
            java.lang.String r9 = r10.getString(r3)     // Catch:{ all -> 0x0ae7 }
            if (r9 == 0) goto L_0x0961
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x0ae7 }
            r11.<init>(r9)     // Catch:{ all -> 0x0ae7 }
            java.util.Map r9 = com.appsflyer.AFHelper.toMap(r11)     // Catch:{ all -> 0x0ae7 }
            boolean r11 = r9.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r11 != 0) goto L_0x0961
            r7.put(r3, r9)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0961
        L_0x0915:
            r10 = r22
            r9.setFirstLaunchCalled()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "waitForCustomerId"
            r9 = 0
            boolean r7 = values((java.lang.String) r7, (boolean) r9)     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x092f
            java.lang.String r7 = "wait_cid"
            r9 = 1
            java.lang.String r11 = java.lang.Boolean.toString(r9)     // Catch:{ all -> 0x0ae7 }
            r2.put(r7, r11)     // Catch:{ all -> 0x0ae7 }
        L_0x092f:
            java.util.Map r7 = getMetaFrom(r2)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "ddl"
            java.lang.String r9 = r10.getString(r9)     // Catch:{ all -> 0x0ae7 }
            if (r9 == 0) goto L_0x094f
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x0ae7 }
            r11.<init>(r9)     // Catch:{ all -> 0x0ae7 }
            java.util.Map r9 = com.appsflyer.AFHelper.toMap(r11)     // Catch:{ all -> 0x0ae7 }
            boolean r11 = r9.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r11 != 0) goto L_0x094f
            java.lang.String r11 = "ddl"
            r7.put(r11, r9)     // Catch:{ all -> 0x0ae7 }
        L_0x094f:
            org.json.JSONObject r9 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0ae7 }
            java.util.Map r9 = com.appsflyer.AFHelper.toMap(r9)     // Catch:{ all -> 0x0ae7 }
            boolean r11 = r9.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r11 != 0) goto L_0x0961
            r7.put(r3, r9)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0961
        L_0x095f:
            r10 = r22
        L_0x0961:
            java.lang.String r3 = "isFirstCall"
            boolean r7 = firstCallSent(r8)     // Catch:{ all -> 0x0ae7 }
            if (r7 != 0) goto L_0x096b
            r7 = 1
            goto L_0x096c
        L_0x096b:
            r7 = 0
        L_0x096c:
            java.lang.String r7 = java.lang.Boolean.toString(r7)     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r7)     // Catch:{ all -> 0x0ae7 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0ae7 }
            r3.<init>()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "cpu_abi"
            java.lang.String r9 = "ro.product.cpu.abi"
            java.lang.String r9 = AFDateFormat((java.lang.String) r9)     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r9)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "cpu_abi2"
            java.lang.String r9 = "ro.product.cpu.abi2"
            java.lang.String r9 = AFDateFormat((java.lang.String) r9)     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r9)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "arch"
            java.lang.String r9 = "os.arch"
            java.lang.String r9 = AFDateFormat((java.lang.String) r9)     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r9)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "build_display_id"
            java.lang.String r9 = "ro.build.display.id"
            java.lang.String r9 = AFDateFormat((java.lang.String) r9)     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r9)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x0a31
            boolean r5 = r1.addParams     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x09eb
            com.appsflyer.internal.q r5 = com.appsflyer.internal.C1068q.C1069d.valueOf     // Catch:{ all -> 0x0ae7 }
            android.location.Location r5 = r5.$$a(r13)     // Catch:{ all -> 0x0ae7 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0ae7 }
            r9 = 3
            r7.<init>(r9)     // Catch:{ all -> 0x0ae7 }
            if (r5 == 0) goto L_0x09e0
            java.lang.String r9 = "lat"
            double r11 = r5.getLatitude()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0ae7 }
            r7.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "lon"
            double r11 = r5.getLongitude()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0ae7 }
            r7.put(r9, r11)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = "ts"
            long r11 = r5.getTime()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0ae7 }
            r7.put(r9, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x09e0:
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r5 != 0) goto L_0x09eb
            java.lang.String r5 = "loc"
            r3.put(r5, r7)     // Catch:{ all -> 0x0ae7 }
        L_0x09eb:
            com.appsflyer.internal.d r5 = com.appsflyer.internal.C1054d.C1056e.AFDateFormat     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.internal.d$a r5 = r5.valueOf(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = "btl"
            float r9 = r5.values     // Catch:{ all -> 0x0ae7 }
            java.lang.String r9 = java.lang.Float.toString(r9)     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r9)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r7 = r5.AFDateFormat     // Catch:{ all -> 0x0ae7 }
            if (r7 == 0) goto L_0x0a07
            java.lang.String r7 = "btch"
            java.lang.String r5 = r5.AFDateFormat     // Catch:{ all -> 0x0ae7 }
            r3.put(r7, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0a07:
            r5 = 2
            if (r6 > r5) goto L_0x0a31
            com.appsflyer.AFSensorManager r5 = com.appsflyer.AFSensorManager.$$b((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0ae7 }
            r6.<init>()     // Catch:{ all -> 0x0ae7 }
            java.util.List r7 = r5.values()     // Catch:{ all -> 0x0ae7 }
            boolean r9 = r7.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r9 != 0) goto L_0x0a21
            r6.put(r4, r7)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0a2e
        L_0x0a21:
            java.util.List r5 = r5.valueOf()     // Catch:{ all -> 0x0ae7 }
            boolean r7 = r5.isEmpty()     // Catch:{ all -> 0x0ae7 }
            if (r7 != 0) goto L_0x0a2e
            r6.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
        L_0x0a2e:
            r3.putAll(r6)     // Catch:{ all -> 0x0ae7 }
        L_0x0a31:
            java.util.Map r4 = com.appsflyer.internal.C1078s.values(r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r5 = "dim"
            r3.put(r5, r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "deviceData"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.HashUtils r3 = new com.appsflyer.HashUtils     // Catch:{ all -> 0x0ae7 }
            r3.<init>()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = r3.getHashCode(r2)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "af_v"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            com.appsflyer.HashUtils r3 = new com.appsflyer.HashUtils     // Catch:{ all -> 0x0ae7 }
            r3.<init>()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = r3.getHashCodeV2(r2)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "af_v2"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            boolean r3 = collectIntentsFromActivities((android.content.Context) r13)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0ae7 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = "is_stop_tracking_used"
            boolean r3 = r8.contains(r3)     // Catch:{ all -> 0x0ae7 }
            if (r3 == 0) goto L_0x0a80
            java.lang.String r3 = "istu"
            java.lang.String r4 = "is_stop_tracking_used"
            r5 = 0
            boolean r4 = r8.getBoolean(r4, r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0ae7 }
        L_0x0a80:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0ae7 }
            r3.<init>()     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r13.getResources()     // Catch:{ all -> 0x0ae7 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0ae7 }
            int r5 = r5.mcc     // Catch:{ all -> 0x0ae7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ae7 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r13.getResources()     // Catch:{ all -> 0x0ae7 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0ae7 }
            int r5 = r5.mnc     // Catch:{ all -> 0x0ae7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ae7 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r4 = "cell"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = "sig"
            java.lang.String r4 = r10.signature()     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = "last_boot_time"
            long r4 = r10.bootTime()     // Catch:{ all -> 0x0ae7 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = "disk"
            java.lang.String r4 = r10.disk()     // Catch:{ all -> 0x0ae7 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0ae7 }
            java.lang.String[] r3 = r1.sharingFilter     // Catch:{ all -> 0x0ae7 }
            if (r3 == 0) goto L_0x0af1
            java.lang.String r4 = "sharing_filter"
            r2.put(r4, r3)     // Catch:{ all -> 0x0ae7 }
            goto L_0x0af1
        L_0x0adb:
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0ae7 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0ae7 }
            r2 = 0
            return r2
        L_0x0ae7:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = r3.getLocalizedMessage()
            r5 = 1
            com.appsflyer.AFLogger.afErrorLog(r4, r3, r5)
        L_0x0af1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.valueOf(com.appsflyer.AFEvent):java.util.Map");
    }

    public static Map<String, Object> getMetaFrom(Map<String, Object> map) {
        if (map.containsKey(ServerParameters.META)) {
            return (Map) map.get(ServerParameters.META);
        }
        HashMap hashMap = new HashMap();
        map.put(ServerParameters.META, hashMap);
        return hashMap;
    }

    public static boolean firstCallSent(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", (String) null));
    }

    private static void AFDateFormat(Context context2, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context2.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : TtmlNode.TAG_P);
        }
    }

    private static String $$b(Activity activity) {
        Intent intent;
        String str = null;
        if (!(activity == null || (intent = activity.getIntent()) == null)) {
            try {
                Bundle extras = intent.getExtras();
                if (!(extras == null || (str = extras.getString("af")) == null)) {
                    AFLogger.afInfoLog("Push Notification received af payload = ".concat(String.valueOf(str)));
                    extras.remove("af");
                    activity.setIntent(intent.putExtras(extras));
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context2, Map<String, Object> map, Uri uri) {
        String str;
        if (!map.containsKey(ServerParameters.DEEP_LINK)) {
            String obj = uri.toString();
            if (obj == null) {
                obj = null;
            } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
                int indexOf = obj.indexOf(63);
                if (indexOf == -1) {
                    str = "";
                } else {
                    str = obj.substring(indexOf);
                }
                if (str.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    if (str.contains("&")) {
                        arrayList = new ArrayList(Arrays.asList(str.split("&")));
                    } else {
                        arrayList.add(str);
                    }
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (str2.contains("access_token")) {
                            it.remove();
                        } else {
                            if (sb.length() != 0) {
                                sb.append("&");
                            } else if (!str2.startsWith("?")) {
                                sb.append("?");
                            }
                            sb.append(str2);
                        }
                    }
                    obj = obj.replace(str, sb.toString());
                }
            }
            AFDeepLinkManager instance2 = AFDeepLinkManager.getInstance();
            if (!(instance2.contains == null || instance2.parameters == null || !obj.contains(instance2.contains))) {
                Uri.Builder buildUpon = Uri.parse(obj).buildUpon();
                Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                for (Map.Entry next : instance2.parameters.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                obj = buildUpon.build().toString();
                map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
            }
            map.put(ServerParameters.DEEP_LINK, obj);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        C1082v vVar = new C1082v(uri, this);
        if (vVar.$$b) {
            map.put(ServerParameters.IS_BRANDED, Boolean.TRUE);
        }
        vVar.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        AndroidUtils.valueOf(context2, hashMap, uri);
        if (vVar.$$a()) {
            vVar.$$a = new C1082v.C1083d() {
                public final void $$b(String str) {
                    DeepLinkCallbacks.onDeepLinkingError(str);
                }

                public final void valueOf(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    DeepLinkCallbacks.onDeepLinkingSuccess(hashMap);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(vVar);
            return;
        }
        DeepLinkCallbacks.onDeepLinkingSuccess(hashMap);
    }

    private static boolean values(Context context2) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context2) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context2.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    private static boolean $$b(Context context2) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !values(context2)) {
            return true;
        }
        return false;
    }

    public boolean isAppsFlyerFirstLaunch(Context context2) {
        return !getSharedPreferences(context2).contains("appsFlyerCount");
    }

    private static String AFDateFormat(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    private static String values(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not find ");
            sb.append(str);
            sb.append(" value in the manifest");
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(Constants.URL_MEDIA_SOURCE, str);
            } catch (JSONException e) {
                AFLogger.afErrorLog(e.getMessage(), e);
            }
        }
        if (str2 != null) {
            jSONObject.put(Constants.URL_CAMPAIGN, str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(Constants.URL_MEDIA_SOURCE)) {
            setProperty("preInstallName", jSONObject.toString());
        } else {
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0028=Splitter:B:13:0x0028, B:22:0x003f=Splitter:B:22:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFDateFormat(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0059
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x0059
        L_0x003e:
            r2 = r0
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            return r0
        L_0x005a:
            r4 = move-exception
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.AFDateFormat(java.io.File, java.lang.String):java.lang.String");
    }

    private static boolean AFDateFormat(File file) {
        return file == null || !file.exists();
    }

    private static File values(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    public String getConfiguredChannel(Context context2) {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = context2 == null ? null : values("CHANNEL", context2.getPackageManager(), context2.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public boolean isPreInstalledApp(Context context2) {
        try {
            if ((context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e);
        }
    }

    /* access modifiers changed from: private */
    public String AFDateFormat(Context context2, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context2);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", (String) null);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    private String $$a(SimpleDateFormat simpleDateFormat, Context context2) {
        String str;
        String string = getSharedPreferences(context2).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            if (isAppsFlyerFirstLaunch(context2)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public String getAttributionId(Context context2) {
        try {
            return new C1086y(context2).AFDateFormat();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(Context context2) {
        if (getInstance().afInfoLog == null) {
            getInstance().afInfoLog = context2.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        }
        return getInstance().afInfoLog;
    }

    public final int getLaunchCounter(SharedPreferences sharedPreferences, boolean z) {
        return $$a(sharedPreferences, "appsFlyerCount", z);
    }

    private static int $$a(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
        if (C1048ac.AFDateFormat().collectIntentsFromActivities()) {
            C1048ac.AFDateFormat().$$a(String.valueOf(i));
        }
        return i;
    }

    public String getAppsFlyerUID(Context context2) {
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "getAppsFlyerUID", new String[0]);
        return Installation.m25id(new WeakReference(context2));
    }

    public void validateAndLogInAppPurchase(Context context2, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context3 = context2;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        C1048ac AFDateFormat2 = C1048ac.AFDateFormat();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        AFDateFormat2.AFDateFormat("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            sb.append(StringUtils.SPACE);
            sb.append(str7);
            sb.append(StringUtils.SPACE);
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = valueOf;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context2.getApplicationContext();
        String property = getProperty(AppsFlyerProperties.AF_KEY);
        if (context3 instanceof Activity) {
            ((Activity) context3).getIntent();
        }
        new Thread(new AFValidateInAppPurchase(applicationContext, property, str, str2, str3, str4, str5, map)).start();
    }

    /* access modifiers changed from: private */
    public static void $$b(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    public boolean isStopped() {
        return this.toJsonObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[SYNTHETIC, Splitter:B:29:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[Catch:{ all -> 0x003b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readServerResponse(java.net.HttpURLConnection r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r8.getErrorStream()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r8.getInputStream()     // Catch:{ all -> 0x0047 }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
            r2.<init>(r3)     // Catch:{ all -> 0x0045 }
            r1 = 0
        L_0x001b:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0034
            if (r1 == 0) goto L_0x002a
            r1 = 10
            java.lang.Character r1 = java.lang.Character.valueOf(r1)     // Catch:{ all -> 0x0040 }
            goto L_0x002c
        L_0x002a:
            java.lang.String r1 = ""
        L_0x002c:
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            r0.append(r4)     // Catch:{ all -> 0x0040 }
            r1 = 1
            goto L_0x001b
        L_0x0034:
            r2.close()     // Catch:{ all -> 0x003b }
            r3.close()     // Catch:{ all -> 0x003b }
            goto L_0x006c
        L_0x003b:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r8)
            goto L_0x006c
        L_0x0040:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0049
        L_0x0045:
            r2 = move-exception
            goto L_0x0049
        L_0x0047:
            r2 = move-exception
            r3 = r1
        L_0x0049:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x0090 }
            java.net.URL r8 = r8.getURL()     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0090 }
            r4.append(r8)     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0090 }
            com.appsflyer.AFLogger.afErrorLog(r8, r2)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ all -> 0x003b }
        L_0x0067:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ all -> 0x003b }
        L_0x006c:
            java.lang.String r8 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0076 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0076 }
            return r8
        L_0x0076:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x0086 }
            return r8
        L_0x0086:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r8 = r8.toString()
            return r8
        L_0x0090:
            r8 = move-exception
            if (r1 == 0) goto L_0x0099
            r1.close()     // Catch:{ all -> 0x0097 }
            goto L_0x0099
        L_0x0097:
            r0 = move-exception
            goto L_0x009f
        L_0x0099:
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ all -> 0x0097 }
            goto L_0x00a2
        L_0x009f:
            com.appsflyer.AFLogger.afErrorLog(r0)
        L_0x00a2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.readServerResponse(java.net.HttpURLConnection):java.lang.String");
    }

    private static float dateFormatUTC(Context context2) {
        try {
            Intent registerReceiver = context2.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return 1.0f;
        }
    }

    private static boolean collectIntentsFromActivities(Context context2) {
        if (context2 != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e);
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            }
        }
        return false;
    }

    public void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z = logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel();
        C1048ac.AFDateFormat().AFDateFormat("public_api_call", "log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            setProperty("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            setProperty("custom_host", str2);
        }
    }

    public String getHostName() {
        String property = getProperty("custom_host");
        return property != null ? property : ServerParameters.DEFAULT_HOST;
    }

    public String getHostPrefix() {
        String property = getProperty("custom_host_prefix");
        return property != null ? property : "";
    }

    public void setMinTimeBetweenSessions(int i) {
        this.AFEvent = TimeUnit.SECONDS.toMillis((long) i);
    }

    public Referrer[] getReferrers() {
        return this.AFInAppEventType;
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$c */
    class C1020c implements Runnable {
        private AFEvent $$a;

        /* synthetic */ C1020c(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1020c(AFEvent aFEvent) {
            this.$$a = aFEvent;
        }

        public final void run() {
            AppsFlyerLibCore.AFDateFormat(AppsFlyerLibCore.this, this.$$a);
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$b */
    class C1019b implements Runnable {
        private final AFEvent $$a;

        /* synthetic */ C1019b(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1019b(AFEvent aFEvent) {
            this.$$a = aFEvent;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte[]} */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x022d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x022e, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0240, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0241, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x024e, code lost:
            r0.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r2.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0160, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0161, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0, true);
            r2 = r1.$$a.getRequestListener();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x016e, code lost:
            if (r2 != null) goto L_0x0170;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0170, code lost:
            r2.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x017a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x017b, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a1, code lost:
            r3.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a6, code lost:
            r3 = r3.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01aa, code lost:
            if (r3 == null) goto L_0x01b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b1, code lost:
            com.appsflyer.AFLogger.afInfoLog("reached cache limit, not caching request");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b8, code lost:
            com.appsflyer.AFLogger.afInfoLog("caching request...");
            r3 = new java.io.File(com.appsflyer.internal.C1085x.AFDateFormat(r5), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r3.createNewFile();
            r5 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r3.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r5.write("version=");
            r5.write(r0.$$b);
            r5.write(10);
            r5.write("url=");
            r5.write(r0.values);
            r5.write(10);
            r5.write("data=");
            r5.write(android.util.Base64.encodeToString(r0.$$a(), 2));
            r5.write(10);
            r5.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0217, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0218, code lost:
            r2 = r0;
            r4 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x021b, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x021c, code lost:
            r4 = r5;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0229 A[SYNTHETIC, Splitter:B:100:0x0229] */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x023c A[SYNTHETIC, Splitter:B:106:0x023c] */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x024e  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0160 A[ExcHandler: all (r0v24 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:32:0x00ec] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01a1 A[Catch:{ Exception -> 0x0221 }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a6 A[Catch:{ Exception -> 0x0221 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r17 = this;
                r1 = r17
                com.appsflyer.AFEvent r0 = r1.$$a
                java.util.Map r2 = r0.params()
                com.appsflyer.AFEvent r0 = r1.$$a
                boolean r0 = r0.values()
                com.appsflyer.AFEvent r3 = r1.$$a
                java.lang.String r3 = r3.urlString()
                com.appsflyer.AFEvent r4 = r1.$$a
                int r4 = r4.AFDeepLinkManager
                com.appsflyer.AFEvent r5 = r1.$$a
                android.app.Application r5 = r5.context()
                com.appsflyer.AppsFlyerLibCore r6 = com.appsflyer.AppsFlyerLibCore.this
                boolean r6 = r6.isStopped()
                if (r6 == 0) goto L_0x0036
                com.appsflyer.AFEvent r0 = r1.$$a
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.getRequestListener()
                if (r0 == 0) goto L_0x0035
                int r2 = com.appsflyer.attribution.RequestError.STOP_TRACKING
                java.lang.String r3 = com.appsflyer.internal.attribution.RequestErrorMessage.STOP_TRACKING
                r0.onError(r2, r3)
            L_0x0035:
                return
            L_0x0036:
                r6 = 0
                byte[] r7 = new byte[r6]
                r8 = 2
                r9 = 1
                if (r0 == 0) goto L_0x00d4
                if (r4 > r8) goto L_0x00d4
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.appsflyer.AppsFlyerLibCore r10 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.Referrer[] r10 = r10.AFInAppEventType
                if (r10 == 0) goto L_0x00b6
                com.appsflyer.AppsFlyerLibCore r10 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.Referrer[] r10 = r10.AFInAppEventType
                int r11 = r10.length
                r12 = 0
            L_0x0054:
                if (r12 >= r11) goto L_0x00b6
                r13 = r10[r12]
                boolean r14 = r13 instanceof com.appsflyer.internal.referrer.GoogleReferrer
                int[] r15 = com.appsflyer.AppsFlyerLibCore.C101310.$$a
                com.appsflyer.internal.referrer.Referrer$State r16 = r13.getState()
                int r16 = r16.ordinal()
                r15 = r15[r16]
                if (r15 == r9) goto L_0x0091
                if (r15 == r8) goto L_0x006b
                goto L_0x00b3
            L_0x006b:
                if (r4 != r8) goto L_0x00b3
                if (r14 != 0) goto L_0x00b3
                java.util.HashMap r14 = new java.util.HashMap
                r14.<init>()
                java.lang.String r15 = "source"
                java.lang.String r13 = r13.getSource()
                r14.put(r15, r13)
                java.lang.String r13 = "response"
                java.lang.String r15 = "TIMEOUT"
                r14.put(r13, r15)
                com.appsflyer.internal.referrer.MandatoryFields r13 = new com.appsflyer.internal.referrer.MandatoryFields
                r13.<init>()
                r14.putAll(r13)
                r0.add(r14)
                goto L_0x00b3
            L_0x0091:
                if (r14 == 0) goto L_0x00ae
                java.lang.String r14 = "rfr"
                r15 = r13
                com.appsflyer.internal.referrer.GoogleReferrer r15 = (com.appsflyer.internal.referrer.GoogleReferrer) r15
                java.util.Map<java.lang.String, java.lang.Object> r15 = r15.oldMap
                r2.put(r14, r15)
                android.content.SharedPreferences r14 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r5)
                android.content.SharedPreferences$Editor r14 = r14.edit()
                java.lang.String r15 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r14 = r14.putBoolean(r15, r9)
                r14.apply()
            L_0x00ae:
                java.util.Map<java.lang.String, java.lang.Object> r13 = r13.map
                r0.add(r13)
            L_0x00b3:
                int r12 = r12 + 1
                goto L_0x0054
            L_0x00b6:
                boolean r4 = r0.isEmpty()
                if (r4 != 0) goto L_0x00c1
                java.lang.String r4 = "referrers"
                r2.put(r4, r0)
            L_0x00c1:
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r0 = r0.toList
                if (r0 == 0) goto L_0x00d4
                java.lang.String r0 = "fb_ddl"
                com.appsflyer.AppsFlyerLibCore r4 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r4 = r4.toList
                r2.put(r0, r4)
            L_0x00d4:
                com.appsflyer.AFEvent r0 = r1.$$a
                boolean r0 = r0 instanceof com.appsflyer.internal.model.event.AdRevenue
                if (r0 != 0) goto L_0x00eb
                com.appsflyer.internal.a$a r0 = new com.appsflyer.internal.a$a
                r0.<init>(r2, r5)
                r2.putAll(r0)
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r0 = r0.valueOf()
                r2.putAll(r0)
            L_0x00eb:
                r4 = 0
                com.appsflyer.AFEvent r0 = r1.$$a     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                boolean r10 = r0 instanceof com.appsflyer.internal.model.event.AdRevenue     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                if (r10 == 0) goto L_0x00fb
                java.lang.String r10 = "af_key"
                java.lang.Object r10 = r2.get(r10)     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                goto L_0x0103
            L_0x00fb:
                java.lang.String r10 = "appsflyerKey"
                java.lang.Object r10 = r2.get(r10)     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
            L_0x0103:
                r0.key(r10)     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                monitor-enter(r2)     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                com.appsflyer.AFEvent r0 = r1.$$a     // Catch:{ all -> 0x015d }
                java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x0154 }
                r10[r6] = r0     // Catch:{ all -> 0x0154 }
                int r0 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch:{ all -> 0x0154 }
                int r0 = r0 >> 8
                int r0 = r0 + 29583
                char r0 = (char) r0     // Catch:{ all -> 0x0154 }
                long r11 = android.view.ViewConfiguration.getZoomControlsTimeout()     // Catch:{ all -> 0x0154 }
                r13 = 0
                int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                int r15 = r15 + 23
                int r11 = android.graphics.Color.argb(r6, r6, r6, r6)     // Catch:{ all -> 0x0154 }
                int r11 = 48 - r11
                java.lang.Object r0 = com.appsflyer.internal.C1053b.$$b(r0, r15, r11)     // Catch:{ all -> 0x0154 }
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0154 }
                java.lang.String r11 = "values"
                java.lang.Class[] r12 = new java.lang.Class[r9]     // Catch:{ all -> 0x0154 }
                java.lang.Class<com.appsflyer.AFEvent> r13 = com.appsflyer.AFEvent.class
                r12[r6] = r13     // Catch:{ all -> 0x0154 }
                java.lang.reflect.Method r0 = r0.getMethod(r11, r12)     // Catch:{ all -> 0x0154 }
                java.lang.Object r0 = r0.invoke(r4, r10)     // Catch:{ all -> 0x0154 }
                r6 = r0
                byte[] r6 = (byte[]) r6     // Catch:{ all -> 0x0154 }
                monitor-exit(r2)     // Catch:{ all -> 0x0151 }
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this     // Catch:{ IOException -> 0x014d, all -> 0x0160 }
                com.appsflyer.AFEvent r2 = r1.$$a     // Catch:{ IOException -> 0x014d, all -> 0x0160 }
                com.appsflyer.AFEvent r2 = r2.post(r6)     // Catch:{ IOException -> 0x014d, all -> 0x0160 }
                com.appsflyer.AppsFlyerLibCore.values((com.appsflyer.AppsFlyerLibCore) r0, (com.appsflyer.AFEvent) r2)     // Catch:{ IOException -> 0x014d, all -> 0x0160 }
                return
            L_0x014d:
                r0 = move-exception
                r2 = r0
                r7 = r6
                goto L_0x017c
            L_0x0151:
                r0 = move-exception
                r7 = r6
                goto L_0x015e
            L_0x0154:
                r0 = move-exception
                java.lang.Throwable r6 = r0.getCause()     // Catch:{ all -> 0x015d }
                if (r6 == 0) goto L_0x015c
                throw r6     // Catch:{ all -> 0x015d }
            L_0x015c:
                throw r0     // Catch:{ all -> 0x015d }
            L_0x015d:
                r0 = move-exception
            L_0x015e:
                monitor-exit(r2)     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
                throw r0     // Catch:{ IOException -> 0x017a, all -> 0x0160 }
            L_0x0160:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r2, r0, r9)
                com.appsflyer.AFEvent r2 = r1.$$a
                com.appsflyer.attribution.AppsFlyerRequestListener r2 = r2.getRequestListener()
                if (r2 == 0) goto L_0x0179
                int r3 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r0 = r0.getMessage()
                r2.onError(r3, r0)
            L_0x0179:
                return
            L_0x017a:
                r0 = move-exception
                r2 = r0
            L_0x017c:
                java.lang.String r0 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.afErrorLog(r0, r2)
                if (r7 == 0) goto L_0x0246
                if (r5 == 0) goto L_0x0246
                java.lang.String r0 = "&isCachedRequest=true&timeincache="
                boolean r0 = r3.contains(r0)
                if (r0 != 0) goto L_0x0246
                com.appsflyer.internal.C1085x.values()
                com.appsflyer.internal.a$a$a r0 = new com.appsflyer.internal.a$a$a
                java.lang.String r6 = "6.2.0"
                r0.<init>(r3, r7, r6)
                java.io.File r3 = com.appsflyer.internal.C1085x.AFDateFormat(r5)     // Catch:{ Exception -> 0x0221 }
                boolean r6 = r3.exists()     // Catch:{ Exception -> 0x0221 }
                if (r6 != 0) goto L_0x01a6
                r3.mkdir()     // Catch:{ Exception -> 0x0221 }
                goto L_0x0232
            L_0x01a6:
                java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x0221 }
                if (r3 == 0) goto L_0x01b8
                int r3 = r3.length     // Catch:{ Exception -> 0x0221 }
                r6 = 40
                if (r3 <= r6) goto L_0x01b8
                java.lang.String r0 = "reached cache limit, not caching request"
                com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Exception -> 0x0221 }
                goto L_0x0232
            L_0x01b8:
                java.lang.String r3 = "caching request..."
                com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Exception -> 0x0221 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0221 }
                java.io.File r5 = com.appsflyer.internal.C1085x.AFDateFormat(r5)     // Catch:{ Exception -> 0x0221 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0221 }
                java.lang.String r6 = java.lang.Long.toString(r6)     // Catch:{ Exception -> 0x0221 }
                r3.<init>(r5, r6)     // Catch:{ Exception -> 0x0221 }
                r3.createNewFile()     // Catch:{ Exception -> 0x0221 }
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0221 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0221 }
                java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x0221 }
                r6.<init>(r3, r9)     // Catch:{ Exception -> 0x0221 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0221 }
                java.lang.String r3 = "version="
                r5.write(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                java.lang.String r3 = r0.$$b     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.write(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r3 = 10
                r5.write(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                java.lang.String r4 = "url="
                r5.write(r4)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                java.lang.String r4 = r0.values     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.write(r4)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.write(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                java.lang.String r4 = "data="
                r5.write(r4)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                byte[] r0 = r0.$$a()     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                java.lang.String r0 = android.util.Base64.encodeToString(r0, r8)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.write(r0)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.write(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.flush()     // Catch:{ Exception -> 0x021b, all -> 0x0217 }
                r5.close()     // Catch:{ IOException -> 0x022d }
                goto L_0x0232
            L_0x0217:
                r0 = move-exception
                r2 = r0
                r4 = r5
                goto L_0x023a
            L_0x021b:
                r0 = move-exception
                r4 = r5
                goto L_0x0222
            L_0x021e:
                r0 = move-exception
                r2 = r0
                goto L_0x023a
            L_0x0221:
                r0 = move-exception
            L_0x0222:
                java.lang.String r3 = "Could not cache request"
                com.appsflyer.AFLogger.afErrorLog(r3, r0)     // Catch:{ all -> 0x021e }
                if (r4 == 0) goto L_0x0232
                r4.close()     // Catch:{ IOException -> 0x022d }
                goto L_0x0232
            L_0x022d:
                r0 = move-exception
                r3 = r0
                com.appsflyer.AFLogger.afErrorLog(r3)
            L_0x0232:
                java.lang.String r0 = r2.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r0, r2)
                goto L_0x0246
            L_0x023a:
                if (r4 == 0) goto L_0x0245
                r4.close()     // Catch:{ IOException -> 0x0240 }
                goto L_0x0245
            L_0x0240:
                r0 = move-exception
                r3 = r0
                com.appsflyer.AFLogger.afErrorLog(r3)
            L_0x0245:
                throw r2
            L_0x0246:
                com.appsflyer.AFEvent r0 = r1.$$a
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.getRequestListener()
                if (r0 == 0) goto L_0x0257
                int r3 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r4 = r2.getMessage()
                r0.onError(r3, r4)
            L_0x0257:
                java.lang.String r0 = r2.getMessage()
                com.appsflyer.AppsFlyerLibCore.InstallAttributionIdFetcher.$$b((java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C1019b.run():void");
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$10 */
    static /* synthetic */ class C101310 {
        static final /* synthetic */ int[] $$a;
        static final /* synthetic */ int[] values;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.appsflyer.internal.referrer.Referrer$State[] r0 = com.appsflyer.internal.referrer.Referrer.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $$a = r0
                r1 = 1
                com.appsflyer.internal.referrer.Referrer$State r2 = com.appsflyer.internal.referrer.Referrer.State.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $$a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.referrer.Referrer$State r3 = com.appsflyer.internal.referrer.Referrer.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                values = r2
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r3 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = values     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C101310.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        if ($$b()) {
            hashMap.put("lvl", this.toMap);
        } else if (this.AFLogger) {
            HashMap hashMap2 = new HashMap();
            this.toMap = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.toMap);
        }
        return hashMap;
    }

    public static void setUrl(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getValue();
            String str2 = (String) next.getKey();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1407250527:
                    if (str2.equals("launches")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1184318185:
                    if (str2.equals("inapps")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1084269027:
                    if (str2.equals("conversions")) {
                        c = 0;
                        break;
                    }
                    break;
                case -690213213:
                    if (str2.equals("register")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3004913:
                    if (str2.equals("attr")) {
                        c = 1;
                        break;
                    }
                    break;
                case 57793177:
                    if (str2.equals("adrevenue")) {
                        c = 6;
                        break;
                    }
                    break;
                case 109757599:
                    if (str2.equals("stats")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    FIRST_LAUNCHES_URL = str;
                    break;
                case 1:
                    REFERRER_TRACKING_URL = str;
                    break;
                case 2:
                    getInstance = str;
                    break;
                case 3:
                    collectIntentsFromActivities = str;
                    break;
                case 4:
                    Register.URL = str;
                    break;
                case 5:
                    dateFormatUTC = str;
                    break;
                case 6:
                    AFDeepLinkManager = str;
                    break;
            }
        }
    }

    public static class InstallAttributionIdFetcher implements Runnable {
        public static String CONVERSION_DATA_URL = "https://%sgcdsdk.%s/install_data/v4.0/";
        private static final List<String> values = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
        final ScheduledExecutorService $$a;
        private final String $$b;
        final AppsFlyerLibCore AFDateFormat;
        private final int getDataFormatter;
        private final AtomicInteger getInstance;
        private final Application valueOf;

        /* synthetic */ InstallAttributionIdFetcher(AppsFlyerLibCore appsFlyerLibCore, Application application, String str, byte b) {
            this(appsFlyerLibCore, application, str);
        }

        private InstallAttributionIdFetcher(AppsFlyerLibCore appsFlyerLibCore, Application application, String str) {
            this.$$a = AFExecutor.getInstance().valueOf();
            this.getInstance = new AtomicInteger(0);
            this.AFDateFormat = appsFlyerLibCore;
            this.valueOf = application;
            this.$$b = str;
            this.getDataFormatter = 0;
        }

        private InstallAttributionIdFetcher(InstallAttributionIdFetcher installAttributionIdFetcher) {
            this.$$a = AFExecutor.getInstance().valueOf();
            this.getInstance = new AtomicInteger(0);
            this.AFDateFormat = installAttributionIdFetcher.AFDateFormat;
            this.valueOf = installAttributionIdFetcher.valueOf;
            this.$$b = installAttributionIdFetcher.$$b;
            this.getDataFormatter = installAttributionIdFetcher.getDataFormatter + 1;
        }

        public static void setUrl(Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                if ("gcdsdk".equals(next.getKey())) {
                    CONVERSION_DATA_URL = (String) next.getValue();
                }
            }
        }

        /* access modifiers changed from: private */
        public static void $$b(String str) {
            if (AppsFlyerLibCore.conversionDataListener != null) {
                AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                AppsFlyerLibCore.conversionDataListener.onConversionDataFail(str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x010e A[Catch:{ u -> 0x0247, all -> 0x0272 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0172 A[Catch:{ u -> 0x0247, all -> 0x0272 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x026e  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x027a A[Catch:{ all -> 0x02aa }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0287 A[Catch:{ all -> 0x02aa }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x029c A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                java.lang.String r0 = "is_first_launch"
                java.lang.String r1 = "af_siteid"
                java.lang.String r2 = r15.$$b
                if (r2 == 0) goto L_0x02b6
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0010
                goto L_0x02b6
            L_0x0010:
                com.appsflyer.AppsFlyerLibCore r2 = r15.AFDateFormat
                boolean r2 = r2.isStopped()
                if (r2 == 0) goto L_0x0023
                java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
                com.appsflyer.AFLogger.afDebugLog(r0)
                java.lang.String r0 = "'isStopTracking' enabled"
                $$b((java.lang.String) r0)
                return
            L_0x0023:
                java.util.concurrent.atomic.AtomicInteger r2 = r15.getInstance
                r2.incrementAndGet()
                r2 = 0
                r3 = 2
                android.app.Application r4 = r15.valueOf     // Catch:{ all -> 0x0275 }
                if (r4 != 0) goto L_0x003e
                java.lang.String r0 = "[GCD-E06] Context null"
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0275 }
                java.lang.String r0 = "Context null"
                $$b((java.lang.String) r0)     // Catch:{ all -> 0x0275 }
                java.util.concurrent.atomic.AtomicInteger r0 = r15.getInstance
                r0.decrementAndGet()
                return
            L_0x003e:
                com.appsflyer.AppsFlyerLibCore r5 = r15.AFDateFormat     // Catch:{ all -> 0x0275 }
                java.lang.String r6 = r5.getConfiguredChannel(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = r5.AFDateFormat((android.content.Context) r4, (java.lang.String) r6)     // Catch:{ all -> 0x0275 }
                java.lang.String r5 = ""
                r6 = 0
                r7 = 1
                if (r4 == 0) goto L_0x0072
                java.util.List<java.lang.String> r8 = values     // Catch:{ all -> 0x0275 }
                java.lang.String r9 = r4.toLowerCase()     // Catch:{ all -> 0x0275 }
                boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x0275 }
                if (r8 != 0) goto L_0x0065
                java.lang.String r8 = "-"
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = r8.concat(r4)     // Catch:{ all -> 0x0275 }
                goto L_0x0073
            L_0x0065:
                java.lang.String r8 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x0275 }
                r9[r6] = r4     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = java.lang.String.format(r8, r9)     // Catch:{ all -> 0x0275 }
                com.appsflyer.AFLogger.afWarnLog(r4)     // Catch:{ all -> 0x0275 }
            L_0x0072:
                r4 = r5
            L_0x0073:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0275 }
                r8.<init>()     // Catch:{ all -> 0x0275 }
                java.lang.String r9 = CONVERSION_DATA_URL     // Catch:{ all -> 0x0275 }
                java.lang.String r9 = com.appsflyer.ServerConfigHandler.getUrl(r9)     // Catch:{ all -> 0x0275 }
                r8.append(r9)     // Catch:{ all -> 0x0275 }
                android.app.Application r9 = r15.valueOf     // Catch:{ all -> 0x0275 }
                java.lang.String r9 = r9.getPackageName()     // Catch:{ all -> 0x0275 }
                r8.append(r9)     // Catch:{ all -> 0x0275 }
                r8.append(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = "?devkey="
                r8.append(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = r15.$$b     // Catch:{ all -> 0x0275 }
                r8.append(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = "&device_id="
                r8.append(r4)     // Catch:{ all -> 0x0275 }
                java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0275 }
                android.app.Application r9 = r15.valueOf     // Catch:{ all -> 0x0275 }
                r4.<init>(r9)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = com.appsflyer.Installation.m25id(r4)     // Catch:{ all -> 0x0275 }
                r8.append(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0275 }
                com.appsflyer.internal.ac r8 = com.appsflyer.internal.C1048ac.AFDateFormat()     // Catch:{ all -> 0x0275 }
                java.lang.String r9 = "server_request"
                java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0275 }
                r8.AFDateFormat(r9, r4, r5)     // Catch:{ all -> 0x0275 }
                java.lang.String r5 = "[GCD-B01] URL: "
                java.lang.String r8 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0275 }
                java.lang.String r5 = r5.concat(r8)     // Catch:{ all -> 0x0275 }
                com.appsflyer.internal.C1084w.valueOf(r5)     // Catch:{ all -> 0x0275 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0275 }
                java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x0275 }
                r5.<init>(r4)     // Catch:{ all -> 0x0275 }
                java.net.URLConnection r5 = r5.openConnection()     // Catch:{ all -> 0x0275 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x0275 }
                java.lang.String r2 = "GET"
                r5.setRequestMethod(r2)     // Catch:{ all -> 0x0272 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r5.setConnectTimeout(r2)     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = "Connection"
                java.lang.String r10 = "close"
                r5.setRequestProperty(r2, r10)     // Catch:{ all -> 0x0272 }
                r5.connect()     // Catch:{ all -> 0x0272 }
                int r2 = r5.getResponseCode()     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerLibCore r10 = r15.AFDateFormat     // Catch:{ all -> 0x0272 }
                java.lang.String r10 = r10.readServerResponse(r5)     // Catch:{ all -> 0x0272 }
                com.appsflyer.internal.ac r11 = com.appsflyer.internal.C1048ac.AFDateFormat()     // Catch:{ all -> 0x0272 }
                java.lang.String r12 = "server_response"
                java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ all -> 0x0272 }
                java.lang.String r14 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0272 }
                r13[r6] = r14     // Catch:{ all -> 0x0272 }
                r13[r7] = r10     // Catch:{ all -> 0x0272 }
                r11.AFDateFormat(r12, r4, r13)     // Catch:{ all -> 0x0272 }
                r4 = 200(0xc8, float:2.8E-43)
                r11 = 404(0x194, float:5.66E-43)
                if (r2 == r4) goto L_0x013a
                if (r2 != r11) goto L_0x0111
                goto L_0x013a
            L_0x0111:
                r0 = 403(0x193, float:5.65E-43)
                if (r2 == r0) goto L_0x0119
                r0 = 500(0x1f4, float:7.0E-43)
                if (r2 < r0) goto L_0x012b
            L_0x0119:
                int r0 = r15.getDataFormatter     // Catch:{ all -> 0x0272 }
                if (r0 >= r3) goto L_0x012b
                com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher r0 = new com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher     // Catch:{ all -> 0x0272 }
                r0.<init>(r15)     // Catch:{ all -> 0x0272 }
                java.util.concurrent.ScheduledExecutorService r1 = r0.$$a     // Catch:{ all -> 0x0272 }
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerLibCore.$$b(r1, r0, 10, r2)     // Catch:{ all -> 0x0272 }
                goto L_0x0267
            L_0x012b:
                java.lang.String r0 = "Error connection to server: "
                java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0272 }
                java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0272 }
                $$b((java.lang.String) r0)     // Catch:{ all -> 0x0272 }
                goto L_0x0267
            L_0x013a:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0272 }
                r4.<init>()     // Catch:{ all -> 0x0272 }
                java.lang.String r12 = "net"
                long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0272 }
                long r13 = r13 - r8
                r4.put(r12, r13)     // Catch:{ all -> 0x0272 }
                java.lang.String r8 = "retries"
                int r9 = r15.getDataFormatter     // Catch:{ all -> 0x0272 }
                r4.put(r8, r9)     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerLibCore r8 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0272 }
                com.appsflyer.internal.EventDataCollector r8 = r8.eventDataCollector     // Catch:{ all -> 0x0272 }
                java.lang.String r9 = "gcd"
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0272 }
                r8.set((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x0272 }
                java.lang.String r4 = "Attribution data: "
                java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0272 }
                java.lang.String r4 = r4.concat(r8)     // Catch:{ all -> 0x0272 }
                com.appsflyer.internal.C1084w.valueOf(r4)     // Catch:{ all -> 0x0272 }
                int r4 = r10.length()     // Catch:{ all -> 0x0272 }
                if (r4 <= 0) goto L_0x0267
                java.util.Map r4 = com.appsflyer.AppsFlyerLibCore.valueOf((java.lang.String) r10)     // Catch:{ all -> 0x0272 }
                java.lang.String r8 = "iscache"
                java.lang.Object r8 = r4.get(r8)     // Catch:{ all -> 0x0272 }
                java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0272 }
                if (r2 != r11) goto L_0x0199
                java.lang.String r2 = "error_reason"
                r4.remove(r2)     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = "status_code"
                r4.remove(r2)     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = "af_status"
                java.lang.String r9 = "Organic"
                r4.put(r2, r9)     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = "af_message"
                java.lang.String r9 = "organic install"
                r4.put(r2, r9)     // Catch:{ all -> 0x0272 }
            L_0x0199:
                if (r8 == 0) goto L_0x01ae
                boolean r2 = r8.booleanValue()     // Catch:{ all -> 0x0272 }
                if (r2 != 0) goto L_0x01ae
                com.appsflyer.AppsFlyerLibCore r2 = r15.AFDateFormat     // Catch:{ all -> 0x0272 }
                android.app.Application r8 = r15.valueOf     // Catch:{ all -> 0x0272 }
                java.lang.String r9 = "appsflyerConversionDataCacheExpiration"
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0272 }
                r2.$$a((android.content.Context) r8, (java.lang.String) r9, (long) r11)     // Catch:{ all -> 0x0272 }
            L_0x01ae:
                boolean r2 = r4.containsKey(r1)     // Catch:{ all -> 0x0272 }
                java.lang.String r8 = "[Invite] Detected App-Invite via channel: "
                java.lang.String r9 = "af_channel"
                if (r2 == 0) goto L_0x01e3
                boolean r2 = r4.containsKey(r9)     // Catch:{ all -> 0x0272 }
                if (r2 == 0) goto L_0x01d2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0272 }
                r2.<init>(r8)     // Catch:{ all -> 0x0272 }
                java.lang.Object r11 = r4.get(r9)     // Catch:{ all -> 0x0272 }
                r2.append(r11)     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0272 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0272 }
                goto L_0x01e3
            L_0x01d2:
                java.lang.String r2 = "[CrossPromotion] App was installed via %s's Cross Promotion"
                java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ all -> 0x0272 }
                java.lang.Object r12 = r4.get(r1)     // Catch:{ all -> 0x0272 }
                r11[r6] = r12     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = java.lang.String.format(r2, r11)     // Catch:{ all -> 0x0272 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0272 }
            L_0x01e3:
                boolean r1 = r4.containsKey(r1)     // Catch:{ all -> 0x0272 }
                if (r1 == 0) goto L_0x01fc
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0272 }
                r1.<init>(r8)     // Catch:{ all -> 0x0272 }
                java.lang.Object r2 = r4.get(r9)     // Catch:{ all -> 0x0272 }
                r1.append(r2)     // Catch:{ all -> 0x0272 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0272 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0272 }
            L_0x01fc:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0272 }
                r4.put(r0, r1)     // Catch:{ all -> 0x0272 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0272 }
                r1.<init>(r4)     // Catch:{ all -> 0x0272 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0272 }
                java.lang.String r2 = "attributionId"
                if (r1 == 0) goto L_0x0216
                com.appsflyer.AppsFlyerLibCore r8 = r15.AFDateFormat     // Catch:{ all -> 0x0272 }
                android.app.Application r9 = r15.valueOf     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerLibCore.AFDateFormat((com.appsflyer.AppsFlyerLibCore) r8, (android.content.Context) r9, (java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0272 }
                goto L_0x021d
            L_0x0216:
                com.appsflyer.AppsFlyerLibCore r1 = r15.AFDateFormat     // Catch:{ all -> 0x0272 }
                android.app.Application r8 = r15.valueOf     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerLibCore.AFDateFormat((com.appsflyer.AppsFlyerLibCore) r1, (android.content.Context) r8, (java.lang.String) r2, (java.lang.String) r10)     // Catch:{ all -> 0x0272 }
            L_0x021d:
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.conversionDataListener     // Catch:{ all -> 0x0272 }
                if (r1 == 0) goto L_0x0267
                java.util.concurrent.atomic.AtomicInteger r1 = r15.getInstance     // Catch:{ all -> 0x0272 }
                int r1 = r1.intValue()     // Catch:{ all -> 0x0272 }
                if (r1 > r7) goto L_0x0267
                com.appsflyer.AppsFlyerLibCore r1 = r15.AFDateFormat     // Catch:{ u -> 0x0247 }
                android.app.Application r2 = r15.valueOf     // Catch:{ u -> 0x0247 }
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.valueOf((android.content.Context) r2)     // Catch:{ u -> 0x0247 }
                android.app.Application r2 = r15.valueOf     // Catch:{ u -> 0x0247 }
                android.content.SharedPreferences r2 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r2)     // Catch:{ u -> 0x0247 }
                java.lang.String r7 = "sixtyDayConversionData"
                boolean r2 = r2.getBoolean(r7, r6)     // Catch:{ u -> 0x0247 }
                if (r2 != 0) goto L_0x0245
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ u -> 0x0247 }
                r1.put(r0, r2)     // Catch:{ u -> 0x0247 }
            L_0x0245:
                r4 = r1
                goto L_0x024d
            L_0x0247:
                r0 = move-exception
                java.lang.String r1 = "Exception while trying to fetch attribution data. "
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x0272 }
            L_0x024d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0272 }
                java.lang.String r1 = "[GCD-A02] Calling onConversionDataSuccess with:\n"
                r0.<init>(r1)     // Catch:{ all -> 0x0272 }
                java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0272 }
                r0.append(r1)     // Catch:{ all -> 0x0272 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0272 }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0272 }
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.conversionDataListener     // Catch:{ all -> 0x0272 }
                r0.onConversionDataSuccess(r4)     // Catch:{ all -> 0x0272 }
            L_0x0267:
                java.util.concurrent.atomic.AtomicInteger r0 = r15.getInstance
                r0.decrementAndGet()
                if (r5 == 0) goto L_0x029f
                r5.disconnect()
                goto L_0x029f
            L_0x0272:
                r0 = move-exception
                r2 = r5
                goto L_0x0276
            L_0x0275:
                r0 = move-exception
            L_0x0276:
                int r1 = r15.getDataFormatter     // Catch:{ all -> 0x02aa }
                if (r1 >= r3) goto L_0x0287
                com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher r1 = new com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher     // Catch:{ all -> 0x02aa }
                r1.<init>(r15)     // Catch:{ all -> 0x02aa }
                java.util.concurrent.ScheduledExecutorService r3 = r1.$$a     // Catch:{ all -> 0x02aa }
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x02aa }
                com.appsflyer.AppsFlyerLibCore.$$b(r3, r1, 10, r4)     // Catch:{ all -> 0x02aa }
                goto L_0x028e
            L_0x0287:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x02aa }
                $$b((java.lang.String) r1)     // Catch:{ all -> 0x02aa }
            L_0x028e:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x02aa }
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x02aa }
                java.util.concurrent.atomic.AtomicInteger r0 = r15.getInstance
                r0.decrementAndGet()
                if (r2 == 0) goto L_0x029f
                r2.disconnect()
            L_0x029f:
                java.util.concurrent.ScheduledExecutorService r0 = r15.$$a
                r0.shutdown()
                java.lang.String r0 = "[GCD-A03] Server retrieving attempt finished"
                com.appsflyer.AFLogger.afDebugLog(r0)
                return
            L_0x02aa:
                r0 = move-exception
                java.util.concurrent.atomic.AtomicInteger r1 = r15.getInstance
                r1.decrementAndGet()
                if (r2 == 0) goto L_0x02b5
                r2.disconnect()
            L_0x02b5:
                throw r0
            L_0x02b6:
                java.lang.String r0 = "[GCD-E05] AppsFlyer dev key is missing"
                com.appsflyer.AFLogger.afDebugLog(r0)
                java.lang.String r0 = "AppsFlyer dev key is missing"
                $$b((java.lang.String) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.InstallAttributionIdFetcher.run():void");
        }

        static /* synthetic */ void $$b(Map map) {
            StringBuilder sb = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
            sb.append(map.toString());
            AFLogger.afDebugLog(sb.toString());
            AppsFlyerLibCore.conversionDataListener.onConversionDataSuccess(map);
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$e */
    class C1021e implements Runnable {
        private final Application $$a;

        public C1021e(Context context) {
            this.$$a = (Application) context.getApplicationContext();
        }

        public final void run() {
            if (!AppsFlyerLibCore.this.context) {
                AppsFlyerLibCore.this.AFDateFormat = System.currentTimeMillis();
                boolean unused = AppsFlyerLibCore.this.context = true;
                try {
                    String property = AppsFlyerLibCore.this.getProperty(AppsFlyerProperties.AF_KEY);
                    C1085x.values();
                    for (C1040a.C1041a.C1042a next : C1085x.$$b(this.$$a)) {
                        StringBuilder sb = new StringBuilder("resending request: ");
                        sb.append(next.values);
                        AFLogger.afInfoLog(sb.toString());
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            long parseLong = Long.parseLong(next.AFDateFormat, 10);
                            AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                            CachedEvent cachedEvent = new CachedEvent();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(next.values);
                            sb2.append("&isCachedRequest=true&timeincache=");
                            sb2.append((currentTimeMillis - parseLong) / 1000);
                            AFEvent context = cachedEvent.urlString(sb2.toString()).post(next.$$a()).key(property).context(this.$$a);
                            context.$$a = next.AFDateFormat;
                            context.dateFormatUTC = false;
                            AppsFlyerLibCore.values(appsFlyerLibCore, context);
                        } catch (Exception e) {
                            AFLogger.afErrorLog("Failed to resend cached request", e);
                        }
                    }
                } catch (Exception e2) {
                    AFLogger.afErrorLog("failed to check cache. ", e2);
                } catch (Throwable th) {
                    boolean unused2 = AppsFlyerLibCore.this.context = false;
                    throw th;
                }
                boolean unused3 = AppsFlyerLibCore.this.context = false;
                AppsFlyerLibCore.this.post.shutdown();
                ScheduledExecutorService unused4 = AppsFlyerLibCore.this.post = null;
            }
        }
    }

    private void values(AFEvent aFEvent) {
        boolean z = aFEvent.values == null;
        if (waitingForId()) {
            AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (AFDateFormat()) {
                AppsFlyerRequestListener requestListener2 = aFEvent.getRequestListener();
                if (requestListener2 != null) {
                    requestListener2.onError(RequestError.EVENT_TIMEOUT, RequestErrorMessage.EVENT_TIMEOUT);
                    return;
                }
                return;
            }
            this.requestListener = System.currentTimeMillis();
        }
        $$b(AFExecutor.getInstance().valueOf(), new C1020c(this, aFEvent, (byte) 0), 0, TimeUnit.MILLISECONDS);
    }

    public void addNetworkData(Context context2, Map<String, ? super String> map) {
        C1065p pVar = C1065p.C1067e.$$b;
        C1065p.C1066b values2 = C1065p.values(context2);
        map.put(ServerParameters.NETWORK, values2.AFDateFormat);
        if (values2.values != null) {
            map.put(ServerParameters.OPERATOR, values2.values);
        }
        if (values2.valueOf != null) {
            map.put(ServerParameters.CARRIER, values2.valueOf);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:36|37|38|39|40|41|(2:43|44)|45|46|(4:(1:50)|(1:52)|(1:54)(2:55|(2:57|(1:59)(2:60|(1:62))))|63)(1:(1:65))|66|67|(3:69|70|(1:72))|73|(2:78|(1:80)(1:(2:102|(1:104))(3:87|88|(5:90|91|92|(1:94)|95))))(1:77)|(2:106|124)(1:125)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c2 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0266 A[SYNTHETIC, Splitter:B:112:0x0266] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0104 A[ADDED_TO_REGION, Catch:{ u -> 0x0246, all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0173 A[Catch:{ u -> 0x0246, all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01af A[SYNTHETIC, Splitter:B:69:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x020f A[Catch:{ u -> 0x0246, all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0215 A[Catch:{ u -> 0x0246, all -> 0x026a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void $$b(com.appsflyer.AFEvent r23) throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "appsflyerConversionDataCacheExpiration"
            java.net.URL r4 = new java.net.URL
            java.lang.String r5 = r0.collectIntentsFromActivities
            r4.<init>(r5)
            byte[] r5 = r23.AFDateFormat()
            java.lang.String r6 = r23.key()
            java.lang.String r7 = r0.$$a
            boolean r8 = r23.values()
            android.app.Application r9 = r23.context()
            com.appsflyer.attribution.AppsFlyerRequestListener r10 = r23.getRequestListener()
            r12 = 1
            if (r8 == 0) goto L_0x002e
            com.appsflyer.AppsFlyerConversionListener r13 = conversionDataListener
            if (r13 == 0) goto L_0x002e
            r13 = 1
            goto L_0x002f
        L_0x002e:
            r13 = 0
        L_0x002f:
            if (r8 == 0) goto L_0x0037
            int r14 = r0.AFDeepLinkManager
            if (r14 != r12) goto L_0x0037
            r14 = 1
            goto L_0x0038
        L_0x0037:
            r14 = 0
        L_0x0038:
            if (r14 == 0) goto L_0x0053
            org.json.JSONObject r15 = r1.AFInAppEventParameterName     // Catch:{ JSONException -> 0x004c }
            java.lang.String r11 = "from_fg"
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x004c }
            r18 = r13
            long r12 = r1.key     // Catch:{ JSONException -> 0x004e }
            long r12 = r16 - r12
            r15.put(r11, r12)     // Catch:{ JSONException -> 0x004e }
            goto L_0x004e
        L_0x004c:
            r18 = r13
        L_0x004e:
            long r11 = java.lang.System.currentTimeMillis()
            goto L_0x0057
        L_0x0053:
            r18 = r13
            r11 = 0
        L_0x0057:
            java.net.URLConnection r15 = r4.openConnection()     // Catch:{ all -> 0x0270 }
            java.net.HttpURLConnection r15 = (java.net.HttpURLConnection) r15     // Catch:{ all -> 0x0270 }
            java.lang.String r13 = "POST"
            r15.setRequestMethod(r13)     // Catch:{ all -> 0x026c }
            int r13 = r5.length     // Catch:{ all -> 0x026c }
            r17 = r2
            java.lang.String r2 = "Content-Length"
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x026c }
            r15.setRequestProperty(r2, r13)     // Catch:{ all -> 0x026c }
            java.lang.String r2 = "Content-Type"
            boolean r13 = r23.isEncrypt()     // Catch:{ all -> 0x026c }
            if (r13 == 0) goto L_0x007d
            java.lang.String r13 = "application/octet-stream"
            goto L_0x007f
        L_0x0079:
            r0 = move-exception
            r13 = r15
            goto L_0x0273
        L_0x007d:
            java.lang.String r13 = "application/json"
        L_0x007f:
            r15.setRequestProperty(r2, r13)     // Catch:{ all -> 0x026c }
            r2 = 10000(0x2710, float:1.4013E-41)
            r15.setConnectTimeout(r2)     // Catch:{ all -> 0x026c }
            r2 = 1
            r15.setDoOutput(r2)     // Catch:{ all -> 0x026c }
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x026c }
            r19 = r6
            java.lang.String r6 = "http_cache"
            boolean r6 = r13.getBoolean(r6, r2)     // Catch:{ all -> 0x026c }
            if (r6 != 0) goto L_0x009f
            r2 = 0
            r15.setUseCaches(r2)     // Catch:{ all -> 0x026c }
            r2 = r15
            goto L_0x00a0
        L_0x009f:
            r2 = r15
        L_0x00a0:
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0261 }
            java.io.OutputStream r13 = r2.getOutputStream()     // Catch:{ all -> 0x0261 }
            r6.<init>(r13)     // Catch:{ all -> 0x0261 }
            r6.write(r5)     // Catch:{ all -> 0x025e }
            r6.close()     // Catch:{ all -> 0x026a }
            int r5 = r2.getResponseCode()     // Catch:{ all -> 0x026a }
            if (r14 == 0) goto L_0x00c2
            org.json.JSONObject r6 = r1.AFInAppEventParameterName     // Catch:{ JSONException -> 0x00c2 }
            java.lang.String r13 = "net"
            long r20 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00c2 }
            long r11 = r20 - r11
            r6.put(r13, r11)     // Catch:{ JSONException -> 0x00c2 }
        L_0x00c2:
            com.appsflyer.internal.EventDataCollector r6 = r1.eventDataCollector(r9)     // Catch:{ all -> 0x026a }
            java.lang.String r11 = "first_launch"
            org.json.JSONObject r12 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x026a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x026a }
            r6.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x026a }
            java.lang.String r6 = r1.readServerResponse(r2)     // Catch:{ all -> 0x026a }
            com.appsflyer.internal.ac r11 = com.appsflyer.internal.C1048ac.AFDateFormat()     // Catch:{ all -> 0x026a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x026a }
            java.lang.String r12 = "server_response"
            r13 = 2
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ all -> 0x026a }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x026a }
            r15 = 0
            r13[r15] = r14     // Catch:{ all -> 0x026a }
            r14 = 1
            r13[r14] = r6     // Catch:{ all -> 0x026a }
            r11.AFDateFormat(r12, r4, r13)     // Catch:{ all -> 0x026a }
            java.lang.String r4 = "response code: "
            java.lang.String r11 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x026a }
            java.lang.String r4 = r4.concat(r11)     // Catch:{ all -> 0x026a }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x026a }
            android.content.SharedPreferences r4 = getSharedPreferences(r9)     // Catch:{ all -> 0x026a }
            r11 = 200(0xc8, float:2.8E-43)
            if (r5 != r11) goto L_0x0173
            if (r9 == 0) goto L_0x010e
            if (r8 == 0) goto L_0x010e
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026a }
            r1.getRequestListener = r11     // Catch:{ all -> 0x026a }
        L_0x010e:
            if (r10 == 0) goto L_0x0113
            r10.onSuccess()     // Catch:{ all -> 0x026a }
        L_0x0113:
            if (r7 == 0) goto L_0x011c
            com.appsflyer.internal.C1085x.values()     // Catch:{ all -> 0x026a }
            com.appsflyer.internal.C1085x.$$b(r7, r9)     // Catch:{ all -> 0x026a }
            goto L_0x015d
        L_0x011c:
            java.lang.String r5 = "sentSuccessfully"
            java.lang.String r7 = "true"
            android.content.SharedPreferences r8 = getSharedPreferences(r9)     // Catch:{ all -> 0x026a }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x026a }
            r8.putString(r5, r7)     // Catch:{ all -> 0x026a }
            r8.apply()     // Catch:{ all -> 0x026a }
            boolean r5 = r1.context     // Catch:{ all -> 0x026a }
            if (r5 != 0) goto L_0x015d
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026a }
            long r10 = r1.AFDateFormat     // Catch:{ all -> 0x026a }
            long r7 = r7 - r10
            r10 = 15000(0x3a98, double:7.411E-320)
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x0141
            goto L_0x015d
        L_0x0141:
            java.util.concurrent.ScheduledExecutorService r5 = r1.post     // Catch:{ all -> 0x026a }
            if (r5 != 0) goto L_0x015d
            com.appsflyer.AFExecutor r5 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x026a }
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r5.valueOf()     // Catch:{ all -> 0x026a }
            r1.post = r5     // Catch:{ all -> 0x026a }
            com.appsflyer.AppsFlyerLibCore$e r5 = new com.appsflyer.AppsFlyerLibCore$e     // Catch:{ all -> 0x026a }
            r5.<init>(r9)     // Catch:{ all -> 0x026a }
            java.util.concurrent.ScheduledExecutorService r7 = r1.post     // Catch:{ all -> 0x026a }
            r10 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x026a }
            $$b(r7, r5, r10, r8)     // Catch:{ all -> 0x026a }
        L_0x015d:
            com.appsflyer.internal.event.uninstall.Register r5 = new com.appsflyer.internal.event.uninstall.Register     // Catch:{ all -> 0x026a }
            r5.<init>(r9)     // Catch:{ all -> 0x026a }
            r5.sendIfQueued()     // Catch:{ all -> 0x026a }
            org.json.JSONObject r5 = com.appsflyer.ServerConfigHandler.$$b(r6)     // Catch:{ all -> 0x026a }
            java.lang.String r6 = "send_background"
            r7 = 0
            boolean r5 = r5.optBoolean(r6, r7)     // Catch:{ all -> 0x026a }
            r1.onAppLinkFetchFinished = r5     // Catch:{ all -> 0x026a }
            goto L_0x0190
        L_0x0173:
            if (r10 == 0) goto L_0x0190
            int r6 = com.appsflyer.attribution.RequestError.RESPONSE_CODE_FAILURE     // Catch:{ all -> 0x026a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            r7.<init>()     // Catch:{ all -> 0x026a }
            java.lang.String r8 = com.appsflyer.internal.attribution.RequestErrorMessage.RESPONSE_CODE_FAILURE     // Catch:{ all -> 0x026a }
            r7.append(r8)     // Catch:{ all -> 0x026a }
            java.lang.String r8 = " "
            r7.append(r8)     // Catch:{ all -> 0x026a }
            r7.append(r5)     // Catch:{ all -> 0x026a }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x026a }
            r10.onError(r6, r5)     // Catch:{ all -> 0x026a }
        L_0x0190:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            java.lang.String r6 = "[GCD-A01] Loading conversion data. Counter: "
            r5.<init>(r6)     // Catch:{ all -> 0x026a }
            int r0 = r0.AFDeepLinkManager     // Catch:{ all -> 0x026a }
            r5.append(r0)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x026a }
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x026a }
            r5 = 0
            long r7 = r4.getLong(r3, r5)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = "attributionId"
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x01e8
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026a }
            long r5 = r5 - r7
            r7 = 5184000000(0x134fd9000, double:2.561236308E-314)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x01e8
            java.lang.String r5 = "[GCD-E02] Cached conversion data expired"
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ all -> 0x026a }
            java.lang.String r5 = "sixtyDayConversionData"
            android.content.SharedPreferences r6 = getSharedPreferences(r9)     // Catch:{ all -> 0x026a }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x026a }
            r7 = 1
            r6.putBoolean(r5, r7)     // Catch:{ all -> 0x026a }
            r6.apply()     // Catch:{ all -> 0x026a }
            android.content.SharedPreferences r5 = getSharedPreferences(r9)     // Catch:{ all -> 0x026a }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x026a }
            r6 = 0
            r5.putString(r0, r6)     // Catch:{ all -> 0x026a }
            r5.apply()     // Catch:{ all -> 0x026a }
            r5 = 0
            r1.$$a((android.content.Context) r9, (java.lang.String) r3, (long) r5)     // Catch:{ all -> 0x026a }
        L_0x01e8:
            r3 = 0
            java.lang.String r5 = r4.getString(r0, r3)     // Catch:{ all -> 0x026a }
            if (r5 != 0) goto L_0x020b
            if (r19 == 0) goto L_0x020b
            if (r18 == 0) goto L_0x020b
            com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher r0 = new com.appsflyer.AppsFlyerLibCore$InstallAttributionIdFetcher     // Catch:{ all -> 0x026a }
            android.content.Context r3 = r9.getApplicationContext()     // Catch:{ all -> 0x026a }
            android.app.Application r3 = (android.app.Application) r3     // Catch:{ all -> 0x026a }
            r5 = r19
            r4 = 0
            r0.<init>(r1, r3, r5, r4)     // Catch:{ all -> 0x026a }
            java.util.concurrent.ScheduledExecutorService r3 = r0.$$a     // Catch:{ all -> 0x026a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x026a }
            r5 = 10
            $$b(r3, r0, r5, r4)     // Catch:{ all -> 0x026a }
            goto L_0x0258
        L_0x020b:
            r5 = r19
            if (r5 != 0) goto L_0x0215
            java.lang.String r0 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x026a }
            goto L_0x0258
        L_0x0215:
            if (r18 == 0) goto L_0x024f
            r3 = 0
            java.lang.String r0 = r4.getString(r0, r3)     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x024f
            r0 = 0
            int r0 = r1.getLaunchCounter(r4, r0)     // Catch:{ all -> 0x026a }
            r3 = 1
            if (r0 <= r3) goto L_0x024f
            java.util.Map r0 = valueOf((android.content.Context) r9)     // Catch:{ u -> 0x0246 }
            if (r0 == 0) goto L_0x0258
            r3 = r17
            boolean r4 = r0.containsKey(r3)     // Catch:{ all -> 0x023d }
            if (r4 != 0) goto L_0x0239
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x023d }
            r0.put(r3, r4)     // Catch:{ all -> 0x023d }
        L_0x0239:
            com.appsflyer.AppsFlyerLibCore.InstallAttributionIdFetcher.$$b((java.util.Map) r0)     // Catch:{ all -> 0x023d }
            goto L_0x0258
        L_0x023d:
            r0 = move-exception
            java.lang.String r3 = r0.getLocalizedMessage()     // Catch:{ u -> 0x0246 }
            com.appsflyer.AFLogger.afErrorLog(r3, r0)     // Catch:{ u -> 0x0246 }
            goto L_0x0258
        L_0x0246:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x026a }
            com.appsflyer.AFLogger.afErrorLog(r3, r0)     // Catch:{ all -> 0x026a }
            goto L_0x0258
        L_0x024f:
            com.appsflyer.AppsFlyerConversionListener r0 = conversionDataListener     // Catch:{ all -> 0x026a }
            if (r0 != 0) goto L_0x0258
            java.lang.String r0 = "[GCD-E01] AppsFlyerConversionListener is null - skip gcd"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x026a }
        L_0x0258:
            if (r2 == 0) goto L_0x025d
            r2.disconnect()
        L_0x025d:
            return
        L_0x025e:
            r0 = move-exception
            r13 = r6
            goto L_0x0264
        L_0x0261:
            r0 = move-exception
            r3 = 0
            r13 = r3
        L_0x0264:
            if (r13 == 0) goto L_0x0269
            r13.close()     // Catch:{ all -> 0x026a }
        L_0x0269:
            throw r0     // Catch:{ all -> 0x026a }
        L_0x026a:
            r0 = move-exception
            goto L_0x026e
        L_0x026c:
            r0 = move-exception
            r2 = r15
        L_0x026e:
            r13 = r2
            goto L_0x0273
        L_0x0270:
            r0 = move-exception
            r3 = 0
            r13 = r3
        L_0x0273:
            if (r13 == 0) goto L_0x0278
            r13.disconnect()
        L_0x0278:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.$$b(com.appsflyer.AFEvent):void");
    }

    static /* synthetic */ void AFDateFormat(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) {
        String str;
        ScheduledExecutorService scheduledExecutorService;
        Application context2 = aFEvent.context();
        String str2 = aFEvent.values;
        if (context2 == null) {
            AFLogger.afDebugLog("sendWithEvent - got null context. skipping event/launch.");
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(context2);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!appsFlyerLibCore.isStopped()) {
            StringBuilder sb = new StringBuilder("sendWithEvent from activity: ");
            sb.append(context2.getClass().getName());
            AFLogger.afInfoLog(sb.toString());
        }
        int i = 1;
        int i2 = 0;
        boolean z = str2 == null;
        boolean z2 = aFEvent instanceof BackgroundReferrerLaunch;
        boolean z3 = aFEvent instanceof Attr;
        aFEvent.dateFormatUTC = z;
        Map<String, Object> valueOf2 = appsFlyerLibCore.valueOf(aFEvent);
        String str3 = (String) valueOf2.get(ServerParameters.AF_DEV_KEY);
        if (str3 == null || str3.length() == 0) {
            AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
            AppsFlyerRequestListener requestListener2 = aFEvent.getRequestListener();
            if (requestListener2 != null) {
                requestListener2.onError(RequestError.NO_DEV_KEY, RequestErrorMessage.NO_DEV_KEY);
                return;
            }
            return;
        }
        if (!appsFlyerLibCore.isStopped()) {
            AFLogger.afInfoLog("AppsFlyerLib.sendWithEvent");
        }
        int launchCounter = appsFlyerLibCore.getLaunchCounter(sharedPreferences, false);
        if (z3 || z2) {
            str = ServerConfigHandler.getUrl(REFERRER_TRACKING_URL);
        } else if (!z) {
            str = ServerConfigHandler.getUrl(collectIntentsFromActivities);
        } else if (launchCounter < 2) {
            str = ServerConfigHandler.getUrl(FIRST_LAUNCHES_URL);
        } else {
            str = ServerConfigHandler.getUrl(getInstance);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(context2.getPackageName());
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("&buildnumber=6.2.0");
        String obj2 = sb3.toString();
        String configuredChannel = appsFlyerLibCore.getConfiguredChannel(context2);
        if (configuredChannel != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj2);
            sb4.append("&channel=");
            sb4.append(configuredChannel);
            obj2 = sb4.toString();
        }
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && valueOf2.get(ServerParameters.ADVERTISING_ID_PARAM) != null) {
            try {
                if (TextUtils.isEmpty(appsFlyerLibCore.$$a) && valueOf2.remove(ServerParameters.ANDROID_ID) != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(appsFlyerLibCore.values) && valueOf2.remove(ServerParameters.IMEI) != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e);
            }
        }
        AFEvent addParams2 = aFEvent.urlString(obj2).addParams(valueOf2);
        addParams2.AFDeepLinkManager = launchCounter;
        C1019b bVar = new C1019b(appsFlyerLibCore, addParams2, (byte) 0);
        if (z) {
            Referrer[] referrerArr = appsFlyerLibCore.AFInAppEventType;
            if (referrerArr != null) {
                int length = referrerArr.length;
                int i3 = 0;
                while (i2 < length) {
                    Referrer referrer = referrerArr[i2];
                    if (referrer.getState() == Referrer.State.STARTED) {
                        StringBuilder sb5 = new StringBuilder("Failed to get ");
                        sb5.append(referrer.getSource());
                        sb5.append(" referrer, wait ...");
                        AFLogger.afDebugLog(sb5.toString());
                        i3 = 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            if (appsFlyerLibCore.onAppLinkFetchFailed && !appsFlyerLibCore.$$a()) {
                AFLogger.afDebugLog("fetching Facebook deferred AppLink data, wait ...");
                i2 = 1;
            }
            if (!appsFlyerLibCore.AFLogger || appsFlyerLibCore.$$b()) {
                i = i2;
            }
        } else {
            i = 0;
        }
        if (AFDeepLinkManager.$$b) {
            AFLogger.afRDLog("ESP deeplink: execute launch on SerialExecutor");
            AFExecutor instance2 = AFExecutor.getInstance();
            if (instance2.AFDateFormat == null) {
                instance2.AFDateFormat = Executors.newSingleThreadScheduledExecutor(instance2.$$a);
            }
            scheduledExecutorService = instance2.AFDateFormat;
        } else {
            scheduledExecutorService = AFExecutor.getInstance().valueOf();
        }
        $$b(scheduledExecutorService, bVar, i != 0 ? 500 : 0, TimeUnit.MILLISECONDS);
    }

    static /* synthetic */ void values(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(aFEvent.urlString());
        AFLogger.afInfoLog(sb.toString());
        if (aFEvent.$$a != null) {
            str = Base64.encodeToString(aFEvent.AFDateFormat(), 2);
            AFLogger.afInfoLog("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(aFEvent.params()).toString();
            String replaceAll = str.replaceAll("\\p{C}", "*Non-printing character*");
            if (!replaceAll.equals(str)) {
                AFLogger.afWarnLog("Payload contains non-printing characters");
                str = replaceAll;
            }
            C1084w.valueOf("data: ".concat(String.valueOf(str)));
        }
        C1048ac.AFDateFormat().AFDateFormat("server_request", aFEvent.urlString(), str);
        try {
            appsFlyerLibCore.$$b(aFEvent);
        } catch (IOException e) {
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", e);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.$$b(aFEvent.urlString(aFEvent.urlString().replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send request to server. ");
            sb2.append(e.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            throw e;
        }
    }

    static /* synthetic */ void AFDateFormat(AppsFlyerLibCore appsFlyerLibCore, Context context2, String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences(context2).edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
