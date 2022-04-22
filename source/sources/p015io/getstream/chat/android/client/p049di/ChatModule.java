package p015io.getstream.chat.android.client.p049di;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.ChatClientConfig;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.token.TokenManager;
import p015io.getstream.chat.android.client.uploader.FileUploader;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/di/ChatModule;", "Lio/getstream/chat/android/client/di/BaseChatModule;", "appContext", "Landroid/content/Context;", "config", "Lio/getstream/chat/android/client/api/ChatClientConfig;", "notificationsHandler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "uploader", "Lio/getstream/chat/android/client/uploader/FileUploader;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "(Landroid/content/Context;Lio/getstream/chat/android/client/api/ChatClientConfig;Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;Lio/getstream/chat/android/client/uploader/FileUploader;Lio/getstream/chat/android/client/token/TokenManager;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.di.ChatModule */
/* compiled from: ChatModule.kt */
public final class ChatModule extends BaseChatModule {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatModule(Context context, ChatClientConfig chatClientConfig, ChatNotificationHandler chatNotificationHandler, FileUploader fileUploader, TokenManager tokenManager) {
        super(context, chatClientConfig, chatNotificationHandler, fileUploader, tokenManager);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(chatClientConfig, "config");
        Intrinsics.checkNotNullParameter(chatNotificationHandler, "notificationsHandler");
        Intrinsics.checkNotNullParameter(tokenManager, "tokenManager");
    }
}
