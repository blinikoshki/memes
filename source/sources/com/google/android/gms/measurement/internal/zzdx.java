package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public final class zzdx extends zza implements zzdz {
    zzdx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zzd(zzas zzas, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzas);
        zzc.zzd(zza, zzp);
        zzc(1, zza);
    }

    public final void zze(zzkg zzkg, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzkg);
        zzc.zzd(zza, zzp);
        zzc(2, zza);
    }

    public final void zzf(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        zzc(4, zza);
    }

    public final void zzg(zzas zzas, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzh(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        zzc(6, zza);
    }

    public final List<zzkg> zzi(zzp zzp, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        zzc.zzb(zza, z);
        Parcel zzz = zzz(7, zza);
        ArrayList<zzkg> createTypedArrayList = zzz.createTypedArrayList(zzkg.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    public final byte[] zzj(zzas zzas, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzas);
        zza.writeString(str);
        Parcel zzz = zzz(9, zza);
        byte[] createByteArray = zzz.createByteArray();
        zzz.recycle();
        return createByteArray;
    }

    public final void zzk(long j, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final String zzl(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        Parcel zzz = zzz(11, zza);
        String readString = zzz.readString();
        zzz.recycle();
        return readString;
    }

    public final void zzm(zzaa zzaa, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzaa);
        zzc.zzd(zza, zzp);
        zzc(12, zza);
    }

    public final void zzn(zzaa zzaa) throws RemoteException {
        throw null;
    }

    public final List<zzkg> zzo(String str, String str2, boolean z, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z);
        zzc.zzd(zza, zzp);
        Parcel zzz = zzz(14, zza);
        ArrayList<zzkg> createTypedArrayList = zzz.createTypedArrayList(zzkg.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    public final List<zzkg> zzp(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc.zzb(zza, z);
        Parcel zzz = zzz(15, zza);
        ArrayList<zzkg> createTypedArrayList = zzz.createTypedArrayList(zzkg.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    public final List<zzaa> zzq(String str, String str2, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, zzp);
        Parcel zzz = zzz(16, zza);
        ArrayList<zzaa> createTypedArrayList = zzz.createTypedArrayList(zzaa.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    public final List<zzaa> zzr(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzz = zzz(17, zza);
        ArrayList<zzaa> createTypedArrayList = zzz.createTypedArrayList(zzaa.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    public final void zzs(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        zzc(18, zza);
    }

    public final void zzt(Bundle bundle, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc.zzd(zza, zzp);
        zzc(19, zza);
    }

    public final void zzu(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzp);
        zzc(20, zza);
    }
}
