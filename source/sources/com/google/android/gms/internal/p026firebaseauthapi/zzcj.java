package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcj */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcj extends zzat<zzgk> {
    zzcj() {
        super(zzgk.class, new zzch(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzgk.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzgk zzgk = (zzgk) zzabg;
        zzlg.zzb(zzgk.zza(), 0);
        if (zzgk.zzb().zzc() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzar<zzgn, zzgk> zzi() {
        return new zzci(this, zzgn.class);
    }
}
