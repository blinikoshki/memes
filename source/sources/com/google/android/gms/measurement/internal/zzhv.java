package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhv implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhu zzb;
    final /* synthetic */ zzhu zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzib zze;

    zzhv(zzib zzib, Bundle bundle, zzhu zzhu, zzhu zzhu2, long j) {
        this.zze = zzib;
        this.zza = bundle;
        this.zzb = zzhu;
        this.zzc = zzhu2;
        this.zzd = j;
    }

    public final void run() {
        zzib.zzu(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
