package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
final class zza implements Runnable {
    private final /* synthetic */ LifecycleCallback zzbq;
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ zzb zzbs;

    zza(zzb zzb, LifecycleCallback lifecycleCallback, String str) {
        this.zzbs = zzb;
        this.zzbq = lifecycleCallback;
        this.zzbr = str;
    }

    public final void run() {
        if (this.zzbs.zzbv > 0) {
            this.zzbq.onCreate(this.zzbs.zzbw != null ? this.zzbs.zzbw.getBundle(this.zzbr) : null);
        }
        if (this.zzbs.zzbv >= 2) {
            this.zzbq.onStart();
        }
        if (this.zzbs.zzbv >= 3) {
            this.zzbq.onResume();
        }
        if (this.zzbs.zzbv >= 4) {
            this.zzbq.onStop();
        }
        if (this.zzbs.zzbv >= 5) {
            this.zzbq.onDestroy();
        }
    }
}
