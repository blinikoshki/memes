package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;
import androidx.core.p006os.BuildCompat;
import com.appsflyer.internal.referrer.Payload;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class PlatformVersion {
    private static Boolean zzhu;

    private PlatformVersion() {
    }

    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwichMR1() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean isAtLeastJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isAtLeastJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean isAtLeastJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean isAtLeastKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean isAtLeastKitKatWatch() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean isAtLeastLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isAtLeastLollipopMR1() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isAtLeastR() {
        boolean z = false;
        if (!isAtLeastQ()) {
            return false;
        }
        if (!(BuildCompat.isAtLeastR() || (Build.VERSION.CODENAME.equals("REL") && Build.VERSION.SDK_INT >= 30) || (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z'))) {
            return false;
        }
        Boolean bool = zzhu;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if (Payload.SOURCE_GOOGLE.equals(Build.BRAND) && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 5954562) {
                z = true;
            }
            zzhu = Boolean.valueOf(z);
        } catch (NumberFormatException unused) {
            zzhu = true;
        }
        if (!zzhu.booleanValue()) {
            Log.w("PlatformVersion", "Build version must be at least 5954562 to support R in gmscore");
        }
        return zzhu.booleanValue();
    }
}
