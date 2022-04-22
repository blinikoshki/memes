package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final /* synthetic */ class zzjk implements Runnable {
    private final zzjl zza;

    zzjk(zzjl zzjl) {
        this.zza = zzjl;
    }

    public final void run() {
        zzjl zzjl = this.zza;
        zzjm zzjm = zzjl.zzc;
        long j = zzjl.zza;
        long j2 = zzjl.zzb;
        zzjm.zza.zzg();
        zzjm.zza.zzx.zzat().zzj().zza("Application going to the background");
        boolean z = true;
        if (zzjm.zza.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            zzjm.zza.zzx.zzd().zzq.zzb(true);
        }
        Bundle bundle = new Bundle();
        if (!zzjm.zza.zzx.zzc().zzt()) {
            zzjm.zza.zzb.zzb(j2);
            if (zzjm.zza.zzx.zzc().zzn((String) null, zzdw.zzak)) {
                zzjo zzjo = zzjm.zza.zzb;
                long j3 = zzjo.zzb;
                zzjo.zzb = j2;
                bundle.putLong("_et", j2 - j3);
                zzib.zzm(zzjm.zza.zzx.zzx().zzh(true), bundle, true);
            } else {
                z = false;
            }
            zzjm.zza.zzb.zzd(false, z, j2);
        }
        zzjm.zza.zzx.zzk().zzt(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
    }
}
