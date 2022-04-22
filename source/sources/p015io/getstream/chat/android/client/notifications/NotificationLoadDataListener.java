package p015io.getstream.chat.android.client.notifications;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/NotificationLoadDataListener;", "", "onLoadFail", "", "messageId", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onLoadSuccess", "channel", "Lio/getstream/chat/android/client/models/Channel;", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.NotificationLoadDataListener */
/* compiled from: NotificationLoadDataListener.kt */
public interface NotificationLoadDataListener {
    void onLoadFail(String str, ChatError chatError);

    void onLoadSuccess(Channel channel, Message message);
}
