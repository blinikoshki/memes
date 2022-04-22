package com.facebook.appevents.p009ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.memes.eventtracker.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.ml.ModelManager */
public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    private static final Integer MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = Arrays.asList(new String[]{"none", IntegrityManager.INTEGRITY_TYPE_ADDRESS, IntegrityManager.INTEGRITY_TYPE_HEALTH});
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = Arrays.asList(new String[]{"other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT});
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String SDK_MODEL_ASSET = "%s/model_asset";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    private static final Map<String, TaskHandler> mTaskHandlers = new ConcurrentHashMap();

    /* renamed from: com.facebook.appevents.ml.ModelManager$4 */
    static /* synthetic */ class C12714 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$appevents$ml$ModelManager$Task;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.appevents.ml.ModelManager$Task[] r0 = com.facebook.appevents.p009ml.ModelManager.Task.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$appevents$ml$ModelManager$Task = r0
                com.facebook.appevents.ml.ModelManager$Task r1 = com.facebook.appevents.p009ml.ModelManager.Task.MTML_INTEGRITY_DETECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$appevents$ml$ModelManager$Task     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.appevents.ml.ModelManager$Task r1 = com.facebook.appevents.p009ml.ModelManager.Task.MTML_APP_EVENT_PREDICTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p009ml.ModelManager.C12714.<clinit>():void");
        }
    }

    /* renamed from: com.facebook.appevents.ml.ModelManager$Task */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public String toKey() {
            int i = C12714.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            if (i != 1) {
                return i != 2 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "app_event_pred";
            }
            return "integrity_detect";
        }

        public String toUseCase() {
            int i = C12714.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            if (i == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i != 2) {
                return null;
            }
            return "MTML_APP_EVENT_PRED";
        }
    }

    public static void enable() {
        Utility.runOnNonUiThread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[Catch:{ Exception -> 0x0066 }, RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ Exception -> 0x0066 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "model_request_timestamp"
                    java.lang.String r1 = "models"
                    android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                    r4 = 0
                    android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x0066 }
                    r3 = 0
                    java.lang.String r3 = r2.getString(r1, r3)     // Catch:{ Exception -> 0x0066 }
                    if (r3 == 0) goto L_0x0023
                    boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x0066 }
                    if (r4 == 0) goto L_0x001d
                    goto L_0x0023
                L_0x001d:
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0066 }
                    r4.<init>(r3)     // Catch:{ Exception -> 0x0066 }
                    goto L_0x0028
                L_0x0023:
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0066 }
                    r4.<init>()     // Catch:{ Exception -> 0x0066 }
                L_0x0028:
                    r5 = 0
                    long r5 = r2.getLong(r0, r5)     // Catch:{ Exception -> 0x0066 }
                    com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x0066 }
                    boolean r3 = com.facebook.internal.FeatureManager.isEnabled(r3)     // Catch:{ Exception -> 0x0066 }
                    if (r3 == 0) goto L_0x0042
                    int r3 = r4.length()     // Catch:{ Exception -> 0x0066 }
                    if (r3 == 0) goto L_0x0042
                    boolean r3 = com.facebook.appevents.p009ml.ModelManager.isValidTimestamp(r5)     // Catch:{ Exception -> 0x0066 }
                    if (r3 != 0) goto L_0x0060
                L_0x0042:
                    org.json.JSONObject r4 = com.facebook.appevents.p009ml.ModelManager.fetchModels()     // Catch:{ Exception -> 0x0066 }
                    if (r4 != 0) goto L_0x0049
                    return
                L_0x0049:
                    android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0066 }
                    android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch:{ Exception -> 0x0066 }
                    long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0066 }
                    android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch:{ Exception -> 0x0066 }
                    r0.apply()     // Catch:{ Exception -> 0x0066 }
                L_0x0060:
                    com.facebook.appevents.p009ml.ModelManager.addModels(r4)     // Catch:{ Exception -> 0x0066 }
                    com.facebook.appevents.p009ml.ModelManager.enableMTML()     // Catch:{ Exception -> 0x0066 }
                L_0x0066:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p009ml.ModelManager.C12681.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean isValidTimestamp(long j) {
        return j != 0 && System.currentTimeMillis() - j < ((long) MODEL_REQUEST_INTERVAL_MILLISECONDS.intValue());
    }

    /* access modifiers changed from: private */
    public static void addModels(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                TaskHandler build = TaskHandler.build(jSONObject.getJSONObject(keys.next()));
                if (build != null) {
                    mTaskHandlers.put(build.useCase, build);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    private static JSONObject parseRawJsonObject(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(VERSION_ID_KEY, jSONObject3.getString(VERSION_ID_KEY));
                jSONObject4.put(USE_CASE_KEY, jSONObject3.getString(USE_CASE_KEY));
                jSONObject4.put(THRESHOLD_KEY, jSONObject3.getJSONArray(THRESHOLD_KEY));
                jSONObject4.put(ASSET_URI_KEY, jSONObject3.getString(ASSET_URI_KEY));
                if (jSONObject3.has(RULES_URI_KEY)) {
                    jSONObject4.put(RULES_URI_KEY, jSONObject3.getString(RULES_URI_KEY));
                }
                jSONObject2.put(jSONObject3.getString(USE_CASE_KEY), jSONObject4);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject fetchModels() {
        String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(Util.EVENT_ID_SEPARATOR, strArr));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, String.format(SDK_MODEL_ASSET, new Object[]{FacebookSdk.getApplicationId()}), (GraphRequest.Callback) null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        if (jSONObject == null) {
            return null;
        }
        return parseRawJsonObject(jSONObject);
    }

    /* access modifiers changed from: private */
    public static void enableMTML() {
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i = 0;
        for (Map.Entry next : mTaskHandlers.entrySet()) {
            String str2 = (String) next.getKey();
            if (str2.equals(Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                TaskHandler taskHandler = (TaskHandler) next.getValue();
                str = taskHandler.assetUri;
                i = Math.max(i, taskHandler.versionId);
                if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                    arrayList.add(taskHandler.setOnPostExecute(new Runnable() {
                        public void run() {
                            SuggestedEventsManager.enable();
                        }
                    }));
                }
            }
            if (str2.equals(Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                TaskHandler taskHandler2 = (TaskHandler) next.getValue();
                String str3 = taskHandler2.assetUri;
                int max = Math.max(i, taskHandler2.versionId);
                if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                    arrayList.add(taskHandler2.setOnPostExecute(new Runnable() {
                        public void run() {
                            IntegrityManager.enable();
                        }
                    }));
                }
                str = str3;
                i = max;
            }
        }
        if (str != null && i > 0 && !arrayList.isEmpty()) {
            TaskHandler.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i, (float[]) null), arrayList);
        }
    }

    private static boolean isLocaleEnglish() {
        Locale resourceLocale = Utility.getResourceLocale();
        return resourceLocale == null || resourceLocale.getLanguage().contains("en");
    }

    /* access modifiers changed from: private */
    public static float[] parseJsonArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        float[] fArr = new float[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                fArr[i] = Float.parseFloat(jSONArray.getString(i));
            } catch (JSONException unused) {
            }
        }
        return fArr;
    }

    public static File getRuleFile(Task task) {
        TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
        if (taskHandler == null) {
            return null;
        }
        return taskHandler.ruleFile;
    }

    public static String[] predict(Task task, float[][] fArr, String[] strArr) {
        TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
        if (!(taskHandler == null || taskHandler.model == null)) {
            int length = strArr.length;
            int length2 = fArr[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            for (int i = 0; i < length; i++) {
                System.arraycopy(fArr[i], 0, mTensor.getData(), i * length2, length2);
            }
            MTensor predictOnMTML = taskHandler.model.predictOnMTML(mTensor, strArr, task.toKey());
            float[] fArr2 = taskHandler.thresholds;
            if (!(predictOnMTML == null || fArr2 == null || predictOnMTML.getData().length == 0 || fArr2.length == 0)) {
                int i2 = C12714.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[task.ordinal()];
                if (i2 == 1) {
                    return processIntegrityDetectionResult(predictOnMTML, fArr2);
                }
                if (i2 != 2) {
                    return null;
                }
                return processSuggestedEventResult(predictOnMTML, fArr2);
            }
        }
        return null;
    }

    private static String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        String[] strArr = new String[shape];
        if (shape2 != fArr.length) {
            return null;
        }
        for (int i = 0; i < shape; i++) {
            strArr[i] = "other";
            for (int i2 = 0; i2 < fArr.length; i2++) {
                if (data[(i * shape2) + i2] >= fArr[i2]) {
                    strArr[i] = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                }
            }
        }
        return strArr;
    }

    private static String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        String[] strArr = new String[shape];
        if (shape2 != fArr.length) {
            return null;
        }
        for (int i = 0; i < shape; i++) {
            strArr[i] = "none";
            for (int i2 = 0; i2 < fArr.length; i2++) {
                if (data[(i * shape2) + i2] >= fArr[i2]) {
                    strArr[i] = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                }
            }
        }
        return strArr;
    }

    /* renamed from: com.facebook.appevents.ml.ModelManager$TaskHandler */
    private static class TaskHandler {
        String assetUri;
        Model model;
        /* access modifiers changed from: private */
        public Runnable onPostExecute;
        File ruleFile;
        String ruleUri;
        float[] thresholds;
        String useCase;
        int versionId;

        TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }

        /* access modifiers changed from: package-private */
        public TaskHandler setOnPostExecute(Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        static TaskHandler build(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new TaskHandler(jSONObject.getString(ModelManager.USE_CASE_KEY), jSONObject.getString(ModelManager.ASSET_URI_KEY), jSONObject.optString(ModelManager.RULES_URI_KEY, (String) null), jSONObject.getInt(ModelManager.VERSION_ID_KEY), ModelManager.parseJsonArray(jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY)));
            } catch (Exception unused) {
                return null;
            }
        }

        static void execute(TaskHandler taskHandler) {
            execute(taskHandler, Collections.singletonList(taskHandler));
        }

        static void execute(TaskHandler taskHandler, final List<TaskHandler> list) {
            deleteOldFiles(taskHandler.useCase, taskHandler.versionId);
            download(taskHandler.assetUri, taskHandler.useCase + "_" + taskHandler.versionId, new FileDownloadTask.Callback() {
                public void onComplete(File file) {
                    final Model build = Model.build(file);
                    if (build != null) {
                        for (final TaskHandler taskHandler : list) {
                            TaskHandler.download(taskHandler.ruleUri, taskHandler.useCase + "_" + taskHandler.versionId + "_rule", new FileDownloadTask.Callback() {
                                public void onComplete(File file) {
                                    taskHandler.model = build;
                                    taskHandler.ruleFile = file;
                                    if (taskHandler.onPostExecute != null) {
                                        taskHandler.onPostExecute.run();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        private static void deleteOldFiles(String str, int i) {
            File[] listFiles;
            File mlDir = Utils.getMlDir();
            if (mlDir != null && (listFiles = mlDir.listFiles()) != null && listFiles.length != 0) {
                String str2 = str + "_" + i;
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith(str) && !name.startsWith(str2)) {
                        file.delete();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public static void download(String str, String str2, FileDownloadTask.Callback callback) {
            File file = new File(Utils.getMlDir(), str2);
            if (str == null || file.exists()) {
                callback.onComplete(file);
            } else {
                new FileDownloadTask(str, file, callback).execute(new String[0]);
            }
        }
    }
}
