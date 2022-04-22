package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzcz extends zzhs<zzcz, zzcy> implements zziy {
    /* access modifiers changed from: private */
    public static final zzcz zzg;
    private int zza;
    private int zze;
    private long zzf;

    static {
        zzcz zzcz = new zzcz();
        zzg = zzcz;
        zzhs.zzby(zzcz.class, zzcz);
    }

    private zzcz() {
    }

    public static zzcy zze() {
        return (zzcy) zzg.zzbt();
    }

    static /* synthetic */ void zzg(zzcz zzcz, int i) {
        zzcz.zza |= 1;
        zzcz.zze = i;
    }

    static /* synthetic */ void zzh(zzcz zzcz, long j) {
        zzcz.zza |= 2;
        zzcz.zzf = j;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final long zzd() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzcz();
        } else {
            if (i2 == 4) {
                return new zzcy((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
