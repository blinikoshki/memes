package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzeo extends zzaad<zzeo, zzen> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzeo zzf;
    private int zzb;
    private zzer zze;

    static {
        zzeo zzeo = new zzeo();
        zzf = zzeo;
        zzaad.zzy(zzeo.class, zzeo);
    }

    private zzeo() {
    }

    public static zzeo zzc(zzzb zzzb, zzzq zzzq) throws zzaal {
        return (zzeo) zzaad.zzE(zzf, zzzb, zzzq);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzer zzb() {
        zzer zzer = this.zze;
        return zzer == null ? zzer.zzb() : zzer;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzeo();
        } else {
            if (i2 == 4) {
                return new zzen((zzem) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
