package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqs */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzqs extends zzvc<Void, zzg> {
    private final zzmf zza;

    public zzqs(PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, String str2) {
        super(2);
        Preconditions.checkNotNull(phoneMultiFactorAssertion);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzmf(phoneMultiFactorAssertion.zza(), str, str2);
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zzqr(this)).build();
    }

    public final void zzc() {
        ((zzg) this.zzf).zza(this.zzj, zztn.zzS(this.zzd, this.zzk));
        zzj(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzC(this.zza, this.zzc);
    }
}
