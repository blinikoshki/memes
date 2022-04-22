package com.google.android.gms.internal.p026firebaseauthapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzub */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public abstract class zzub extends zzb implements zzuc {
    public zzub() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzwv) zzc.zza(parcel, zzwv.CREATOR));
                return true;
            case 2:
                zze((zzwv) zzc.zza(parcel, zzwv.CREATOR), (zzwo) zzc.zza(parcel, zzwo.CREATOR));
                return true;
            case 3:
                zzf((zzwa) zzc.zza(parcel, zzwa.CREATOR));
                return true;
            case 4:
                zzg((zzxg) zzc.zza(parcel, zzxg.CREATOR));
                return true;
            case 5:
                zzh((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                zzi();
                return true;
            case 7:
                zzj();
                return true;
            case 8:
                zzk(parcel.readString());
                return true;
            case 9:
                zzl(parcel.readString());
                return true;
            case 10:
                zzm((PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                zzn(parcel.readString());
                return true;
            case 12:
                zzo((Status) zzc.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                zzp();
                return true;
            case 14:
                zzq((zzod) zzc.zza(parcel, zzod.CREATOR));
                return true;
            case 15:
                zzr((zzof) zzc.zza(parcel, zzof.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
