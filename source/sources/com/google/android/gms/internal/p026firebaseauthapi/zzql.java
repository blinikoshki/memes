package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzql */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzql implements RemoteCall {
    private final zzqm zza;

    zzql(zzqm zzqm) {
        this.zza = zzqm;
    }

    public final void accept(Object obj, Object obj2) {
        zzqm zzqm = this.zza;
        zzqm.zzv = new zzvb(zzqm, (TaskCompletionSource) obj2);
        ((zztr) obj).zzq().zzh(zzqm.zza, zzqm.zzc);
    }
}
