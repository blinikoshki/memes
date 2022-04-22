package com.google.android.gms.internal.p026firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzek */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzek extends zzzz<zzel, zzek> implements zzabh {
    private zzek() {
        super(zzel.zzg);
    }

    /* synthetic */ zzek(zzej zzej) {
        super(zzel.zzg);
    }

    public final zzek zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzel) this.zza).zzb = 0;
        return this;
    }

    public final zzek zzb(zzzb zzzb) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzel) this.zza).zze = zzzb;
        return this;
    }

    public final zzek zzc(zzer zzer) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzel.zzi((zzel) this.zza, zzer);
        return this;
    }
}
