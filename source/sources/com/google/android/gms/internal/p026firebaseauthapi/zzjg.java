package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzjg extends zzaad<zzjg, zzjf> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzjg zzf;
    private String zzb = "";
    private zzih zze;

    static {
        zzjg zzjg = new zzjg();
        zzf = zzjg;
        zzaad.zzy(zzjg.class, zzjg);
    }

    private zzjg() {
    }

    public static zzjg zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzjg) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzjg zzd() {
        return zzf;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzih zzb() {
        zzih zzih = this.zze;
        return zzih == null ? zzih.zze() : zzih;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzjg();
        } else {
            if (i2 == 4) {
                return new zzjf((zzje) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
