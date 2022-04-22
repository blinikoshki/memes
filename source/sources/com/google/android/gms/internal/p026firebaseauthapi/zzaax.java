package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaax */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaax implements zzabe {
    private final zzabe[] zza;

    zzaax(zzabe... zzabeArr) {
        this.zza = zzabeArr;
    }

    public final boolean zzb(Class<?> cls) {
        zzabe[] zzabeArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzabeArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzabd zzc(Class<?> cls) {
        zzabe[] zzabeArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzabe zzabe = zzabeArr[i];
            if (zzabe.zzb(cls)) {
                return zzabe.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
