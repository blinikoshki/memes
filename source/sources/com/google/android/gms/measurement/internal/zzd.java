package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzd extends zze {
    private final Map<String, Long> zza = new ArrayMap();
    private final Map<String, Integer> zzb = new ArrayMap();
    private long zzc;

    public zzd(zzfl zzfl) {
        super(zzfl);
    }

    static /* synthetic */ void zzd(zzd zzd, String str, long j) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzd.zzb.isEmpty()) {
            zzd.zzc = j;
        }
        Integer num = zzd.zzb.get(str);
        if (num != null) {
            zzd.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzd.zzb.size() >= 100) {
            zzd.zzx.zzat().zze().zza("Too many ads visible");
        } else {
            zzd.zzb.put(str, 1);
            zzd.zza.put(str, Long.valueOf(j));
        }
    }

    static /* synthetic */ void zze(zzd zzd, String str, long j) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = zzd.zzb.get(str);
        if (num != null) {
            zzhu zzh = zzd.zzx.zzx().zzh(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzd.zzb.remove(str);
                Long l = zzd.zza.get(str);
                if (l == null) {
                    zzd.zzx.zzat().zzb().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = l.longValue();
                    zzd.zza.remove(str);
                    zzd.zzi(str, j - longValue, zzh);
                }
                if (zzd.zzb.isEmpty()) {
                    long j2 = zzd.zzc;
                    if (j2 == 0) {
                        zzd.zzx.zzat().zzb().zza("First ad exposure time was never set");
                        return;
                    }
                    zzd.zzh(j - j2, zzh);
                    zzd.zzc = 0;
                    return;
                }
                return;
            }
            zzd.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzd.zzx.zzat().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void zzh(long j, zzhu zzhu) {
        if (zzhu == null) {
            this.zzx.zzat().zzk().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            this.zzx.zzat().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzib.zzm(zzhu, bundle, true);
            this.zzx.zzk().zzs("am", "_xa", bundle);
        }
    }

    private final void zzi(String str, long j, zzhu zzhu) {
        if (zzhu == null) {
            this.zzx.zzat().zzk().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            this.zzx.zzat().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzib.zzm(zzhu, bundle, true);
            this.zzx.zzk().zzs("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(long j) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzx.zzat().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzx.zzau().zzh(new zza(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzx.zzat().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzx.zzau().zzh(new zzb(this, str, j));
        }
    }

    public final void zzc(long j) {
        zzhu zzh = this.zzx.zzx().zzh(false);
        for (String next : this.zza.keySet()) {
            zzi(next, j - this.zza.get(next).longValue(), zzh);
        }
        if (!this.zza.isEmpty()) {
            zzh(j - this.zzc, zzh);
        }
        zzj(j);
    }
}
