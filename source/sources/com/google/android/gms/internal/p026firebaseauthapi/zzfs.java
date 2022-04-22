package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfs */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfs extends zzaad<zzfs, zzfr> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfs zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzzb zze = zzzb.zzb;

    static {
        zzfs zzfs = new zzfs();
        zzf = zzfs;
        zzaad.zzy(zzfs.class, zzfs);
    }

    private zzfs() {
    }

    public static zzfs zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfs) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzfr zzd() {
        return (zzfr) zzf.zzs();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzzb zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfs();
        } else {
            if (i2 == 4) {
                return new zzfr((zzfq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
