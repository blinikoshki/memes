package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzay extends zzbg {
    final /* synthetic */ zzm zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzbr zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(zzbr zzbr, zzm zzm, int i) {
        super(zzbr, true);
        this.zzc = zzbr;
        this.zza = zzm;
        this.zzb = i;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzk.getTestFlag(this.zza, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zzb((Bundle) null);
    }
}
