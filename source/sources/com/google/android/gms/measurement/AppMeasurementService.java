package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjh;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class AppMeasurementService extends Service implements zzjg {
    private zzjh<AppMeasurementService> zza;

    private final zzjh<AppMeasurementService> zzd() {
        if (this.zza == null) {
            this.zza = new zzjh<>(this);
        }
        return this.zza;
    }

    public IBinder onBind(Intent intent) {
        return zzd().zze(intent);
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

    public int onStartCommand(Intent intent, int i, int i2) {
        zzd().zzc(intent, i, i2);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zzb(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzc(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
