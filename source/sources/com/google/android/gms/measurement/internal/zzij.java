package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzij implements Runnable {
    final /* synthetic */ zzhu zza;
    final /* synthetic */ zzjb zzb;

    zzij(zzjb zzjb, zzhu zzhu) {
        this.zzb = zzjb;
        this.zza = zzhu;
    }

    public final void run() {
        zzdz zzM = this.zzb.zzb;
        if (zzM == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzhu zzhu = this.zza;
            if (zzhu == null) {
                zzM.zzk(0, (String) null, (String) null, this.zzb.zzx.zzaw().getPackageName());
            } else {
                zzM.zzk(zzhu.zzc, zzhu.zza, zzhu.zzb, this.zzb.zzx.zzaw().getPackageName());
            }
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send current screen to the service", e);
        }
    }
}
