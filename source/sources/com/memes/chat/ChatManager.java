package com.memes.chat;

import android.content.Context;
import com.getstream.sdk.chat.ChatUI;
import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.chat.push.MemesChatNotificationHandler;
import com.memes.chat.util.logger.ChatLogger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.logger.ChatLogLevel;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/ChatManager;", "", "()V", "API_KEY", "", "disconnect", "", "init", "applicationContext", "Landroid/content/Context;", "initChatUser", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatManager.kt */
public final class ChatManager {
    private static final String API_KEY = "g5auu9ccs7n9";
    public static final ChatManager INSTANCE = new ChatManager();

    private ChatManager() {
    }

    public final void init(Context context) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "applicationContext");
        new ChatDomain.Builder(new ChatClient.Builder(API_KEY, context2).loggerHandler(ChatLogger.INSTANCE).logLevel(ChatLogLevel.NOTHING).notifications(new MemesChatNotificationHandler(context2, new NotificationConfig(0, 0, C4059R.C4062drawable.chat_notification_small, "message_id", (String) null, "channel_id", "channel_type", (String) null, 0, 0, false, 1939, (DefaultConstructorMarker) null))).build(), context2).offlineEnabled().userPresenceEnabled().build();
        new ChatUI.Builder(context2).build();
        initChatUser(context);
    }

    private final void initChatUser(Context context) {
        ChatCredentialsSharedPref chatCredentialsSharedPref = new ChatCredentialsSharedPref(context);
        String realUserId = chatCredentialsSharedPref.realUserId();
        CharSequence charSequence = realUserId;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            String chatToken = chatCredentialsSharedPref.getChatToken();
            CharSequence charSequence2 = chatToken;
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                String userName = chatCredentialsSharedPref.userName();
                CharSequence charSequence3 = userName;
                if (!(charSequence3 == null || StringsKt.isBlank(charSequence3))) {
                    String profilePic = chatCredentialsSharedPref.profilePic();
                    User user = r1;
                    String str = chatToken;
                    User user2 = new User(realUserId, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
                    user.getExtraData().put("name", userName);
                    CharSequence charSequence4 = profilePic;
                    if (charSequence4 == null || StringsKt.isBlank(charSequence4)) {
                        z = true;
                    }
                    if (!z) {
                        user.getExtraData().put("image", profilePic);
                    }
                    ChatClient.Companion.instance().connectUser(user, str).enqueue();
                }
            }
        }
    }

    public final void disconnect() {
        ChatClient.Companion.instance().disconnect();
    }
}
