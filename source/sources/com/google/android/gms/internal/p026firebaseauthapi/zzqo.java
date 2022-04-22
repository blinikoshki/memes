package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.firebase.auth.internal.zzan;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqo */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzqo extends zzvc<Void, zzan> {
    public zzqo() {
        super(5);
    }

    public final String zza() {
        return "delete";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zzqn(this)).build();
    }

    public final void zzc() {
        ((zzan) this.zzf).zza();
        zzj(null);
    }
}
