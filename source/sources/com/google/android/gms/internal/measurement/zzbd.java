package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzbd extends zzbg {
    final /* synthetic */ zzbi zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbd(zzbr zzbr, zzbi zzbi) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = zzbi;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zzk.unregisterOnMeasurementEventListener(this.zza);
    }
}
