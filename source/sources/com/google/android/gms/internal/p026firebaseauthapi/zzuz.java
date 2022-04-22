package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuz */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
final class zzuz extends zzub {
    final /* synthetic */ zzvc zza;

    zzuz(zzvc zzvc) {
        this.zza = zzvc;
    }

    private final void zzb(Status status, AuthCredential authCredential, String str, String str2) {
        zzvc.zzn(this.zza, status);
        zzvc zzvc = this.zza;
        zzvc.zzp = authCredential;
        zzvc.zzq = str;
        zzvc.zzr = str2;
        zzao zzao = zzvc.zzg;
        if (zzao != null) {
            zzao.zzb(status);
        }
        this.zza.zzk(status);
    }

    private final void zzc(zzva zzva) {
        this.zza.zzi.execute(new zzuy(this, zzva));
    }

    public final void zzd(zzwv zzwv) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzj = zzwv;
        zzvc.zzl(zzvc);
    }

    public final void zze(zzwv zzwv, zzwo zzwo) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzj = zzwv;
        zzvc.zzk = zzwo;
        zzvc.zzl(zzvc);
    }

    public final void zzf(zzwa zzwa) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 3;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzl = zzwa;
        zzvc.zzl(zzvc);
    }

    public final void zzg(zzxg zzxg) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 4;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzm = zzxg;
        zzvc.zzl(zzvc);
    }

    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzvc zzvc = this.zza;
        if (zzvc.zzb == 8) {
            boolean unused = zzvc.zza = true;
            zzc(new zzux(this, status));
            return;
        }
        zzvc.zzn(zzvc, status);
        this.zza.zzk(status);
    }

    public final void zzi() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 5;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc.zzl(this.zza);
    }

    public final void zzj() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 6;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc.zzl(this.zza);
    }

    public final void zzk(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 7;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzn = str;
        zzvc.zzl(zzvc);
    }

    public final void zzl(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzo = str;
        zzc(new zzuu(this, str));
    }

    public final void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        boolean unused = this.zza.zza = true;
        zzc(new zzuv(this, phoneAuthCredential));
    }

    public final void zzn(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc zzvc = this.zza;
        zzvc.zzo = str;
        boolean unused = zzvc.zza = true;
        zzc(new zzuw(this, str));
    }

    public final void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzb(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zzp() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 9;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzvc.zzl(this.zza);
    }

    public final void zzq(zzod zzod) {
        zzb(zzod.zza(), zzod.zzb(), zzod.zzc(), zzod.zzd());
    }

    public final void zzr(zzof zzof) {
        zzvc zzvc = this.zza;
        zzvc.zzs = zzof;
        zzvc.zzk(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }
}
