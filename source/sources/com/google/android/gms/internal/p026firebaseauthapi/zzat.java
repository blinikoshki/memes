package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzabg;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzat<KeyProtoT extends zzabg> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzas<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    @SafeVarargs
    protected zzat(Class<KeyProtoT> cls, zzas<?, KeyProtoT>... zzasArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i <= 0) {
            zzas<?, KeyProtoT> zzas = zzasArr[i];
            if (hashMap.containsKey(zzas.zza())) {
                String valueOf = String.valueOf(zzas.zza().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzas.zza(), zzas);
                i++;
            }
        }
        this.zzc = zzasArr[0].zza();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> zza() {
        return this.zza;
    }

    public abstract String zzb();

    public abstract zzib zzc();

    public abstract KeyProtoT zzd(zzzb zzzb) throws zzaal;

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final <P> P zzf(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzas zzas = this.zzb.get(cls);
        if (zzas != null) {
            return zzas.zzb(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzh() {
        return this.zzc;
    }

    public zzar<?, KeyProtoT> zzi() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
