package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
/* renamed from: com.appsflyer.internal.r */
public final class C1070r {
    C1070r() {
    }

    public static C1071b valueOf(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            C1072c cVar = new C1072c((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, cVar, 1)) {
                    if (context != null) {
                        context.unbindService(cVar);
                    }
                    throw new IOException("Google Play connection failed");
                } else if (!cVar.values) {
                    cVar.values = true;
                    IBinder poll = cVar.valueOf.poll(10, TimeUnit.SECONDS);
                    if (poll != null) {
                        C1073e eVar = new C1073e(poll);
                        return new C1071b(eVar.$$a(), eVar.values());
                    }
                    throw new TimeoutException("Timed out waiting for the service connection");
                } else {
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
            } finally {
                if (context != null) {
                    context.unbindService(cVar);
                }
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    /* renamed from: com.appsflyer.internal.r$b */
    public static final class C1071b {
        public final String AFDateFormat;
        private final boolean valueOf;

        C1071b(String str, boolean z) {
            this.AFDateFormat = str;
            this.valueOf = z;
        }

        public final boolean valueOf() {
            return this.valueOf;
        }
    }

    /* renamed from: com.appsflyer.internal.r$c */
    static final class C1072c implements ServiceConnection {
        final LinkedBlockingQueue<IBinder> valueOf;
        boolean values;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private C1072c() {
            this.valueOf = new LinkedBlockingQueue<>(1);
            this.values = false;
        }

        /* synthetic */ C1072c(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.valueOf.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: com.appsflyer.internal.r$e */
    static final class C1073e implements IInterface {
        private final IBinder $$a;

        C1073e(IBinder iBinder) {
            this.$$a = iBinder;
        }

        public final IBinder asBinder() {
            return this.$$a;
        }

        public final String $$a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.$$a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean values() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.$$a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
