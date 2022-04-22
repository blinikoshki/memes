package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfd extends zzaad<zzfd, zzfc> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfd zzf;
    private zzfg zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzfd zzfd = new zzfd();
        zzf = zzfd;
        zzaad.zzy(zzfd.class, zzfd);
    }

    private zzfd() {
    }

    public static zzfd zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfd) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzfc zzd() {
        return (zzfc) zzf.zzs();
    }

    public static zzfd zze() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfd zzfd, zzfg zzfg) {
        zzfg.getClass();
        zzfd.zzb = zzfg;
    }

    public final zzfg zza() {
        zzfg zzfg = this.zzb;
        return zzfg == null ? zzfg.zzc() : zzfg;
    }

    public final int zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfd();
        } else {
            if (i2 == 4) {
                return new zzfc((zzfb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
