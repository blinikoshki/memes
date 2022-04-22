package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzfx implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgd zzc;

    zzfx(zzgd zzgd, zzas zzas, String str) {
        this.zzc = zzgd;
        this.zza = zzas;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzK();
        this.zzc.zza.zzz(this.zza, this.zzb);
    }
}
