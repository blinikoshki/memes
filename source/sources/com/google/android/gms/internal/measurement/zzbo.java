package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzbo extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzm zzb;
    final /* synthetic */ zzbq zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbo(zzbq zzbq, Activity activity, zzm zzm) {
        super(zzbq.zza, true);
        this.zzc = zzbq;
        this.zza = activity;
        this.zzb = zzm;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zza.zzk.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zza), this.zzb, this.zzi);
    }
}
