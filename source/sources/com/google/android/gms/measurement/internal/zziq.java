package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zziq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzas zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjb zze;

    zziq(zzjb zzjb, boolean z, zzp zzp, boolean z2, zzas zzas, String str) {
        this.zze = zzjb;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzas;
        this.zzd = str;
    }

    public final void run() {
        zzas zzas;
        zzdz zzM = this.zze.zzb;
        if (zzM == null) {
            this.zze.zzx.zzat().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb = this.zze;
        if (this.zzb) {
            zzas = null;
        } else {
            zzas = this.zzc;
        }
        zzjb.zzk(zzM, zzas, this.zza);
        this.zze.zzP();
    }
}
