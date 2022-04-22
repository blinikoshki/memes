package com.google.android.gms.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zza {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzhc;
    private static float zzhd = Float.NaN;

    public static int zzg(Context context) {
        int i;
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
        int i2 = 0;
        if (registerReceiver == null) {
            i = 0;
        } else {
            i = registerReceiver.getIntExtra("plugged", 0);
        }
        int i3 = 3;
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            i3 = 7;
        }
        int i4 = (i & i3) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i2 = 2;
        }
        return i2 | i4;
    }

    public static synchronized float zzh(Context context) {
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - zzhc >= 60000 || Float.isNaN(zzhd)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
                if (registerReceiver != null) {
                    zzhd = ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzhc = SystemClock.elapsedRealtime();
                float f = zzhd;
                return f;
            }
            float f2 = zzhd;
            return f2;
        }
    }
}
