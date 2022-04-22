package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzkz implements zzei {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzkz(byte[] bArr) throws GeneralSecurityException {
        zzlg.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher zzb2 = zzb();
        zzb2.init(1, secretKeySpec);
        byte[] zza2 = zzka.zza(zzb2.doFinal(new byte[16]));
        this.zzb = zza2;
        this.zzc = zzka.zza(zza2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        return zzkn.zza.zza("AES/ECB/NoPadding");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzkb.zzc(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzkb.zze(zzka.zzb(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzb2.doFinal(zzkb.zzc(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzkb.zze(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
