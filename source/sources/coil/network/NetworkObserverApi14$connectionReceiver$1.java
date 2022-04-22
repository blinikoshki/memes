package coil.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import coil.network.NetworkObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"coil/network/NetworkObserverApi14$connectionReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: NetworkObserver.kt */
public final class NetworkObserverApi14$connectionReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ NetworkObserver.Listener $listener;
    final /* synthetic */ NetworkObserverApi14 this$0;

    NetworkObserverApi14$connectionReceiver$1(NetworkObserverApi14 networkObserverApi14, NetworkObserver.Listener listener) {
        this.this$0 = networkObserverApi14;
        this.$listener = listener;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) "android.net.conn.CONNECTIVITY_CHANGE")) {
            this.$listener.onConnectivityChange(this.this$0.isOnline());
        }
    }
}
