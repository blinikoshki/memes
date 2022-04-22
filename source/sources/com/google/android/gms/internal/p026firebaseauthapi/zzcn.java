package com.google.android.gms.internal.p026firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcn implements zzag {
    private static final byte[] zza = new byte[0];
    private final zzih zzb;
    private final zzag zzc;

    public zzcn(zzih zzih, zzag zzag) {
        this.zzb = zzih;
        this.zzc = zzag;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzag) zzbl.zzi(this.zzb.zza(), this.zzc.zzb(bArr3, zza), zzag.class)).zzb(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
