package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketService;", "", "addListener", "", "listener", "Lio/getstream/chat/android/client/socket/SocketListener;", "anonymousConnect", "endpoint", "", "apiKey", "disconnect", "onConnectionResolved", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "onSocketError", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "removeListener", "userConnect", "user", "Lio/getstream/chat/android/client/models/User;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketService */
/* compiled from: ChatSocketService.kt */
public interface ChatSocketService {
    void addListener(SocketListener socketListener);

    void anonymousConnect(String str, String str2);

    void disconnect();

    void onConnectionResolved(ConnectedEvent connectedEvent);

    void onEvent(ChatEvent chatEvent);

    void onSocketError(ChatError chatError);

    void removeListener(SocketListener socketListener);

    void userConnect(String str, String str2, User user);
}
