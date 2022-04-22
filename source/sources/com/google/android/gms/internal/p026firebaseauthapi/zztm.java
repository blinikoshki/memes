package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zztm extends zzvc<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzmz zza;

    public zztm(zzxi zzxi) {
        super(8);
        Preconditions.checkNotNull(zzxi);
        this.zza = new zzmz(zzxi);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zztl(this)).build();
    }

    public final void zzc() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzu(this.zza, this.zzc);
    }
}
