package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdq extends zzhs<zzdq, zzdp> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdq zzh;
    /* access modifiers changed from: private */
    public zzhy zza = zzbC();
    /* access modifiers changed from: private */
    public zzhy zze = zzbC();
    private zzhz<zzcz> zzf = zzbE();
    private zzhz<zzds> zzg = zzbE();

    static {
        zzdq zzdq = new zzdq();
        zzh = zzdq;
        zzhs.zzby(zzdq.class, zzdq);
    }

    private zzdq() {
    }

    public static zzdp zzk() {
        return (zzdp) zzh.zzbt();
    }

    public static zzdq zzm() {
        return zzh;
    }

    static /* synthetic */ void zzo(zzdq zzdq, Iterable iterable) {
        zzhy zzhy = zzdq.zza;
        if (!zzhy.zza()) {
            zzdq.zza = zzhs.zzbD(zzhy);
        }
        zzgb.zzbs(iterable, zzdq.zza);
    }

    static /* synthetic */ void zzq(zzdq zzdq, Iterable iterable) {
        zzhy zzhy = zzdq.zze;
        if (!zzhy.zza()) {
            zzdq.zze = zzhs.zzbD(zzhy);
        }
        zzgb.zzbs(iterable, zzdq.zze);
    }

    static /* synthetic */ void zzs(zzdq zzdq, Iterable iterable) {
        zzdq.zzw();
        zzgb.zzbs(iterable, zzdq.zzf);
    }

    static /* synthetic */ void zzt(zzdq zzdq, int i) {
        zzdq.zzw();
        zzdq.zzf.remove(i);
    }

    static /* synthetic */ void zzu(zzdq zzdq, Iterable iterable) {
        zzdq.zzx();
        zzgb.zzbs(iterable, zzdq.zzg);
    }

    static /* synthetic */ void zzv(zzdq zzdq, int i) {
        zzdq.zzx();
        zzdq.zzg.remove(i);
    }

    private final void zzw() {
        zzhz<zzcz> zzhz = this.zzf;
        if (!zzhz.zza()) {
            this.zzf = zzhs.zzbF(zzhz);
        }
    }

    private final void zzx() {
        zzhz<zzds> zzhz = this.zzg;
        if (!zzhz.zza()) {
            this.zzg = zzhs.zzbF(zzhz);
        }
    }

    public final List<Long> zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final List<Long> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List<zzcz> zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final zzcz zzg(int i) {
        return (zzcz) this.zzf.get(i);
    }

    public final List<zzds> zzh() {
        return this.zzg;
    }

    public final int zzi() {
        return this.zzg.size();
    }

    public final zzds zzj(int i) {
        return (zzds) this.zzg.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzh, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zza", "zze", "zzf", zzcz.class, "zzg", zzds.class});
        } else if (i2 == 3) {
            return new zzdq();
        } else {
            if (i2 == 4) {
                return new zzdp((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
