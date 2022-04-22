package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzabg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbf<PrimitiveT, KeyProtoT extends zzabg, PublicKeyProtoT extends zzabg> extends zzap<PrimitiveT, KeyProtoT> implements zzan {
    private final zzbg<KeyProtoT, PublicKeyProtoT> zza;
    private final zzat<PublicKeyProtoT> zzb;

    public zzbf(zzbg<KeyProtoT, PublicKeyProtoT> zzbg, zzat<PublicKeyProtoT> zzat, Class<PrimitiveT> cls) {
        super(zzbg, cls);
        this.zza = zzbg;
        this.zzb = zzat;
    }

    public final zzic zze(zzzb zzzb) throws GeneralSecurityException {
        try {
            zzhb zzd = zzhb.zzd(zzzb, zzzq.zza());
            zzde.zzj(zzd);
            zzhe zzb2 = zzd.zzb();
            this.zzb.zze(zzb2);
            zzhz zzd2 = zzic.zzd();
            zzd2.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
            zzd2.zzb(zzb2.zzn());
            zzd2.zzc(zzib.ASYMMETRIC_PUBLIC);
            return (zzic) zzd2.zzl();
        } catch (zzaal e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
