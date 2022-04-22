package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public interface zzc extends IInterface {
    int zza(int i, String str, String str2) throws RemoteException;

    Bundle zza(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle zza(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException;

    Bundle zza(int i, String str, String str2, String str3) throws RemoteException;

    Bundle zza(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle zza(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle zza(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle zza(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    int zzb(int i, String str, String str2) throws RemoteException;

    int zzb(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle zzb(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle zzc(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle zzc(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException;
}
