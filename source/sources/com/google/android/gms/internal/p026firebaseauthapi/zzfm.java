package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfm extends zzaad<zzfm, zzfl> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfm zzf;
    private zzfp zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzfm zzfm = new zzfm();
        zzf = zzfm;
        zzaad.zzy(zzfm.class, zzfm);
    }

    private zzfm() {
    }

    public static zzfm zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfm) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public static zzfl zzd() {
        return (zzfl) zzf.zzs();
    }

    static /* synthetic */ void zzf(zzfm zzfm, zzfp zzfp) {
        zzfp.getClass();
        zzfm.zzb = zzfp;
    }

    public final zzfp zza() {
        zzfp zzfp = this.zzb;
        return zzfp == null ? zzfp.zzc() : zzfp;
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
            return new zzfm();
        } else {
            if (i2 == 4) {
                return new zzfl((zzfk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
