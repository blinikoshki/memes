package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzgw implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhn zzb;

    zzgw(zzhn zzhn, long j) {
        this.zzb = zzhn;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzG(this.zza, true);
        this.zzb.zzx.zzy().zzv(new AtomicReference());
    }
}
