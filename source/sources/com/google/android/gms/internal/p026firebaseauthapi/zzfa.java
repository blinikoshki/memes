package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfa */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfa extends zzaad<zzfa, zzez> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfa zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzfg zze;
    /* access modifiers changed from: private */
    public zzzb zzf = zzzb.zzb;

    static {
        zzfa zzfa = new zzfa();
        zzg = zzfa;
        zzaad.zzy(zzfa.class, zzfa);
    }

    private zzfa() {
    }

    public static zzfa zzd(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfa) zzaad.zzE(zzg, zzzb, zzzq);
    }

    public static zzez zze() {
        return (zzez) zzg.zzs();
    }

    public static zzfa zzf() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzfa zzfa, zzfg zzfg) {
        zzfg.getClass();
        zzfa.zze = zzfg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfg zzb() {
        zzfg zzfg = this.zze;
        return zzfg == null ? zzfg.zzc() : zzfg;
    }

    public final zzzb zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfa();
        } else {
            if (i2 == 4) {
                return new zzez((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
