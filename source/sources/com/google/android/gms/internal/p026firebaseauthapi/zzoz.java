package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzoz implements zzve<zzwv> {
    final /* synthetic */ zzxv zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzoz(zzpy zzpy, zzxv zzxv, zztq zztq) {
        this.zzc = zzpy;
        this.zza = zzxv;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzf(true);
        this.zza.zzb(((zzwv) obj).zze());
        this.zzc.zza.zzd((Context) null, this.zza, new zzoy(this, this));
    }
}
