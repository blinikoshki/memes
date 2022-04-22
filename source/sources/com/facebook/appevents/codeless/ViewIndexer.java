package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.codeless.ViewIndexer";
    private static final String TREE_PARAM = "tree";
    private static ViewIndexer instance;
    /* access modifiers changed from: private */
    public WeakReference<Activity> activityReference;
    /* access modifiers changed from: private */
    public Timer indexingTimer;
    /* access modifiers changed from: private */
    public String previousDigest = null;
    /* access modifiers changed from: private */
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public void schedule() {
        final C12501 r0 = new TimerTask() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x007c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    com.facebook.appevents.codeless.ViewIndexer r0 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                    java.lang.ref.WeakReference r0 = r0.activityReference     // Catch:{ Exception -> 0x0090 }
                    java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0090 }
                    android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0090 }
                    android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x0090 }
                    if (r0 == 0) goto L_0x008f
                    if (r1 != 0) goto L_0x0016
                    goto L_0x008f
                L_0x0016:
                    java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x0090 }
                    boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled()     // Catch:{ Exception -> 0x0090 }
                    if (r2 != 0) goto L_0x0025
                    return
                L_0x0025:
                    boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x0090 }
                    if (r2 == 0) goto L_0x002f
                    com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x0090 }
                    return
                L_0x002f:
                    java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0090 }
                    com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x0090 }
                    r3.<init>(r1)     // Catch:{ Exception -> 0x0090 }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x0090 }
                    com.facebook.appevents.codeless.ViewIndexer r3 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                    android.os.Handler r3 = r3.uiThreadHandler     // Catch:{ Exception -> 0x0090 }
                    r3.post(r2)     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r3 = ""
                    r4 = 1
                    java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0050 }
                    java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x0050 }
                    java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0050 }
                    r3 = r2
                    goto L_0x005a
                L_0x0050:
                    r2 = move-exception
                    java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r5 = "Failed to take screenshot."
                    android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x0090 }
                L_0x005a:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0090 }
                    r2.<init>()     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r4 = "screenname"
                    r2.put(r4, r0)     // Catch:{ JSONException -> 0x007c }
                    java.lang.String r0 = "screenshot"
                    r2.put(r0, r3)     // Catch:{ JSONException -> 0x007c }
                    org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007c }
                    r0.<init>()     // Catch:{ JSONException -> 0x007c }
                    org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x007c }
                    r0.put(r1)     // Catch:{ JSONException -> 0x007c }
                    java.lang.String r1 = "view"
                    r2.put(r1, r0)     // Catch:{ JSONException -> 0x007c }
                    goto L_0x0085
                L_0x007c:
                    java.lang.String r0 = com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0090 }
                    java.lang.String r1 = "Failed to create JSONObject"
                    android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x0090 }
                L_0x0085:
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0090 }
                    com.facebook.appevents.codeless.ViewIndexer r1 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0090 }
                    r1.sendToServer(r0)     // Catch:{ Exception -> 0x0090 }
                    goto L_0x009a
                L_0x008f:
                    return
                L_0x0090:
                    r0 = move-exception
                    java.lang.String r1 = com.facebook.appevents.codeless.ViewIndexer.TAG
                    java.lang.String r2 = "UI Component tree indexing failure!"
                    android.util.Log.e(r1, r2, r0)
                L_0x009a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer.C12501.run():void");
            }
        };
        try {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        if (ViewIndexer.this.indexingTimer != null) {
                            ViewIndexer.this.indexingTimer.cancel();
                        }
                        String unused = ViewIndexer.this.previousDigest = null;
                        Timer unused2 = ViewIndexer.this.indexingTimer = new Timer();
                        ViewIndexer.this.indexingTimer.scheduleAtFixedRate(r0, 0, 1000);
                    } catch (Exception e) {
                        Log.e(ViewIndexer.TAG, "Error scheduling indexing job", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Error scheduling indexing job", e);
        }
    }

    public void unschedule() {
        Timer timer;
        if (((Activity) this.activityReference.get()) != null && (timer = this.indexingTimer) != null) {
            try {
                timer.cancel();
                this.indexingTimer = null;
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            }
        }
    }

    public static void sendToServerUnityInstance(String str) {
        ViewIndexer viewIndexer = instance;
        if (viewIndexer != null) {
            viewIndexer.sendToServerUnity(str);
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        instance.sendToServer(str);
    }

    /* access modifiers changed from: private */
    public void sendToServer(final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                GraphRequest buildAppIndexingRequest;
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if ((md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) && (buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING)) != null) {
                    GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(jSONObject.optString("success"))) {
                                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                String unused = ViewIndexer.this.previousDigest = md5hash;
                            }
                            if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                                CodelessManager.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                                return;
                            }
                            return;
                        }
                        String access$200 = ViewIndexer.TAG;
                        Log.e(access$200, "Error sending UI component tree to Facebook: " + executeAndWait.getError());
                    } catch (JSONException e) {
                        Log.e(ViewIndexer.TAG, "Error decoding server response.", e);
                    }
                }
            }
        });
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), (JSONObject) null, (GraphRequest.Callback) null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(TREE_PARAM, str);
        parameters.putString(APP_VERSION_PARAM, AppEventUtility.getAppVersion());
        parameters.putString("platform", Constants.PLATFORM);
        parameters.putString(REQUEST_TYPE, str3);
        if (str3.equals(Constants.APP_INDEXING)) {
            parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID());
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
            }
        });
        return newPostRequest;
    }

    private static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        ScreenshotTaker(View view) {
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }
}
