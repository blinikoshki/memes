package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcu */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzcu extends ThreadLocal<Cipher> {
    zzcu() {
    }

    protected static final Cipher zza() {
        try {
            return zzkn.zza.zza("AES/GCM-SIV/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
