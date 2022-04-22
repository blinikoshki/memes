package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpj */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpj implements zzve<zzwi> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzpj(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwi zzwi = (zzwi) obj;
        this.zzb.zzO(new zzwv(zzwi.zzc(), zzwi.zzb(), Long.valueOf(zzwx.zza(zzwi.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
