package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzja extends zzaad<zzja, zziz> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzja zze;
    private String zzb = "";

    static {
        zzja zzja = new zzja();
        zze = zzja;
        zzaad.zzy(zzja.class, zzja);
    }

    private zzja() {
    }

    public static zzja zzb(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzja) zzaad.zzE(zze, zzzb, zzzq);
    }

    public static zzja zzc() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzja();
        } else {
            if (i2 == 4) {
                return new zziz((zziy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
