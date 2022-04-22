package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzdr extends zzho<zzds, zzdr> implements zziy {
    private zzdr() {
        super(zzds.zzg);
    }

    /* synthetic */ zzdr(zzcs zzcs) {
        super(zzds.zzg);
    }

    public final zzdr zza(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzds.zzh((zzds) this.zza, i);
        return this;
    }

    public final zzdr zzb(Iterable<? extends Long> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzds.zzi((zzds) this.zza, iterable);
        return this;
    }
}
