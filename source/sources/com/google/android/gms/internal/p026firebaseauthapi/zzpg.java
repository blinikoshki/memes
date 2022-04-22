package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpg implements zzve<zzxz> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzpg(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzxz zzxz = (zzxz) obj;
        this.zzb.zzO(new zzwv(zzxz.zzc(), zzxz.zzb(), Long.valueOf(zzxz.zzd()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzxz.zze()), (zze) null, this.zza, this);
    }
}
