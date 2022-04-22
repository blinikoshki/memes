package com.google.android.gms.internal.common;

import android.content.Context;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zzl {
    private static volatile boolean zzjs = (!zzam());
    private static boolean zzjt = false;

    public static boolean zzam() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static Context getDeviceProtectedStorageContext(Context context) {
        if (context.isDeviceProtectedStorage()) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }
}
