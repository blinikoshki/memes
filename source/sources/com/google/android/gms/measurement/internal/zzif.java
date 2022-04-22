package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzif implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjb zzb;

    zzif(zzjb zzjb, zzp zzp) {
        this.zzb = zzjb;
        this.zza = zzp;
    }

    public final void run() {
        zzdz zzM = this.zzb.zzb;
        if (zzM == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzM.zzs(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzP();
    }
}
