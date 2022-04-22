package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzld */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzld extends ThreadLocal<SecureRandom> {
    zzld() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
