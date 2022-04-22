package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzir implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;
    final /* synthetic */ zzaa zzd;
    final /* synthetic */ zzjb zze;

    zzir(zzjb zzjb, boolean z, zzp zzp, boolean z2, zzaa zzaa, zzaa zzaa2) {
        this.zze = zzjb;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzaa;
        this.zzd = zzaa2;
    }

    public final void run() {
        zzaa zzaa;
        zzdz zzM = this.zze.zzb;
        if (zzM == null) {
            this.zze.zzx.zzat().zzb().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb = this.zze;
        if (this.zzb) {
            zzaa = null;
        } else {
            zzaa = this.zzc;
        }
        zzjb.zzk(zzM, zzaa, this.zza);
        this.zze.zzP();
    }
}
