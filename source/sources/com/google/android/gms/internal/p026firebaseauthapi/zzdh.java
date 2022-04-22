package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdh */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzdh {
    @Deprecated
    public static final zzjl zza = zzjl.zza();
    @Deprecated
    public static final zzjl zzb = zzjl.zza();
    @Deprecated
    public static final zzjl zzc = zzjl.zza();

    static {
        new zzdg();
        new zzde();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbn.zza();
        zzbl.zzb(new zzde(), new zzdg(), true);
        zzbl.zzc(new zzdj());
        zzbl.zzc(new zzdl());
    }
}
