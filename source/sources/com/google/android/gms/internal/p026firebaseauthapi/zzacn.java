package com.google.android.gms.internal.p026firebaseauthapi;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacn */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzacn extends zzacq {
    zzacn(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object obj, long j) {
        if (zzacr.zzb) {
            return zzacr.zzH(obj, j);
        }
        return zzacr.zzI(obj, j);
    }

    public final void zzb(Object obj, long j, byte b) {
        if (zzacr.zzb) {
            zzacr.zzJ(obj, j, b);
        } else {
            zzacr.zzK(obj, j, b);
        }
    }

    public final boolean zzc(Object obj, long j) {
        if (zzacr.zzb) {
            return zzacr.zzy(obj, j);
        }
        return zzacr.zzz(obj, j);
    }

    public final void zzd(Object obj, long j, boolean z) {
        if (zzacr.zzb) {
            zzacr.zzJ(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzacr.zzK(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final float zze(Object obj, long j) {
        return Float.intBitsToFloat(zzn(obj, j));
    }

    public final void zzf(Object obj, long j, float f) {
        zzo(obj, j, Float.floatToIntBits(f));
    }

    public final double zzg(Object obj, long j) {
        return Double.longBitsToDouble(zzp(obj, j));
    }

    public final void zzh(Object obj, long j, double d) {
        zzq(obj, j, Double.doubleToLongBits(d));
    }
}
