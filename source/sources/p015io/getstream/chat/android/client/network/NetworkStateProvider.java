package p015io.getstream.chat.android.client.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/network/NetworkStateProvider;", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "callback", "io/getstream/chat/android/client/network/NetworkStateProvider$callback$1", "Lio/getstream/chat/android/client/network/NetworkStateProvider$callback$1;", "isConnected", "", "isRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listeners", "", "Lio/getstream/chat/android/client/network/NetworkStateProvider$NetworkStateListener;", "subscribe", "", "listener", "unsubscribe", "NetworkStateListener", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.network.NetworkStateProvider */
/* compiled from: NetworkStateProvider.kt */
public final class NetworkStateProvider {
    private final NetworkStateProvider$callback$1 callback = new NetworkStateProvider$callback$1(this);
    /* access modifiers changed from: private */
    public final ConnectivityManager connectivityManager;
    /* access modifiers changed from: private */
    public volatile boolean isConnected;
    private final AtomicBoolean isRegistered = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public volatile List<? extends NetworkStateListener> listeners = CollectionsKt.emptyList();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/network/NetworkStateProvider$NetworkStateListener;", "", "onConnected", "", "onDisconnected", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.network.NetworkStateProvider$NetworkStateListener */
    /* compiled from: NetworkStateProvider.kt */
    public interface NetworkStateListener {
        void onConnected();

        void onDisconnected();
    }

    public NetworkStateProvider(ConnectivityManager connectivityManager2) {
        Intrinsics.checkNotNullParameter(connectivityManager2, "connectivityManager");
        this.connectivityManager = connectivityManager2;
    }

    public final boolean isConnected() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        this.isConnected = activeNetworkInfo != null ? activeNetworkInfo.isConnected() : false;
        return this.isConnected;
    }

    public final void subscribe(NetworkStateListener networkStateListener) {
        Intrinsics.checkNotNullParameter(networkStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners = CollectionsKt.plus(this.listeners, networkStateListener);
        this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.callback);
        this.isRegistered.set(true);
    }

    public final void unsubscribe(NetworkStateListener networkStateListener) {
        Intrinsics.checkNotNullParameter(networkStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List<? extends NetworkStateListener> minus = CollectionsKt.minus(this.listeners, networkStateListener);
        if (minus.isEmpty() && this.isRegistered.compareAndSet(true, false)) {
            this.connectivityManager.unregisterNetworkCallback(this.callback);
        }
        Unit unit = Unit.INSTANCE;
        this.listeners = minus;
    }
}
