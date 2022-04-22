package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuc */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public interface zzuc extends IInterface {
    void zzd(zzwv zzwv) throws RemoteException;

    void zze(zzwv zzwv, zzwo zzwo) throws RemoteException;

    void zzf(zzwa zzwa) throws RemoteException;

    void zzg(zzxg zzxg) throws RemoteException;

    void zzh(Status status) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj() throws RemoteException;

    void zzk(String str) throws RemoteException;

    void zzl(String str) throws RemoteException;

    void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zzn(String str) throws RemoteException;

    void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zzp() throws RemoteException;

    void zzq(zzod zzod) throws RemoteException;

    void zzr(zzof zzof) throws RemoteException;
}
