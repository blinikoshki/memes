package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.HealthMonitor$reconnect$1 */
/* compiled from: HealthMonitor.kt */
final class HealthMonitor$reconnect$1 implements Runnable {
    final /* synthetic */ HealthMonitor this$0;

    HealthMonitor$reconnect$1(HealthMonitor healthMonitor) {
        this.this$0 = healthMonitor;
    }

    public final void run() {
        if (this.this$0.needToReconnect()) {
            this.this$0.healthCallback.reconnect();
        }
    }
}
