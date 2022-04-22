package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdd extends zzar<zzgv, zzhb> {
    final /* synthetic */ zzde zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdd(zzde zzde, Class cls) {
        super(cls);
        this.zza = zzde;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzabg zzabg) throws GeneralSecurityException {
        zzdn.zza(((zzgv) zzabg).zza());
    }

    public final /* bridge */ /* synthetic */ zzabg zzc(zzzb zzzb) throws zzaal {
        return zzgv.zzb(zzzb, zzzq.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzabg zzabg) throws GeneralSecurityException {
        zzgv zzgv = (zzgv) zzabg;
        ECParameterSpec zze = zzkl.zze(zzdn.zzc(zzgv.zza().zza().zza()));
        KeyPairGenerator zza2 = zzkn.zzf.zza("EC");
        zza2.initialize(zze);
        KeyPair generateKeyPair = zza2.generateKeyPair();
        ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
        zzhd zzf = zzhe.zzf();
        zzf.zza(0);
        zzf.zzb(zzgv.zza());
        zzf.zzc(zzzb.zzm(w.getAffineX().toByteArray()));
        zzf.zzd(zzzb.zzm(w.getAffineY().toByteArray()));
        zzha zze2 = zzhb.zze();
        zze2.zza(0);
        zze2.zzb((zzhe) zzf.zzl());
        zze2.zzc(zzzb.zzm(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray()));
        return (zzhb) zze2.zzl();
    }
}
