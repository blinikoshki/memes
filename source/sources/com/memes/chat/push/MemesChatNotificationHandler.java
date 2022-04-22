package com.memes.chat.push;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import com.memes.chat.p036ui.startup.ChatStartupActivity;
import com.memes.chat.routing.ChatRouting;
import com.memes.chat.util.extensions.ChannelExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.notifications.NotificationLoadDataListener;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J8\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/chat/push/MemesChatNotificationHandler;", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "Lio/getstream/chat/android/client/notifications/NotificationLoadDataListener;", "context", "Landroid/content/Context;", "notificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "(Landroid/content/Context;Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;)V", "channel", "Lio/getstream/chat/android/client/models/Channel;", "message", "Lio/getstream/chat/android/client/models/Message;", "buildNotification", "Landroid/app/Notification;", "notificationId", "", "channelName", "", "messageText", "messageId", "channelType", "channelId", "getDataLoadListener", "getNewMessageIntent", "Landroid/content/Intent;", "onLoadFail", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onLoadSuccess", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesChatNotificationHandler.kt */
public final class MemesChatNotificationHandler extends ChatNotificationHandler implements NotificationLoadDataListener {
    private Channel channel;
    private Message message;

    public void onLoadFail(String str, ChatError chatError) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(chatError, "error");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemesChatNotificationHandler(Context context, NotificationConfig notificationConfig) {
        super(context, notificationConfig);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
    }

    public Intent getNewMessageIntent(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        ChatPushMessage chatPushMessage = new ChatPushMessage(str3, str2, str);
        Intent intent = new Intent(getContext(), ChatStartupActivity.class);
        intent.putExtra(ChatRouting.EXTRA_PUSH_MESSAGE, chatPushMessage);
        return intent;
    }

    public NotificationLoadDataListener getDataLoadListener() {
        return this;
    }

    public Notification buildNotification(int i, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "channelName");
        Intrinsics.checkNotNullParameter(str2, "messageText");
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str4, "channelType");
        Intrinsics.checkNotNullParameter(str5, "channelId");
        Channel channel2 = this.channel;
        Message message2 = this.message;
        String str6 = null;
        if (Intrinsics.areEqual((Object) str5, (Object) channel2 != null ? channel2.getId() : null)) {
            if (message2 != null) {
                str6 = message2.getId();
            }
            if (Intrinsics.areEqual((Object) str3, (Object) str6)) {
                str = ContentUtils.getName(message2.getUser());
                String name = ContentUtils.getName(channel2);
                if (!ChannelExtKt.isDirectMessagingScope(channel2)) {
                    if (!StringsKt.isBlank(name)) {
                        str = str + " @ " + name;
                    } else {
                        str = str + " [Group]";
                    }
                }
            }
        }
        return super.buildNotification(i, str, str2, str3, str4, str5);
    }

    public void onLoadSuccess(Channel channel2, Message message2) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.channel = channel2;
        this.message = message2;
    }
}
