package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbz extends zzar<zzfm, zzfj> {
    final /* synthetic */ zzca zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbz(zzca zzca, Class cls) {
        super(cls);
        this.zza = zzca;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabg zzabg) throws GeneralSecurityException {
        zzfm zzfm = (zzfm) zzabg;
        zzlg.zza(zzfm.zzb());
        if (zzfm.zza().zza() != 12 && zzfm.zza().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* bridge */ /* synthetic */ zzabg zzc(zzzb zzzb) throws zzaal {
        return zzfm.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabg zzabg) throws GeneralSecurityException {
        zzfm zzfm = (zzfm) zzabg;
        zzfi zze = zzfj.zze();
        zze.zzc(zzzb.zzm(zzle.zza(zzfm.zzb())));
        zze.zzb(zzfm.zza());
        zze.zza(0);
        return (zzfj) zze.zzl();
    }
}
