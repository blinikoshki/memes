package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzjj implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzjq zzb;

    zzjj(zzjq zzjq, long j) {
        this.zzb = zzjq;
        this.zza = j;
    }

    public final void run() {
        zzjq.zzi(this.zzb, this.zza);
    }
}
