package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzjg;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzjh<T extends Context & zzjg> {
    private final T zza;

    public zzjh(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    private final zzei zzk() {
        return zzfl.zzC(this.zza, (zzy) null, (Long) null).zzat();
    }

    public final void zza() {
        zzfl zzC = zzfl.zzC(this.zza, (zzy) null, (Long) null);
        zzei zzat = zzC.zzat();
        zzC.zzas();
        zzat.zzk().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzfl zzC = zzfl.zzC(this.zza, (zzy) null, (Long) null);
        zzei zzat = zzC.zzat();
        zzC.zzas();
        zzat.zzk().zza("Local AppMeasurementService is shutting down");
    }

    public final int zzc(Intent intent, int i, int i2) {
        zzfl zzC = zzfl.zzC(this.zza, (zzy) null, (Long) null);
        zzei zzat = zzC.zzat();
        if (intent == null) {
            zzat.zze().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzC.zzas();
        zzat.zzk().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzd(new zzjd(this, i2, zzat, intent));
        }
        return 2;
    }

    public final void zzd(Runnable runnable) {
        zzkd zza2 = zzkd.zza(this.zza);
        zza2.zzau().zzh(new zzjf(this, zza2, runnable));
    }

    public final IBinder zze(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgd(zzkd.zza(this.zza), (String) null);
        }
        zzk().zze().zzb("onBind received unknown action", action);
        return null;
    }

    public final boolean zzf(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzk().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zzg(JobParameters jobParameters) {
        zzfl zzC = zzfl.zzC(this.zza, (zzy) null, (Long) null);
        zzei zzat = zzC.zzat();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        zzC.zzas();
        zzat.zzk().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzd(new zzje(this, zzat, jobParameters));
        return true;
    }

    public final void zzh(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onRebind called with null intent");
            return;
        }
        zzk().zzk().zzb("onRebind called. action", intent.getAction());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzei zzei, JobParameters jobParameters) {
        zzei.zzk().zza("AppMeasurementJobService processed last upload request.");
        ((zzjg) this.zza).zzb(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, zzei zzei, Intent intent) {
        if (((zzjg) this.zza).zza(i)) {
            zzei.zzk().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzk().zzk().zza("Completed wakeful intent.");
            ((zzjg) this.zza).zzc(intent);
        }
    }
}
