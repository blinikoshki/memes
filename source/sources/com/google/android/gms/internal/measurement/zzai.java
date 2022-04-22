package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzai extends zzbg {
    final /* synthetic */ zzbr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzbr zzbr) {
        super(zzbr, true);
        this.zza = zzbr;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zza.zzk.resetAnalyticsData(this.zzh);
    }
}
