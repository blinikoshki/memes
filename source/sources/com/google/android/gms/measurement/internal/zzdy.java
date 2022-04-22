package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
public abstract class zzdy extends zzb implements zzdz {
    public zzdy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzas) zzc.zzc(parcel, zzas.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zze((zzkg) zzc.zzc(parcel, zzkg.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zzf((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zzg((zzas) zzc.zzc(parcel, zzas.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzh((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkg> zzi = zzi((zzp) zzc.zzc(parcel, zzp.CREATOR), zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                return true;
            case 9:
                byte[] zzj = zzj((zzas) zzc.zzc(parcel, zzas.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zzj);
                return true;
            case 10:
                zzk(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzl = zzl((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzl);
                return true;
            case 12:
                zzm((zzaa) zzc.zzc(parcel, zzaa.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzn((zzaa) zzc.zzc(parcel, zzaa.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkg> zzo = zzo(parcel.readString(), parcel.readString(), zzc.zza(parcel), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzo);
                return true;
            case 15:
                List<zzkg> zzp = zzp(parcel.readString(), parcel.readString(), parcel.readString(), zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzp);
                return true;
            case 16:
                List<zzaa> zzq = zzq(parcel.readString(), parcel.readString(), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzq);
                return true;
            case 17:
                List<zzaa> zzr = zzr(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zzr);
                return true;
            case 18:
                zzs((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                zzt((Bundle) zzc.zzc(parcel, Bundle.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                zzu((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
