package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhz implements Runnable {
    final /* synthetic */ zzhu zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzib zzc;

    zzhz(zzib zzib, zzhu zzhu, long j) {
        this.zzc = zzib;
        this.zza = zzhu;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzib zzib = this.zzc;
        zzib.zza = null;
        zzib.zzx.zzy().zzz((zzhu) null);
    }
}
