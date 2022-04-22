package com.google.android.gms.internal.p026firebaseauthapi;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacp */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzacp extends zzacq {
    zzacp(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object obj, long j) {
        return this.zza.getByte(obj, j);
    }

    public final void zzb(Object obj, long j, byte b) {
        this.zza.putByte(obj, j, b);
    }

    public final boolean zzc(Object obj, long j) {
        return this.zza.getBoolean(obj, j);
    }

    public final void zzd(Object obj, long j, boolean z) {
        this.zza.putBoolean(obj, j, z);
    }

    public final float zze(Object obj, long j) {
        return this.zza.getFloat(obj, j);
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putFloat(obj, j, f);
    }

    public final double zzg(Object obj, long j) {
        return this.zza.getDouble(obj, j);
    }

    public final void zzh(Object obj, long j, double d) {
        this.zza.putDouble(obj, j, d);
    }

    public final boolean zzi() {
        if (!super.zzi()) {
            return false;
        }
        try {
            Class<?> cls = this.zza.getClass();
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            zzacr.zzs(th);
            return false;
        }
    }

    public final boolean zzj() {
        if (!super.zzj()) {
            return false;
        }
        try {
            Class<?> cls = this.zza.getClass();
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            zzacr.zzs(th);
            return false;
        }
    }
}
