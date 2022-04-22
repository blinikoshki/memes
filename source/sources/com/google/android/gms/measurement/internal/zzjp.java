package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzll;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzjp {
    final /* synthetic */ zzjq zza;

    zzjp(zzjq zzjq) {
        this.zza = zzjq;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzx.zzd().zzl(this.zza.zzx.zzax().currentTimeMillis())) {
            this.zza.zzx.zzd().zzl.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzx.zzat().zzk().zza("Detected application was in foreground");
                zzc(this.zza.zzx.zzax().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzl();
        if (this.zza.zzx.zzd().zzl(j)) {
            this.zza.zzx.zzd().zzl.zzb(true);
        }
        this.zza.zzx.zzd().zzo.zzb(j);
        if (this.zza.zzx.zzd().zzl.zza()) {
            zzc(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzx.zzF()) {
            this.zza.zzx.zzd().zzo.zzb(j);
            this.zza.zzx.zzat().zzk().zzb("Session started, time", Long.valueOf(this.zza.zzx.zzax().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzx.zzk().zzB(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            this.zza.zzx.zzd().zzl.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzx.zzc().zzn((String) null, zzdw.zzai) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzx.zzk().zzt(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            zzll.zzb();
            if (this.zza.zzx.zzc().zzn((String) null, zzdw.zzan)) {
                String zza2 = this.zza.zzx.zzd().zzt.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza2);
                    this.zza.zzx.zzk().zzt(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
                }
            }
        }
    }
}
