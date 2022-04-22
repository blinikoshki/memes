package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzeg extends zzhs<zzeg, zzec> implements zziy {
    /* access modifiers changed from: private */
    public static final zzeg zzk;
    private int zza;
    private int zze;
    private zzhz<zzeg> zzf = zzbE();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzeg zzeg = new zzeg();
        zzk = zzeg;
        zzhs.zzby(zzeg.class, zzeg);
    }

    private zzeg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zza", "zze", zzef.zzb(), "zzf", zzeg.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzeg();
        } else {
            if (i2 == 4) {
                return new zzec((zzdv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
