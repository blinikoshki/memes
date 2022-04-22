package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzcd extends zzhs<zzcd, zzbz> implements zziy {
    /* access modifiers changed from: private */
    public static final zzcd zzj;
    private int zza;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzcd zzcd = new zzcd();
        zzj = zzcd;
        zzhs.zzby(zzcd.class, zzcd);
    }

    private zzcd() {
    }

    public static zzcd zzk() {
        return zzj;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcc zzb() {
        zzcc zza2 = zzcc.zza(this.zze);
        return zza2 == null ? zzcc.UNKNOWN_COMPARISON_TYPE : zza2;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final boolean zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final String zzj() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zza", "zze", zzcc.zzb(), "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzcd();
        } else {
            if (i2 == 4) {
                return new zzbz((zzbs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
