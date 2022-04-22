package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/SocketListener;", "", "()V", "onConnected", "", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onConnecting", "onDisconnected", "onError", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.SocketListener */
/* compiled from: SocketListener.kt */
public class SocketListener {
    public void onConnected(ConnectedEvent connectedEvent) {
        Intrinsics.checkNotNullParameter(connectedEvent, "event");
    }

    public void onConnecting() {
    }

    public void onDisconnected() {
    }

    public void onError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
    }

    public void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
    }
}
