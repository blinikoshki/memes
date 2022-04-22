package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfp */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfp extends zzaad<zzfp, zzfo> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfp zze;
    /* access modifiers changed from: private */
    public int zzb;

    static {
        zzfp zzfp = new zzfp();
        zze = zzfp;
        zzaad.zzy(zzfp.class, zzfp);
    }

    private zzfp() {
    }

    public static zzfo zzb() {
        return (zzfo) zze.zzs();
    }

    public static zzfp zzc() {
        return zze;
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
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzfp();
        } else {
            if (i2 == 4) {
                return new zzfo((zzfn) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
