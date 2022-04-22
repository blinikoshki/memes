package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzix implements Runnable {
    final /* synthetic */ zzdz zza;
    final /* synthetic */ zzja zzb;

    zzix(zzja zzja, zzdz zzdz) {
        this.zzb = zzja;
        this.zza = zzdz;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzh()) {
                this.zzb.zza.zzx.zzat().zzj().zza("Connected to remote service");
                this.zzb.zza.zzE(this.zza);
            }
        }
    }
}
