package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzol */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzol implements zzve<zzwm> {
    final /* synthetic */ zzvd zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzwv zzc;
    final /* synthetic */ zzxl zzd;
    final /* synthetic */ zzpy zze;

    zzol(zzpy zzpy, zzvd zzvd, zztq zztq, zzwv zzwv, zzxl zzxl) {
        this.zze = zzpy;
        this.zza = zzvd;
        this.zzb = zztq;
        this.zzc = zzwv;
        this.zzd = zzxl;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<zzwo> zzb2 = ((zzwm) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzpy.zzK(this.zze, this.zzb, this.zzc, zzb2.get(0), this.zzd, this.zza);
        }
    }
}
