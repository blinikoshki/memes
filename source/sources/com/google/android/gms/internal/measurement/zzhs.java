package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public abstract class zzhs<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzgb<MessageType, BuilderType> {
    private static final Map<Object, zzhs<?, ?>> zza = new ConcurrentHashMap();
    protected zzjx zzc = zzjx.zza();
    protected int zzd = -1;

    static Object zzbA(Method method, Object obj, Object... objArr) {
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

    protected static zzhx zzbB() {
        return zzht.zzd();
    }

    protected static zzhy zzbC() {
        return zzim.zzf();
    }

    protected static zzhy zzbD(zzhy zzhy) {
        int size = zzhy.size();
        return zzhy.zzd(size == 0 ? 10 : size + size);
    }

    protected static <E> zzhz<E> zzbE() {
        return zzjg.zzd();
    }

    protected static <E> zzhz<E> zzbF(zzhz<E> zzhz) {
        int size = zzhz.size();
        return zzhz.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzhs> T zzbx(Class<T> cls) {
        Map<Object, zzhs<?, ?>> map = zza;
        T t = (zzhs) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhs) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhs) ((zzhs) zzkh.zzc(cls)).zzl(6, (Object) null, (Object) null);
            if (t != null) {
                map.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzhs> void zzby(Class<T> cls, T t) {
        zza.put(cls, t);
    }

    protected static Object zzbz(zzix zzix, String str, Object[] objArr) {
        return new zzjh(zzix, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjf.zza().zzb(getClass()).zzb(this, (zzhs) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzc2 = zzjf.zza().zzb(getClass()).zzc(this);
        this.zzb = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zziz.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zziw zzbG() {
        zzho zzho = (zzho) zzl(5, (Object) null, (Object) null);
        zzho.zzaB(this);
        return zzho;
    }

    public final /* bridge */ /* synthetic */ zziw zzbH() {
        return (zzho) zzl(5, (Object) null, (Object) null);
    }

    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return (zzhs) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbq() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(int i) {
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> BuilderType zzbt() {
        return (zzho) zzl(5, (Object) null, (Object) null);
    }

    public final BuilderType zzbu() {
        BuilderType buildertype = (zzho) zzl(5, (Object) null, (Object) null);
        buildertype.zzaB(this);
        return buildertype;
    }

    public final void zzbv(zzgz zzgz) throws IOException {
        zzjf.zza().zzb(getClass()).zzm(this, zzha.zza(zzgz));
    }

    public final int zzbw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zze = zzjf.zza().zzb(getClass()).zze(this);
        this.zzd = zze;
        return zze;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);
}
