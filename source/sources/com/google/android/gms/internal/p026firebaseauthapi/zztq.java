package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztq */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public class zztq {
    private final zzuc zza;
    private final Logger zzb;

    public zztq(zztq zztq) {
        this(zztq.zza, zztq.zzb);
    }

    public final void zza(zzwv zzwv) {
        try {
            this.zza.zzd(zzwv);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zzb(zzwv zzwv, zzwo zzwo) {
        try {
            this.zza.zze(zzwv, zzwo);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zzc(zzwa zzwa) {
        try {
            this.zza.zzf(zzwa);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zzd(zzxg zzxg) {
        try {
            this.zza.zzg(zzxg);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zze() {
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzf() {
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzg(String str) {
        try {
            this.zza.zzk(str);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public void zzh(String str) {
        try {
            this.zza.zzl(str);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zzi(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzm(phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }

    public final void zzj(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }

    public void zzk(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzl(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzo(status, phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zzn(zzod zzod) {
        try {
            this.zza.zzq(zzod);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zzo(zzof zzof) {
        try {
            this.zza.zzr(zzof);
        } catch (RemoteException e) {
            this.zzb.mo39949e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public zztq(zzuc zzuc, Logger logger) {
        this.zza = (zzuc) Preconditions.checkNotNull(zzuc);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }
}
