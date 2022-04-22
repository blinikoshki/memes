package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzhz extends zzzz<zzic, zzhz> implements zzabh {
    private zzhz() {
        super(zzic.zzg);
    }

    /* synthetic */ zzhz(zzhy zzhy) {
        super(zzic.zzg);
    }

    public final zzhz zza(String str) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zzb = str;
        return this;
    }

    public final zzhz zzb(zzzb zzzb) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zze = zzzb;
        return this;
    }

    public final zzhz zzc(zzib zzib) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzic) this.zza).zzf = zzib.zza();
        return this;
    }
}
