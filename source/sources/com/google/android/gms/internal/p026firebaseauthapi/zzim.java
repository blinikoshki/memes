package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzim extends zzzz<zzip, zzim> implements zzabh {
    private zzim() {
        super(zzip.zzf);
    }

    /* synthetic */ zzim(zzil zzil) {
        super(zzip.zzf);
    }

    public final zzim zza(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzip) this.zza).zzb = i;
        return this;
    }

    public final List<zzio> zzb() {
        return Collections.unmodifiableList(((zzip) this.zza).zzb());
    }

    public final int zzc() {
        return ((zzip) this.zza).zzc();
    }

    public final zzio zzd(int i) {
        return ((zzip) this.zza).zzd(i);
    }

    public final zzim zze(zzio zzio) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzip.zzi((zzip) this.zza, zzio);
        return this;
    }
}
