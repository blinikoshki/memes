package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfz implements Runnable {
    final /* synthetic */ zzkg zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfz(zzgd zzgd, zzkg zzkg, zzp zzp) {
        this.zzc = zzgd;
        this.zza = zzkg;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzK();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzN(this.zza, this.zzb);
        }
    }
}
