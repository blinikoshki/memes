package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcm extends zzat<zzix> {
    zzcm() {
        super(zzix.class, new zzck(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final zzib zzc() {
        return zzib.REMOTE;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzix.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzlg.zzb(((zzix) zzabg).zza(), 0);
    }

    public final zzar<zzja, zzix> zzi() {
        return new zzcl(this, zzja.class);
    }
}
