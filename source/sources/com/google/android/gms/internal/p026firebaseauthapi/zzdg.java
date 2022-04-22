package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdg extends zzat<zzhe> {
    public zzdg() {
        super(zzhe.class, new zzdf(zzam.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzib zzc() {
        return zzib.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzhe.zze(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzhe zzhe = (zzhe) zzabg;
        zzlg.zzb(zzhe.zza(), 0);
        zzdn.zza(zzhe.zzb());
    }
}
