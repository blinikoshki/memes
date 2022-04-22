package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhe */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhe extends zzaad<zzhe, zzhd> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzhe zzh;
    /* access modifiers changed from: private */
    public int zzb;
    private zzgy zze;
    /* access modifiers changed from: private */
    public zzzb zzf = zzzb.zzb;
    /* access modifiers changed from: private */
    public zzzb zzg = zzzb.zzb;

    static {
        zzhe zzhe = new zzhe();
        zzh = zzhe;
        zzaad.zzy(zzhe.class, zzhe);
    }

    private zzhe() {
    }

    public static zzhe zze(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzhe) zzaad.zzE(zzh, zzzb, zzzq);
    }

    public static zzhd zzf() {
        return (zzhd) zzh.zzs();
    }

    public static zzhe zzg() {
        return zzh;
    }

    static /* synthetic */ void zzk(zzhe zzhe, zzgy zzgy) {
        zzgy.getClass();
        zzhe.zze = zzgy;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzgy zzb() {
        zzgy zzgy = this.zze;
        return zzgy == null ? zzgy.zze() : zzgy;
    }

    public final zzzb zzc() {
        return this.zzf;
    }

    public final zzzb zzd() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzhe();
        } else {
            if (i2 == 4) {
                return new zzhd((zzhc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
