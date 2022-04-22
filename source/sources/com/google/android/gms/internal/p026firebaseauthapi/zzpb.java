package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpb */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpb implements zzve<zzwm> {
    final /* synthetic */ zzve zza;
    final /* synthetic */ zzwv zzb;
    final /* synthetic */ zzpc zzc;

    zzpb(zzpc zzpc, zzve zzve, zzwv zzwv) {
        this.zzc = zzpc;
        this.zza = zzve;
        this.zzb = zzwv;
    }

    public final void zza(String str) {
        this.zzc.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<zzwo> zzb2 = ((zzwm) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzxl zzxl = new zzxl();
        zzxl.zzg(this.zzb.zze());
        zzxl.zzl(this.zzc.zza);
        zzpc zzpc = this.zzc;
        zzpy.zzK(zzpc.zzc, zzpc.zzb, this.zzb, zzb2.get(0), zzxl, this.zza);
    }
}
