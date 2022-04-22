package com.google.android.gms.internal.p026firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbm {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zziu zza(zzip zzip) {
        zzir zzb = zziu.zzb();
        zzb.zza(zzip.zza());
        for (zzio next : zzip.zzb()) {
            zzis zzb2 = zzit.zzb();
            zzb2.zza(next.zzb().zza());
            zzb2.zzb(next.zzc());
            zzb2.zzd(next.zze());
            zzb2.zzc(next.zzd());
            zzb.zzb((zzit) zzb2.zzl());
        }
        return (zziu) zzb.zzl();
    }

    public static void zzb(zzip zzip) throws GeneralSecurityException {
        int zza2 = zzip.zza();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzio next : zzip.zzb()) {
            if (next.zzc() == zzie.ENABLED) {
                if (!next.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzd())}));
                } else if (next.zze() == zzji.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzd())}));
                } else if (next.zzc() != zzie.UNKNOWN_STATUS) {
                    if (next.zzd() == zza2) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= next.zzb().zzc() == zzib.ASYMMETRIC_PUBLIC;
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzd())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
