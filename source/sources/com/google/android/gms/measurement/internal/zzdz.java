package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public interface zzdz extends IInterface {
    void zzd(zzas zzas, zzp zzp) throws RemoteException;

    void zze(zzkg zzkg, zzp zzp) throws RemoteException;

    void zzf(zzp zzp) throws RemoteException;

    void zzg(zzas zzas, String str, String str2) throws RemoteException;

    void zzh(zzp zzp) throws RemoteException;

    List<zzkg> zzi(zzp zzp, boolean z) throws RemoteException;

    byte[] zzj(zzas zzas, String str) throws RemoteException;

    void zzk(long j, String str, String str2, String str3) throws RemoteException;

    String zzl(zzp zzp) throws RemoteException;

    void zzm(zzaa zzaa, zzp zzp) throws RemoteException;

    void zzn(zzaa zzaa) throws RemoteException;

    List<zzkg> zzo(String str, String str2, boolean z, zzp zzp) throws RemoteException;

    List<zzkg> zzp(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzaa> zzq(String str, String str2, zzp zzp) throws RemoteException;

    List<zzaa> zzr(String str, String str2, String str3) throws RemoteException;

    void zzs(zzp zzp) throws RemoteException;

    void zzt(Bundle bundle, zzp zzp) throws RemoteException;

    void zzu(zzp zzp) throws RemoteException;
}
