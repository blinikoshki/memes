package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdf extends zzhs<zzdf, zzde> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdf zzk;
    private int zza;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;
    /* access modifiers changed from: private */
    public zzhz<zzdf> zzj = zzbE();

    static {
        zzdf zzdf = new zzdf();
        zzk = zzdf;
        zzhs.zzby(zzdf.class, zzdf);
    }

    private zzdf() {
    }

    public static zzde zzn() {
        return (zzde) zzk.zzbt();
    }

    static /* synthetic */ void zzp(zzdf zzdf, String str) {
        str.getClass();
        zzdf.zza |= 1;
        zzdf.zze = str;
    }

    static /* synthetic */ void zzq(zzdf zzdf, String str) {
        str.getClass();
        zzdf.zza |= 2;
        zzdf.zzf = str;
    }

    static /* synthetic */ void zzr(zzdf zzdf) {
        zzdf.zza &= -3;
        zzdf.zzf = zzk.zzf;
    }

    static /* synthetic */ void zzs(zzdf zzdf, long j) {
        zzdf.zza |= 4;
        zzdf.zzg = j;
    }

    static /* synthetic */ void zzt(zzdf zzdf) {
        zzdf.zza &= -5;
        zzdf.zzg = 0;
    }

    static /* synthetic */ void zzu(zzdf zzdf, double d) {
        zzdf.zza |= 16;
        zzdf.zzi = d;
    }

    static /* synthetic */ void zzv(zzdf zzdf) {
        zzdf.zza &= -17;
        zzdf.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    static /* synthetic */ void zzw(zzdf zzdf, zzdf zzdf2) {
        zzdf2.getClass();
        zzdf.zzz();
        zzdf.zzj.add(zzdf2);
    }

    static /* synthetic */ void zzx(zzdf zzdf, Iterable iterable) {
        zzdf.zzz();
        zzgb.zzbs(iterable, zzdf.zzj);
    }

    private final void zzz() {
        zzhz<zzdf> zzhz = this.zzj;
        if (!zzhz.zza()) {
            this.zzj = zzhs.zzbF(zzhz);
        }
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
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

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final float zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final double zzj() {
        return this.zzi;
    }

    public final List<zzdf> zzk() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzdf.class});
        } else if (i2 == 3) {
            return new zzdf();
        } else {
            if (i2 == 4) {
                return new zzde((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }

    public final int zzm() {
        return this.zzj.size();
    }
}
