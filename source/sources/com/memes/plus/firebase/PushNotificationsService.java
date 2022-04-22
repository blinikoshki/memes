package com.memes.plus.firebase;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.memes.chat.push.ChatPushMessageHandler;
import com.memes.network.memes.MemesSession;
import com.memes.plus.firebase.firebase_token.FirebaseTokenSender;
import com.memes.plus.notifications.NotificationCreator;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/firebase/PushNotificationsService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "chatPushMessageHandler", "Lcom/memes/chat/push/ChatPushMessageHandler;", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PushNotificationsService.kt */
public final class PushNotificationsService extends FirebaseMessagingService {
    private final ChatPushMessageHandler chatPushMessageHandler = new ChatPushMessageHandler(this);

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        if (!this.chatPushMessageHandler.handlePushMessage(remoteMessage)) {
            RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            repositoryInjection.storageRepository(applicationContext).refreshSession();
            if (!MemesSession.INSTANCE.isEmpty()) {
                PushMessage from = PushMessage.Companion.from(remoteMessage);
                Timber.m306i(from.getLog(), new Object[0]);
                if (MemesSession.INSTANCE.isOf(from.getReceiverId())) {
                    NotificationCreator.INSTANCE.create(this, from);
                }
            }
        }
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.chatPushMessageHandler.handleTokenUpdated(str);
        FirebaseTokenSender.INSTANCE.send(str);
    }
}
