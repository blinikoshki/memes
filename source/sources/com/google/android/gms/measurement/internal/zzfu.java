package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfu implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgd zzb;

    zzfu(zzgd zzgd, zzp zzp) {
        this.zzb = zzgd;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzK();
        this.zzb.zza.zzt(this.zza);
    }
}
