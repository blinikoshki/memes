package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzgs implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhn zzb;

    zzgs(zzhn zzhn, long j) {
        this.zzb = zzhn;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzx.zzd().zzk.zzb(this.zza);
        this.zzb.zzx.zzat().zzj().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
