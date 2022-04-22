package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
final class zzio implements zziv {
    private final zziv[] zza;

    zzio(zziv... zzivArr) {
        this.zza = zzivArr;
    }

    public final boolean zzb(Class<?> cls) {
        zziv[] zzivArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzivArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zziu zzc(Class<?> cls) {
        zziv[] zzivArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zziv zziv = zzivArr[i];
            if (zziv.zzb(cls)) {
                return zziv.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
