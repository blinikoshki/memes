package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzqi extends zzvc<ActionCodeResult, zzg> {
    private final zzlx zza;

    public zzqi(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = new zzlx(str, str2);
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final TaskApiCall<zztr, ActionCodeResult> zzb() {
        return TaskApiCall.builder().run(new zzqh(this)).build();
    }

    public final void zzc() {
        zzj(new zzo(this.zzm));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zztr zztr, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzv = new zzvb(this, taskCompletionSource);
        zztr.zzq().zzr(this.zza, this.zzc);
    }
}
