package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzju */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzju extends ThreadLocal<Cipher> {
    zzju() {
    }

    protected static final Cipher zza() {
        try {
            return zzkn.zza.zza("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
