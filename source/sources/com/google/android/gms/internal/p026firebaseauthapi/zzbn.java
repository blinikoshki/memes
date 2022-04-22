package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzbn {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final zzjl zzc;
    @Deprecated
    public static final zzjl zzd;
    @Deprecated
    public static final zzjl zze;

    static {
        new zzbu();
        new zzcd();
        new zzcg();
        new zzca();
        new zzcm();
        new zzcq();
        new zzcj();
        new zzct();
        zzjl zza2 = zzjl.zza();
        zzc = zza2;
        zzd = zza2;
        zze = zza2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzee.zza();
        zzbl.zza(new zzbu(), true);
        zzbl.zza(new zzca(), true);
        zzbl.zza(new zzcd(), true);
        zzcg.zzj(true);
        zzbl.zza(new zzcj(), true);
        zzbl.zza(new zzcm(), true);
        zzbl.zza(new zzcq(), true);
        zzbl.zza(new zzct(), true);
        zzbl.zzc(new zzbr());
    }
}
