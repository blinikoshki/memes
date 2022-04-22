package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
final class zzd implements Runnable {
    private final /* synthetic */ LifecycleCallback zzbq;
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ zzc zzcc;

    zzd(zzc zzc, LifecycleCallback lifecycleCallback, String str) {
        this.zzcc = zzc;
        this.zzbq = lifecycleCallback;
        this.zzbr = str;
    }

    public final void run() {
        if (this.zzcc.zzbv > 0) {
            this.zzbq.onCreate(this.zzcc.zzbw != null ? this.zzcc.zzbw.getBundle(this.zzbr) : null);
        }
        if (this.zzcc.zzbv >= 2) {
            this.zzbq.onStart();
        }
        if (this.zzcc.zzbv >= 3) {
            this.zzbq.onResume();
        }
        if (this.zzcc.zzbv >= 4) {
            this.zzbq.onStop();
        }
        if (this.zzcc.zzbv >= 5) {
            this.zzbq.onDestroy();
        }
    }
}
