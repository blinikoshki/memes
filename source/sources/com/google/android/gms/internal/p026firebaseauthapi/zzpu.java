package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpu */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpu implements zzve<zzwv> {
    final /* synthetic */ String zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzpu(zzpy zzpy, String str, zztq zztq) {
        this.zzc = zzpy;
        this.zza = str;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwv zzwv = (zzwv) obj;
        zzxl zzxl = new zzxl();
        zzxl.zzg(zzwv.zze());
        zzxl.zzh(this.zza);
        zzpy.zzI(this.zzc, this.zzb, zzwv, zzxl, this);
    }
}
