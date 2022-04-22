package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.WebSocket;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.parser.ChatParser;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/Socket;", "", "socket", "Lokhttp3/WebSocket;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "(Lokhttp3/WebSocket;Lio/getstream/chat/android/client/parser/ChatParser;)V", "getParser", "()Lio/getstream/chat/android/client/parser/ChatParser;", "getSocket", "()Lokhttp3/WebSocket;", "close", "", "code", "", "reason", "", "send", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.Socket */
/* compiled from: Socket.kt */
public final class Socket {
    private final ChatParser parser;
    private final WebSocket socket;

    public Socket(WebSocket webSocket, ChatParser chatParser) {
        Intrinsics.checkNotNullParameter(webSocket, "socket");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        this.socket = webSocket;
        this.parser = chatParser;
    }

    public final ChatParser getParser() {
        return this.parser;
    }

    public final WebSocket getSocket() {
        return this.socket;
    }

    public final void send(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        this.socket.send(this.parser.toJson(chatEvent));
    }

    public final void close(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        this.socket.close(i, str);
    }
}
