package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgs */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzgs extends zzaad<zzgs, zzgr> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzgs zze;
    private zzih zzb;

    static {
        zzgs zzgs = new zzgs();
        zze = zzgs;
        zzaad.zzy(zzgs.class, zzgs);
    }

    private zzgs() {
    }

    public static zzgr zzb() {
        return (zzgr) zze.zzs();
    }

    public static zzgs zzc() {
        return zze;
    }

    static /* synthetic */ void zze(zzgs zzgs, zzih zzih) {
        zzih.getClass();
        zzgs.zzb = zzih;
    }

    public final zzih zza() {
        zzih zzih = this.zzb;
        return zzih == null ? zzih.zze() : zzih;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzgs();
        } else {
            if (i2 == 4) {
                return new zzgr((zzgq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
