package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzaz extends zzbg {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzbr zzbr, boolean z) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = z;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zzk.setDataCollectionEnabled(this.zza);
    }
}
