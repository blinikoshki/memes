package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdu extends zzhs<zzdu, zzdt> implements zziy {
    /* access modifiers changed from: private */
    public static final zzdu zzk;
    private int zza;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzdu zzdu = new zzdu();
        zzk = zzdu;
        zzhs.zzby(zzdu.class, zzdu);
    }

    private zzdu() {
    }

    public static zzdt zzj() {
        return (zzdt) zzk.zzbt();
    }

    static /* synthetic */ void zzm(zzdu zzdu, long j) {
        zzdu.zza |= 1;
        zzdu.zze = j;
    }

    static /* synthetic */ void zzn(zzdu zzdu, String str) {
        str.getClass();
        zzdu.zza |= 2;
        zzdu.zzf = str;
    }

    static /* synthetic */ void zzo(zzdu zzdu, String str) {
        str.getClass();
        zzdu.zza |= 4;
        zzdu.zzg = str;
    }

    static /* synthetic */ void zzp(zzdu zzdu) {
        zzdu.zza &= -5;
        zzdu.zzg = zzk.zzg;
    }

    static /* synthetic */ void zzq(zzdu zzdu, long j) {
        zzdu.zza |= 8;
        zzdu.zzh = j;
    }

    static /* synthetic */ void zzr(zzdu zzdu) {
        zzdu.zza &= -9;
        zzdu.zzh = 0;
    }

    static /* synthetic */ void zzs(zzdu zzdu, double d) {
        zzdu.zza |= 32;
        zzdu.zzj = d;
    }

    static /* synthetic */ void zzt(zzdu zzdu) {
        zzdu.zza &= -33;
        zzdu.zzj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zza & 32) != 0;
    }

    public final double zzi() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzdu();
        } else {
            if (i2 == 4) {
                return new zzdt((zzcs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
