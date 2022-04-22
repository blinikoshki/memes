package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzcx extends zzhs<zzcx, zzcw> implements zziy {
    /* access modifiers changed from: private */
    public static final zzcx zzi;
    private int zza;
    private int zze;
    private zzdq zzf;
    private zzdq zzg;
    private boolean zzh;

    static {
        zzcx zzcx = new zzcx();
        zzi = zzcx;
        zzhs.zzby(zzcx.class, zzcx);
    }

    private zzcx() {
    }

    public static zzcw zzh() {
        return (zzcw) zzi.zzbt();
    }

    static /* synthetic */ void zzj(zzcx zzcx, int i) {
        zzcx.zza |= 1;
        zzcx.zze = i;
    }

    static /* synthetic */ void zzk(zzcx zzcx, zzdq zzdq) {
        zzdq.getClass();
        zzcx.zzf = zzdq;
        zzcx.zza |= 2;
    }

    static /* synthetic */ void zzm(zzcx zzcx, zzdq zzdq) {
        zzcx.zzg = zzdq;
        zzcx.zza |= 4;
    }

    static /* synthetic */ void zzn(zzcx zzcx, boolean z) {
        zzcx.zza |= 8;
        zzcx.zzh = z;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzdq zzc() {
        zzdq zzdq = this.zzf;
        return zzdq == null ? zzdq.zzm() : zzdq;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final zzdq zze() {
        zzdq zzdq = this.zzg;
        return zzdq == null ? zzdq.zzm() : zzdq;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzcx();
        } else {
            if (i2 == 4) {
                return new zzcw((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
