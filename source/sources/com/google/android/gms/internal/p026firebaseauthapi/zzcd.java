package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcd extends zzat<zzfs> {
    zzcd() {
        super(zzfs.class, new zzcb(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzfs.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzfs zzfs = (zzfs) zzabg;
        zzlg.zzb(zzfs.zza(), 0);
        zzlg.zza(zzfs.zzb().zzc());
    }

    public final zzar<zzfv, zzfs> zzi() {
        return new zzcc(this, zzfv.class);
    }
}
