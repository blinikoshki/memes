package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final /* synthetic */ class zzsr implements RemoteCall {
    private final zzss zza;

    zzsr(zzss zzss) {
        this.zza = zzss;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztr) obj, (TaskCompletionSource) obj2);
    }
}