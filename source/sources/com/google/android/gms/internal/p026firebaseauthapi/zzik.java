package com.google.android.gms.internal.p026firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzik */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzik extends zzaad<zzik, zzij> implements zzabh {
    /* access modifiers changed from: private */
    public static final zzik zzi;
    private String zzb = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzik zzik = new zzik();
        zzi = zzik;
        zzaad.zzy(zzik.class, zzik);
    }

    private zzik() {
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzz(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzik();
        } else {
            if (i2 == 4) {
                return new zzij((zzii) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
