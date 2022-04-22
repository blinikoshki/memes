package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbw extends zzar<zzfd, zzfa> {
    final /* synthetic */ zzbx zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbw(zzbx zzbx, Class cls) {
        super(cls);
        this.zza = zzbx;
    }

    public static final zzfa zzf(zzfd zzfd) throws GeneralSecurityException {
        zzez zze = zzfa.zze();
        zze.zzb(zzfd.zza());
        zze.zzc(zzzb.zzm(zzle.zza(zzfd.zzb())));
        zze.zza(0);
        return (zzfa) zze.zzl();
    }

    public final /* bridge */ /* synthetic */ zzabg zzc(zzzb zzzb) throws zzaal {
        return zzfd.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabg zzabg) throws GeneralSecurityException {
        return zzf((zzfd) zzabg);
    }

    /* renamed from: zze */
    public final void zzb(zzfd zzfd) throws GeneralSecurityException {
        zzlg.zza(zzfd.zzb());
        zzbx.zzl(zzfd.zza());
    }
}
