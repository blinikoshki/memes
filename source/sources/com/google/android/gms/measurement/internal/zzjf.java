package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzjf implements Runnable {
    final /* synthetic */ zzkd zza;
    final /* synthetic */ Runnable zzb;

    zzjf(zzjh zzjh, zzkd zzkd, Runnable runnable) {
        this.zza = zzkd;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzK();
        this.zza.zzJ(this.zzb);
        this.zza.zzF();
    }
}
