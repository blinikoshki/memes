package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzuv implements zzva {
    final /* synthetic */ PhoneAuthCredential zza;

    zzuv(zzuz zzuz, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
