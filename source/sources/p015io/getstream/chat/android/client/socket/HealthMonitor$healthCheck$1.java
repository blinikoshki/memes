package p015io.getstream.chat.android.client.socket;

import androidx.work.WorkRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.HealthMonitor$healthCheck$1 */
/* compiled from: HealthMonitor.kt */
final class HealthMonitor$healthCheck$1 implements Runnable {
    final /* synthetic */ HealthMonitor this$0;

    HealthMonitor$healthCheck$1(HealthMonitor healthMonitor) {
        this.this$0 = healthMonitor;
    }

    public final void run() {
        this.this$0.healthCallback.check();
        this.this$0.delayHandler.postDelayed(this.this$0.monitor, WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
