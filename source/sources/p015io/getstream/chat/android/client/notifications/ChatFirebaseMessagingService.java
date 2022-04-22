package p015io.getstream.chat.android.client.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/ChatFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "defaultNotificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "createSyncNotificationChannel", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "showForegroundNotification", "smallIcon", "", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatFirebaseMessagingService */
/* compiled from: ChatFirebaseMessagingService.kt */
public final class ChatFirebaseMessagingService extends FirebaseMessagingService {
    @Deprecated
    private static final String CHANNEL_ID = "notification_channel_id";
    @Deprecated
    private static final String CHANNEL_NAME = "Chat messages sync";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int NOTIFICATION_ID = 1;
    private final NotificationConfig defaultNotificationConfig = new NotificationConfig(0, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, false, 2047, (DefaultConstructorMarker) null);
    private final TaggedLogger logger = ChatLogger.Companion.get("ChatFirebaseMessagingService");

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logD("onMessageReceived(): " + remoteMessage);
        if (ChatClient.Companion.isValidRemoteMessage(remoteMessage, this.defaultNotificationConfig)) {
            createSyncNotificationChannel();
            showForegroundNotification(this.defaultNotificationConfig.getSmallIcon());
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getIO(), (CoroutineStart) null, new ChatFirebaseMessagingService$onMessageReceived$1(this, remoteMessage, (Continuation) null), 2, (Object) null);
        }
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        if (ChatClient.Companion.isInitialized()) {
            ChatClient.Companion.instance().onNewTokenReceived(str);
        }
    }

    private final void showForegroundNotification(int i) {
        startForeground(1, new NotificationCompat.Builder(this, CHANNEL_ID).setAutoCancel(true).setSmallIcon(i).build());
    }

    private final void createSyncNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/ChatFirebaseMessagingService$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "NOTIFICATION_ID", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.notifications.ChatFirebaseMessagingService$Companion */
    /* compiled from: ChatFirebaseMessagingService.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
