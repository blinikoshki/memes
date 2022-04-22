package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final /* synthetic */ class zzje implements Runnable {
    private final zzjh zza;
    private final zzei zzb;
    private final JobParameters zzc;

    zzje(zzjh zzjh, zzei zzei, JobParameters jobParameters) {
        this.zza = zzjh;
        this.zzb = zzei;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
