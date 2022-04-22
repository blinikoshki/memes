package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzec */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzec extends zzar<zzhu, zzhr> {
    final /* synthetic */ zzed zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzed zzed, Class cls) {
        super(cls);
        this.zza = zzed;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabg zzabg) throws GeneralSecurityException {
        zzhu zzhu = (zzhu) zzabg;
        if (zzhu.zzb() >= 16) {
            zzed.zzl(zzhu.zza());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* bridge */ /* synthetic */ zzabg zzc(zzzb zzzb) throws zzaal {
        return zzhu.zzc(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabg zzabg) throws GeneralSecurityException {
        zzhu zzhu = (zzhu) zzabg;
        zzhq zze = zzhr.zze();
        zze.zza(0);
        zze.zzb(zzhu.zza());
        zze.zzc(zzzb.zzm(zzle.zza(zzhu.zzb())));
        return (zzhr) zze.zzl();
    }
}
