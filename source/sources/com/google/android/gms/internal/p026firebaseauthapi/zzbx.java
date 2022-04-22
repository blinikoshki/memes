package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbx */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbx extends zzat<zzfa> {
    zzbx() {
        super(zzfa.class, new zzbv(zzkx.class));
    }

    public static final void zzk(zzfa zzfa) throws GeneralSecurityException {
        zzlg.zzb(zzfa.zza(), 0);
        zzlg.zza(zzfa.zzc().zzc());
        zzl(zzfa.zzb());
    }

    /* access modifiers changed from: private */
    public static final void zzl(zzfg zzfg) throws GeneralSecurityException {
        if (zzfg.zza() < 12 || zzfg.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabg zzd(zzzb zzzb) throws zzaal {
        return zzfa.zzd(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabg zzabg) throws GeneralSecurityException {
        zzk((zzfa) zzabg);
    }

    public final zzar<zzfd, zzfa> zzi() {
        return new zzbw(this, zzfd.class);
    }
}
