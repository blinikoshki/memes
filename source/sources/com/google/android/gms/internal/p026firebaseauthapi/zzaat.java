package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzaat extends zzaau {
    private zzaat() {
        super((zzaar) null);
    }

    /* synthetic */ zzaat(zzaar zzaar) {
        super((zzaar) null);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzaai zzaai = (zzaai) zzacr.zzn(obj, j);
        if (zzaai.zza()) {
            return zzaai;
        }
        int size = zzaai.size();
        zzaai zze = zzaai.zze(size == 0 ? 10 : size + size);
        zzacr.zzo(obj, j, zze);
        return zze;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzaai) zzacr.zzn(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzaai zzaai = (zzaai) zzacr.zzn(obj, j);
        zzaai zzaai2 = (zzaai) zzacr.zzn(obj2, j);
        int size = zzaai.size();
        int size2 = zzaai2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaai.zza()) {
                zzaai = zzaai.zze(size2 + size);
            }
            zzaai.addAll(zzaai2);
        }
        if (size > 0) {
            zzaai2 = zzaai;
        }
        zzacr.zzo(obj, j, zzaai2);
    }
}
