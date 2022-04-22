package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzrw extends zzvc<Void, zzg> {
    public zzrw() {
        super(2);
    }

    public final String zza() {
        return "reload";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zzrv(this)).build();
    }

    public final void zzc() {
        ((zzg) this.zzf).zza(this.zzj, zztn.zzS(this.zzd, this.zzk));
        zzj(null);
    }
}
