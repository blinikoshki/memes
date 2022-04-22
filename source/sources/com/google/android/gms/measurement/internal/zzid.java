package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzid implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzkg zzc;
    final /* synthetic */ zzjb zzd;

    zzid(zzjb zzjb, zzp zzp, boolean z, zzkg zzkg) {
        this.zzd = zzjb;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzkg;
    }

    public final void run() {
        zzkg zzkg;
        zzdz zzM = this.zzd.zzb;
        if (zzM == null) {
            this.zzd.zzx.zzat().zzb().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb = this.zzd;
        if (this.zzb) {
            zzkg = null;
        } else {
            zzkg = this.zzc;
        }
        zzjb.zzk(zzM, zzkg, this.zza);
        this.zzd.zzP();
    }
}
