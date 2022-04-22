package coil.network;

import android.net.ConnectivityManager;
import android.net.Network;
import com.appsflyer.ServerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo26107d2 = {"coil/network/NetworkObserverApi21$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: NetworkObserver.kt */
public final class NetworkObserverApi21$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkObserverApi21 this$0;

    NetworkObserverApi21$networkCallback$1(NetworkObserverApi21 networkObserverApi21) {
        this.this$0 = networkObserverApi21;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, ServerParameters.NETWORK);
        this.this$0.onConnectivityChange(network, true);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, ServerParameters.NETWORK);
        this.this$0.onConnectivityChange(network, false);
    }
}
