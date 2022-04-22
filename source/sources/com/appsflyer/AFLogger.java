package com.appsflyer;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.internal.C1048ac;
import com.appsflyer.internal.Exlytics;

public class AFLogger {
    private static final long $$b = System.currentTimeMillis();

    public static void afInfoLog(String str, boolean z) {
        if (values(LogLevel.INFO)) {
            Log.i(AppsFlyerLibCore.LOG_TAG, valueOf(str, false));
        }
        if (z) {
            C1048ac.AFDateFormat().AFDateFormat((String) null, "I", valueOf(str, true));
        }
    }

    private static String valueOf(String str, boolean z) {
        if (str == null) {
            str = "null";
        }
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(System.currentTimeMillis() - $$b);
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    private static void valueOf(String str, Throwable th, boolean z, boolean z2) {
        if (values(LogLevel.ERROR)) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getClass().getSimpleName());
                sb.append(" at ");
                sb.append(th.getStackTrace()[0].toString());
                str = sb.toString();
            }
            String valueOf = valueOf(str, false);
            if (z2) {
                Log.e(AppsFlyerLibCore.LOG_TAG, valueOf, th);
            } else if (z) {
                Log.d(AppsFlyerLibCore.LOG_TAG, valueOf);
            }
        }
        C1048ac AFDateFormat = C1048ac.AFDateFormat();
        Throwable cause = th.getCause();
        AFDateFormat.AFDateFormat("exception", th.getClass().getSimpleName(), C1048ac.values(cause == null ? th.getMessage() : cause.getMessage(), cause == null ? th.getStackTrace() : cause.getStackTrace()));
        Exlytics.increment();
    }

    static void AFDateFormat(String str) {
        if (values(LogLevel.WARNING)) {
            Log.w(AppsFlyerLibCore.LOG_TAG, valueOf(str, false));
        }
        C1048ac.AFDateFormat().AFDateFormat((String) null, ExifInterface.LONGITUDE_WEST, valueOf(str, true));
    }

    public static void afRDLog(String str) {
        if (values(LogLevel.VERBOSE)) {
            Log.v(AppsFlyerLibCore.LOG_TAG, valueOf(str, false));
        }
        C1048ac.AFDateFormat().AFDateFormat((String) null, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, valueOf(str, true));
    }

    private static boolean values(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    static void $$a(String str) {
        if (!values()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, valueOf(str, false));
        }
        C1048ac.AFDateFormat().AFDateFormat((String) null, "F", str);
    }

    private static boolean values() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        valueOf(str, th, true, false);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        valueOf(str, th, true, z);
    }

    public static void afErrorLog(Throwable th) {
        valueOf((String) null, th, false, false);
    }

    public static void afWarnLog(String str) {
        AFDateFormat(str);
    }

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int $$b;

        private LogLevel(int i) {
            this.$$b = i;
        }

        public final int getLevel() {
            return this.$$b;
        }
    }

    public static void afDebugLog(String str) {
        if (values(LogLevel.DEBUG)) {
            Log.d(AppsFlyerLibCore.LOG_TAG, valueOf(str, false));
        }
        C1048ac.AFDateFormat().AFDateFormat((String) null, "D", valueOf(str, true));
    }
}
