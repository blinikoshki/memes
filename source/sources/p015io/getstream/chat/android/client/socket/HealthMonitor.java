package p015io.getstream.chat.android.client.socket;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0012\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/HealthMonitor;", "", "healthCallback", "Lio/getstream/chat/android/client/socket/HealthMonitor$HealthCallback;", "(Lio/getstream/chat/android/client/socket/HealthMonitor$HealthCallback;)V", "consecutiveFailures", "", "delayHandler", "Landroid/os/Handler;", "disconnected", "", "healthCheck", "Ljava/lang/Runnable;", "lastEventDate", "Ljava/util/Date;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "monitor", "reconnect", "ack", "", "getRetryInterval", "", "needToReconnect", "onDisconnected", "resetHealthMonitor", "start", "stop", "HealthCallback", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.HealthMonitor */
/* compiled from: HealthMonitor.kt */
public final class HealthMonitor {
    private int consecutiveFailures;
    /* access modifiers changed from: private */
    public final Handler delayHandler = new Handler(Looper.getMainLooper());
    private boolean disconnected;
    /* access modifiers changed from: private */
    public final HealthCallback healthCallback;
    /* access modifiers changed from: private */
    public final Runnable healthCheck = new HealthMonitor$healthCheck$1(this);
    private Date lastEventDate = new Date();
    private final TaggedLogger logger = ChatLogger.Companion.get("SocketMonitor");
    /* access modifiers changed from: private */
    public final Runnable monitor = new HealthMonitor$monitor$1(this);
    private final Runnable reconnect = new HealthMonitor$reconnect$1(this);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/HealthMonitor$HealthCallback;", "", "check", "", "reconnect", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.socket.HealthMonitor$HealthCallback */
    /* compiled from: HealthMonitor.kt */
    public interface HealthCallback {
        void check();

        void reconnect();
    }

    public HealthMonitor(HealthCallback healthCallback2) {
        Intrinsics.checkNotNullParameter(healthCallback2, "healthCallback");
        this.healthCallback = healthCallback2;
    }

    public final void start() {
        this.lastEventDate = new Date();
        this.disconnected = false;
        resetHealthMonitor();
    }

    public final void stop() {
        this.delayHandler.removeCallbacks(this.monitor);
        this.delayHandler.removeCallbacks(this.reconnect);
        this.delayHandler.removeCallbacks(this.healthCheck);
    }

    public final void ack() {
        this.lastEventDate = new Date();
        this.delayHandler.removeCallbacks(this.reconnect);
        this.disconnected = false;
        this.consecutiveFailures = 0;
    }

    public final void onDisconnected() {
        this.disconnected = true;
        resetHealthMonitor();
    }

    private final void resetHealthMonitor() {
        stop();
        this.delayHandler.postDelayed(this.monitor, 1000);
    }

    /* access modifiers changed from: private */
    public final void reconnect() {
        stop();
        int i = this.consecutiveFailures + 1;
        this.consecutiveFailures = i;
        long retryInterval = getRetryInterval(i);
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI("Next connection attempt in " + retryInterval + " ms");
        this.delayHandler.postDelayed(this.reconnect, retryInterval);
    }

    /* access modifiers changed from: private */
    public final boolean needToReconnect() {
        return this.disconnected || new Date().getTime() - this.lastEventDate.getTime() >= 30000;
    }

    private final long getRetryInterval(int i) {
        int min = Math.min((i * 2000) + 500, 25000);
        int min2 = Math.min(Math.max(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, (i - 1) * 2000), 25000);
        return (long) Math.floor((Math.random() * ((double) (min - min2))) + ((double) min2));
    }
}
