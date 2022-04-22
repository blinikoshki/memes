package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzbt extends zzho<zzbu, zzbt> implements zziy {
    private zzbt() {
        super(zzbu.zzj);
    }

    /* synthetic */ zzbt(zzbs zzbs) {
        super(zzbu.zzj);
    }

    public final int zza() {
        return ((zzbu) this.zza).zzd();
    }

    public final zzcf zzb(int i) {
        return ((zzbu) this.zza).zze(i);
    }

    public final zzbt zzc(int i, zzce zzce) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbu.zzj((zzbu) this.zza, i, (zzcf) zzce.zzaA());
        return this;
    }

    public final int zzd() {
        return ((zzbu) this.zza).zzg();
    }

    public final zzbw zze(int i) {
        return ((zzbu) this.zza).zzh(i);
    }

    public final zzbt zzf(int i, zzbv zzbv) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbu.zzk((zzbu) this.zza, i, (zzbw) zzbv.zzaA());
        return this;
    }
}
