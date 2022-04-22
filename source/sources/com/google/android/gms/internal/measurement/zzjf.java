package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzjf {
    private static final zzjf zza = new zzjf();
    private final zzjj zzb = new zzip();
    private final ConcurrentMap<Class<?>, zzji<?>> zzc = new ConcurrentHashMap();

    private zzjf() {
    }

    public static zzjf zza() {
        return zza;
    }

    public final <T> zzji<T> zzb(Class<T> cls) {
        zzia.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzji<T> zzji = (zzji) this.zzc.get(cls);
        if (zzji == null) {
            zzji = this.zzb.zza(cls);
            zzia.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzia.zzb(zzji, "schema");
            zzji<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzji);
            return putIfAbsent == null ? zzji : putIfAbsent;
        }
    }
}
