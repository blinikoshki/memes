package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzde */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzde extends zzbg<zzhb, zzhe> {
    zzde() {
        super(zzhb.class, zzhe.class, new zzdc(zzal.class));
    }

    public static final void zzj(zzhb zzhb) throws GeneralSecurityException {
        if (zzhb.zzc().zzc() != 0) {
            zzlg.zzb(zzhb.zza(), 0);
            zzdn.zza(zzhb.zzb().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzib zzc() {
        return zzib.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzhb.zzd(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzj((zzhb) zzabg);
    }

    public final zzar<zzgv, zzhb> zzi() {
        return new zzdd(this, zzgv.class);
    }
}
