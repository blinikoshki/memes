package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzh implements Runnable {
    private final /* synthetic */ zzf zza;

    zzh(zzf zzf) {
        this.zza = zzf;
    }

    public final void run() {
        synchronized (this.zza.zzb) {
            if (this.zza.zzc != null) {
                this.zza.zzc.onCanceled();
            }
        }
    }
}
