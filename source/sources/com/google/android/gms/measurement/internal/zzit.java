package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzit implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ zzs zzd;
    final /* synthetic */ zzjb zze;

    zzit(zzjb zzjb, String str, String str2, zzp zzp, zzs zzs) {
        this.zze = zzjb;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = zzs;
    }

    public final void run() {
        zzfl zzfl;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzdz zzM = this.zze.zzb;
            if (zzM == null) {
                this.zze.zzx.zzat().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzfl = this.zze.zzx;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzkk.zzak(zzM.zzq(this.zza, this.zzb, this.zzc));
                this.zze.zzP();
                zzfl = this.zze.zzx;
            }
        } catch (RemoteException e) {
            this.zze.zzx.zzat().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            zzfl = this.zze.zzx;
        } catch (Throwable th) {
            this.zze.zzx.zzl().zzaj(this.zzd, arrayList);
            throw th;
        }
        zzfl.zzl().zzaj(this.zzd, arrayList);
    }
}
