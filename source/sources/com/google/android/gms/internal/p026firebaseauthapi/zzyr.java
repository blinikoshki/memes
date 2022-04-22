package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzyr implements Comparator<zzzb> {
    zzyr() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzzb zzzb = (zzzb) obj;
        zzzb zzzb2 = (zzzb) obj2;
        zzyq zzyq = new zzyq(zzzb);
        zzyq zzyq2 = new zzyq(zzzb2);
        while (zzyq.hasNext() && zzyq2.hasNext()) {
            int compare = Integer.compare(zzyq.zza() & 255, zzyq2.zza() & 255);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzzb.zzc(), zzzb2.zzc());
    }
}
