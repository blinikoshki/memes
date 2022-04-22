package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzoi implements zzve<zzyc> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzoi(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzyc zzyc = (zzyc) obj;
        if (zzyc.zzg()) {
            this.zza.zzo(new zzof(zzyc.zzf(), zzyc.zze(), (zze) null));
            return;
        }
        this.zzb.zzO(new zzwv(zzyc.zzc(), zzyc.zzb(), Long.valueOf(zzyc.zzd()), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
