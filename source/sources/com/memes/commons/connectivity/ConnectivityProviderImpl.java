package com.memes.commons.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.appsflyer.ServerParameters;
import com.memes.commons.connectivity.ConnectivityProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProviderImpl;", "Lcom/memes/commons/connectivity/ConnectivityProviderBaseImpl;", "cm", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "networkCallback", "Lcom/memes/commons/connectivity/ConnectivityProviderImpl$ConnectivityCallback;", "getNetworkState", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "subscribe", "", "unsubscribe", "ConnectivityCallback", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityProviderImpl.kt */
public final class ConnectivityProviderImpl extends ConnectivityProviderBaseImpl {

    /* renamed from: cm */
    private final ConnectivityManager f959cm;
    private final ConnectivityCallback networkCallback = new ConnectivityCallback();

    public ConnectivityProviderImpl(ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "cm");
        this.f959cm = connectivityManager;
    }

    /* access modifiers changed from: protected */
    public void subscribe() {
        this.f959cm.registerDefaultNetworkCallback(this.networkCallback);
    }

    /* access modifiers changed from: protected */
    public void unsubscribe() {
        this.f959cm.unregisterNetworkCallback(this.networkCallback);
    }

    public ConnectivityProvider.NetworkState getNetworkState() {
        ConnectivityManager connectivityManager = this.f959cm;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities != null) {
            return new ConnectivityProvider.NetworkState.ConnectedState.Connected(networkCapabilities);
        }
        return ConnectivityProvider.NetworkState.NotConnectedState.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProviderImpl$ConnectivityCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "(Lcom/memes/commons/connectivity/ConnectivityProviderImpl;)V", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "capabilities", "Landroid/net/NetworkCapabilities;", "onLost", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ConnectivityProviderImpl.kt */
    private final class ConnectivityCallback extends ConnectivityManager.NetworkCallback {
        public ConnectivityCallback() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, ServerParameters.NETWORK);
            Intrinsics.checkNotNullParameter(networkCapabilities, "capabilities");
            ConnectivityProviderImpl.this.dispatchChange(new ConnectivityProvider.NetworkState.ConnectedState.Connected(networkCapabilities));
        }

        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, ServerParameters.NETWORK);
            ConnectivityProviderImpl.this.dispatchChange(ConnectivityProvider.NetworkState.NotConnectedState.INSTANCE);
        }
    }
}
