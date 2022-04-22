package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzic extends zzaad<zzic, zzhz> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzic zzg;
    /* access modifiers changed from: private */
    public String zzb = "";
    /* access modifiers changed from: private */
    public zzzb zze = zzzb.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzic zzic = new zzic();
        zzg = zzic;
        zzaad.zzy(zzic.class, zzic);
    }

    private zzic() {
    }

    public static zzhz zzd() {
        return (zzhz) zzg.zzs();
    }

    public static zzic zze() {
        return zzg;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzzb zzb() {
        return this.zze;
    }

    public final zzib zzc() {
        zzib zzb2 = zzib.zzb(this.zzf);
        return zzb2 == null ? zzib.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzic();
        } else {
            if (i2 == 4) {
                return new zzhz((zzhy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
