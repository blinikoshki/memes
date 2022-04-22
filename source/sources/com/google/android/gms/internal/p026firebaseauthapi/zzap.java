package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzabg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zzap<PrimitiveT, KeyProtoT extends zzabg> implements zzan<PrimitiveT> {
    private final zzat<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzap(zzat<KeyProtoT> zzat, Class<PrimitiveT> cls) {
        if (zzat.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzat;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzat.toString(), cls.getName()}));
    }

    private final PrimitiveT zze(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zze(keyprotot);
            return this.zza.zzf(keyprotot, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private final zzao<?, KeyProtoT> zzf() {
        return new zzao<>(this.zza.zzi());
    }

    public final PrimitiveT zza(zzzb zzzb) throws GeneralSecurityException {
        try {
            return zze(this.zza.zzd(zzzb));
        } catch (zzaal e) {
            String valueOf = String.valueOf(this.zza.zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final PrimitiveT zzb(zzabg zzabg) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zza.zza().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zza.zza().isInstance(zzabg)) {
            return zze(zzabg);
        }
        throw new GeneralSecurityException(concat);
    }

    public final zzabg zzc(zzzb zzzb) throws GeneralSecurityException {
        try {
            return zzf().zza(zzzb);
        } catch (zzaal e) {
            String valueOf = String.valueOf(this.zza.zzi().zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzic zzd(zzzb zzzb) throws GeneralSecurityException {
        try {
            zzabg zza2 = zzf().zza(zzzb);
            zzhz zzd = zzic.zzd();
            zzd.zza(this.zza.zzb());
            zzd.zzb(zza2.zzn());
            zzd.zzc(this.zza.zzc());
            return (zzic) zzd.zzl();
        } catch (zzaal e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
