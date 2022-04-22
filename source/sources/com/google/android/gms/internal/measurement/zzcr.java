package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzcr extends zzhs<zzcr, zzcq> implements zziy {
    /* access modifiers changed from: private */
    public static final zzcr zzg;
    private int zza;
    private String zze = "";
    private String zzf = "";

    static {
        zzcr zzcr = new zzcr();
        zzg = zzcr;
        zzhs.zzby(zzcr.class, zzcr);
    }

    private zzcr() {
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzcr();
        } else {
            if (i2 == 4) {
                return new zzcq((zzcl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
