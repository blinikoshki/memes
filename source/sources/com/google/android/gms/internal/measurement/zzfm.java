package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public abstract class zzfm<T> implements Serializable {
    zzfm() {
    }

    public static <T> zzfm<T> zzc() {
        return zzfk.zza;
    }

    public static <T> zzfm<T> zzd(T t) {
        return new zzfn(t);
    }

    public abstract boolean zza();

    public abstract T zzb();
}
