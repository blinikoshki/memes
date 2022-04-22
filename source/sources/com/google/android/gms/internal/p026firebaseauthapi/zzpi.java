package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzpi implements zzve<zzwv> {
    final /* synthetic */ zzwf zza;
    final /* synthetic */ zztq zzb;
    final /* synthetic */ zzpy zzc;

    zzpi(zzpy zzpy, zzwf zzwf, Context context, zztq zztq) {
        this.zzc = zzpy;
        this.zza = zzwf;
        this.zzb = zztq;
    }

    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzc(((zzwv) obj).zze());
        this.zzc.zza.zzr((Context) null, this.zza, new zzph(this));
    }
}
