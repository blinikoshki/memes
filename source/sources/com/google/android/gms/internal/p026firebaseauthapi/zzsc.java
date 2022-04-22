package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzsc extends zzvc<Void, zzg> {
    private final zznb zza;

    public zzsc(String str) {
        super(9);
        this.zza = new zznb(str);
    }

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zzsb(this)).build();
    }

    public final void zzc() {
        zzj(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzy(this.zza, this.zzc);
    }
}
