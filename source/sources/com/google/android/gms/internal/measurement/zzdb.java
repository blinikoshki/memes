package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdb extends zzhs<zzdb, zzda> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdb zzj;
    private int zza;
    /* access modifiers changed from: private */
    public zzhz<zzdf> zze = zzbE();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzdb zzdb = new zzdb();
        zzj = zzdb;
        zzhs.zzby(zzdb.class, zzdb);
    }

    private zzdb() {
    }

    public static zzda zzk() {
        return (zzda) zzj.zzbt();
    }

    static /* synthetic */ void zzn(zzdb zzdb, int i, zzdf zzdf) {
        zzdf.getClass();
        zzdb.zzv();
        zzdb.zze.set(i, zzdf);
    }

    static /* synthetic */ void zzo(zzdb zzdb, zzdf zzdf) {
        zzdf.getClass();
        zzdb.zzv();
        zzdb.zze.add(zzdf);
    }

    static /* synthetic */ void zzp(zzdb zzdb, Iterable iterable) {
        zzdb.zzv();
        zzgb.zzbs(iterable, zzdb.zze);
    }

    static /* synthetic */ void zzr(zzdb zzdb, int i) {
        zzdb.zzv();
        zzdb.zze.remove(i);
    }

    static /* synthetic */ void zzs(zzdb zzdb, String str) {
        str.getClass();
        zzdb.zza |= 1;
        zzdb.zzf = str;
    }

    static /* synthetic */ void zzt(zzdb zzdb, long j) {
        zzdb.zza |= 2;
        zzdb.zzg = j;
    }

    static /* synthetic */ void zzu(zzdb zzdb, long j) {
        zzdb.zza |= 4;
        zzdb.zzh = j;
    }

    private final void zzv() {
        zzhz<zzdf> zzhz = this.zze;
        if (!zzhz.zza()) {
            this.zze = zzhs.zzbF(zzhz);
        }
    }

    public final List<zzdf> zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final zzdf zzc(int i) {
        return (zzdf) this.zze.get(i);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 2) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 4) != 0;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 8) != 0;
    }

    public final int zzj() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zza", "zze", zzdf.class, "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzdb();
        } else {
            if (i2 == 4) {
                return new zzda((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
