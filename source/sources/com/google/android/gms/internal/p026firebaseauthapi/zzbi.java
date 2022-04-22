package com.google.android.gms.internal.p026firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbi implements zzbk {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ zzat zzb;

    zzbi(zzbg zzbg, zzat zzat) {
        this.zza = zzbg;
        this.zzb = zzat;
    }

    public final <Q> zzan<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzbf(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzan<?> zzb() {
        zzbg zzbg = this.zza;
        return new zzbf(zzbg, this.zzb, zzbg.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return this.zzb.getClass();
    }
}
