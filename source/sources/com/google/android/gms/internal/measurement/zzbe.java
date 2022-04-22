package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzbe extends zzbg {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzbr zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzbr zzbr, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzbr, true);
        this.zzg = zzbr;
        this.zza = l;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        Long l = this.zza;
        this.zzg.zzk.logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l == null ? this.zzh : l.longValue());
    }
}
