package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzabo {
    private static final zzabo zza = new zzabo();
    private final zzabt zzb = new zzaay();
    private final ConcurrentMap<Class<?>, zzabs<?>> zzc = new ConcurrentHashMap();

    private zzabo() {
    }

    public static zzabo zza() {
        return zza;
    }

    public final <T> zzabs<T> zzb(Class<T> cls) {
        zzaaj.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzabs<T> zzabs = (zzabs) this.zzc.get(cls);
        if (zzabs == null) {
            zzabs = this.zzb.zza(cls);
            zzaaj.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzaaj.zzb(zzabs, "schema");
            zzabs<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzabs);
            return putIfAbsent == null ? zzabs : putIfAbsent;
        }
    }
}
