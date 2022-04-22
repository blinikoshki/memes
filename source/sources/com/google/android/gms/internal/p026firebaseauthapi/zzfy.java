package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfy extends zzaad<zzfy, zzfx> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfy zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzzb zze = zzzb.zzb;

    static {
        zzfy zzfy = new zzfy();
        zzf = zzfy;
        zzaad.zzy(zzfy.class, zzfy);
    }

    private zzfy() {
    }

    public static zzfy zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfy) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzfx zzd() {
        return (zzfx) zzf.zzs();
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
            return new zzfy();
        } else {
            if (i2 == 4) {
                return new zzfx((zzfw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
