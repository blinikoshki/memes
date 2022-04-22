package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzbu extends zzhs<zzbu, zzbt> implements zziy {
    /* access modifiers changed from: private */
    public static final zzbu zzj;
    private int zza;
    private int zze;
    private zzhz<zzcf> zzf = zzbE();
    private zzhz<zzbw> zzg = zzbE();
    private boolean zzh;
    private boolean zzi;

    static {
        zzbu zzbu = new zzbu();
        zzj = zzbu;
        zzhs.zzby(zzbu.class, zzbu);
    }

    private zzbu() {
    }

    static /* synthetic */ void zzj(zzbu zzbu, int i, zzcf zzcf) {
        zzcf.getClass();
        zzhz<zzcf> zzhz = zzbu.zzf;
        if (!zzhz.zza()) {
            zzbu.zzf = zzhs.zzbF(zzhz);
        }
        zzbu.zzf.set(i, zzcf);
    }

    static /* synthetic */ void zzk(zzbu zzbu, int i, zzbw zzbw) {
        zzbw.getClass();
        zzhz<zzbw> zzhz = zzbu.zzg;
        if (!zzhz.zza()) {
            zzbu.zzg = zzhs.zzbF(zzhz);
        }
        zzbu.zzg.set(i, zzbw);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<zzcf> zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzcf zze(int i) {
        return (zzcf) this.zzf.get(i);
    }

    public final List<zzbw> zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zzbw zzh(int i) {
        return (zzbw) this.zzg.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zza", "zze", "zzf", zzcf.class, "zzg", zzbw.class, "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzbu();
        } else {
            if (i2 == 4) {
                return new zzbt((zzbs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
