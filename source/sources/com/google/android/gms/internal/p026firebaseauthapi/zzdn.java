package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdn {
    public static void zza(zzgy zzgy) throws GeneralSecurityException {
        zzkl.zze(zzc(zzgy.zza().zza()));
        zzb(zzgy.zza().zzb());
        if (zzgy.zzc() != zzgp.UNKNOWN_FORMAT) {
            zzbl.zze(zzgy.zzb().zza());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zzb(zzho zzho) throws NoSuchAlgorithmException {
        zzgp zzgp = zzgp.UNKNOWN_FORMAT;
        zzhj zzhj = zzhj.UNKNOWN_CURVE;
        zzho zzho2 = zzho.UNKNOWN_HASH;
        int ordinal = zzho.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzho);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static int zzc(zzhj zzhj) throws GeneralSecurityException {
        zzgp zzgp = zzgp.UNKNOWN_FORMAT;
        zzhj zzhj2 = zzhj.UNKNOWN_CURVE;
        zzho zzho = zzho.UNKNOWN_HASH;
        int ordinal = zzhj.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzhj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }

    public static int zzd(zzgp zzgp) throws GeneralSecurityException {
        zzgp zzgp2 = zzgp.UNKNOWN_FORMAT;
        zzhj zzhj = zzhj.UNKNOWN_CURVE;
        zzho zzho = zzho.UNKNOWN_HASH;
        int ordinal = zzgp.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzgp);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }
}
