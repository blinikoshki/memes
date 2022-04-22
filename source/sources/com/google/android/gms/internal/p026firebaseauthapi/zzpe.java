package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpe implements zzve<zzwv> {
    final /* synthetic */ String zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzpe(zzpy zzpy, String str, zztq zztq) {
        this.zzc = zzpy;
        this.zza = str;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zza.zzs(new zzyf(((zzwv) obj).zze(), this.zza), new zzpd(this));
    }
}
