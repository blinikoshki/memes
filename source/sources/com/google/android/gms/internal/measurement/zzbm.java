package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
final class zzbm extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbq zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbm(zzbq zzbq, Activity activity) {
        super(zzbq.zza, true);
        this.zzb = zzbq;
        this.zza = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzb.zza.zzk.onActivityPaused(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
