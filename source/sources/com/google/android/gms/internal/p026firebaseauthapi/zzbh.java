package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbh */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbh implements zzbk {
    final /* synthetic */ zzat zza;

    zzbh(zzat zzat) {
        this.zza = zzat;
    }

    public final <Q> zzan<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzap(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzan<?> zzb() {
        zzat zzat = this.zza;
        return new zzap(zzat, zzat.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return null;
    }
}
