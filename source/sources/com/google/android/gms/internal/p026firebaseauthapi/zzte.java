package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzte */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzte extends zzvc<Void, zzg> {
    private final PhoneAuthCredential zza;

    public zzte(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zza = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final TaskApiCall<zztr, Void> zzb() {
        return TaskApiCall.builder().run(new zztd(this)).build();
    }

    public final void zzc() {
        ((zzg) this.zzf).zza(this.zzj, zztn.zzS(this.zzd, this.zzk));
        zzj(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzw(new zzmr(this.zze.zzg(), this.zza), this.zzc);
    }
}
