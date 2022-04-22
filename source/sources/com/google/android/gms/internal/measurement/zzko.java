package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public enum zzko {
    DOUBLE(zzkp.DOUBLE, 1),
    FLOAT(zzkp.FLOAT, 5),
    INT64(zzkp.LONG, 0),
    UINT64(zzkp.LONG, 0),
    INT32(zzkp.INT, 0),
    FIXED64(zzkp.LONG, 1),
    FIXED32(zzkp.INT, 5),
    BOOL(zzkp.BOOLEAN, 0),
    STRING(zzkp.STRING, 2),
    GROUP(zzkp.MESSAGE, 3),
    MESSAGE(zzkp.MESSAGE, 2),
    BYTES(zzkp.BYTE_STRING, 2),
    UINT32(zzkp.INT, 0),
    ENUM(zzkp.ENUM, 0),
    SFIXED32(zzkp.INT, 5),
    SFIXED64(zzkp.LONG, 1),
    SINT32(zzkp.INT, 0),
    SINT64(zzkp.LONG, 0);
    
    private final zzkp zzs;

    private zzko(zzkp zzkp, int i) {
        this.zzs = zzkp;
    }

    public final zzkp zza() {
        return this.zzs;
    }
}
