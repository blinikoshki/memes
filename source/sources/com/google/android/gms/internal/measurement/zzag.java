package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzag extends zzbg {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzbr zzbr, Bundle bundle) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zzk.setConsent(this.zza, this.zzh);
    }
}
