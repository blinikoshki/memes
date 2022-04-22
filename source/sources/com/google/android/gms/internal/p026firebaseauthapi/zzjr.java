package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzjr extends zzaad<zzjr, zzjq> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzjr zzb;

    static {
        zzjr zzjr = new zzjr();
        zzb = zzjr;
        zzaad.zzy(zzjr.class, zzjr);
    }

    private zzjr() {
    }

    public static zzjr zza(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzjr) zzaad.zzE(zzb, zzzb, zzzq);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzjr();
        }
        if (i2 == 4) {
            return new zzjq((zzjp) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
