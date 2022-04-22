package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzi implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzj zzb;

    zzi(zzj zzj, Task task) {
        this.zzb = zzj;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onComplete(this.zza);
            }
        }
    }
}
