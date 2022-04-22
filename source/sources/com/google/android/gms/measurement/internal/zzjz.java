package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzjz implements Callable<String> {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzkd zzb;

    zzjz(zzkd zzkd, zzp zzp) {
        this.zzb = zzkd;
        this.zza = zzp;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlc.zzb();
        if (!this.zzb.zzd().zzn((String) null, zzdw.zzay) || (this.zzb.zzx(this.zza.zza).zzh() && zzaf.zzc(this.zza.zzv).zzh())) {
            return this.zzb.zzX(this.zza).zzd();
        }
        this.zzb.zzat().zzk().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
