package com.appsflyer.internal;

import android.content.pm.PackageManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.BackgroundHttpTask;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.appsflyer.internal.model.event.ProxyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ac */
public final class C1048ac {
    private static C1048ac AFDateFormat = null;
    private static String values = "https://%smonitorsdk.%s/remote-debug?app_id=";
    public boolean $$a;
    private boolean $$b = true;
    private int AFDeepLinkManager = 0;
    private boolean collectIntentsFromActivities;
    private final List<String> dateFormatUTC = new ArrayList();
    private boolean getDataFormatter;
    private String getInstance = "-1";
    private JSONObject valueOf;

    private C1048ac() {
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.getDataFormatter = z;
        this.$$a = true ^ z;
        this.AFDeepLinkManager = 0;
        this.collectIntentsFromActivities = false;
    }

    public static C1048ac AFDateFormat() {
        if (AFDateFormat == null) {
            AFDateFormat = new C1048ac();
        }
        return AFDateFormat;
    }

    public final synchronized void $$a(String str) {
        this.getInstance = str;
    }

    public final synchronized void $$b() {
        this.collectIntentsFromActivities = true;
        AFDateFormat("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    public final synchronized void $$a() {
        AFDateFormat("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.collectIntentsFromActivities = false;
        this.$$b = false;
    }

    public final synchronized void values() {
        this.valueOf = null;
        AFDateFormat = null;
    }

    private boolean getDataFormatter() {
        if (this.$$a) {
            return this.$$b || this.collectIntentsFromActivities;
        }
        return false;
    }

    private synchronized void values(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.valueOf.put(ServerParameters.BRAND, str);
            this.valueOf.put(ServerParameters.MODEL, str2);
            this.valueOf.put(ServerParameters.PLATFORM, "Android");
            this.valueOf.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.valueOf.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.valueOf.put(ServerParameters.IMEI, str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.valueOf.put(ServerParameters.ANDROID_ID, str6);
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void $$b(String str, String str2, String str3, String str4) {
        try {
            this.valueOf.put(ServerParameters.SDK_DATA_SDK_VERSION, str);
            if (str2 != null && str2.length() > 0) {
                this.valueOf.put(ServerParameters.DEV_KEY, str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.valueOf.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.valueOf.put(ServerParameters.AF_USER_ID, str4);
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void AFDateFormat(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.valueOf.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.valueOf.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.valueOf.put("channel", str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.valueOf.put("preInstall", str4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void AFDateFormat(java.lang.String r4, java.lang.String r5, java.lang.String... r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.getDataFormatter()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0091
            int r0 = r3.AFDeepLinkManager     // Catch:{ all -> 0x0093 }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0010
            goto L_0x0091
        L_0x0010:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = ", "
            java.lang.String r6 = android.text.TextUtils.join(r2, r6)     // Catch:{ all -> 0x008f }
            if (r4 == 0) goto L_0x0051
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008f }
            long r0 = r0.getId()     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " _/AppsFlyer_6.2.0 ["
            r2.append(r0)     // Catch:{ all -> 0x008f }
            r2.append(r4)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "] "
            r2.append(r4)     // Catch:{ all -> 0x008f }
            r2.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = " "
            r2.append(r4)     // Catch:{ all -> 0x008f }
            r2.append(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x008f }
            goto L_0x007d
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r4.<init>()     // Catch:{ all -> 0x008f }
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008f }
            long r0 = r0.getId()     // Catch:{ all -> 0x008f }
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x008f }
            r4.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r5 = "/AppsFlyer_6.2.0 "
            r4.append(r5)     // Catch:{ all -> 0x008f }
            r4.append(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008f }
        L_0x007d:
            java.util.List<java.lang.String> r5 = r3.dateFormatUTC     // Catch:{ all -> 0x008f }
            r5.add(r4)     // Catch:{ all -> 0x008f }
            int r5 = r3.AFDeepLinkManager     // Catch:{ all -> 0x008f }
            int r4 = r4.length()     // Catch:{ all -> 0x008f }
            int r4 = r4 << 1
            int r5 = r5 + r4
            r3.AFDeepLinkManager = r5     // Catch:{ all -> 0x008f }
            monitor-exit(r3)
            return
        L_0x008f:
            monitor-exit(r3)
            return
        L_0x0091:
            monitor-exit(r3)
            return
        L_0x0093:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1048ac.AFDateFormat(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String dateFormatUTC() {
        /*
            r4 = this;
            monitor-enter(r4)
            org.json.JSONObject r0 = r4.valueOf     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.lang.String r1 = "data"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.util.List<java.lang.String> r3 = r4.dateFormatUTC     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            org.json.JSONObject r0 = r4.valueOf     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x001c, all -> 0x0019 }
            r4.getInstance()     // Catch:{ JSONException -> 0x001d, all -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x001c:
            r0 = 0
        L_0x001d:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1048ac.dateFormatUTC():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)(8:6|7|8|9|10|11|13|14)|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void AFDateFormat(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0090 }
            com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x007f }
            r11.<init>(r2)     // Catch:{ all -> 0x007f }
            r10.valueOf = r11     // Catch:{ all -> 0x007f }
            goto L_0x007f
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            r10.valueOf = r2     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r1.values     // Catch:{ all -> 0x0090 }
            java.lang.String r9 = r1.$$a     // Catch:{ all -> 0x0090 }
            r3 = r10
            r3.values(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "6.2.0."
            r1.<init>(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = com.appsflyer.AppsFlyerLibCore.$$b     // Catch:{ all -> 0x0090 }
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0090 }
            r10.$$b(r1, r2, r3, r4)     // Catch:{ all -> 0x0090 }
            r1 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r11, r1)     // Catch:{ all -> 0x0074 }
            int r12 = r12.versionCode     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0074 }
            r10.AFDateFormat(r11, r12, r1, r2)     // Catch:{ all -> 0x0074 }
        L_0x0074:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.valueOf     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0090 }
            r0.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0090 }
        L_0x007f:
            org.json.JSONObject r11 = r10.valueOf     // Catch:{ JSONException -> 0x008a }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.getInstance     // Catch:{ JSONException -> 0x008a }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x008a }
            monitor-exit(r10)
            return
        L_0x008a:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0090 }
            monitor-exit(r10)
            return
        L_0x0090:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1048ac.AFDateFormat(java.lang.String, android.content.pm.PackageManager):void");
    }

    public static String[] values(String str, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return new String[]{str};
        }
        String[] strArr = new String[(stackTraceElementArr.length + 1)];
        strArr[0] = str;
        for (int i = 1; i < stackTraceElementArr.length; i++) {
            strArr[i] = stackTraceElementArr[i].toString();
        }
        return strArr;
    }

    private synchronized void getInstance() {
        this.dateFormatUTC.clear();
        this.AFDeepLinkManager = 0;
    }

    public final synchronized void valueOf() {
        this.$$b = false;
        getInstance();
    }

    public final boolean collectIntentsFromActivities() {
        return this.collectIntentsFromActivities;
    }

    public static void values(String str, PackageManager packageManager) {
        try {
            if (AFDateFormat == null) {
                AFDateFormat = new C1048ac();
            }
            AFDateFormat.AFDateFormat(str, packageManager);
            if (AFDateFormat == null) {
                AFDateFormat = new C1048ac();
            }
            BackgroundEvent trackingStopped = new ProxyEvent().body(AFDateFormat.dateFormatUTC()).trackingStopped(AppsFlyerLib.getInstance().isStopped());
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(values));
            sb.append(str);
            new BackgroundHttpTask((BackgroundEvent) trackingStopped.urlString(sb.toString())).execute();
        } catch (Throwable th) {
            AFLogger.afErrorLog(th);
        }
    }
}
