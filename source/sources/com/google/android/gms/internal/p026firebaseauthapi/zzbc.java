package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzbc implements Comparable<zzbc> {
    private final byte[] zza;

    /* synthetic */ zzbc(byte[] bArr, zzba zzba) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzbc zzbc = (zzbc) obj;
        int length = this.zza.length;
        int length2 = zzbc.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = zzbc.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbc)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzbc) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzkw.zza(this.zza);
    }
}
