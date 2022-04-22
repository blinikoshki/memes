package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzd<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> zzb;
    /* access modifiers changed from: private */
    public final zzu<TContinuationResult> zzc;

    public zzd(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzu;
    }

    public final void zza(Task<TResult> task) {
        this.zza.execute(new zzg(this, task));
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzc.zza(tcontinuationresult);
    }

    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    public final void onCanceled() {
        this.zzc.zza();
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
