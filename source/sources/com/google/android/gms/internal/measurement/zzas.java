package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzas extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzm zzd;
    final /* synthetic */ zzbr zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzbr zzbr, String str, String str2, boolean z, zzm zzm) {
        super(zzbr, true);
        this.zze = zzbr;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzm;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzk.getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zzb((Bundle) null);
    }
}
