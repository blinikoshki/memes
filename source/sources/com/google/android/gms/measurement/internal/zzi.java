package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
final class zzi implements Runnable {
    final /* synthetic */ zzs zza;
    final /* synthetic */ zzas zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs, zzas zzas, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzs;
        this.zzb = zzas;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzy().zzG(this.zza, this.zzb, this.zzc);
    }
}
