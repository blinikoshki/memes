package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzgj implements Comparator<zzgs> {
    zzgj() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzgs zzgs = (zzgs) obj;
        zzgs zzgs2 = (zzgs) obj2;
        zzgi zzgi = new zzgi(zzgs);
        zzgi zzgi2 = new zzgi(zzgs2);
        while (zzgi.hasNext() && zzgi2.hasNext()) {
            int compare = Integer.compare(zzgi.zza() & 255, zzgi2.zza() & 255);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgs.zzc(), zzgs2.zzc());
    }
}
