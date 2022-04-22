package p015io.getstream.chat.android.client.socket;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.network.NetworkStateProvider;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.token.TokenManager;
import p015io.getstream.chat.android.client.utils.observable.ChatObservable;
import p015io.getstream.chat.android.client.utils.observable.ChatObservableImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketImpl;", "Lio/getstream/chat/android/client/socket/ChatSocket;", "apiKey", "", "wssUrl", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "networkStateProvider", "Lio/getstream/chat/android/client/network/NetworkStateProvider;", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/token/TokenManager;Lio/getstream/chat/android/client/parser/ChatParser;Lio/getstream/chat/android/client/network/NetworkStateProvider;)V", "eventsParser", "Lio/getstream/chat/android/client/socket/EventsParser;", "service", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl;", "addListener", "", "listener", "Lio/getstream/chat/android/client/socket/SocketListener;", "connect", "user", "Lio/getstream/chat/android/client/models/User;", "connectAnonymously", "disconnect", "events", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "removeListener", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketImpl */
/* compiled from: ChatSocketImpl.kt */
public final class ChatSocketImpl implements ChatSocket {
    private final String apiKey;
    private final EventsParser eventsParser;
    private final ChatSocketServiceImpl service;
    private final String wssUrl;

    public ChatSocketImpl(String str, String str2, TokenManager tokenManager, ChatParser chatParser, NetworkStateProvider networkStateProvider) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(str2, "wssUrl");
        Intrinsics.checkNotNullParameter(tokenManager, "tokenManager");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        Intrinsics.checkNotNullParameter(networkStateProvider, "networkStateProvider");
        this.apiKey = str;
        this.wssUrl = str2;
        EventsParser eventsParser2 = new EventsParser(chatParser);
        this.eventsParser = eventsParser2;
        this.service = ChatSocketServiceImpl.Companion.create(tokenManager, new SocketFactory(eventsParser2, chatParser, tokenManager), eventsParser2, networkStateProvider);
    }

    public void connectAnonymously() {
        this.service.anonymousConnect(this.wssUrl, this.apiKey);
    }

    public void connect(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.service.userConnect(this.wssUrl, this.apiKey, user);
    }

    public ChatObservable events() {
        return new ChatObservableImpl(this.service);
    }

    public void disconnect() {
        this.service.disconnect();
    }

    public void addListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.service.addListener(socketListener);
    }

    public void removeListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.service.removeListener(socketListener);
    }
}
