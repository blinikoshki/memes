package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzou */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzou implements zzve<zzye> {
    final /* synthetic */ zztq zza;
    final /* synthetic */ zzpy zzb;

    zzou(zzpy zzpy, zztq zztq) {
        this.zzb = zzpy;
        this.zza = zztq;
    }

    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzye zzye = (zzye) obj;
        this.zzb.zzO(new zzwv(zzye.zzc(), zzye.zzb(), Long.valueOf(zzye.zzd()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzye.zze()), (zze) null, this.zza, this);
    }
}
