package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfv implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgd zzb;

    zzfv(zzgd zzgd, zzp zzp) {
        this.zzb = zzgd;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzK();
        this.zzb.zza.zzu(this.zza);
    }
}
