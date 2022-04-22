package com.memes.chat.push;

import androidx.core.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.service.sync.PushMessageSyncHandler;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/chat/push/ChatPushMessageHandler;", "", "service", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "(Lcom/google/firebase/messaging/FirebaseMessagingService;)V", "pushDataSyncHandler", "Lio/getstream/chat/android/livedata/service/sync/PushMessageSyncHandler;", "handlePushMessage", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "handleTokenUpdated", "", "token", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatPushMessageHandler.kt */
public final class ChatPushMessageHandler {
    private final PushMessageSyncHandler pushDataSyncHandler;

    public ChatPushMessageHandler(FirebaseMessagingService firebaseMessagingService) {
        Intrinsics.checkNotNullParameter(firebaseMessagingService, NotificationCompat.CATEGORY_SERVICE);
        this.pushDataSyncHandler = new PushMessageSyncHandler(firebaseMessagingService);
    }

    public final void handleTokenUpdated(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.pushDataSyncHandler.onNewToken(str);
    }

    public final boolean handlePushMessage(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (!this.pushDataSyncHandler.isStreamMessage(remoteMessage)) {
            return false;
        }
        this.pushDataSyncHandler.onMessageReceived(remoteMessage);
        return true;
    }
}
