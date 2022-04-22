package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzux */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzux implements zzva {
    final /* synthetic */ Status zza;

    zzux(zzuz zzuz, Status status) {
        this.zza = status;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zztt.zza(this.zza));
    }
}
