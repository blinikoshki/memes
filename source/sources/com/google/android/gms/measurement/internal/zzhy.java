package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhy implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzib zzb;

    zzhy(zzib zzib, long j) {
        this.zzb = zzib;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzx.zzB().zzc(this.zza);
        this.zzb.zza = null;
    }
}
