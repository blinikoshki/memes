package com.facebook.internal.instrument;

import android.os.Build;
import com.facebook.internal.Utility;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class InstrumentData {
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_CALLSTACK = "callstack";
    private static final String PARAM_DEVICE_MODEL = "device_model";
    private static final String PARAM_DEVICE_OS = "device_os_version";
    private static final String PARAM_FEATURE_NAMES = "feature_names";
    private static final String PARAM_REASON = "reason";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_TYPE = "type";
    private static final String UNKNOWN = "Unknown";
    private String appVersion;
    private String cause;
    private JSONArray featureNames;
    private String filename;
    private String stackTrace;
    private Long timestamp;
    private Type type;

    /* synthetic */ InstrumentData(File file, C14941 r2) {
        this(file);
    }

    /* synthetic */ InstrumentData(Throwable th, Type type2, C14941 r3) {
        this(th, type2);
    }

    /* synthetic */ InstrumentData(JSONArray jSONArray, C14941 r2) {
        this(jSONArray);
    }

    /* renamed from: com.facebook.internal.instrument.InstrumentData$1 */
    static /* synthetic */ class C14941 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.internal.instrument.InstrumentData$Type[] r0 = com.facebook.internal.instrument.InstrumentData.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type = r0
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.Analysis     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.CrashReport     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.CrashShield     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.ThreadCheck     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.instrument.InstrumentData.C14941.<clinit>():void");
        }
    }

    public enum Type {
        Unknown,
        Analysis,
        CrashReport,
        CrashShield,
        ThreadCheck;

        public String toString() {
            int i = C14941.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            if (i == 1) {
                return "Analysis";
            }
            if (i == 2) {
                return "CrashReport";
            }
            if (i != 3) {
                return i != 4 ? "Unknown" : "ThreadCheck";
            }
            return "CrashShield";
        }

        public String getLogPrefix() {
            int i = C14941.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            if (i == 1) {
                return InstrumentUtility.ANALYSIS_REPORT_PREFIX;
            }
            if (i == 2) {
                return InstrumentUtility.CRASH_REPORT_PREFIX;
            }
            if (i != 3) {
                return i != 4 ? "Unknown" : InstrumentUtility.THREAD_CHECK_PREFIX;
            }
            return InstrumentUtility.CRASH_SHIELD_PREFIX;
        }
    }

    private InstrumentData(JSONArray jSONArray) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.featureNames = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    private InstrumentData(Throwable th, Type type2) {
        this.type = type2;
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type2.getLogPrefix());
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    private InstrumentData(File file) {
        String name = file.getName();
        this.filename = name;
        this.type = getType(name);
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong(PARAM_TIMESTAMP, 0));
            this.appVersion = readFile.optString(PARAM_APP_VERSION, (String) null);
            this.cause = readFile.optString(PARAM_REASON, (String) null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, (String) null);
            this.featureNames = readFile.optJSONArray(PARAM_FEATURE_NAMES);
        }
    }

    private static Type getType(String str) {
        if (str.startsWith(InstrumentUtility.CRASH_REPORT_PREFIX)) {
            return Type.CrashReport;
        }
        if (str.startsWith(InstrumentUtility.CRASH_SHIELD_PREFIX)) {
            return Type.CrashShield;
        }
        if (str.startsWith(InstrumentUtility.THREAD_CHECK_PREFIX)) {
            return Type.ThreadCheck;
        }
        if (str.startsWith(InstrumentUtility.ANALYSIS_REPORT_PREFIX)) {
            return Type.Analysis;
        }
        return Type.Unknown;
    }

    public int compareTo(InstrumentData instrumentData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public boolean isValid() {
        int i = C14941.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[this.type.ordinal()];
        if (i != 1) {
            if ((i != 2 && i != 3 && i != 4) || this.stackTrace == null || this.timestamp == null) {
                return false;
            }
            return true;
        } else if (this.featureNames == null || this.timestamp == null) {
            return false;
        } else {
            return true;
        }
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    private JSONObject getParameters() {
        int i = C14941.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[this.type.ordinal()];
        if (i == 1) {
            return getAnalysisReportParameters();
        }
        if (i == 2 || i == 3 || i == 4) {
            return getExceptionReportParameters();
        }
        return null;
    }

    private JSONObject getAnalysisReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.featureNames;
            if (jSONArray != null) {
                jSONObject.put(PARAM_FEATURE_NAMES, jSONArray);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put(PARAM_TIMESTAMP, l);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject getExceptionReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.appVersion;
            if (str != null) {
                jSONObject.put(PARAM_APP_VERSION, str);
            }
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put(PARAM_TIMESTAMP, l);
            }
            String str2 = this.cause;
            if (str2 != null) {
                jSONObject.put(PARAM_REASON, str2);
            }
            String str3 = this.stackTrace;
            if (str3 != null) {
                jSONObject.put(PARAM_CALLSTACK, str3);
            }
            Type type2 = this.type;
            if (type2 != null) {
                jSONObject.put("type", type2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static class Builder {
        public static InstrumentData load(File file) {
            return new InstrumentData(file, (C14941) null);
        }

        public static InstrumentData build(Throwable th, Type type) {
            return new InstrumentData(th, type, (C14941) null);
        }

        public static InstrumentData build(JSONArray jSONArray) {
            return new InstrumentData(jSONArray, (C14941) null);
        }
    }
}
