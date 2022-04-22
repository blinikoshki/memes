package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzfk implements Runnable {
    final /* synthetic */ zzgn zza;
    final /* synthetic */ zzfl zzb;

    zzfk(zzfl zzfl, zzgn zzgn) {
        this.zzb = zzfl;
        this.zza = zzgn;
    }

    public final void run() {
        zzfl.zzO(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
