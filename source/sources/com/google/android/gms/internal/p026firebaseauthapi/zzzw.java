package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public enum zzzw {
    DOUBLE(0, 1, zzaam.DOUBLE),
    FLOAT(1, 1, zzaam.FLOAT),
    INT64(2, 1, zzaam.LONG),
    UINT64(3, 1, zzaam.LONG),
    INT32(4, 1, zzaam.INT),
    FIXED64(5, 1, zzaam.LONG),
    FIXED32(6, 1, zzaam.INT),
    BOOL(7, 1, zzaam.BOOLEAN),
    STRING(8, 1, zzaam.STRING),
    MESSAGE(9, 1, zzaam.MESSAGE),
    BYTES(10, 1, zzaam.BYTE_STRING),
    UINT32(11, 1, zzaam.INT),
    ENUM(12, 1, zzaam.ENUM),
    SFIXED32(13, 1, zzaam.INT),
    SFIXED64(14, 1, zzaam.LONG),
    SINT32(15, 1, zzaam.INT),
    SINT64(16, 1, zzaam.LONG),
    GROUP(17, 1, zzaam.MESSAGE),
    DOUBLE_LIST(18, 2, zzaam.DOUBLE),
    FLOAT_LIST(19, 2, zzaam.FLOAT),
    INT64_LIST(20, 2, zzaam.LONG),
    UINT64_LIST(21, 2, zzaam.LONG),
    INT32_LIST(22, 2, zzaam.INT),
    FIXED64_LIST(23, 2, zzaam.LONG),
    FIXED32_LIST(24, 2, zzaam.INT),
    BOOL_LIST(25, 2, zzaam.BOOLEAN),
    STRING_LIST(26, 2, zzaam.STRING),
    MESSAGE_LIST(27, 2, zzaam.MESSAGE),
    BYTES_LIST(28, 2, zzaam.BYTE_STRING),
    UINT32_LIST(29, 2, zzaam.INT),
    ENUM_LIST(30, 2, zzaam.ENUM),
    SFIXED32_LIST(31, 2, zzaam.INT),
    SFIXED64_LIST(32, 2, zzaam.LONG),
    SINT32_LIST(33, 2, zzaam.INT),
    SINT64_LIST(34, 2, zzaam.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzaam.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzaam.FLOAT),
    INT64_LIST_PACKED(37, 3, zzaam.LONG),
    UINT64_LIST_PACKED(38, 3, zzaam.LONG),
    INT32_LIST_PACKED(39, 3, zzaam.INT),
    FIXED64_LIST_PACKED(40, 3, zzaam.LONG),
    FIXED32_LIST_PACKED(41, 3, zzaam.INT),
    BOOL_LIST_PACKED(42, 3, zzaam.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzaam.INT),
    ENUM_LIST_PACKED(44, 3, zzaam.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzaam.INT),
    SFIXED64_LIST_PACKED(46, 3, zzaam.LONG),
    SINT32_LIST_PACKED(47, 3, zzaam.INT),
    SINT64_LIST_PACKED(48, 3, zzaam.LONG),
    GROUP_LIST(49, 2, zzaam.MESSAGE),
    MAP(50, 4, zzaam.VOID);
    
    private static final zzzw[] zzac = null;
    private final zzaam zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        int i;
        zzac = new zzzw[r1];
        for (zzzw zzzw : values()) {
            zzac[zzzw.zzaa] = zzzw;
        }
    }

    private zzzw(int i, int i2, zzaam zzaam) {
        this.zzaa = i;
        this.zzZ = zzaam;
        zzaam zzaam2 = zzaam.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzaam.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzaam.zza();
        }
        if (i2 == 1) {
            zzaam.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}
