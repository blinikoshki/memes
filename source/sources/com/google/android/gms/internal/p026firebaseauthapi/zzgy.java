package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgy */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzgy extends zzaad<zzgy, zzgx> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzgy zzg;
    private zzhh zzb;
    private zzgs zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgy zzgy = new zzgy();
        zzg = zzgy;
        zzaad.zzy(zzgy.class, zzgy);
    }

    private zzgy() {
    }

    public static zzgx zzd() {
        return (zzgx) zzg.zzs();
    }

    public static zzgy zze() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzgy zzgy, zzhh zzhh) {
        zzhh.getClass();
        zzgy.zzb = zzhh;
    }

    static /* synthetic */ void zzh(zzgy zzgy, zzgs zzgs) {
        zzgs.getClass();
        zzgy.zze = zzgs;
    }

    public final zzhh zza() {
        zzhh zzhh = this.zzb;
        return zzhh == null ? zzhh.zze() : zzhh;
    }

    public final zzgs zzb() {
        zzgs zzgs = this.zze;
        return zzgs == null ? zzgs.zzc() : zzgs;
    }

    public final zzgp zzc() {
        zzgp zzb2 = zzgp.zzb(this.zzf);
        return zzb2 == null ? zzgp.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgy();
        } else {
            if (i2 == 4) {
                return new zzgx((zzgw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
