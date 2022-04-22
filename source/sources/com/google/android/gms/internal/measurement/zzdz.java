package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdz extends zzhs<zzdz, zzdy> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdz zzg;
    private int zza;
    private String zze = "";
    private zzhz<zzeg> zzf = zzbE();

    static {
        zzdz zzdz = new zzdz();
        zzg = zzdz;
        zzhs.zzby(zzdz.class, zzdz);
    }

    private zzdz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zza", "zze", "zzf", zzeg.class});
        } else if (i2 == 3) {
            return new zzdz();
        } else {
            if (i2 == 4) {
                return new zzdy((zzdv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
