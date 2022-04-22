package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhm extends zzaad<zzhm, zzhl> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzhm zzf;
    /* access modifiers changed from: private */
    public zzzb zzb = zzzb.zzb;
    private zziu zze;

    static {
        zzhm zzhm = new zzhm();
        zzf = zzhm;
        zzaad.zzy(zzhm.class, zzhm);
    }

    private zzhm() {
    }

    public static zzhm zzb(byte[] bArr, zzzq zzzq) throws zzaal {
        return (zzhm) zzaad.zzF(zzf, bArr, zzzq);
    }

    public static zzhl zzc() {
        return (zzhl) zzf.zzs();
    }

    static /* synthetic */ void zzf(zzhm zzhm, zziu zziu) {
        zziu.getClass();
        zzhm.zze = zziu;
    }

    public final zzzb zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzhm();
        } else {
            if (i2 == 4) {
                return new zzhl((zzhk) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
