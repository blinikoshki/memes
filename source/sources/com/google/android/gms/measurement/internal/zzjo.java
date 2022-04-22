package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzlx;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzjo {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzjq zzc;
    private final zzal zzd;

    public zzjo(zzjq zzjq) {
        this.zzc = zzjq;
        this.zzd = new zzjn(this, zzjq.zzx);
        long elapsedRealtime = zzjq.zzx.zzax().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd.zzd();
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zzb();
        zzlx.zzb();
        if (!this.zzc.zzx.zzc().zzn((String) null, zzdw.zzao)) {
            this.zzc.zzx.zzd().zzo.zzb(this.zzc.zzx.zzax().currentTimeMillis());
        } else if (this.zzc.zzx.zzF()) {
            this.zzc.zzx.zzd().zzo.zzb(this.zzc.zzx.zzax().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            this.zzc.zzx.zzat().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzib.zzm(this.zzc.zzx.zzx().zzh(!this.zzc.zzx.zzc().zzt()), bundle, true);
            if (!this.zzc.zzx.zzc().zzn((String) null, zzdw.zzT) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzc.zzx.zzc().zzn((String) null, zzdw.zzT) || !z2) {
                this.zzc.zzx.zzk().zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzd.zzd();
            this.zzd.zzb(DateUtils.MILLIS_PER_HOUR);
            return true;
        }
        this.zzc.zzx.zzat().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
