package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
final class zzep implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzeq zzb;

    zzep(zzeq zzeq, boolean z) {
        this.zzb = zzeq;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zzZ(this.zza);
    }
}
