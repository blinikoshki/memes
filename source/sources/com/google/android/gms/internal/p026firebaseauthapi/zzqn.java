package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzqn implements RemoteCall {
    private final zzqo zza;

    zzqn(zzqo zzqo) {
        this.zza = zzqo;
    }

    public final void accept(Object obj, Object obj2) {
        zzqo zzqo = this.zza;
        zzqo.zzv = new zzvb(zzqo, (TaskCompletionSource) obj2);
        ((zztr) obj).zzq().zzq(new zzmd(zzqo.zze.zzg()), zzqo.zzc);
    }
}
