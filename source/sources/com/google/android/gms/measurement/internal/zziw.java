package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zziw implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzja zzb;

    zziw(zzja zzja, ComponentName componentName) {
        this.zzb = zzja;
        this.zza = componentName;
    }

    public final void run() {
        zzjb.zzJ(this.zzb.zza, this.zza);
    }
}
