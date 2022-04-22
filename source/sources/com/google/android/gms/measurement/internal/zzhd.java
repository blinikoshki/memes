package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhd implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzhn zzb;

    zzhd(zzhn zzhn, AtomicReference atomicReference) {
        this.zzb = zzhn;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(this.zzb.zzx.zzc().zzi(this.zzb.zzx.zzA().zzi(), zzdw.zzK));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
