package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzak implements Runnable {
    final /* synthetic */ zzgg zza;
    final /* synthetic */ zzal zzb;

    zzak(zzal zzal, zzgg zzgg) {
        this.zzb = zzal;
        this.zza = zzgg;
    }

    public final void run() {
        this.zza.zzas();
        if (zzz.zza()) {
            this.zza.zzau().zzh(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        long unused = this.zzb.zzd = 0;
        if (zzc) {
            this.zzb.zza();
        }
    }
}
