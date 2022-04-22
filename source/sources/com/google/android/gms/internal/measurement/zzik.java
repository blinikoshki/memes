package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzik extends zzil {
    private zzik() {
        super((zzii) null);
    }

    /* synthetic */ zzik(zzii zzii) {
        super((zzii) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        ((zzhz) zzkh.zzn(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzb(Object obj, Object obj2, long j) {
        zzhz zzhz = (zzhz) zzkh.zzn(obj, j);
        zzhz zzhz2 = (zzhz) zzkh.zzn(obj2, j);
        int size = zzhz.size();
        int size2 = zzhz2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhz.zza()) {
                zzhz = zzhz.zze(size2 + size);
            }
            zzhz.addAll(zzhz2);
        }
        if (size > 0) {
            zzhz2 = zzhz;
        }
        zzkh.zzo(obj, j, zzhz2);
    }
}
