package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p014a.C1807a;
import com.google.android.p014a.C1808b;
import com.google.android.p014a.C1809c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends C1808b implements IGetInstallReferrerService {

        public static class Proxy extends C1807a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            /* renamed from: c */
            public final Bundle mo38919c(Bundle bundle) throws RemoteException {
                Parcel a = mo21442a();
                C1809c.m135b(a, bundle);
                Parcel b = mo21444b(a);
                Bundle bundle2 = (Bundle) C1809c.m134a(b, Bundle.CREATOR);
                b.recycle();
                return bundle2;
            }
        }

        /* renamed from: b */
        public static IGetInstallReferrerService m367b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo21445a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle c = mo38919c((Bundle) C1809c.m134a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            C1809c.m136c(parcel2, c);
            return true;
        }
    }

    /* renamed from: c */
    Bundle mo38919c(Bundle bundle) throws RemoteException;
}
