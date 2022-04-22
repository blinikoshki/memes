package com.google.android.gms.internal.p026firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzdc extends zzas<zzal, zzhb> {
    zzdc(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzhb zzhb = (zzhb) obj;
        zzgy zzb = zzhb.zzb().zzb();
        zzhh zza = zzb.zza();
        int zzc = zzdn.zzc(zza.zza());
        byte[] zzp = zzhb.zzc().zzp();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, zzp), zzkl.zze(zzc));
        return new zzkh((ECPrivateKey) zzkn.zzg.zza("EC").generatePrivate(eCPrivateKeySpec), zza.zzc().zzp(), zzdn.zzb(zza.zzb()), zzdn.zzd(zzb.zzc()), new zzdo(zzb.zzb().zza()));
    }
}
