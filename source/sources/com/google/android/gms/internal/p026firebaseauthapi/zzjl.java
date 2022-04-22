package com.google.android.gms.internal.p026firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzjl extends zzaad<zzjl, zzjk> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzjl zzf;
    private String zzb = "";
    private zzaai<zzik> zze = zzB();

    static {
        zzjl zzjl = new zzjl();
        zzf = zzjl;
        zzaad.zzy(zzjl.class, zzjl);
    }

    private zzjl() {
    }

    public static zzjl zza() {
        return zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zze", zzik.class});
        } else if (i2 == 3) {
            return new zzjl();
        } else {
            if (i2 == 4) {
                return new zzjk((zzjj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
