package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzw implements Continuation<GetTokenResult, Task<Void>> {
    final /* synthetic */ FirebaseUser zza;

    zzw(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zzd()).zzs((ActionCodeSettings) null, ((GetTokenResult) task.getResult()).getToken());
    }
}
