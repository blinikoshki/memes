package p015io.getstream.chat.android.client.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.RemoteMessage;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.ChatApi;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.call.CallKt;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.NewMessageEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.notifications.FirebaseMessageParser;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0002J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015J\b\u0010/\u001a\u00020\u0017H\u0002J\u0018\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/ChatNotifications;", "", "handler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "client", "Lio/getstream/chat/android/client/api/ChatApi;", "context", "Landroid/content/Context;", "(Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;Lio/getstream/chat/android/client/api/ChatApi;Landroid/content/Context;)V", "getHandler", "()Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "Lkotlin/Lazy;", "showedNotifications", "", "", "handleEvent", "", "event", "Lio/getstream/chat/android/client/events/NewMessageEvent;", "handleRemoteMessage", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "init", "isForeground", "", "isValidRemoteMessage", "loadRequiredData", "channelType", "channelId", "messageId", "onChatEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "onFirebaseMessage", "onRequiredDataLoaded", "channel", "Lio/getstream/chat/android/client/models/Channel;", "Lio/getstream/chat/android/client/models/Message;", "onSetUser", "setFirebaseToken", "firebaseToken", "showErrorCaseNotification", "showNotification", "notificationId", "", "notification", "Landroid/app/Notification;", "wasNotificationDisplayed", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications */
/* compiled from: ChatNotifications.kt */
public final class ChatNotifications {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ChatApi client;
    /* access modifiers changed from: private */
    public final Context context;
    private final ChatNotificationHandler handler;
    /* access modifiers changed from: private */
    public final TaggedLogger logger;
    private final Lazy notificationManager$delegate;
    private final Set<String> showedNotifications;

    private final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    private ChatNotifications(ChatNotificationHandler chatNotificationHandler, ChatApi chatApi, Context context2) {
        this.handler = chatNotificationHandler;
        this.client = chatApi;
        this.context = context2;
        this.showedNotifications = new LinkedHashSet();
        this.logger = ChatLogger.Companion.get("ChatNotifications");
        this.notificationManager$delegate = LazyKt.lazy(new ChatNotifications$notificationManager$2(this));
    }

    public /* synthetic */ ChatNotifications(ChatNotificationHandler chatNotificationHandler, ChatApi chatApi, Context context2, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatNotificationHandler, chatApi, context2);
    }

    public final ChatNotificationHandler getHandler() {
        return this.handler;
    }

    /* access modifiers changed from: private */
    public final void init() {
        if (Build.VERSION.SDK_INT >= 26) {
            getNotificationManager().createNotificationChannel(this.handler.createNotificationChannel());
        }
    }

    public final void onSetUser() {
        Task<InstanceIdResult> instanceId;
        FirebaseInstanceId firebaseInstanceId = this.handler.getFirebaseInstanceId();
        if (firebaseInstanceId != null && (instanceId = firebaseInstanceId.getInstanceId()) != null) {
            instanceId.addOnCompleteListener(new ChatNotifications$onSetUser$1(this));
        }
    }

    public final void setFirebaseToken(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI("setFirebaseToken: " + str);
        this.client.addDevice(str).enqueue(new ChatNotifications$setFirebaseToken$1(this));
    }

    public final void onFirebaseMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI("onReceiveFirebaseMessage: payload: {" + remoteMessage + ".data}");
        if (!this.handler.onFirebaseMessage(remoteMessage) && !isForeground()) {
            handleRemoteMessage(remoteMessage);
        }
    }

    public final void onChatEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        if (chatEvent instanceof NewMessageEvent) {
            TaggedLogger taggedLogger = this.logger;
            taggedLogger.logI("onChatEvent: {" + chatEvent + ".type}");
            if (!this.handler.onChatEvent(chatEvent) && !isForeground()) {
                TaggedLogger taggedLogger2 = this.logger;
                taggedLogger2.logI("onReceiveWebSocketEvent: " + chatEvent);
                handleEvent((NewMessageEvent) chatEvent);
            }
        }
    }

    private final void handleRemoteMessage(RemoteMessage remoteMessage) {
        if (isValidRemoteMessage(remoteMessage)) {
            FirebaseMessageParser.Data parse = this.handler.getFirebaseMessageParser().parse(remoteMessage);
            if (!wasNotificationDisplayed(parse.getMessageId())) {
                this.showedNotifications.add(parse.getMessageId());
                loadRequiredData(parse.getChannelType(), parse.getChannelId(), parse.getMessageId());
                return;
            }
            return;
        }
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logE("Push payload is not configured correctly: {" + remoteMessage.getData() + '}');
    }

    public final boolean isValidRemoteMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.handler.isValidRemoteMessage$stream_chat_android_client_release(remoteMessage);
    }

    private final void handleEvent(NewMessageEvent newMessageEvent) {
        String id = newMessageEvent.getMessage().getId();
        if (!wasNotificationDisplayed(id)) {
            this.showedNotifications.add(id);
            loadRequiredData(newMessageEvent.getChannelType(), newMessageEvent.getChannelId(), id);
        }
    }

    private final boolean wasNotificationDisplayed(String str) {
        return this.showedNotifications.contains(str);
    }

    private final void loadRequiredData(String str, String str2, String str3) {
        CallKt.zipWith(this.client.queryChannel(str, str2, new QueryChannelRequest()), this.client.getMessage(str3)).enqueue(new ChatNotifications$loadRequiredData$1(this, str3));
    }

    /* access modifiers changed from: private */
    public final void onRequiredDataLoaded(Channel channel, Message message) {
        String id = message.getId();
        String id2 = channel.getId();
        int currentTimeMillis = (int) System.currentTimeMillis();
        Object obj = channel.getExtraData().get("name");
        if (obj == null) {
            obj = "";
        }
        Notification buildNotification = this.handler.buildNotification(currentTimeMillis, obj.toString(), message.getText(), id, channel.getType(), id2);
        this.showedNotifications.add(id);
        showNotification(currentTimeMillis, buildNotification);
    }

    /* access modifiers changed from: private */
    public final void showErrorCaseNotification() {
        showNotification((int) System.currentTimeMillis(), this.handler.buildErrorCaseNotification());
    }

    private final void showNotification(int i, Notification notification) {
        if (!isForeground()) {
            Object systemService = this.context.getSystemService("notification");
            if (!(systemService instanceof NotificationManager)) {
                systemService = null;
            }
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                notificationManager.notify(i, notification);
            }
        }
    }

    private final boolean isForeground() {
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "ProcessLifecycleOwner.get().lifecycle");
        return lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/ChatNotifications$Companion;", "", "()V", "create", "Lio/getstream/chat/android/client/notifications/ChatNotifications;", "handler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "client", "Lio/getstream/chat/android/client/api/ChatApi;", "context", "Landroid/content/Context;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.notifications.ChatNotifications$Companion */
    /* compiled from: ChatNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatNotifications create(ChatNotificationHandler chatNotificationHandler, ChatApi chatApi, Context context) {
            Intrinsics.checkNotNullParameter(chatNotificationHandler, "handler");
            Intrinsics.checkNotNullParameter(chatApi, "client");
            Intrinsics.checkNotNullParameter(context, "context");
            ChatNotifications chatNotifications = new ChatNotifications(chatNotificationHandler, chatApi, context, (DefaultConstructorMarker) null);
            chatNotifications.init();
            return chatNotifications;
        }
    }
}
