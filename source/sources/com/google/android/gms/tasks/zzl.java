package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzl implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzk zzb;

    zzl(zzk zzk, Task task) {
        this.zzb = zzk;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onFailure(this.zza.getException());
            }
        }
    }
}
