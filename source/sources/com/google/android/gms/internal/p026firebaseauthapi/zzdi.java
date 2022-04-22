package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdi implements zzal {
    private final zzbd<zzal> zza;

    public zzdi(zzbd<zzal> zzbd) {
        this.zza = zzbd;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzbb zza2 : this.zza.zza(copyOfRange)) {
                try {
                    return ((zzal) zza2.zza()).zza(copyOfRange2, (byte[]) null);
                } catch (GeneralSecurityException e) {
                    Logger zzd = zzdj.zza;
                    Level level = Level.INFO;
                    String valueOf = String.valueOf(e.toString());
                    zzd.logp(level, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", valueOf.length() != 0 ? "ciphertext prefix matches a key, but cannot decrypt: ".concat(valueOf) : new String("ciphertext prefix matches a key, but cannot decrypt: "));
                }
            }
        }
        for (zzbb zza3 : this.zza.zza(zzaj.zza)) {
            try {
                return ((zzal) zza3.zza()).zza(bArr, (byte[]) null);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
