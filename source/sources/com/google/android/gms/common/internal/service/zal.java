package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zal extends zab implements zam {
    zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zaa(zak zak) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) zak);
        zac(1, zaa);
    }
}
