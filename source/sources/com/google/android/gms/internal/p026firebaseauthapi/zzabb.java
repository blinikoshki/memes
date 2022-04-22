package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabb */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzabb {
    zzabb() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzaba zzaba = (zzaba) obj;
        zzaaz zzaaz = (zzaaz) obj2;
        if (zzaba.isEmpty()) {
            return 0;
        }
        Iterator it = zzaba.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzaba) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzaba zzaba = (zzaba) obj;
        zzaba zzaba2 = (zzaba) obj2;
        if (!zzaba2.isEmpty()) {
            if (!zzaba.zze()) {
                zzaba = zzaba.zzc();
            }
            zzaba.zzb(zzaba2);
        }
        return zzaba;
    }
}
