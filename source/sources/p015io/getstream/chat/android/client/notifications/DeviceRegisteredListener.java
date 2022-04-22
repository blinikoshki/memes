package p015io.getstream.chat.android.client.notifications;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/DeviceRegisteredListener;", "", "onDeviceRegisteredError", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onDeviceRegisteredSuccess", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.DeviceRegisteredListener */
/* compiled from: DeviceRegisteredListener.kt */
public interface DeviceRegisteredListener {
    void onDeviceRegisteredError(ChatError chatError);

    void onDeviceRegisteredSuccess();
}
