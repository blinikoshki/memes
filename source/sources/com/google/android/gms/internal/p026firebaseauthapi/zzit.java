package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzit */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzit extends zzaad<zzit, zzis> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzit zzh;
    private String zzb = "";
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzit zzit = new zzit();
        zzh = zzit;
        zzaad.zzy(zzit.class, zzit);
    }

    private zzit() {
    }

    public static zzis zzb() {
        return (zzis) zzh.zzs();
    }

    static /* synthetic */ void zzd(zzit zzit, String str) {
        str.getClass();
        zzit.zzb = str;
    }

    public final int zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzit();
        } else {
            if (i2 == 4) {
                return new zzis((zziq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
