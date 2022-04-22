package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* renamed from: com.appsflyer.internal.w */
public final class C1084w {
    private static String $$b;
    private static String AFDateFormat;

    C1084w() {
    }

    public static void $$b(String str) {
        AFDateFormat = str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                sb.append(str.charAt(i));
            } else {
                sb.append("*");
            }
        }
        $$b = sb.toString();
    }

    public static void valueOf(String str) {
        if (AFDateFormat == null) {
            $$b(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = AFDateFormat;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, $$b));
        }
    }
}
