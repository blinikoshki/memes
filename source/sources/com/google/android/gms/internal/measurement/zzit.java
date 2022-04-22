package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzit {
    private static final zzis zza;
    private static final zzis zzb = new zzis();

    static {
        zzis zzis;
        try {
            zzis = (zzis) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzis = null;
        }
        zza = zzis;
    }

    static zzis zza() {
        return zza;
    }

    static zzis zzb() {
        return zzb;
    }
}
