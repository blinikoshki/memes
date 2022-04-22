package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzgc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgd zze;

    zzgc(zzgd zzgd, String str, String str2, String str3, long j) {
        this.zze = zzgd;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzR().zzx().zzn(this.zzb, (zzhu) null);
            return;
        }
        this.zze.zza.zzR().zzx().zzn(this.zzb, new zzhu(this.zzc, str, this.zzd));
    }
}
