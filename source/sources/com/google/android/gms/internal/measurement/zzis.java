package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzis {
    zzis() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzir zzir = (zzir) obj;
        zziq zziq = (zziq) obj2;
        if (zzir.isEmpty()) {
            return 0;
        }
        Iterator it = zzir.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzir zzir = (zzir) obj;
        zzir zzir2 = (zzir) obj2;
        if (!zzir2.isEmpty()) {
            if (!zzir.zze()) {
                zzir = zzir.zzc();
            }
            zzir.zzb(zzir2);
        }
        return zzir;
    }
}
