package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzm implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzn zzb;

    zzm(zzn zzn, Task task) {
        this.zzb = zzn;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
