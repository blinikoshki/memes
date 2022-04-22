package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdj;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzkc {
    zzdj zza;
    List<Long> zzb;
    List<zzdb> zzc;
    long zzd;
    final /* synthetic */ zzkd zze;

    /* synthetic */ zzkc(zzkd zzkd, zzjw zzjw) {
        this.zze = zzkd;
    }

    private static final long zzb(zzdb zzdb) {
        return ((zzdb.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzdb zzdb) {
        Preconditions.checkNotNull(zzdb);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.size() > 0 && zzb(this.zzc.get(0)) != zzb(zzdb)) {
            return false;
        }
        long zzbw = this.zzd + ((long) zzdb.zzbw());
        this.zze.zzd();
        if (zzbw >= ((long) Math.max(0, zzdw.zzh.zzb(null).intValue()))) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzdb);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzd();
        if (size >= Math.max(1, zzdw.zzi.zzb(null).intValue())) {
            return false;
        }
        return true;
    }
}
