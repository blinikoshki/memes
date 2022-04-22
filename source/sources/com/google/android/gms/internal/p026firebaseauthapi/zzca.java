package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzca */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzca extends zzat<zzfj> {
    zzca() {
        super(zzfj.class, new zzby(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzfj.zzd(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzfj zzfj = (zzfj) zzabg;
        zzlg.zzb(zzfj.zza(), 0);
        zzlg.zza(zzfj.zzc().zzc());
        if (zzfj.zzb().zza() != 12 && zzfj.zzb().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final zzar<zzfm, zzfj> zzi() {
        return new zzbz(this, zzfm.class);
    }
}
