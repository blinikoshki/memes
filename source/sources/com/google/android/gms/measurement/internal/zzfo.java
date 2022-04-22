package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfo implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzgd zzb;

    zzfo(zzgd zzgd, zzaa zzaa) {
        this.zzb = zzgd;
        this.zza = zzaa;
    }

    public final void run() {
        this.zzb.zza.zzK();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzV(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
