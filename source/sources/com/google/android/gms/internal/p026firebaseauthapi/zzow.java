package com.google.android.gms.internal.p026firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzow */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzow implements zzve<zzye> {
    final /* synthetic */ zzve zza;
    final /* synthetic */ zzox zzb;

    zzow(zzox zzox, zzve zzve) {
        this.zzb = zzox;
        this.zza = zzve;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzye zzye = (zzye) obj;
        if (!TextUtils.isEmpty(zzye.zzf())) {
            this.zzb.zzb.zzl(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzc(zzye.zzg(), zzye.zzf()));
            return;
        }
        this.zzb.zzc.zzO(new zzwv(zzye.zzc(), zzye.zzb(), Long.valueOf(zzye.zzd()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzye.zze()), (zze) null, this.zzb.zzb, this.zza);
    }
}
