package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzzq {
    static final zzzq zza = new zzzq(true);
    private static volatile boolean zzb = false;
    private static volatile zzzq zzc;
    private final Map<zzzp, zzaab<?, ?>> zzd;

    zzzq() {
        this.zzd = new HashMap();
    }

    public static zzzq zza() {
        zzzq zzzq = zzc;
        if (zzzq == null) {
            synchronized (zzzq.class) {
                zzzq = zzc;
                if (zzzq == null) {
                    zzzq = zza;
                    zzc = zzzq;
                }
            }
        }
        return zzzq;
    }

    public final <ContainingType extends zzabg> zzaab<ContainingType, ?> zzb(ContainingType containingtype, int i) {
        return this.zzd.get(new zzzp(containingtype, i));
    }

    zzzq(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
