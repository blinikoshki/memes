package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final /* synthetic */ class zzgp implements Runnable {
    private final zzhn zza;

    zzgp(zzhn zzhn) {
        this.zza = zzhn;
    }

    public final void run() {
        zzhn zzhn = this.zza;
        zzhn.zzg();
        if (!zzhn.zzx.zzd().zzr.zza()) {
            long zza2 = zzhn.zzx.zzd().zzs.zza();
            zzhn.zzx.zzd().zzs.zzb(1 + zza2);
            zzhn.zzx.zzc();
            if (zza2 >= 5) {
                zzhn.zzx.zzat().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhn.zzx.zzd().zzr.zzb(true);
                return;
            }
            zzhn.zzx.zzM();
            return;
        }
        zzhn.zzx.zzat().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
