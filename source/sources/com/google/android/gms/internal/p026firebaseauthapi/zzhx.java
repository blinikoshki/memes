package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhx */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhx extends zzaad<zzhx, zzhw> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzhx zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzhx zzhx = new zzhx();
        zzf = zzhx;
        zzaad.zzy(zzhx.class, zzhx);
    }

    private zzhx() {
    }

    public static zzhw zzc() {
        return (zzhw) zzf.zzs();
    }

    public static zzhx zzd() {
        return zzf;
    }

    public final zzho zza() {
        zzho zzb2 = zzho.zzb(this.zzb);
        return zzb2 == null ? zzho.UNRECOGNIZED : zzb2;
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
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzhx();
        } else {
            if (i2 == 4) {
                return new zzhw((zzhv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
