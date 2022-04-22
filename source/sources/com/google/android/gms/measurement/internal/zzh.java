package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
final class zzh implements Runnable {
    final /* synthetic */ zzs zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzs;
    }

    public final void run() {
        this.zzb.zza.zzy().zzx(this.zza);
    }
}
