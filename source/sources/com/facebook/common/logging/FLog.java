package com.facebook.common.logging;

import java.util.Locale;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m85v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m86v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m87v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m88v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m89v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m77v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m78v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m79v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m80v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m77v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m81v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m91v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m92v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15544v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m83v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15543v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m84v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15544v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m90v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15544v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m82v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo15544v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m45d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m46d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m47d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m48d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m49d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m37d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m38d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m39d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m40d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m41d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m51d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m45d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m52d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m50d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m43d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15532d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m44d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15533d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m50d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15533d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m42d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo15533d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m69i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m70i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m71i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m72i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m73i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m61i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m62i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m63i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m64i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m65i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m75i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m76i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15538i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m67i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15537i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m68i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo15538i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m74i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15538i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m66i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo15538i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m97w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15545w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m93w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15545w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m99w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15545w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m100w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15546w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m95w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15545w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m96w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m94w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m98w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15546w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m94w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo15546w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m57e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15534e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m53e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15534e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m59e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15534e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m60e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15535e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m55e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15534e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m56e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15535e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m58e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15535e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m54e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo15535e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
