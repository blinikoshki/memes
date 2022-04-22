package com.google.android.gms.internal.measurement;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzej {
    private static volatile boolean zza = (!zza());

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
