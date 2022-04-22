package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.p003v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.getstream.sdk.chat.model.ModelType;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static final String FACEBOOK_COM = "facebook.com";
    private static final String FB_GG = "fb.gg";
    private static final Object LOCK = new Object();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = "com.facebook.FacebookSdk";
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    /* access modifiers changed from: private */
    public static Context applicationContext;
    /* access modifiers changed from: private */
    public static volatile String applicationId;
    private static volatile String applicationName;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = "facebook.com";
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static GraphRequestCreator graphRequestCreator = new GraphRequestCreator() {
        public GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
            return GraphRequest.newPostRequest(accessToken, str, jSONObject, callback);
        }
    };
    public static boolean hasCustomTabsPrefetching = false;
    public static boolean ignoreAppSwitchToLoggedOut = false;
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    private static Boolean sdkFullyInitialized = false;
    private static Boolean sdkInitialized = false;

    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback);
    }

    public interface InitializeCallback {
        void onInitialized();
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i, (InitializeCallback) null);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue()) {
                if (i != callbackRequestCodeOffset) {
                    throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                }
            }
            if (i >= 0) {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        return;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void sdkInitialize(final android.content.Context r3, final com.facebook.FacebookSdk.InitializeCallback r4) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.Boolean r1 = sdkInitialized     // Catch:{ all -> 0x00bd }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0012
            if (r4 == 0) goto L_0x0010
            r4.onInitialized()     // Catch:{ all -> 0x00bd }
        L_0x0010:
            monitor-exit(r0)
            return
        L_0x0012:
            java.lang.String r1 = "applicationContext"
            com.facebook.internal.Validate.notNull(r3, r1)     // Catch:{ all -> 0x00bd }
            r1 = 0
            com.facebook.internal.Validate.hasFacebookActivity(r3, r1)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.Validate.hasInternetPermissions(r3, r1)     // Catch:{ all -> 0x00bd }
            android.content.Context r1 = r3.getApplicationContext()     // Catch:{ all -> 0x00bd }
            applicationContext = r1     // Catch:{ all -> 0x00bd }
            com.facebook.appevents.AppEventsLogger.getAnonymousAppDeviceGUID(r3)     // Catch:{ all -> 0x00bd }
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x00bd }
            loadDefaultsFromMetadata(r1)     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = applicationId     // Catch:{ all -> 0x00bd }
            boolean r1 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r1)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x00b5
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00bd }
            sdkInitialized = r1     // Catch:{ all -> 0x00bd }
            boolean r1 = getAutoInitEnabled()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0044
            fullyInitialize()     // Catch:{ all -> 0x00bd }
        L_0x0044:
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x00bd }
            boolean r1 = r1 instanceof android.app.Application     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0059
            boolean r1 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0059
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x00bd }
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = applicationId     // Catch:{ all -> 0x00bd }
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r1, r2)     // Catch:{ all -> 0x00bd }
        L_0x0059:
            com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync()     // Catch:{ all -> 0x00bd }
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x00bd }
            com.facebook.internal.BoltsMeasurementEventListener.getInstance(r1)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.LockOnGetVariable r1 = new com.facebook.internal.LockOnGetVariable     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$2 r2 = new com.facebook.FacebookSdk$2     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            r1.<init>(r2)     // Catch:{ all -> 0x00bd }
            cacheDir = r1     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$3 r2 = new com.facebook.FacebookSdk$3     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager.checkFeature(r1, r2)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$4 r2 = new com.facebook.FacebookSdk$4     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager.checkFeature(r1, r2)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$5 r2 = new com.facebook.FacebookSdk$5     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager.checkFeature(r1, r2)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$6 r2 = new com.facebook.FacebookSdk$6     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager.checkFeature(r1, r2)     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.Monitoring     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$7 r2 = new com.facebook.FacebookSdk$7     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            com.facebook.internal.FeatureManager.checkFeature(r1, r2)     // Catch:{ all -> 0x00bd }
            java.util.concurrent.FutureTask r1 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x00bd }
            com.facebook.FacebookSdk$8 r2 = new com.facebook.FacebookSdk$8     // Catch:{ all -> 0x00bd }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x00bd }
            r1.<init>(r2)     // Catch:{ all -> 0x00bd }
            java.util.concurrent.Executor r3 = getExecutor()     // Catch:{ all -> 0x00bd }
            r3.execute(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)
            return
        L_0x00b5:
            com.facebook.FacebookException r3 = new com.facebook.FacebookException     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r3.<init>((java.lang.String) r4)     // Catch:{ all -> 0x00bd }
            throw r3     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static synchronized boolean isFullyInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkFullyInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static void fullyInitialize() {
        sdkFullyInitialized = true;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
            updateGraphDebugBehavior();
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(loggingBehavior);
        }
    }

    public static void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            z = isDebugEnabled() && hashSet.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            hashSet.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor2) {
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            executor = executor2;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String graphDomain = currentAccessToken != null ? currentAccessToken.getGraphDomain() : null;
        if (graphDomain == null) {
            return facebookDomain;
        }
        if (graphDomain.equals(ModelType.channel_gaming)) {
            return facebookDomain.replace("facebook.com", FB_GG);
        }
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static void setGraphApiVersion(String str) {
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (!Utility.isNullOrEmpty(str) && !graphApiVersion.equals(str)) {
            graphApiVersion = str;
        }
    }

    public static String getGraphApiVersion() {
        Utility.logd(TAG, String.format("getGraphApiVersion: %s", new Object[]{graphApiVersion}));
        return graphApiVersion;
    }

    public static void publishInstallAsync(Context context, final String str) {
        final Context applicationContext2 = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                FacebookSdk.publishInstallAndWaitForResponse(applicationContext2, str);
            }
        });
    }

    static void publishInstallAndWaitForResponse(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String str2 = str + "ping";
            long j = sharedPreferences.getLong(str2, 0);
            GraphRequest createPostRequest = graphRequestCreator.createPostRequest((AccessToken) null, String.format(PUBLISH_ACTIVITY_PATH, new Object[]{str}), AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context), (GraphRequest.Callback) null);
            if (j == 0 && createPostRequest.executeAndWait().getError() == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str2, System.currentTimeMillis());
                edit.apply();
            }
        } catch (JSONException e) {
            throw new FacebookException("An error occurred while publishing install.", (Throwable) e);
        } catch (Exception e2) {
            Utility.logd("Facebook-publish", e2);
        }
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    static void loadDefaultsFromMetadata(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                applicationId = str.substring(2);
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                        callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
                    }
                    if (codelessDebugLogEnabled == null) {
                        codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getApplicationSignature(android.content.Context r3) {
        /*
            com.facebook.internal.Validate.sdkInitialized()
            r0 = 0
            if (r3 != 0) goto L_0x0007
            return r0
        L_0x0007:
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.String r3 = r3.getPackageName()
            r2 = 64
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{ NameNotFoundException -> 0x003d }
            android.content.pm.Signature[] r1 = r3.signatures
            if (r1 == 0) goto L_0x003d
            int r1 = r1.length
            if (r1 != 0) goto L_0x0020
            goto L_0x003d
        L_0x0020:
            java.lang.String r1 = "SHA-1"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r1)     // Catch:{  }
            android.content.pm.Signature[] r3 = r3.signatures
            r1 = 0
            r3 = r3[r1]
            byte[] r3 = r3.toByteArray()
            r0.update(r3)
            byte[] r3 = r0.digest()
            r0 = 9
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r0)
            return r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.getApplicationSignature(android.content.Context):java.lang.String");
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static void setAutoInitEnabled(boolean z) {
        UserSettingsManager.setAutoInitEnabled(z);
        if (z) {
            fullyInitialize();
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z);
        if (z) {
            ActivityLifecycleTracker.startTracking((Application) applicationContext, applicationId);
        }
    }

    public static boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        return codelessDebugLogEnabled.booleanValue();
    }

    public static boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z);
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    public static boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    public static void setMonitorEnabled(boolean z) {
        UserSettingsManager.setMonitorEnabled(z);
    }

    public static void setDataProcessingOptions(String[] strArr) {
        setDataProcessingOptions(strArr, 0, 0);
    }

    public static void setDataProcessingOptions(String[] strArr, int i, int i2) {
        if (strArr == null) {
            strArr = new String[0];
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSION_OPTIONS, new JSONArray(Arrays.asList(strArr)));
            jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, i);
            jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, i2);
            applicationContext.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, jSONObject.toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return cacheDir.getValue();
    }

    public static void setCacheDir(File file) {
        cacheDir = new LockOnGetVariable<>(file);
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static boolean isFacebookRequestCode(int i) {
        int i2 = callbackRequestCodeOffset;
        return i >= i2 && i < i2 + 100;
    }

    public static void setGraphRequestCreator(GraphRequestCreator graphRequestCreator2) {
        graphRequestCreator = graphRequestCreator2;
    }
}
