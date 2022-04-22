package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public enum zzacy {
    DOUBLE(zzacz.DOUBLE, 1),
    FLOAT(zzacz.FLOAT, 5),
    INT64(zzacz.LONG, 0),
    UINT64(zzacz.LONG, 0),
    INT32(zzacz.INT, 0),
    FIXED64(zzacz.LONG, 1),
    FIXED32(zzacz.INT, 5),
    BOOL(zzacz.BOOLEAN, 0),
    STRING(zzacz.STRING, 2),
    GROUP(zzacz.MESSAGE, 3),
    MESSAGE(zzacz.MESSAGE, 2),
    BYTES(zzacz.BYTE_STRING, 2),
    UINT32(zzacz.INT, 0),
    ENUM(zzacz.ENUM, 0),
    SFIXED32(zzacz.INT, 5),
    SFIXED64(zzacz.LONG, 1),
    SINT32(zzacz.INT, 0),
    SINT64(zzacz.LONG, 0);
    
    private final zzacz zzs;

    private zzacy(zzacz zzacz, int i) {
        this.zzs = zzacz;
    }

    public final zzacz zza() {
        return this.zzs;
    }
}
