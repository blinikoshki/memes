package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public enum zzhk {
    DOUBLE(0, 1, zzid.DOUBLE),
    FLOAT(1, 1, zzid.FLOAT),
    INT64(2, 1, zzid.LONG),
    UINT64(3, 1, zzid.LONG),
    INT32(4, 1, zzid.INT),
    FIXED64(5, 1, zzid.LONG),
    FIXED32(6, 1, zzid.INT),
    BOOL(7, 1, zzid.BOOLEAN),
    STRING(8, 1, zzid.STRING),
    MESSAGE(9, 1, zzid.MESSAGE),
    BYTES(10, 1, zzid.BYTE_STRING),
    UINT32(11, 1, zzid.INT),
    ENUM(12, 1, zzid.ENUM),
    SFIXED32(13, 1, zzid.INT),
    SFIXED64(14, 1, zzid.LONG),
    SINT32(15, 1, zzid.INT),
    SINT64(16, 1, zzid.LONG),
    GROUP(17, 1, zzid.MESSAGE),
    DOUBLE_LIST(18, 2, zzid.DOUBLE),
    FLOAT_LIST(19, 2, zzid.FLOAT),
    INT64_LIST(20, 2, zzid.LONG),
    UINT64_LIST(21, 2, zzid.LONG),
    INT32_LIST(22, 2, zzid.INT),
    FIXED64_LIST(23, 2, zzid.LONG),
    FIXED32_LIST(24, 2, zzid.INT),
    BOOL_LIST(25, 2, zzid.BOOLEAN),
    STRING_LIST(26, 2, zzid.STRING),
    MESSAGE_LIST(27, 2, zzid.MESSAGE),
    BYTES_LIST(28, 2, zzid.BYTE_STRING),
    UINT32_LIST(29, 2, zzid.INT),
    ENUM_LIST(30, 2, zzid.ENUM),
    SFIXED32_LIST(31, 2, zzid.INT),
    SFIXED64_LIST(32, 2, zzid.LONG),
    SINT32_LIST(33, 2, zzid.INT),
    SINT64_LIST(34, 2, zzid.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzid.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzid.FLOAT),
    INT64_LIST_PACKED(37, 3, zzid.LONG),
    UINT64_LIST_PACKED(38, 3, zzid.LONG),
    INT32_LIST_PACKED(39, 3, zzid.INT),
    FIXED64_LIST_PACKED(40, 3, zzid.LONG),
    FIXED32_LIST_PACKED(41, 3, zzid.INT),
    BOOL_LIST_PACKED(42, 3, zzid.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzid.INT),
    ENUM_LIST_PACKED(44, 3, zzid.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzid.INT),
    SFIXED64_LIST_PACKED(46, 3, zzid.LONG),
    SINT32_LIST_PACKED(47, 3, zzid.INT),
    SINT64_LIST_PACKED(48, 3, zzid.LONG),
    GROUP_LIST(49, 2, zzid.MESSAGE),
    MAP(50, 4, zzid.VOID);
    
    private static final zzhk[] zzac = null;
    private final zzid zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        int i;
        zzac = new zzhk[r1];
        for (zzhk zzhk : values()) {
            zzac[zzhk.zzaa] = zzhk;
        }
    }

    private zzhk(int i, int i2, zzid zzid) {
        this.zzaa = i;
        this.zzZ = zzid;
        zzid zzid2 = zzid.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzid.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzid.zza();
        }
        if (i2 == 1) {
            zzid.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}
