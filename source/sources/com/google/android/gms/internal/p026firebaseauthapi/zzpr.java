package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpr */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpr implements zzve<zzxx> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzpr(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzxx zzxx = (zzxx) obj;
        if (!zzxx.zzo()) {
            zzpy.zzH(this.zzb, zzxx, this.zza, this);
        } else {
            this.zza.zzo(new zzof(zzxx.zzn(), zzxx.zzm(), zzxx.zzp()));
        }
    }
}
