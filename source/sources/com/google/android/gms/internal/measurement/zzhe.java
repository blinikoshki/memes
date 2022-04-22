package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
public final class zzhe {
    static final zzhe zza = new zzhe(true);
    private static volatile boolean zzb = false;
    private static volatile zzhe zzc;
    private static volatile zzhe zzd;
    private final Map<zzhd, zzhq<?, ?>> zze;

    zzhe() {
        this.zze = new HashMap();
    }

    public static zzhe zza() {
        zzhe zzhe = zzc;
        if (zzhe == null) {
            synchronized (zzhe.class) {
                zzhe = zzc;
                if (zzhe == null) {
                    zzhe = zza;
                    zzc = zzhe;
                }
            }
        }
        return zzhe;
    }

    public final <ContainingType extends zzix> zzhq<ContainingType, ?> zzc(ContainingType containingtype, int i) {
        return this.zze.get(new zzhd(containingtype, i));
    }

    zzhe(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzhe zzb() {
        Class<zzhe> cls = zzhe.class;
        zzhe zzhe = zzd;
        if (zzhe != null) {
            return zzhe;
        }
        synchronized (cls) {
            zzhe zzhe2 = zzd;
            if (zzhe2 != null) {
                return zzhe2;
            }
            zzhe zzb2 = zzhm.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }
}
