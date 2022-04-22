package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzex extends zzaad<zzex, zzew> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzex zzf;
    private zzfd zzb;
    private zzhu zze;

    static {
        zzex zzex = new zzex();
        zzf = zzex;
        zzaad.zzy(zzex.class, zzex);
    }

    private zzex() {
    }

    public static zzex zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzex) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzew zzd() {
        return (zzew) zzf.zzs();
    }

    static /* synthetic */ void zzf(zzex zzex, zzfd zzfd) {
        zzfd.getClass();
        zzex.zzb = zzfd;
    }

    static /* synthetic */ void zzg(zzex zzex, zzhu zzhu) {
        zzhu.getClass();
        zzex.zze = zzhu;
    }

    public final zzfd zza() {
        zzfd zzfd = this.zzb;
        return zzfd == null ? zzfd.zze() : zzfd;
    }

    public final zzhu zzb() {
        zzhu zzhu = this.zze;
        return zzhu == null ? zzhu.zze() : zzhu;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzex();
        } else {
            if (i2 == 4) {
                return new zzew((zzev) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
