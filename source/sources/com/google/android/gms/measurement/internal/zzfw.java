package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfw implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfw(zzgd zzgd, zzas zzas, zzp zzp) {
        this.zzc = zzgd;
        this.zza = zzas;
        this.zzb = zzp;
    }

    public final void run() {
        zzas zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzK();
        this.zzc.zza.zzB(zzb2, this.zzb);
    }
}
