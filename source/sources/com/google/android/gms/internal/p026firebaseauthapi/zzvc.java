package com.google.android.gms.internal.p026firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
abstract class zzvc<ResultT, CallbackT> implements zzqc<zztr, ResultT> {
    /* access modifiers changed from: private */
    public boolean zza;
    protected final int zzb;
    final zzuz zzc = new zzuz(this);
    protected FirebaseApp zzd;
    protected FirebaseUser zze;
    protected CallbackT zzf;
    protected zzao zzg;
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzh = new ArrayList();
    protected Executor zzi;
    protected zzwv zzj;
    protected zzwo zzk;
    protected zzwa zzl;
    protected zzxg zzm;
    protected String zzn;
    protected String zzo;
    protected AuthCredential zzp;
    protected String zzq;
    protected String zzr;
    protected zzof zzs;
    ResultT zzt;
    Status zzu;
    protected zzvb zzv;

    public zzvc(int i) {
        this.zzb = i;
    }

    static /* synthetic */ void zzl(zzvc zzvc) {
        zzvc.zzc();
        Preconditions.checkState(zzvc.zza, "no success or failure set on method implementation");
    }

    static /* synthetic */ void zzn(zzvc zzvc, Status status) {
        zzao zzao = zzvc.zzg;
        if (zzao != null) {
            zzao.zzb(status);
        }
    }

    public abstract void zzc();

    public final zzvc<ResultT, CallbackT> zze(FirebaseApp firebaseApp) {
        this.zzd = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzvc<ResultT, CallbackT> zzf(FirebaseUser firebaseUser) {
        this.zze = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzvc<ResultT, CallbackT> zzg(CallbackT callbackt) {
        this.zzf = Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public final zzvc<ResultT, CallbackT> zzh(zzao zzao) {
        this.zzg = (zzao) Preconditions.checkNotNull(zzao, "external failure callback cannot be null");
        return this;
    }

    public final zzvc<ResultT, CallbackT> zzi(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc2 = zzvm.zzc(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            this.zzh.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zzc2));
        }
        if (activity != null) {
            zzut.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzj(ResultT resultt) {
        this.zza = true;
        this.zzt = resultt;
        this.zzv.zza(resultt, (Status) null);
    }

    public final void zzk(Status status) {
        this.zza = true;
        this.zzu = status;
        this.zzv.zza(null, status);
    }
}
