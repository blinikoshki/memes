package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zar;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaq implements zabr {
    private final Context mContext;
    private final Looper zabl;
    private final zaaw zaeh;
    /* access modifiers changed from: private */
    public final zabe zaei;
    /* access modifiers changed from: private */
    public final zabe zaej;
    private final Map<Api.AnyClientKey<?>, zabe> zaek;
    private final Set<SignInConnectionListener> zael = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zaem;
    private Bundle zaen;
    /* access modifiers changed from: private */
    public ConnectionResult zaeo = null;
    /* access modifiers changed from: private */
    public ConnectionResult zaep = null;
    /* access modifiers changed from: private */
    public boolean zaeq = false;
    /* access modifiers changed from: private */
    public final Lock zaer;
    private int zaes = 0;

    public static zaq zaa(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, ArrayList<zap> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = next2.getClientKey();
            if (arrayMap.containsKey(clientKey)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(clientKey)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zap zap = (zap) obj;
            if (arrayMap3.containsKey(zap.mApi)) {
                arrayList2.add(zap);
            } else if (arrayMap4.containsKey(zap.mApi)) {
                arrayList3.add(zap);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaq(context, zaaw, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private zaq(Context context, zaaw zaaw, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zap> arrayList, ArrayList<zap> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zaeh = zaaw;
        this.zaer = lock;
        this.zabl = looper;
        this.zaem = client;
        Context context2 = context;
        zaaw zaaw2 = zaaw;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabe zabe = r3;
        zabe zabe2 = new zabe(context2, zaaw2, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zac, SignInOptions>) null, arrayList2, new zas(this, (zat) null));
        this.zaei = zabe;
        this.zaej = new zabe(context2, zaaw2, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zau(this, (zat) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.zaei);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.zaej);
        }
        this.zaek = Collections.unmodifiableMap(arrayMap);
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zaei.enqueue(t);
        }
        if (!zax()) {
            return this.zaej.enqueue(t);
        }
        t.setFailedResult(new Status(4, (String) null, zay()));
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        if (!zaa((BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>) t)) {
            return this.zaei.execute(t);
        }
        if (!zax()) {
            return this.zaej.execute(t);
        }
        t.setFailedResult(new Status(4, (String) null, zay()));
        return t;
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        if (!this.zaek.get(api.getClientKey()).equals(this.zaej)) {
            return this.zaei.getConnectionResult(api);
        }
        if (zax()) {
            return new ConnectionResult(4, zay());
        }
        return this.zaej.getConnectionResult(api);
    }

    public final void connect() {
        this.zaes = 2;
        this.zaeq = false;
        this.zaep = null;
        this.zaeo = null;
        this.zaei.connect();
        this.zaej.connect();
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void disconnect() {
        this.zaep = null;
        this.zaeo = null;
        this.zaes = 0;
        this.zaei.disconnect();
        this.zaej.disconnect();
        zaw();
    }

    public final boolean isConnected() {
        this.zaer.lock();
        try {
            boolean z = true;
            if (!this.zaei.isConnected() || (!this.zaej.isConnected() && !zax() && this.zaes != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zaer.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zaer.lock();
        try {
            return this.zaes == 2;
        } finally {
            this.zaer.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaer.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zaej.isConnected()) {
                this.zael.add(signInConnectionListener);
                if (this.zaes == 0) {
                    this.zaes = 1;
                }
                this.zaep = null;
                this.zaej.connect();
                return true;
            }
            this.zaer.unlock();
            return false;
        } finally {
            this.zaer.unlock();
        }
    }

    public final void zau() {
        this.zaei.zau();
        this.zaej.zau();
    }

    public final void maybeSignOut() {
        this.zaer.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zaej.disconnect();
            this.zaep = new ConnectionResult(4);
            if (isConnecting) {
                new zar(this.zabl).post(new zat(this));
            } else {
                zaw();
            }
        } finally {
            this.zaer.unlock();
        }
    }

    /* access modifiers changed from: private */
    public final void zav() {
        if (zab(this.zaeo)) {
            if (zab(this.zaep) || zax()) {
                int i = this.zaes;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zaes = 0;
                        return;
                    }
                    this.zaeh.zab(this.zaen);
                }
                zaw();
                this.zaes = 0;
                return;
            }
            ConnectionResult connectionResult = this.zaep;
            if (connectionResult == null) {
                return;
            }
            if (this.zaes == 1) {
                zaw();
                return;
            }
            zaa(connectionResult);
            this.zaei.disconnect();
        } else if (this.zaeo == null || !zab(this.zaep)) {
            ConnectionResult connectionResult2 = this.zaeo;
            if (connectionResult2 != null && this.zaep != null) {
                if (this.zaej.zahw < this.zaei.zahw) {
                    connectionResult2 = this.zaep;
                }
                zaa(connectionResult2);
            }
        } else {
            this.zaej.disconnect();
            zaa(this.zaeo);
        }
    }

    private final void zaa(ConnectionResult connectionResult) {
        int i = this.zaes;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zaes = 0;
            }
            this.zaeh.zac(connectionResult);
        }
        zaw();
        this.zaes = 0;
    }

    private final void zaw() {
        for (SignInConnectionListener onComplete : this.zael) {
            onComplete.onComplete();
        }
        this.zael.clear();
    }

    /* access modifiers changed from: private */
    public final void zaa(int i, boolean z) {
        this.zaeh.zab(i, z);
        this.zaep = null;
        this.zaeo = null;
    }

    private final boolean zax() {
        ConnectionResult connectionResult = this.zaep;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zaek.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zaek.get(clientKey).equals(this.zaej);
    }

    private final PendingIntent zay() {
        if (this.zaem == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaeh), this.zaem.getSignInIntent(), 134217728);
    }

    /* access modifiers changed from: private */
    public final void zaa(Bundle bundle) {
        Bundle bundle2 = this.zaen;
        if (bundle2 == null) {
            this.zaen = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private static boolean zab(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zaej.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zaei.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
