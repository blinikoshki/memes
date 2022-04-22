package com.google.android.gms.internal.p026firebaseauthapi;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzacr {
    static final long zza = ((long) zzC(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzyl.zzb();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzacq zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    static {
        boolean z;
        boolean z2;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        Unsafe zzr = zzr();
        zzc = zzr;
        boolean zzE = zzE(Long.TYPE);
        zze = zzE;
        boolean zzE2 = zzE(Integer.TYPE);
        zzf = zzE2;
        zzacq zzacq = null;
        if (zzr != null) {
            if (!zzyl.zza()) {
                zzacq = new zzacp(zzr);
            } else if (zzE) {
                zzacq = new zzaco(zzr);
            } else if (zzE2) {
                zzacq = new zzacn(zzr);
            }
        }
        zzg = zzacq;
        boolean z3 = false;
        if (zzacq == null) {
            z = false;
        } else {
            z = zzacq.zzj();
        }
        zzh = z;
        if (zzacq == null) {
            z2 = false;
        } else {
            z2 = zzacq.zzi();
        }
        zzi = z2;
        zzC(cls5);
        zzD(cls5);
        zzC(cls4);
        zzD(cls4);
        zzC(cls3);
        zzD(cls3);
        zzC(cls2);
        zzD(cls2);
        zzC(cls);
        zzD(cls);
        zzC(Object[].class);
        zzD(Object[].class);
        Field zzF = zzF();
        if (!(zzF == null || zzacq == null)) {
            zzacq.zzk(zzF);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        }
        zzb = z3;
    }

    private zzacr() {
    }

    private static int zzC(Class<?> cls) {
        if (zzi) {
            return zzg.zzl(cls);
        }
        return -1;
    }

    private static int zzD(Class<?> cls) {
        if (zzi) {
            return zzg.zzm(cls);
        }
        return -1;
    }

    private static boolean zzE(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzyl.zza()) {
            return false;
        }
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static Field zzF() {
        Field zzG;
        if (zzyl.zza() && (zzG = zzG(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzG;
        }
        Field zzG2 = zzG(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (zzG2 == null || zzG2.getType() != Long.TYPE) {
            return null;
        }
        return zzG2;
    }

    private static Field zzG(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzH(Object obj, long j) {
        return (byte) ((zzg.zzn(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte zzI(Object obj, long j) {
        return (byte) ((zzg.zzn(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static void zzJ(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzacq zzacq = zzg;
        int zzn = zzacq.zzn(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzacq.zzo(obj, j2, ((255 & b) << i) | (zzn & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzK(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzacq zzacq = zzg;
        int i = (((int) j) & 3) << 3;
        zzacq.zzo(obj, j2, ((255 & b) << i) | (zzacq.zzn(obj, j2) & (~(255 << i))));
    }

    static boolean zza() {
        return zzi;
    }

    static boolean zzb() {
        return zzh;
    }

    static <T> T zzc(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static int zzd(Object obj, long j) {
        return zzg.zzn(obj, j);
    }

    static void zze(Object obj, long j, int i) {
        zzg.zzo(obj, j, i);
    }

    static long zzf(Object obj, long j) {
        return zzg.zzp(obj, j);
    }

    static void zzg(Object obj, long j, long j2) {
        zzg.zzq(obj, j, j2);
    }

    static boolean zzh(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    static void zzi(Object obj, long j, boolean z) {
        zzg.zzd(obj, j, z);
    }

    static float zzj(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    static void zzk(Object obj, long j, float f) {
        zzg.zzf(obj, j, f);
    }

    static double zzl(Object obj, long j) {
        return zzg.zzg(obj, j);
    }

    static void zzm(Object obj, long j, double d) {
        zzg.zzh(obj, j, d);
    }

    static Object zzn(Object obj, long j) {
        return zzg.zzr(obj, j);
    }

    static void zzo(Object obj, long j, Object obj2) {
        zzg.zzs(obj, j, obj2);
    }

    static byte zzp(byte[] bArr, long j) {
        return zzg.zza(bArr, zza + j);
    }

    static void zzq(byte[] bArr, long j, byte b) {
        zzg.zzb(bArr, zza + j, b);
    }

    static Unsafe zzr() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzacm());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzs(Throwable th) {
        Logger logger = Logger.getLogger(zzacr.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static /* synthetic */ boolean zzy(Object obj, long j) {
        return zzH(obj, j) != 0;
    }

    static /* synthetic */ boolean zzz(Object obj, long j) {
        return zzI(obj, j) != 0;
    }
}
