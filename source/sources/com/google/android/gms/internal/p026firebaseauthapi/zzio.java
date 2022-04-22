package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzio */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzio extends zzaad<zzio, zzin> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzio zzh;
    private zzic zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzio zzio = new zzio();
        zzh = zzio;
        zzaad.zzy(zzio.class, zzio);
    }

    private zzio() {
    }

    public static zzin zzf() {
        return (zzin) zzh.zzs();
    }

    static /* synthetic */ void zzh(zzio zzio, zzic zzic) {
        zzic.getClass();
        zzio.zzb = zzic;
    }

    public final boolean zza() {
        return this.zzb != null;
    }

    public final zzic zzb() {
        zzic zzic = this.zzb;
        return zzic == null ? zzic.zze() : zzic;
    }

    public final zzie zzc() {
        zzie zzb2 = zzie.zzb(this.zze);
        return zzb2 == null ? zzie.UNRECOGNIZED : zzb2;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final zzji zze() {
        zzji zzb2 = zzji.zzb(this.zzg);
        return zzb2 == null ? zzji.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzio();
        } else {
            if (i2 == 4) {
                return new zzin((zzil) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
