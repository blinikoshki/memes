package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.internal.p026firebaseauthapi.zzaad;
import com.google.android.gms.internal.p026firebaseauthapi.zzzz;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzaad<MessageType extends zzaad<MessageType, BuilderType>, BuilderType extends zzzz<MessageType, BuilderType>> extends zzyj<MessageType, BuilderType> {
    private static final Map<Object, zzaad<?, ?>> zzb = new ConcurrentHashMap();
    protected zzach zzc = zzach.zza();
    protected int zzd = -1;

    static Object zzA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <E> zzaai<E> zzB() {
        return zzabp.zzd();
    }

    protected static <E> zzaai<E> zzC(zzaai<E> zzaai) {
        int size = zzaai.size();
        return zzaai.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzaad<T, ?>> T zzD(T t, byte[] bArr, int i, int i2, zzzq zzzq) throws zzaal {
        T t2 = (zzaad) t.zzj(4, (Object) null, (Object) null);
        try {
            zzabs<?> zzb2 = zzabo.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, 0, i2, new zzym(zzzq));
            zzb2.zzj(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzaal) {
                throw ((zzaal) e.getCause());
            }
            zzaal zzaal = new zzaal(e.getMessage());
            zzaal.zza(t2);
            throw zzaal;
        } catch (IndexOutOfBoundsException unused) {
            zzaal zzb3 = zzaal.zzb();
            zzb3.zza(t2);
            throw zzb3;
        }
    }

    protected static <T extends zzaad<T, ?>> T zzE(T t, zzzb zzzb, zzzq zzzq) throws zzaal {
        T t2;
        try {
            zzze zzk = zzzb.zzk();
            t2 = (zzaad) t.zzj(4, (Object) null, (Object) null);
            zzabs<?> zzb2 = zzabo.zza().zzb(t2.getClass());
            zzb2.zzf(t2, zzzf.zza(zzk), zzzq);
            zzb2.zzj(t2);
            zzk.zzb(0);
            zza(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzaal) {
                throw ((zzaal) e.getCause());
            }
            zzaal zzaal = new zzaal(e.getMessage());
            zzaal.zza(t2);
            throw zzaal;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzaal) {
                throw ((zzaal) e2.getCause());
            }
            throw e2;
        } catch (zzaal e3) {
            e3.zza(t2);
            throw e3;
        } catch (zzaal e4) {
            throw e4;
        }
    }

    protected static <T extends zzaad<T, ?>> T zzF(T t, byte[] bArr, zzzq zzzq) throws zzaal {
        T zzD = zzD(t, bArr, 0, bArr.length, zzzq);
        zza(zzD);
        return zzD;
    }

    private static <T extends zzaad<T, ?>> T zza(T t) throws zzaal {
        if (t == null || t.zzt()) {
            return t;
        }
        zzaal zzaal = new zzaal(new zzacf(t).getMessage());
        zzaal.zza(t);
        throw zzaal;
    }

    static <T extends zzaad> T zzx(Class<T> cls) {
        Map<Object, zzaad<?, ?>> map = zzb;
        T t = (zzaad) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzaad) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzaad) ((zzaad) zzacr.zzc(cls)).zzj(6, (Object) null, (Object) null);
            if (t != null) {
                map.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzaad> void zzy(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    protected static Object zzz(zzabg zzabg, String str, Object[] objArr) {
        return new zzabq(zzabg, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzabo.zza().zzb(getClass()).zzb(this, (zzaad) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzabo.zza().zzb(getClass()).zzc(this);
        this.zza = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zzabi.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzabf zzG() {
        zzzz zzzz = (zzzz) zzj(5, (Object) null, (Object) null);
        zzzz.zzm(this);
        return zzzz;
    }

    public final /* bridge */ /* synthetic */ zzabf zzH() {
        return (zzzz) zzj(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);

    public final /* bridge */ /* synthetic */ zzabg zzo() {
        return (zzaad) zzj(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzq() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzr(int i) {
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzaad<MessageType, BuilderType>, BuilderType extends zzzz<MessageType, BuilderType>> BuilderType zzs() {
        return (zzzz) zzj(5, (Object) null, (Object) null);
    }

    public final BuilderType zzu() {
        BuilderType buildertype = (zzzz) zzj(5, (Object) null, (Object) null);
        buildertype.zzm(this);
        return buildertype;
    }

    public final void zzv(zzzl zzzl) throws IOException {
        zzabo.zza().zzb(getClass()).zzn(this, zzzm.zza(zzzl));
    }

    public final int zzw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzabo.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }

    public final boolean zzt() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzj(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzabo.zza().zzb(getClass()).zzk(this);
        zzj(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }
}
