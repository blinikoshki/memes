package p015io.getstream.chat.android.client.notifications;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.extensions.RemoteMessageExtensionsKt;
import p015io.getstream.chat.android.client.notifications.FirebaseMessageParser;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/FirebaseMessageParserImpl;", "Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "config", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "(Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;)V", "channelIdKey", "", "channelTypeKey", "messageIdKey", "isValidRemoteMessage", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "parse", "Lio/getstream/chat/android/client/notifications/FirebaseMessageParser$Data;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.FirebaseMessageParserImpl */
/* compiled from: FirebaseMessageParserImpl.kt */
public final class FirebaseMessageParserImpl implements FirebaseMessageParser {
    private final String channelIdKey;
    private final String channelTypeKey;
    private final NotificationConfig config;
    private final String messageIdKey;

    public FirebaseMessageParserImpl(NotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(notificationConfig, "config");
        this.config = notificationConfig;
        this.messageIdKey = notificationConfig.getFirebaseMessageIdKey();
        this.channelTypeKey = notificationConfig.getFirebaseChannelTypeKey();
        this.channelIdKey = notificationConfig.getFirebaseChannelIdKey();
    }

    public boolean isValidRemoteMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return RemoteMessageExtensionsKt.isValid(remoteMessage, this.config);
    }

    public FirebaseMessageParser.Data parse(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        String str = remoteMessage.getData().get(this.messageIdKey);
        Intrinsics.checkNotNull(str);
        String str2 = remoteMessage.getData().get(this.channelIdKey);
        Intrinsics.checkNotNull(str2);
        String str3 = remoteMessage.getData().get(this.channelTypeKey);
        Intrinsics.checkNotNull(str3);
        return new FirebaseMessageParser.Data(str, str3, str2);
    }
}
