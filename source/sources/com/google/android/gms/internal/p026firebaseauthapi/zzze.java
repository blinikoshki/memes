package com.google.android.gms.internal.p026firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzze */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzze {
    int zza;
    zzzf zzb;

    /* synthetic */ zzze(zzzc zzzc) {
    }

    static zzze zzs(byte[] bArr, int i, int i2, boolean z) {
        zzzd zzzd = new zzzd(bArr, 0, i2, z, (zzzc) null);
        try {
            zzzd.zzm(i2);
            return zzzd;
        } catch (zzaal e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzt(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzu(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzaal;

    public abstract boolean zzc(int i) throws IOException;

    public abstract boolean zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract zzzb zzg() throws IOException;

    public abstract int zzm(int i) throws zzaal;

    public abstract void zzn(int i);

    public abstract boolean zzo() throws IOException;

    public abstract int zzp();
}
