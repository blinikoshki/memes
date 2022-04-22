package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzjw implements Runnable {
    final /* synthetic */ zzke zza;
    final /* synthetic */ zzkd zzb;

    zzjw(zzkd zzkd, zzke zzke) {
        this.zzb = zzkd;
        this.zza = zzke;
    }

    public final void run() {
        zzkd.zzaa(this.zzb, this.zza);
        this.zzb.zzc();
    }
}
