package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzgv implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzhn zzc;

    zzgv(zzhn zzhn, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhn;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzx.zzy().zzt(this.zza, this.zzb);
    }
}
