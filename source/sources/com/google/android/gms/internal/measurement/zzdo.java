package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdo extends zzhs<zzdo, zzdk> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdo zzg;
    private int zza;
    private int zze = 1;
    private zzhz<zzdd> zzf = zzbE();

    static {
        zzdo zzdo = new zzdo();
        zzg = zzdo;
        zzhs.zzby(zzdo.class, zzdo);
    }

    private zzdo() {
    }

    public static zzdk zza() {
        return (zzdk) zzg.zzbt();
    }

    static /* synthetic */ void zzc(zzdo zzdo, zzdd zzdd) {
        zzdd.getClass();
        zzhz<zzdd> zzhz = zzdo.zzf;
        if (!zzhz.zza()) {
            zzdo.zzf = zzhs.zzbF(zzhz);
        }
        zzdo.zzf.add(zzdd);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zza", "zze", zzdn.zzb(), "zzf", zzdd.class});
        } else if (i2 == 3) {
            return new zzdo();
        } else {
            if (i2 == 4) {
                return new zzdk((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
