package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjh;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class AppMeasurementJobService extends JobService implements zzjg {
    private zzjh<AppMeasurementJobService> zza;

    private final zzjh<AppMeasurementJobService> zzd() {
        if (this.zza == null) {
            this.zza = new zzjh<>(this);
        }
        return this.zza;
    }

    public void onCreate() {
        super.onCreate();
        zzd().zza();
    }

    public void onDestroy() {
        zzd().zzb();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        zzd().zzh(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        zzd().zzg(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    public final void zzb(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzc(Intent intent) {
    }
}
