package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
final class zzhw implements Runnable {
    final /* synthetic */ zzhu zza;
    final /* synthetic */ zzhu zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzib zze;

    zzhw(zzib zzib, zzhu zzhu, zzhu zzhu2, long j, boolean z) {
        this.zze = zzib;
        this.zza = zzhu;
        this.zzb = zzhu2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
