package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.work.PeriodicWorkRequest;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.security.CertificateUtil;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

class SessionLogger {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 1800000, DateUtils.MILLIS_PER_HOUR, 21600000, 43200000, DateUtils.MILLIS_PER_DAY, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String PACKAGE_CHECKSUM = "PCKGCHKSUM";
    private static final String TAG = "com.facebook.appevents.internal.SessionLogger";

    SessionLogger() {
    }

    static void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo2);
        bundle.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, computePackageChecksum(context));
        bundle.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, (AccessToken) null);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
        if (InternalAppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
    }

    static void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        if (sessionInfo != null) {
            Long valueOf = Long.valueOf(sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue());
            if (valueOf.longValue() < 0) {
                valueOf = 0L;
                logClockSkewEvent();
            }
            Long valueOf2 = Long.valueOf(sessionInfo.getSessionLength());
            if (valueOf2.longValue() < 0) {
                logClockSkewEvent();
                valueOf2 = 0L;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
            bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(getQuantaIndex(valueOf.longValue()))}));
            SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
            bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, sessionInfo.getSessionLastEventTime().longValue() / 1000);
            new InternalAppEventsLogger(str, str2, (AccessToken) null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, ((double) valueOf2.longValue()) / 1000.0d, bundle);
        }
    }

    private static void logClockSkewEvent() {
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    private static String computePackageChecksum(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            SharedPreferences sharedPreferences = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
            String string = sharedPreferences.getString(str, (String) null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String computeChecksum = HashUtils.computeChecksum(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
            sharedPreferences.edit().putString(str, computeChecksum).apply();
            return computeChecksum;
        } catch (Exception unused) {
            return null;
        }
    }
}
