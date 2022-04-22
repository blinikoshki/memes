package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzaj;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzqq extends zzvc<SignInMethodQueryResult, zzg> {
    private final zzml zza;

    public zzqq(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzml(str, str2);
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final TaskApiCall<zztr, SignInMethodQueryResult> zzb() {
        return TaskApiCall.builder().run(new zzqp(this)).build();
    }

    public final void zzc() {
        zzj(new zzaj(this.zzl.zzb()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzj(this.zza, this.zzc);
    }
}
