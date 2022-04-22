package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcq extends zzat<zzjd> {
    zzcq() {
        super(zzjd.class, new zzco(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final zzib zzc() {
        return zzib.REMOTE;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzjd.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzlg.zzb(((zzjd) zzabg).zza(), 0);
    }

    public final zzar<zzjg, zzjd> zzi() {
        return new zzcp(this, zzjg.class);
    }
}
