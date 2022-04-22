package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfn implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfn(zzgd zzgd, zzaa zzaa, zzp zzp) {
        this.zzc = zzgd;
        this.zza = zzaa;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzK();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzW(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzU(this.zza, this.zzb);
        }
    }
}
