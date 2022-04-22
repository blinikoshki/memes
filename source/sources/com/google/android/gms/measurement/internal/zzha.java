package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzha implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzhn zzd;

    zzha(zzhn zzhn, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzd = zzhn;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void run() {
        this.zzd.zzx.zzy().zzn(this.zza, (String) null, this.zzb, this.zzc);
    }
}
