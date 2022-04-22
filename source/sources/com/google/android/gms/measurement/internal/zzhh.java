package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhh implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhn zzb;

    zzhh(zzhn zzhn, Boolean bool) {
        this.zzb = zzhn;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzY(this.zza, true);
    }
}
