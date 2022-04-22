package com.google.android.gms.internal.p026firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p026firebaseauthapi.zzqa;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqd */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzqd<T extends zzqa> {
    private zzpz<T> zza;

    /* access modifiers changed from: package-private */
    public abstract Future<zzpz<T>> zza();

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzb(zzqc<A, ResultT> zzqc) {
        return zzd().zza.doRead(zzqc.zzb());
    }

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzc(zzqc<A, ResultT> zzqc) {
        return zzd().zza.doWrite(zzqc.zzb());
    }

    public final zzpz<T> zzd() {
        zzpz<T> zzpz;
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = (zzpz) zza().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to the GoogleApi: ".concat(valueOf) : new String("There was an error while initializing the connection to the GoogleApi: "));
                }
            }
            zzpz = this.zza;
        }
        return zzpz;
    }
}
