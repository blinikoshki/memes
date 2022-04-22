package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzcz {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    public static final zzjl zzb = zzjl.zza();
    @Deprecated
    public static final zzjl zzc = zzjl.zza();

    static {
        new zzcy();
        try {
            zzbl.zza(new zzcy(), true);
            zzbl.zzc(new zzdb());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
