package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzhh {
    private static final zzhf<?> zza = new zzhg();
    private static final zzhf<?> zzb;

    static {
        zzhf<?> zzhf;
        try {
            zzhf = (zzhf) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzhf = null;
        }
        zzb = zzhf;
    }

    static zzhf<?> zza() {
        return zza;
    }

    static zzhf<?> zzb() {
        zzhf<?> zzhf = zzb;
        if (zzhf != null) {
            return zzhf;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
