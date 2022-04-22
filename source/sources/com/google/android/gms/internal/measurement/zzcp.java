package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzcp extends zzhs<zzcp, zzco> implements zziy {
    /* access modifiers changed from: private */
    public static final zzcp zzn;
    private int zza;
    private long zze;
    private String zzf = "";
    private int zzg;
    private zzhz<zzcr> zzh = zzbE();
    private zzhz<zzcn> zzi = zzbE();
    /* access modifiers changed from: private */
    public zzhz<zzbu> zzj = zzbE();
    private String zzk = "";
    private boolean zzl;
    private zzhz<zzeb> zzm = zzbE();

    static {
        zzcp zzcp = new zzcp();
        zzn = zzcp;
        zzhs.zzby(zzcp.class, zzcp);
    }

    private zzcp() {
    }

    public static zzco zzj() {
        return (zzco) zzn.zzbt();
    }

    public static zzcp zzk() {
        return zzn;
    }

    static /* synthetic */ void zzn(zzcp zzcp, int i, zzcn zzcn) {
        zzcn.getClass();
        zzhz<zzcn> zzhz = zzcp.zzi;
        if (!zzhz.zza()) {
            zzcp.zzi = zzhs.zzbF(zzhz);
        }
        zzcp.zzi.set(i, zzcn);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List<zzcr> zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    public final zzcn zzg(int i) {
        return (zzcn) this.zzi.get(i);
    }

    public final List<zzbu> zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", zzcr.class, "zzi", zzcn.class, "zzj", zzbu.class, "zzk", "zzl", "zzm", zzeb.class});
        } else if (i2 == 3) {
            return new zzcp();
        } else {
            if (i2 == 4) {
                return new zzco((zzcl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzn;
        }
    }
}
