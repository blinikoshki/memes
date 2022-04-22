package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzps */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzps implements zzve<zzxo> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzps(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzxo zzxo = (zzxo) obj;
        this.zzb.zzO(new zzwv(zzxo.zzc(), zzxo.zzb(), Long.valueOf(zzxo.zzd()), "Bearer"), (String) null, (String) null, true, (zze) null, this.zza, this);
    }
}
