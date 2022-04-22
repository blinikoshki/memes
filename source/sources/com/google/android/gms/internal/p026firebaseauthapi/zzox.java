package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzox */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzox implements zzve<zzwv> {
    final /* synthetic */ zzyd zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzox(zzpy zzpy, zzyd zzyd, Context context, zztq zztq) {
        this.zzc = zzpy;
        this.zza = zzyd;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(((zzwv) obj).zze());
        this.zzc.zza.zzm((Context) null, this.zza, new zzow(this, this));
    }
}
