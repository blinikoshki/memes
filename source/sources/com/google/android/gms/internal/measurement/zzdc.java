package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdc extends zzho<zzdd, zzdc> implements zziy {
    private zzdc() {
        super(zzdd.zzg);
    }

    /* synthetic */ zzdc(zzcs zzcs) {
        super(zzdd.zzg);
    }

    public final zzdc zza(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdd.zzc((zzdd) this.zza, str);
        return this;
    }

    public final zzdc zzb(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdd.zzd((zzdd) this.zza, j);
        return this;
    }
}
