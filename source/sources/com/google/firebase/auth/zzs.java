package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p026firebaseauthapi.zzwv;
import com.google.firebase.auth.internal.zzg;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
class zzs implements zzg {
    final /* synthetic */ FirebaseAuth zza;

    zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzwv zzwv, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzwv);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzf(zzwv);
        this.zza.zza(firebaseUser, zzwv, true, false);
    }
}
