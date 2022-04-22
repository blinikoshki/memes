package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrv */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzrv implements RemoteCall {
    private final zzrw zza;

    zzrv(zzrw zzrw) {
        this.zza = zzrw;
    }

    public final void accept(Object obj, Object obj2) {
        zzrw zzrw = this.zza;
        zzrw.zzv = new zzvb(zzrw, (TaskCompletionSource) obj2);
        ((zztr) obj).zzq().zzo(new zzmt(zzrw.zze.zzg()), zzrw.zzc);
    }
}
