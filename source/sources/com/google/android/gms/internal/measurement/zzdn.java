package com.google.android.gms.internal.measurement;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public enum zzdn implements zzhu {
    RADS(1),
    PROVISIONING(2);
    
    private static final zzhv<zzdn> zzc = null;
    private final int zzd;

    static {
        zzc = new zzdl();
    }

    private zzdn(int i) {
        this.zzd = i;
    }

    public static zzdn zza(int i) {
        if (i == 1) {
            return RADS;
        }
        if (i != 2) {
            return null;
        }
        return PROVISIONING;
    }

    public static zzhw zzb() {
        return zzdm.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
    }
}
