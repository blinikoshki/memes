package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzel */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzel extends zzaad<zzel, zzek> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzel zzg;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzzb zze = zzzb.zzb;
    private zzer zzf;

    static {
        zzel zzel = new zzel();
        zzg = zzel;
        zzaad.zzy(zzel.class, zzel);
    }

    private zzel() {
    }

    public static zzel zzd(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzel) zzaad.zzE(zzg, zzzb, zzzq);
    }

    public static zzek zze() {
        return (zzek) zzg.zzs();
    }

    static /* synthetic */ void zzi(zzel zzel, zzer zzer) {
        zzer.getClass();
        zzel.zzf = zzer;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzzb zzb() {
        return this.zze;
    }

    public final zzer zzc() {
        zzer zzer = this.zzf;
        return zzer == null ? zzer.zzb() : zzer;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzel();
        } else {
            if (i2 == 4) {
                return new zzek((zzej) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
