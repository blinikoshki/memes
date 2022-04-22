package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgv */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzgv extends zzaad<zzgv, zzgu> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzgv zze;
    private zzgy zzb;

    static {
        zzgv zzgv = new zzgv();
        zze = zzgv;
        zzaad.zzy(zzgv.class, zzgv);
    }

    private zzgv() {
    }

    public static zzgv zzb(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzgv) zzaad.zzE(zze, zzzb, zzzq);
    }

    public static zzgu zzc() {
        return (zzgu) zze.zzs();
    }

    static /* synthetic */ void zze(zzgv zzgv, zzgy zzgy) {
        zzgy.getClass();
        zzgv.zzb = zzgy;
    }

    public final zzgy zza() {
        zzgy zzgy = this.zzb;
        return zzgy == null ? zzgy.zze() : zzgy;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzgv();
        } else {
            if (i2 == 4) {
                return new zzgu((zzgt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
