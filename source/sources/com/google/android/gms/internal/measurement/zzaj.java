package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzaj extends zzbg {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzbr zzbr, long j) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = j;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zzk.setSessionTimeoutDuration(this.zza);
    }
}
