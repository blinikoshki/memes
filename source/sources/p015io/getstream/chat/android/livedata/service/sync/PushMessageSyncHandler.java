package p015io.getstream.chat.android.livedata.service.sync;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.FirebaseMessageParser;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0007J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020 J(\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u000201H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u00063"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/PushMessageSyncHandler;", "", "service", "Landroid/app/Service;", "(Landroid/app/Service;)V", "firebaseMessageParser", "Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "getFirebaseMessageParser", "()Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "firebaseMessageParser$delegate", "Lkotlin/Lazy;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "notificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "getNotificationConfig", "()Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "notificationConfig$delegate", "syncModule", "Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "getSyncModule", "()Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "syncModule$delegate", "createSyncNotificationChannel", "", "initClient", "Lio/getstream/chat/android/client/ChatClient;", "context", "Landroid/content/Context;", "user", "Lio/getstream/chat/android/client/models/User;", "userToken", "", "apiKey", "initDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "client", "isStreamMessage", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "onMessageReceived", "onNewToken", "token", "performSync", "domain", "cid", "startForegroundExecution", "smallIcon", "", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.service.sync.PushMessageSyncHandler */
/* compiled from: PushMessageSyncHandler.kt */
public final class PushMessageSyncHandler {
    @Deprecated
    private static final String CHANNEL_ID = "notification_channel_id";
    @Deprecated
    private static final String CHANNEL_NAME = "Chat messages sync";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int NOTIFICATION_ID = 1;
    private final Lazy firebaseMessageParser$delegate = LazyKt.lazy(new PushMessageSyncHandler$firebaseMessageParser$2(this));
    private final TaggedLogger logger = ChatLogger.Companion.get("PushMessageSyncHandler");
    private final Lazy notificationConfig$delegate = LazyKt.lazy(new PushMessageSyncHandler$notificationConfig$2(this));
    /* access modifiers changed from: private */
    public final Service service;
    private final Lazy syncModule$delegate = LazyKt.lazy(new PushMessageSyncHandler$syncModule$2(this));

    private final FirebaseMessageParser getFirebaseMessageParser() {
        return (FirebaseMessageParser) this.firebaseMessageParser$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NotificationConfig getNotificationConfig() {
        return (NotificationConfig) this.notificationConfig$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SyncProvider getSyncModule() {
        return (SyncProvider) this.syncModule$delegate.getValue();
    }

    public PushMessageSyncHandler(Service service2) {
        Intrinsics.checkNotNullParameter(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    public final void onNewToken(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "token");
        if (ChatClient.Companion.isInitialized()) {
            ChatClient.Companion.instance().onNewTokenReceived(str2);
            return;
        }
        BackgroundSyncConfig backgroundSyncConfig = getSyncModule().mo69979x9c3f7c57().get();
        if (backgroundSyncConfig != null) {
            User user = r3;
            User user2 = new User(backgroundSyncConfig.getUserId(), (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
            User user3 = user;
            initClient(this.service, user3, backgroundSyncConfig.getUserToken(), backgroundSyncConfig.getApiKey()).onNewTokenReceived(str2);
        }
    }

    public final void onMessageReceived(RemoteMessage remoteMessage) {
        RemoteMessage remoteMessage2 = remoteMessage;
        Intrinsics.checkNotNullParameter(remoteMessage2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (isStreamMessage(remoteMessage)) {
            createSyncNotificationChannel();
            startForegroundExecution(getNotificationConfig().getSmallIcon());
            FirebaseMessageParser.Data parse = getFirebaseMessageParser().parse(remoteMessage2);
            String str = parse.getChannelType() + ':' + parse.getChannelId();
            if (!ChatDomain.Companion.isInitialized() || !ChatClient.Companion.isInitialized()) {
                BackgroundSyncConfig backgroundSyncConfig = getSyncModule().mo69979x9c3f7c57().get();
                if (backgroundSyncConfig != null) {
                    User user = r4;
                    User user2 = new User(backgroundSyncConfig.getUserId(), (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
                    User user3 = user;
                    ChatClient initClient = initClient(this.service, user3, backgroundSyncConfig.getUserToken(), backgroundSyncConfig.getApiKey());
                    ChatDomain initDomain = initDomain(user3, initClient);
                    this.logger.logD("Starting the sync, config: " + backgroundSyncConfig);
                    performSync(initDomain, str, initClient, remoteMessage2);
                }
            } else {
                this.logger.logD("Starting the sync");
                performSync(ChatDomain.Companion.instance(), str, ChatClient.Companion.instance(), remoteMessage2);
            }
            this.service.stopForeground(true);
        }
    }

    public final boolean isStreamMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return ChatClient.Companion.isValidRemoteMessage(remoteMessage, getNotificationConfig());
    }

    private final void performSync(ChatDomain chatDomain, String str, ChatClient chatClient, RemoteMessage remoteMessage) {
        if (chatDomain.getUseCases().getReplayEventsForActiveChannels().invoke(str).execute().isSuccess()) {
            this.logger.logD("Sync success.");
        } else {
            this.logger.logD("Sync failed.");
        }
        chatClient.onMessageReceived(remoteMessage);
    }

    private final void startForegroundExecution(int i) {
        this.service.startForeground(1, new NotificationCompat.Builder(this.service, CHANNEL_ID).setAutoCancel(true).setSmallIcon(i).build());
    }

    private final void createSyncNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.service.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4));
        }
    }

    private final ChatDomain initDomain(User user, ChatClient chatClient) {
        return new ChatDomain.Builder((Context) this.service, chatClient, user).build();
    }

    private final ChatClient initClient(Context context, User user, String str, String str2) {
        ChatNotificationHandler chatNotificationHandler = new ChatNotificationHandler(context, getSyncModule().getNotificationConfigStore$stream_chat_android_offline_release().get());
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        ChatClient build = new ChatClient.Builder(str2, applicationContext).notifications(chatNotificationHandler).build();
        build.setUserWithoutConnecting(user, str);
        return build;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/PushMessageSyncHandler$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "NOTIFICATION_ID", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.service.sync.PushMessageSyncHandler$Companion */
    /* compiled from: PushMessageSyncHandler.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
