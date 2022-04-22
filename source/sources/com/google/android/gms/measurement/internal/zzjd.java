package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final /* synthetic */ class zzjd implements Runnable {
    private final zzjh zza;
    private final int zzb;
    private final zzei zzc;
    private final Intent zzd;

    zzjd(zzjh zzjh, int i, zzei zzei, Intent intent) {
        this.zza = zzjh;
        this.zzb = i;
        this.zzc = zzei;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}
