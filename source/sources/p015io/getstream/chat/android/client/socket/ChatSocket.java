package p015io.getstream.chat.android.client.socket;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.observable.ChatObservable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocket;", "", "addListener", "", "listener", "Lio/getstream/chat/android/client/socket/SocketListener;", "connect", "user", "Lio/getstream/chat/android/client/models/User;", "connectAnonymously", "disconnect", "events", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "removeListener", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocket */
/* compiled from: ChatSocket.kt */
public interface ChatSocket {
    void addListener(SocketListener socketListener);

    void connect(User user);

    void connectAnonymously();

    void disconnect();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use addListener and removeListener directly instead (or the subscribe methods of ChatClient)")
    ChatObservable events();

    void removeListener(SocketListener socketListener);
}
