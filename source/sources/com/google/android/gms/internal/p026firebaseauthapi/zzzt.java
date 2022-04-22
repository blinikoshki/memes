package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzt */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzzt {
    private static final zzzr<?> zza = new zzzs();
    private static final zzzr<?> zzb;

    static {
        zzzr<?> zzzr;
        try {
            zzzr = (zzzr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzzr = null;
        }
        zzb = zzzr;
    }

    static zzzr<?> zza() {
        return zza;
    }

    static zzzr<?> zzb() {
        zzzr<?> zzzr = zzb;
        if (zzzr != null) {
            return zzzr;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
