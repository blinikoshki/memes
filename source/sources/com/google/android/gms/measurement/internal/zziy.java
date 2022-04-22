package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zziy implements Runnable {
    final /* synthetic */ zzja zza;

    zziy(zzja zzja) {
        this.zza = zzja;
    }

    public final void run() {
        zzjb zzjb = this.zza.zza;
        Context zzaw = zzjb.zzx.zzaw();
        this.zza.zza.zzx.zzas();
        zzjb.zzJ(zzjb, new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
