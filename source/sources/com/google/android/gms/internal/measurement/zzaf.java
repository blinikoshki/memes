package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzaf extends zzbg {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaf(zzbr zzbr, Boolean bool) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = bool;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        if (this.zza != null) {
            this.zzb.zzk.setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            this.zzb.zzk.clearMeasurementEnabled(this.zzh);
        }
    }
}
