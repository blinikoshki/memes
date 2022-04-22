package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzee */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzee {
    @Deprecated
    public static final zzjl zza;
    @Deprecated
    public static final zzjl zzb;
    @Deprecated
    public static final zzjl zzc;

    static {
        new zzed();
        zzjl zza2 = zzjl.zza();
        zza = zza2;
        zzb = zza2;
        zzc = zza2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbl.zza(new zzed(), true);
        zzbl.zza(new zzea(), true);
        zzbl.zzc(new zzeh());
    }
}
