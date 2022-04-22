package com.google.android.gms.internal.p026firebaseauthapi;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
abstract class zzacq {
    final Unsafe zza;

    zzacq(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(Object obj, long j);

    public abstract void zzb(Object obj, long j, byte b);

    public abstract boolean zzc(Object obj, long j);

    public abstract void zzd(Object obj, long j, boolean z);

    public abstract float zze(Object obj, long j);

    public abstract void zzf(Object obj, long j, float f);

    public abstract double zzg(Object obj, long j);

    public abstract void zzh(Object obj, long j, double d);

    public boolean zzi() {
        Unsafe unsafe = this.zza;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("arrayIndexScale", new Class[]{Class.class});
                cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
                cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
                return true;
            } catch (Throwable th) {
                zzacr.zzs(th);
            }
        }
        return false;
    }

    public boolean zzj() {
        Unsafe unsafe = this.zza;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                return zzacr.zzF() != null;
            } catch (Throwable th) {
                zzacr.zzs(th);
            }
        }
        return false;
    }

    public final long zzk(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzl(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzm(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzn(Object obj, long j) {
        return this.zza.getInt(obj, j);
    }

    public final void zzo(Object obj, long j, int i) {
        this.zza.putInt(obj, j, i);
    }

    public final long zzp(Object obj, long j) {
        return this.zza.getLong(obj, j);
    }

    public final void zzq(Object obj, long j, long j2) {
        this.zza.putLong(obj, j, j2);
    }

    public final Object zzr(Object obj, long j) {
        return this.zza.getObject(obj, j);
    }

    public final void zzs(Object obj, long j, Object obj2) {
        this.zza.putObject(obj, j, obj2);
    }
}
