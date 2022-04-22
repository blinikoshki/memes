package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzgq implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhn zzb;

    zzgq(zzhn zzhn, boolean z) {
        this.zzb = zzhn;
        this.zza = z;
    }

    public final void run() {
        boolean zzF = this.zzb.zzx.zzF();
        boolean zzE = this.zzb.zzx.zzE();
        this.zzb.zzx.zzD(this.zza);
        if (zzE == this.zza) {
            this.zzb.zzx.zzat().zzk().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzx.zzF() == zzF || this.zzb.zzx.zzF() != this.zzb.zzx.zzE()) {
            this.zzb.zzx.zzat().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzF));
        }
        this.zzb.zzZ();
    }
}
