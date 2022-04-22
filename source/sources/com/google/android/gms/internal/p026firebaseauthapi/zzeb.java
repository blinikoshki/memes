package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzeb extends zzas<zzaz, zzhr> {
    zzeb(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzhr zzhr = (zzhr) obj;
        zzho zza = zzhr.zzb().zza();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzhr.zzc().zzp(), "HMAC");
        int zzb = zzhr.zzb().zzb();
        zzho zzho = zzho.UNKNOWN_HASH;
        int ordinal = zza.ordinal();
        if (ordinal == 1) {
            return new zzlc(new zzlb("HMACSHA1", secretKeySpec), zzb);
        }
        if (ordinal == 3) {
            return new zzlc(new zzlb("HMACSHA256", secretKeySpec), zzb);
        }
        if (ordinal == 4) {
            return new zzlc(new zzlb("HMACSHA512", secretKeySpec), zzb);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
