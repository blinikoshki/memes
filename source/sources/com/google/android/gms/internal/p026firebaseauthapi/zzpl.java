package com.google.android.gms.internal.p026firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpl */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpl implements zzve<zzwm> {
    final /* synthetic */ zzve zza;
    final /* synthetic */ zzwv zzb;
    final /* synthetic */ zzpm zzc;

    zzpl(zzpm zzpm, zzve zzve, zzwv zzwv) {
        this.zzc = zzpm;
        this.zza = zzve;
        this.zzb = zzwv;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<zzwo> zzb2 = ((zzwm) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zzb(this.zzb, zzb2.get(0));
        }
    }
}
