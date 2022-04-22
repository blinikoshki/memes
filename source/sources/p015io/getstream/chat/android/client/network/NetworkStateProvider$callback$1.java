package p015io.getstream.chat.android.client.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.network.NetworkStateProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo26107d2 = {"io/getstream/chat/android/client/network/NetworkStateProvider$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.network.NetworkStateProvider$callback$1 */
/* compiled from: NetworkStateProvider.kt */
public final class NetworkStateProvider$callback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkStateProvider this$0;

    NetworkStateProvider$callback$1(NetworkStateProvider networkStateProvider) {
        this.this$0 = networkStateProvider;
    }

    public void onAvailable(Network network) {
        if (!this.this$0.isConnected) {
            this.this$0.isConnected = true;
            for (NetworkStateProvider.NetworkStateListener onConnected : this.this$0.listeners) {
                onConnected.onConnected();
            }
        }
    }

    public void onLost(Network network) {
        NetworkInfo activeNetworkInfo = this.this$0.connectivityManager.getActiveNetworkInfo();
        if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnected() : false) && this.this$0.isConnected) {
            this.this$0.isConnected = false;
            for (NetworkStateProvider.NetworkStateListener onDisconnected : this.this$0.listeners) {
                onDisconnected.onDisconnected();
            }
        }
    }
}
