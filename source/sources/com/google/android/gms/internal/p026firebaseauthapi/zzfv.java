package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfv */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfv extends zzaad<zzfv, zzfu> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfv zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private int zze;

    static {
        zzfv zzfv = new zzfv();
        zzf = zzfv;
        zzaad.zzy(zzfv.class, zzfv);
    }

    private zzfv() {
    }

    public static zzfv zzb(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfv) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzfu zzc() {
        return (zzfu) zzf.zzs();
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfv();
        } else {
            if (i2 == 4) {
                return new zzfu((zzft) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
