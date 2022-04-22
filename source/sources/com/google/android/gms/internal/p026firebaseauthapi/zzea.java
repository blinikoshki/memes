package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzea extends zzat<zzel> {
    zzea() {
        super(zzel.class, new zzdy(zzaz.class));
    }

    /* access modifiers changed from: private */
    public static void zzl(zzer zzer) throws GeneralSecurityException {
        if (zzer.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzer.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzm(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzel.zzd(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzel zzel = (zzel) zzabg;
        zzlg.zzb(zzel.zza(), 0);
        zzm(zzel.zzb().zzc());
        zzl(zzel.zzc());
    }

    public final zzar<zzeo, zzel> zzi() {
        return new zzdz(this, zzeo.class);
    }
}
