package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzua */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzua extends zza implements zzuc {
    zzua(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void zzd(zzwv zzwv) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwv);
        zzJ(1, zza);
    }

    public final void zze(zzwv zzwv, zzwo zzwo) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwv);
        zzc.zzb(zza, zzwo);
        zzJ(2, zza);
    }

    public final void zzf(zzwa zzwa) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzwa);
        zzJ(3, zza);
    }

    public final void zzg(zzxg zzxg) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzxg);
        zzJ(4, zza);
    }

    public final void zzh(Status status) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, status);
        zzJ(5, zza);
    }

    public final void zzi() throws RemoteException {
        zzJ(6, zza());
    }

    public final void zzj() throws RemoteException {
        zzJ(7, zza());
    }

    public final void zzk(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(8, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(9, zza);
    }

    public final void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, phoneAuthCredential);
        zzJ(10, zza);
    }

    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzJ(11, zza);
    }

    public final void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, status);
        zzc.zzb(zza, phoneAuthCredential);
        zzJ(12, zza);
    }

    public final void zzp() throws RemoteException {
        zzJ(13, zza());
    }

    public final void zzq(zzod zzod) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzod);
        zzJ(14, zza);
    }

    public final void zzr(zzof zzof) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzof);
        zzJ(15, zza);
    }
}
