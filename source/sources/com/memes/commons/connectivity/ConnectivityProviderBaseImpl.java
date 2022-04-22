package com.memes.commons.connectivity;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.connectivity.ConnectivityProvider;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000bH$J\b\u0010\u0012\u001a\u00020\u000bH$J\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProviderBaseImpl;", "Lcom/memes/commons/connectivity/ConnectivityProvider;", "()V", "handler", "Landroid/os/Handler;", "listeners", "", "Lcom/memes/commons/connectivity/ConnectivityProvider$ConnectivityStateListener;", "subscribed", "", "addListener", "", "listener", "dispatchChange", "state", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "removeListener", "subscribe", "unsubscribe", "verifySubscription", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityProviderBaseImpl.kt */
public abstract class ConnectivityProviderBaseImpl implements ConnectivityProvider {
    private final Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Set<ConnectivityProvider.ConnectivityStateListener> listeners = new LinkedHashSet();
    private boolean subscribed;

    /* access modifiers changed from: protected */
    public abstract void subscribe();

    /* access modifiers changed from: protected */
    public abstract void unsubscribe();

    public void addListener(ConnectivityProvider.ConnectivityStateListener connectivityStateListener) {
        Intrinsics.checkNotNullParameter(connectivityStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(connectivityStateListener);
        connectivityStateListener.onStateChange(getNetworkState());
        verifySubscription();
    }

    public void removeListener(ConnectivityProvider.ConnectivityStateListener connectivityStateListener) {
        Intrinsics.checkNotNullParameter(connectivityStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(connectivityStateListener);
        verifySubscription();
    }

    private final void verifySubscription() {
        if (!this.subscribed && (!this.listeners.isEmpty())) {
            subscribe();
            this.subscribed = true;
        } else if (this.subscribed && this.listeners.isEmpty()) {
            unsubscribe();
            this.subscribed = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void dispatchChange(ConnectivityProvider.NetworkState networkState) {
        Intrinsics.checkNotNullParameter(networkState, "state");
        this.handler.post(new ConnectivityProviderBaseImpl$dispatchChange$1(this, networkState));
    }
}
