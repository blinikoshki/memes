package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzuw implements zzva {
    final /* synthetic */ String zza;

    zzuw(zzuz zzuz, String str) {
        this.zza = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zza);
    }
}
