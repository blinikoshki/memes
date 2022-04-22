package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpd implements zzve<zzyg> {
    final /* synthetic */ zzpe zza;

    zzpd(zzpe zzpe) {
        this.zza = zzpe;
    }

    public final void zza(String str) {
        this.zza.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzyg zzyg = (zzyg) obj;
        if (TextUtils.isEmpty(zzyg.zzb()) || TextUtils.isEmpty(zzyg.zzc())) {
            this.zza.zzb.zzk(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zza.zzc.zzO(new zzwv(zzyg.zzc(), zzyg.zzb(), Long.valueOf(zzwx.zza(zzyg.zzb())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza.zzb, this);
    }
}
