package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcx */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzcx extends zzar<zzgh, zzge> {
    final /* synthetic */ zzcy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzcy zzcy, Class cls) {
        super(cls);
        this.zza = zzcy;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabg zzabg) throws GeneralSecurityException {
        zzgh zzgh = (zzgh) zzabg;
        if (zzgh.zza() != 64) {
            int zza2 = zzgh.zza();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zza2);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
    }

    public final /* bridge */ /* synthetic */ zzabg zzc(zzzb zzzb) throws zzaal {
        return zzgh.zzb(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabg zzabg) throws GeneralSecurityException {
        zzgd zzd = zzge.zzd();
        zzd.zzb(zzzb.zzm(zzle.zza(((zzgh) zzabg).zza())));
        zzd.zza(0);
        return (zzge) zzd.zzl();
    }
}
