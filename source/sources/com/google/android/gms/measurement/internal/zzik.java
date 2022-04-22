package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzik implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjb zzc;

    zzik(zzjb zzjb, zzp zzp, Bundle bundle) {
        this.zzc = zzjb;
        this.zza = zzp;
        this.zzb = bundle;
    }

    public final void run() {
        zzdz zzM = this.zzc.zzb;
        if (zzM == null) {
            this.zzc.zzx.zzat().zzb().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzM.zzt(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzx.zzat().zzb().zzb("Failed to send default event parameters to service", e);
        }
    }
}
