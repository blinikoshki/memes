package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzii implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjb zzb;

    zzii(zzjb zzjb, zzp zzp) {
        this.zzb = zzjb;
        this.zza = zzp;
    }

    public final void run() {
        zzdz zzM = this.zzb.zzb;
        if (zzM == null) {
            this.zzb.zzx.zzat().zzb().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzM.zzf(this.zza);
            this.zzb.zzx.zzn().zzn();
            this.zzb.zzk(zzM, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send app launch to the service", e);
        }
    }
}
