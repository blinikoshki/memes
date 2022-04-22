package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzph */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzph implements zzve<zzwg> {
    final /* synthetic */ zzpi zza;

    zzph(zzpi zzpi) {
        this.zza = zzpi;
    }

    public final void zza(String str) {
        this.zza.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwg zzwg = (zzwg) obj;
        this.zza.zzc.zzO(new zzwv(zzwg.zzc(), zzwg.zzb(), Long.valueOf(zzwx.zza(zzwg.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza.zzb, this);
    }
}
