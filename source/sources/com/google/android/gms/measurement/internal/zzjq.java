package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzjq extends zzf {
    protected final zzjp zza = new zzjp(this);
    protected final zzjo zzb = new zzjo(this);
    protected final zzjm zzc = new zzjm(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzjq(zzfl zzfl) {
        super(zzfl);
    }

    static /* synthetic */ void zzh(zzjq zzjq, long j) {
        zzjq.zzg();
        zzjq.zzl();
        zzjq.zzx.zzat().zzk().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzjq.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            if (zzjq.zzx.zzc().zzt() || zzjq.zzx.zzd().zzq.zza()) {
                zzjq.zzb.zza(j);
            }
            zzjq.zzc.zza();
        } else {
            zzjq.zzc.zza();
            if (zzjq.zzx.zzc().zzt()) {
                zzjq.zzb.zza(j);
            }
        }
        zzjp zzjp = zzjq.zza;
        zzjp.zza.zzg();
        if (zzjp.zza.zzx.zzF()) {
            if (!zzjp.zza.zzx.zzc().zzn((String) null, zzdw.zzat)) {
                zzjp.zza.zzx.zzd().zzq.zzb(false);
            }
            zzjp.zzb(zzjp.zza.zzx.zzax().currentTimeMillis(), false);
        }
    }

    static /* synthetic */ void zzi(zzjq zzjq, long j) {
        zzjq.zzg();
        zzjq.zzl();
        zzjq.zzx.zzat().zzk().zzb("Activity paused, time", Long.valueOf(j));
        zzjq.zzc.zzb(j);
        if (zzjq.zzx.zzc().zzt()) {
            zzjq.zzb.zzb(j);
        }
        zzjp zzjp = zzjq.zza;
        if (!zzjp.zza.zzx.zzc().zzn((String) null, zzdw.zzat)) {
            zzjp.zza.zzx.zzd().zzq.zzb(true);
        }
    }

    /* access modifiers changed from: private */
    public final void zzl() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzl(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }
}
