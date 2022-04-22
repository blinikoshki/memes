package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzck extends zzhs<zzck, zzcg> implements zziy {
    /* access modifiers changed from: private */
    public static final zzck zzi;
    private int zza;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private zzhz<String> zzh = zzhs.zzbE();

    static {
        zzck zzck = new zzck();
        zzi = zzck;
        zzhs.zzby(zzck.class, zzck);
    }

    private zzck() {
    }

    public static zzck zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcj zzb() {
        zzcj zza2 = zzcj.zza(this.zze);
        return zza2 == null ? zzcj.UNKNOWN_MATCH_TYPE : zza2;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final List<String> zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zza", "zze", zzcj.zzb(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzck();
        } else {
            if (i2 == 4) {
                return new zzcg((zzbs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
