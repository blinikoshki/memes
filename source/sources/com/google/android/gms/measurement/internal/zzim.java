package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzim implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzs zzc;
    final /* synthetic */ zzjb zzd;

    zzim(zzjb zzjb, zzas zzas, String str, zzs zzs) {
        this.zzd = zzjb;
        this.zza = zzas;
        this.zzb = str;
        this.zzc = zzs;
    }

    public final void run() {
        zzfl zzfl;
        byte[] bArr = null;
        try {
            zzdz zzM = this.zzd.zzb;
            if (zzM == null) {
                this.zzd.zzx.zzat().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzfl = this.zzd.zzx;
            } else {
                bArr = zzM.zzj(this.zza, this.zzb);
                this.zzd.zzP();
                zzfl = this.zzd.zzx;
            }
        } catch (RemoteException e) {
            this.zzd.zzx.zzat().zzb().zzb("Failed to send event to the service to bundle", e);
            zzfl = this.zzd.zzx;
        } catch (Throwable th) {
            this.zzd.zzx.zzl().zzag(this.zzc, bArr);
            throw th;
        }
        zzfl.zzl().zzag(this.zzc, bArr);
    }
}
