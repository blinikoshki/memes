package com.memes.commons.connectivity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.memes.commons.connectivity.ConnectivityProvider;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/memes/commons/connectivity/ConnectivityProvider$ConnectivityStateListener;", "connectivityProvider", "Lcom/memes/commons/connectivity/ConnectivityProvider;", "(Lcom/memes/commons/connectivity/ConnectivityProvider;)V", "_connected", "Lcom/memes/commons/util/SingleLiveEvent;", "", "connected", "Landroidx/lifecycle/LiveData;", "onLifecycleStart", "", "onLifecycleStop", "onStateChange", "state", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityViewModel.kt */
public final class ConnectivityViewModel extends BaseViewModel implements LifecycleObserver, ConnectivityProvider.ConnectivityStateListener {
    private final SingleLiveEvent<Boolean> _connected = new SingleLiveEvent<>();
    private final ConnectivityProvider connectivityProvider;

    public ConnectivityViewModel(ConnectivityProvider connectivityProvider2) {
        Intrinsics.checkNotNullParameter(connectivityProvider2, "connectivityProvider");
        this.connectivityProvider = connectivityProvider2;
    }

    public final LiveData<Boolean> connected() {
        return this._connected;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onLifecycleStart() {
        this.connectivityProvider.addListener(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onLifecycleStop() {
        this.connectivityProvider.removeListener(this);
    }

    public void onStateChange(ConnectivityProvider.NetworkState networkState) {
        Intrinsics.checkNotNullParameter(networkState, "state");
        if (networkState instanceof ConnectivityProvider.NetworkState.NotConnectedState) {
            this._connected.setValue(false);
        } else if (networkState instanceof ConnectivityProvider.NetworkState.ConnectedState) {
            this._connected.setValue(Boolean.valueOf(((ConnectivityProvider.NetworkState.ConnectedState) networkState).getHasInternet()));
        }
    }
}
