package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zztk extends zzvc<String, zzg> {
    private final zzlx zza;

    public zztk(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = new zzlx(str, str2);
    }

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public final TaskApiCall<zztr, String> zzb() {
        return TaskApiCall.builder().run(new zztj(this)).build();
    }

    public final void zzc() {
        if (new zzo(this.zzm).getOperation() != 0) {
            zzk(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzj(this.zzm.zzb());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzr(this.zza, this.zzc);
    }
}
