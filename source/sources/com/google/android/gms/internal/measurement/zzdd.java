package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdd extends zzhs<zzdd, zzdc> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdd zzg;
    private int zza;
    private String zze = "";
    private long zzf;

    static {
        zzdd zzdd = new zzdd();
        zzg = zzdd;
        zzhs.zzby(zzdd.class, zzdd);
    }

    private zzdd() {
    }

    public static zzdc zza() {
        return (zzdc) zzg.zzbt();
    }

    static /* synthetic */ void zzc(zzdd zzdd, String str) {
        str.getClass();
        zzdd.zza |= 1;
        zzdd.zze = str;
    }

    static /* synthetic */ void zzd(zzdd zzdd, long j) {
        zzdd.zza |= 2;
        zzdd.zzf = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzdd();
        } else {
            if (i2 == 4) {
                return new zzdc((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
