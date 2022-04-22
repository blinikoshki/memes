package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzih implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzs zzb;
    final /* synthetic */ zzjb zzc;

    zzih(zzjb zzjb, zzp zzp, zzs zzs) {
        this.zzc = zzjb;
        this.zza = zzp;
        this.zzb = zzs;
    }

    public final void run() {
        zzfl zzfl;
        String str = null;
        try {
            zzlc.zzb();
            if (!this.zzc.zzx.zzc().zzn((String) null, zzdw.zzaw) || this.zzc.zzx.zzd().zzi().zzh()) {
                zzdz zzM = this.zzc.zzb;
                if (zzM == null) {
                    this.zzc.zzx.zzat().zzb().zza("Failed to get app instance id");
                    zzfl = this.zzc.zzx;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzM.zzl(this.zza);
                    if (str != null) {
                        this.zzc.zzx.zzk().zzE(str);
                        this.zzc.zzx.zzd().zzj.zzb(str);
                    }
                    this.zzc.zzP();
                    zzfl = this.zzc.zzx;
                }
                zzfl.zzl().zzad(this.zzb, str);
            }
            this.zzc.zzx.zzat().zzh().zza("Analytics storage consent denied; will not get app instance id");
            this.zzc.zzx.zzk().zzE((String) null);
            this.zzc.zzx.zzd().zzj.zzb((String) null);
            zzfl = this.zzc.zzx;
            zzfl.zzl().zzad(this.zzb, str);
        } catch (RemoteException e) {
            this.zzc.zzx.zzat().zzb().zzb("Failed to get app instance id", e);
            zzfl = this.zzc.zzx;
        } catch (Throwable th) {
            this.zzc.zzx.zzl().zzad(this.zzb, (String) null);
            throw th;
        }
    }
}
