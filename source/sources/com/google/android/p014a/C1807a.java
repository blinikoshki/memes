package com.google.android.p014a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.a.a */
/* compiled from: BaseProxy */
public class C1807a implements IInterface {

    /* renamed from: a */
    private final IBinder f188a;

    /* renamed from: b */
    private final String f189b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected C1807a(IBinder iBinder) {
        this.f188a = iBinder;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo21442a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f189b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f188a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Parcel mo21444b(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f188a.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }
}
