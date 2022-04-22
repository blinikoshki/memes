package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhh */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhh extends zzaad<zzhh, zzhg> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzhh zzg;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzzb zzf = zzzb.zzb;

    static {
        zzhh zzhh = new zzhh();
        zzg = zzhh;
        zzaad.zzy(zzhh.class, zzhh);
    }

    private zzhh() {
    }

    public static zzhg zzd() {
        return (zzhg) zzg.zzs();
    }

    public static zzhh zze() {
        return zzg;
    }

    public final zzhj zza() {
        zzhj zzb2 = zzhj.zzb(this.zzb);
        return zzb2 == null ? zzhj.UNRECOGNIZED : zzb2;
    }

    public final zzho zzb() {
        zzho zzb2 = zzho.zzb(this.zze);
        return zzb2 == null ? zzho.UNRECOGNIZED : zzb2;
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
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzhh();
        } else {
            if (i2 == 4) {
                return new zzhg((zzhf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
