package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcy extends zzat<zzge> {
    zzcy() {
        super(zzge.class, new zzcw(zzak.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzge.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzge zzge = (zzge) zzabg;
        zzlg.zzb(zzge.zza(), 0);
        if (zzge.zzb().zzc() != 64) {
            int zzc = zzge.zzb().zzc();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zzc);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(sb.toString());
        }
    }

    public final zzar<zzgh, zzge> zzi() {
        return new zzcx(this, zzgh.class);
    }
}
