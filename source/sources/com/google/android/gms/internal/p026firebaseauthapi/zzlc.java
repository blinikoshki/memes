package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzlc implements zzaz {
    private final zzei zza;
    private final int zzb;

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzkb.zza(this.zza.zza(bArr2, this.zzb), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public zzlc(zzei zzei, int i) throws GeneralSecurityException {
        this.zza = zzei;
        this.zzb = i;
        if (i >= 10) {
            zzei.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
