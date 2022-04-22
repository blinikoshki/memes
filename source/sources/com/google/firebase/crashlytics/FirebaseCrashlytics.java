package com.google.firebase.crashlytics;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.util.Objects;

public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger} */
    /* JADX WARNING: type inference failed for: r14v13, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver] */
    /* JADX WARNING: type inference failed for: r3v3, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.crashlytics.FirebaseCrashlytics init(com.google.firebase.FirebaseApp r11, com.google.firebase.installations.FirebaseInstallationsApi r12, com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r13, com.google.firebase.analytics.connector.AnalyticsConnector r14) {
        /*
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Initializing Firebase Crashlytics "
            r1.append(r2)
            java.lang.String r2 = com.google.firebase.crashlytics.internal.common.CrashlyticsCore.getVersion()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo53733i(r1)
            android.content.Context r2 = r11.getApplicationContext()
            java.lang.String r0 = r2.getPackageName()
            com.google.firebase.crashlytics.internal.common.IdManager r1 = new com.google.firebase.crashlytics.internal.common.IdManager
            r1.<init>(r2, r0, r12)
            com.google.firebase.crashlytics.internal.common.DataCollectionArbiter r12 = new com.google.firebase.crashlytics.internal.common.DataCollectionArbiter
            r12.<init>(r11)
            if (r13 != 0) goto L_0x0035
            com.google.firebase.crashlytics.internal.MissingNativeComponent r13 = new com.google.firebase.crashlytics.internal.MissingNativeComponent
            r13.<init>()
        L_0x0035:
            r6 = r13
            if (r14 == 0) goto L_0x0081
            com.google.firebase.crashlytics.internal.Logger r13 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r0 = "Firebase Analytics is available."
            r13.mo53729d(r0)
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r13 = new com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger
            r13.<init>(r14)
            com.google.firebase.crashlytics.CrashlyticsAnalyticsListener r0 = new com.google.firebase.crashlytics.CrashlyticsAnalyticsListener
            r0.<init>()
            com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle r14 = subscribeToAnalyticsEvents(r14, r0)
            if (r14 == 0) goto L_0x0070
            com.google.firebase.crashlytics.internal.Logger r14 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r3 = "Firebase Analytics listener registered successfully."
            r14.mo53729d(r3)
            com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver r14 = new com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver
            r14.<init>()
            com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger r3 = new com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger
            r4 = 500(0x1f4, float:7.0E-43)
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3.<init>(r13, r4, r5)
            r0.setBreadcrumbEventReceiver(r14)
            r0.setCrashlyticsOriginEventReceiver(r3)
            r13 = r3
            goto L_0x007e
        L_0x0070:
            com.google.firebase.crashlytics.internal.Logger r14 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r0 = "Firebase Analytics listener registration failed."
            r14.mo53729d(r0)
            com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource r14 = new com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource
            r14.<init>()
        L_0x007e:
            r9 = r13
            r8 = r14
            goto L_0x0096
        L_0x0081:
            com.google.firebase.crashlytics.internal.Logger r13 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r14 = "Firebase Analytics is unavailable."
            r13.mo53729d(r14)
            com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource r13 = new com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource
            r13.<init>()
            com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger r14 = new com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger
            r14.<init>()
            r8 = r13
            r9 = r14
        L_0x0096:
            java.lang.String r13 = "Crashlytics Exception Handler"
            java.util.concurrent.ExecutorService r10 = com.google.firebase.crashlytics.internal.common.ExecutorUtils.buildSingleThreadExecutorService(r13)
            com.google.firebase.crashlytics.internal.common.CrashlyticsCore r13 = new com.google.firebase.crashlytics.internal.common.CrashlyticsCore
            r3 = r13
            r4 = r11
            r5 = r1
            r7 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            com.google.firebase.FirebaseOptions r11 = r11.getOptions()
            java.lang.String r3 = r11.getApplicationId()
            java.lang.String r11 = com.google.firebase.crashlytics.internal.common.CommonUtils.getMappingFileId(r2)
            com.google.firebase.crashlytics.internal.Logger r14 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Mapping file ID is: "
            r0.append(r4)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r14.mo53729d(r0)
            com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider r14 = new com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider
            r14.<init>(r2)
            com.google.firebase.crashlytics.internal.common.AppData r11 = com.google.firebase.crashlytics.internal.common.AppData.create(r2, r1, r3, r11, r14)     // Catch:{ NameNotFoundException -> 0x011f }
            com.google.firebase.crashlytics.internal.Logger r14 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Installer package name is: "
            r0.append(r4)
            java.lang.String r4 = r11.installerPackageName
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r14.mo53729d(r0)
            java.lang.String r14 = "com.google.firebase.crashlytics.startup"
            java.util.concurrent.ExecutorService r14 = com.google.firebase.crashlytics.internal.common.ExecutorUtils.buildSingleThreadExecutorService(r14)
            com.google.firebase.crashlytics.internal.network.HttpRequestFactory r5 = new com.google.firebase.crashlytics.internal.network.HttpRequestFactory
            r5.<init>()
            java.lang.String r6 = r11.versionCode
            java.lang.String r7 = r11.versionName
            r4 = r1
            r8 = r12
            com.google.firebase.crashlytics.internal.settings.SettingsController r12 = com.google.firebase.crashlytics.internal.settings.SettingsController.create(r2, r3, r4, r5, r6, r7, r8)
            com.google.android.gms.tasks.Task r0 = r12.loadSettingsData(r14)
            com.google.firebase.crashlytics.FirebaseCrashlytics$1 r1 = new com.google.firebase.crashlytics.FirebaseCrashlytics$1
            r1.<init>()
            r0.continueWith(r14, r1)
            boolean r11 = r13.onPreExecute(r11, r12)
            com.google.firebase.crashlytics.FirebaseCrashlytics$2 r0 = new com.google.firebase.crashlytics.FirebaseCrashlytics$2
            r0.<init>(r11, r13, r12)
            com.google.android.gms.tasks.Tasks.call(r14, r0)
            com.google.firebase.crashlytics.FirebaseCrashlytics r11 = new com.google.firebase.crashlytics.FirebaseCrashlytics
            r11.<init>(r13)
            return r11
        L_0x011f:
            r11 = move-exception
            com.google.firebase.crashlytics.internal.Logger r12 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r13 = "Could not retrieve app info, initialization failed."
            r12.mo53732e(r13, r11)
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.FirebaseCrashlytics.init(com.google.firebase.FirebaseApp, com.google.firebase.installations.FirebaseInstallationsApi, com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent, com.google.firebase.analytics.connector.AnalyticsConnector):com.google.firebase.crashlytics.FirebaseCrashlytics");
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector analyticsConnector, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().mo53729d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("crash", crashlyticsAnalyticsListener);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().mo53739w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    public void recordException(Throwable th) {
        if (th == null) {
            Logger.getLogger().mo53739w("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.core.logException(th);
        }
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCustomKey(String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setCustomKey(String str, double d) {
        this.core.setCustomKey(str, Double.toString(d));
    }

    public void setCustomKey(String str, float f) {
        this.core.setCustomKey(str, Float.toString(f));
    }

    public void setCustomKey(String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(String str, long j) {
        this.core.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }
}
