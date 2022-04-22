package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzig */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzig extends zzzz<zzih, zzig> implements zzabh {
    private zzig() {
        super(zzih.zzg);
    }

    /* synthetic */ zzig(zzif zzif) {
        super(zzih.zzg);
    }

    public final zzig zza(String str) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzih.zzg((zzih) this.zza, str);
        return this;
    }

    public final zzig zzb(zzzb zzzb) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzih) this.zza).zze = zzzb;
        return this;
    }

    public final zzig zzc(zzji zzji) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzih) this.zza).zzf = zzji.zza();
        return this;
    }
}
