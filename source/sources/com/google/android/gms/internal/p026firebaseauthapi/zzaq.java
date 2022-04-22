package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzaq {
    private final zzih zza;

    private zzaq(zzih zzih) {
        this.zza = zzih;
    }

    public static zzaq zzb(String str, byte[] bArr, int i) {
        zzji zzji;
        zzig zzd = zzih.zzd();
        zzd.zza(str);
        zzd.zzb(zzzb.zzm(bArr));
        zzji zzji2 = zzji.UNKNOWN_PREFIX;
        int i2 = i - 1;
        if (i2 != 0) {
            zzji = i2 != 1 ? i2 != 2 ? zzji.CRUNCHY : zzji.RAW : zzji.LEGACY;
        } else {
            zzji = zzji.TINK;
        }
        zzd.zzc(zzji);
        return new zzaq((zzih) zzd.zzl());
    }

    /* access modifiers changed from: package-private */
    public final zzih zza() {
        return this.zza;
    }
}
