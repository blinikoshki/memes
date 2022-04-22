package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpt */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpt implements zzve<zzwv> {
    final /* synthetic */ UserProfileChangeRequest zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzpt(zzpy zzpy, UserProfileChangeRequest userProfileChangeRequest, zztq zztq) {
        this.zzc = zzpy;
        this.zza = userProfileChangeRequest;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzwv zzwv = (zzwv) obj;
        zzxl zzxl = new zzxl();
        zzxl.zzg(zzwv.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzxl.zzj(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzxl.zzk(this.zza.zza());
        }
        zzpy.zzI(this.zzc, this.zzb, zzwv, zzxl, this);
    }
}
