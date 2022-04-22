package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfg extends zzaad<zzfg, zzff> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfg zze;
    /* access modifiers changed from: private */
    public int zzb;

    static {
        zzfg zzfg = new zzfg();
        zze = zzfg;
        zzaad.zzy(zzfg.class, zzfg);
    }

    private zzfg() {
    }

    public static zzff zzb() {
        return (zzff) zze.zzs();
    }

    public static zzfg zzc() {
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
            return new zzfg();
        } else {
            if (i2 == 4) {
                return new zzff((zzfe) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
