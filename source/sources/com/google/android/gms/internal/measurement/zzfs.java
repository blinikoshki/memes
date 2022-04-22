package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzfs {
    public static <T> zzfo<T> zza(zzfo<T> zzfo) {
        if ((zzfo instanceof zzfq) || (zzfo instanceof zzfp)) {
            return zzfo;
        }
        if (zzfo instanceof Serializable) {
            return new zzfp(zzfo);
        }
        return new zzfq(zzfo);
    }

    public static <T> zzfo<T> zzb(@NullableDecl T t) {
        return new zzfr(t);
    }
}
