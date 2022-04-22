package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzaq extends zzbg {
    final /* synthetic */ zzm zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaq(zzbr zzbr, zzm zzm) {
        super(zzbr, true);
        this.zzb = zzbr;
        this.zza = zzm;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zzk.getCurrentScreenName(this.zza);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zzb((Bundle) null);
    }
}
