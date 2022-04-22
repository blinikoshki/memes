package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzov */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzov implements zzve<zzwv> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zztq zzc;
    final /* synthetic */ zzpy zzd;

    zzov(zzpy zzpy, String str, String str2, zztq zztq) {
        this.zzd = zzpy;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zztq;
    }

    public final void zza(String str) {
        this.zzc.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwv zzwv = (zzwv) obj;
        zzxl zzxl = new zzxl();
        zzxl.zzg(zzwv.zze());
        zzxl.zzh(this.zza);
        zzxl.zzi(this.zzb);
        zzpy.zzI(this.zzd, this.zzc, zzwv, zzxl, this);
    }
}
