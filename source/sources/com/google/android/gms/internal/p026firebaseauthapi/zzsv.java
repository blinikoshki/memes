package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsv */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzsv implements RemoteCall {
    private final zzsw zza;

    zzsv(zzsw zzsw) {
        this.zza = zzsw;
    }

    public final void accept(Object obj, Object obj2) {
        zzsw zzsw = this.zza;
        zzsw.zzv = new zzvb(zzsw, (TaskCompletionSource) obj2);
        ((zztr) obj).zzq().zzm(new zznv(zzsw.zze.zzg()), zzsw.zzc);
    }
}
