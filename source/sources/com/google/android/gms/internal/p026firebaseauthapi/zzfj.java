package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfj */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzfj extends zzaad<zzfj, zzfi> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzfj zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzfp zze;
    /* access modifiers changed from: private */
    public zzzb zzf = zzzb.zzb;

    static {
        zzfj zzfj = new zzfj();
        zzg = zzfj;
        zzaad.zzy(zzfj.class, zzfj);
    }

    private zzfj() {
    }

    public static zzfj zzd(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzfj) zzaad.zzE(zzg, zzzb, zzzq);
    }

    public static zzfi zze() {
        return (zzfi) zzg.zzs();
    }

    static /* synthetic */ void zzh(zzfj zzfj, zzfp zzfp) {
        zzfp.getClass();
        zzfj.zze = zzfp;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfp zzb() {
        zzfp zzfp = this.zze;
        return zzfp == null ? zzfp.zzc() : zzfp;
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
            return new zzfj();
        } else {
            if (i2 == 4) {
                return new zzfi((zzfh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
