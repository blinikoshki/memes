package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzjl implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjm zzc;

    zzjl(zzjm zzjm, long j, long j2) {
        this.zzc = zzjm;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzx.zzau().zzh(new zzjk(this));
    }
}
