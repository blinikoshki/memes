package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhw extends zzzz<zzhx, zzhw> implements zzabh {
    private zzhw() {
        super(zzhx.zzf);
    }

    /* synthetic */ zzhw(zzhv zzhv) {
        super(zzhx.zzf);
    }

    public final zzhw zza(zzho zzho) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhx) this.zza).zzb = zzho.zza();
        return this;
    }

    public final zzhw zzb(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzhx) this.zza).zze = i;
        return this;
    }
}
