package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzau extends zzbg {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzm zzb;
    final /* synthetic */ zzbr zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzbr zzbr, Bundle bundle, zzm zzm) {
        super(zzbr, true);
        this.zzc = zzbr;
        this.zza = bundle;
        this.zzb = zzm;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzk.performAction(this.zza, this.zzb, this.zzh);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzb.zzb((Bundle) null);
    }
}
