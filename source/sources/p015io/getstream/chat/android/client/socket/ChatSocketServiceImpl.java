package p015io.getstream.chat.android.client.socket;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatErrorCode;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.network.NetworkStateProvider;
import p015io.getstream.chat.android.client.token.TokenManager;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b\u0000\u0018\u0000 C2\u00020\u0001:\u0003CDEB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u001c\u0010+\u001a\u00020%2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0-H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020%H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020%2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00104\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00101\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0015\u0010=\u001a\u00020%2\u0006\u00104\u001a\u000207H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010@\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010A\u001a\u00020BH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R1\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8@@BX\u0002¢\u0006\u0018\n\u0004\b\"\u0010#\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl;", "Lio/getstream/chat/android/client/socket/ChatSocketService;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "socketFactory", "Lio/getstream/chat/android/client/socket/SocketFactory;", "networkStateProvider", "Lio/getstream/chat/android/client/network/NetworkStateProvider;", "(Lio/getstream/chat/android/client/token/TokenManager;Lio/getstream/chat/android/client/socket/SocketFactory;Lio/getstream/chat/android/client/network/NetworkStateProvider;)V", "connectionConf", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf;", "eventUiHandler", "Landroid/os/Handler;", "healthMonitor", "Lio/getstream/chat/android/client/socket/HealthMonitor;", "listeners", "", "Lio/getstream/chat/android/client/socket/SocketListener;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "networkStateListener", "io/getstream/chat/android/client/socket/ChatSocketServiceImpl$networkStateListener$1", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$networkStateListener$1;", "socket", "Lio/getstream/chat/android/client/socket/Socket;", "<set-?>", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "state", "getState$stream_chat_android_client_release$annotations", "()V", "getState$stream_chat_android_client_release", "()Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "setState", "(Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;)V", "state$delegate", "Lkotlin/properties/ReadWriteProperty;", "addListener", "", "listener", "anonymousConnect", "endpoint", "", "apiKey", "callListeners", "call", "Lkotlin/Function1;", "connect", "disconnect", "onChatNetworkError", "error", "Lio/getstream/chat/android/client/errors/ChatNetworkError;", "onConnectionResolved", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "onSocketError", "Lio/getstream/chat/android/client/errors/ChatError;", "reconnect", "releaseSocket", "removeListener", "sendEvent", "sendEvent$stream_chat_android_client_release", "setupSocket", "userConnect", "user", "Lio/getstream/chat/android/client/models/User;", "Companion", "ConnectionConf", "State", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl */
/* compiled from: ChatSocketServiceImpl.kt */
public final class ChatSocketServiceImpl implements ChatSocketService {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ChatSocketServiceImpl.class, "state", "getState$stream_chat_android_client_release()Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public ConnectionConf connectionConf;
    private final Handler eventUiHandler;
    /* access modifiers changed from: private */
    public final HealthMonitor healthMonitor;
    private final List<SocketListener> listeners;
    /* access modifiers changed from: private */
    public final TaggedLogger logger;
    /* access modifiers changed from: private */
    public final ChatSocketServiceImpl$networkStateListener$1 networkStateListener;
    /* access modifiers changed from: private */
    public final NetworkStateProvider networkStateProvider;
    private Socket socket;
    private final SocketFactory socketFactory;
    private final ReadWriteProperty state$delegate;
    private final TokenManager tokenManager;

    public static /* synthetic */ void getState$stream_chat_android_client_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final void setState(State state) {
        this.state$delegate.setValue(this, $$delegatedProperties[0], state);
    }

    public final State getState$stream_chat_android_client_release() {
        return (State) this.state$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private ChatSocketServiceImpl(TokenManager tokenManager2, SocketFactory socketFactory2, NetworkStateProvider networkStateProvider2) {
        this.tokenManager = tokenManager2;
        this.socketFactory = socketFactory2;
        this.networkStateProvider = networkStateProvider2;
        this.logger = ChatLogger.Companion.get("SocketService");
        this.connectionConf = ConnectionConf.None.INSTANCE;
        this.listeners = new ArrayList();
        this.eventUiHandler = new Handler(Looper.getMainLooper());
        this.healthMonitor = new HealthMonitor(new ChatSocketServiceImpl$healthMonitor$1(this));
        this.networkStateListener = new ChatSocketServiceImpl$networkStateListener$1(this);
        Delegates delegates = Delegates.INSTANCE;
        State.Disconnected disconnected = State.Disconnected.INSTANCE;
        Objects.requireNonNull(disconnected, "null cannot be cast to non-null type io.getstream.chat.android.client.socket.ChatSocketServiceImpl.State");
        State state = disconnected;
        this.state$delegate = new ChatSocketServiceImpl$$special$$inlined$observable$1(state, state, this);
    }

    public /* synthetic */ ChatSocketServiceImpl(TokenManager tokenManager2, SocketFactory socketFactory2, NetworkStateProvider networkStateProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(tokenManager2, socketFactory2, networkStateProvider2);
    }

    public void onSocketError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        if (!Intrinsics.areEqual((Object) getState$stream_chat_android_client_release(), (Object) State.DisconnectedPermanently.INSTANCE)) {
            this.logger.logE(chatError);
            callListeners(new ChatSocketServiceImpl$onSocketError$1(chatError));
            if (!(chatError instanceof ChatNetworkError)) {
                chatError = null;
            }
            ChatNetworkError chatNetworkError = (ChatNetworkError) chatError;
            if (chatNetworkError != null) {
                onChatNetworkError(chatNetworkError);
            }
        }
    }

    private final void onChatNetworkError(ChatNetworkError chatNetworkError) {
        int streamCode = chatNetworkError.getStreamCode();
        if (streamCode != ChatErrorCode.PARSER_ERROR.getCode() && streamCode != ChatErrorCode.CANT_PARSE_CONNECTION_EVENT.getCode() && streamCode != ChatErrorCode.CANT_PARSE_EVENT.getCode() && streamCode != ChatErrorCode.UNABLE_TO_PARSE_SOCKET_EVENT.getCode() && streamCode != ChatErrorCode.NO_ERROR_BODY.getCode()) {
            if (streamCode == ChatErrorCode.TOKEN_EXPIRED.getCode()) {
                this.tokenManager.expireToken();
                this.tokenManager.loadSync();
                setState(State.Disconnected.INSTANCE);
            } else if (streamCode == ChatErrorCode.UNDEFINED_TOKEN.getCode() || streamCode == ChatErrorCode.INVALID_TOKEN.getCode() || streamCode == ChatErrorCode.API_KEY_NOT_FOUND.getCode()) {
                setState(State.DisconnectedPermanently.INSTANCE);
            } else if (streamCode == ChatErrorCode.NETWORK_FAILED.getCode() || streamCode == ChatErrorCode.SOCKET_CLOSED.getCode() || streamCode == ChatErrorCode.SOCKET_FAILURE.getCode()) {
                setState(State.Disconnected.INSTANCE);
            } else {
                setState(State.Disconnected.INSTANCE);
            }
        }
    }

    public void removeListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.listeners) {
            this.listeners.remove(socketListener);
        }
    }

    public void addListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.listeners) {
            this.listeners.add(socketListener);
        }
    }

    public void anonymousConnect(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "apiKey");
        connect(new ConnectionConf.AnonymousConnectionConf(str, str2));
    }

    public void userConnect(String str, String str2, User user) {
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "apiKey");
        Intrinsics.checkNotNullParameter(user, "user");
        connect(new ConnectionConf.UserConnectionConf(str, str2, user));
    }

    private final void connect(ConnectionConf connectionConf2) {
        this.logger.logI("connect");
        this.connectionConf = connectionConf2;
        if (this.networkStateProvider.isConnected()) {
            setState(State.Disconnected.INSTANCE);
            setupSocket(connectionConf2);
        } else {
            setState(State.NetworkDisconnected.INSTANCE);
        }
        this.networkStateProvider.subscribe(this.networkStateListener);
    }

    public void disconnect() {
        setState(State.DisconnectedPermanently.INSTANCE);
    }

    public void onConnectionResolved(ConnectedEvent connectedEvent) {
        Intrinsics.checkNotNullParameter(connectedEvent, "event");
        setState(new State.Connected(connectedEvent));
    }

    public void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        this.healthMonitor.ack();
        callListeners(new ChatSocketServiceImpl$onEvent$1(chatEvent));
    }

    public final void sendEvent$stream_chat_android_client_release(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.send(chatEvent);
        }
    }

    /* access modifiers changed from: private */
    public final void reconnect(ConnectionConf connectionConf2) {
        releaseSocket();
        setupSocket(connectionConf2);
    }

    private final void setupSocket(ConnectionConf connectionConf2) {
        this.logger.logI("setupSocket");
        if (connectionConf2 instanceof ConnectionConf.None) {
            setState(State.DisconnectedPermanently.INSTANCE);
            Unit unit = Unit.INSTANCE;
        } else if (connectionConf2 instanceof ConnectionConf.AnonymousConnectionConf) {
            setState(State.Connecting.INSTANCE);
            ConnectionConf.AnonymousConnectionConf anonymousConnectionConf = (ConnectionConf.AnonymousConnectionConf) connectionConf2;
            this.socket = this.socketFactory.createAnonymousSocket(anonymousConnectionConf.getEndpoint(), anonymousConnectionConf.getApiKey());
            Unit unit2 = Unit.INSTANCE;
        } else if (connectionConf2 instanceof ConnectionConf.UserConnectionConf) {
            setState(State.Connecting.INSTANCE);
            ConnectionConf.UserConnectionConf userConnectionConf = (ConnectionConf.UserConnectionConf) connectionConf2;
            this.socket = this.socketFactory.createNormalSocket(userConnectionConf.getEndpoint(), userConnectionConf.getApiKey(), userConnectionConf.getUser());
            Unit unit3 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void releaseSocket() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.close(1000, "Connection close by client");
        }
        this.socket = null;
    }

    /* access modifiers changed from: private */
    public final void callListeners(Function1<? super SocketListener, Unit> function1) {
        synchronized (this.listeners) {
            for (SocketListener chatSocketServiceImpl$callListeners$$inlined$synchronized$lambda$1 : this.listeners) {
                this.eventUiHandler.post(new C4956x71d68104(chatSocketServiceImpl$callListeners$$inlined$synchronized$lambda$1, this, function1));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf;", "", "()V", "AnonymousConnectionConf", "None", "UserConnectionConf", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$None;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$AnonymousConnectionConf;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$UserConnectionConf;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$ConnectionConf */
    /* compiled from: ChatSocketServiceImpl.kt */
    public static abstract class ConnectionConf {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$None;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$ConnectionConf$None */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class None extends ConnectionConf {
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ConnectionConf() {
        }

        public /* synthetic */ ConnectionConf(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$AnonymousConnectionConf;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf;", "endpoint", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getEndpoint", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$ConnectionConf$AnonymousConnectionConf */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class AnonymousConnectionConf extends ConnectionConf {
            private final String apiKey;
            private final String endpoint;

            public static /* synthetic */ AnonymousConnectionConf copy$default(AnonymousConnectionConf anonymousConnectionConf, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = anonymousConnectionConf.endpoint;
                }
                if ((i & 2) != 0) {
                    str2 = anonymousConnectionConf.apiKey;
                }
                return anonymousConnectionConf.copy(str, str2);
            }

            public final String component1() {
                return this.endpoint;
            }

            public final String component2() {
                return this.apiKey;
            }

            public final AnonymousConnectionConf copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "endpoint");
                Intrinsics.checkNotNullParameter(str2, "apiKey");
                return new AnonymousConnectionConf(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnonymousConnectionConf)) {
                    return false;
                }
                AnonymousConnectionConf anonymousConnectionConf = (AnonymousConnectionConf) obj;
                return Intrinsics.areEqual((Object) this.endpoint, (Object) anonymousConnectionConf.endpoint) && Intrinsics.areEqual((Object) this.apiKey, (Object) anonymousConnectionConf.apiKey);
            }

            public int hashCode() {
                String str = this.endpoint;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.apiKey;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "AnonymousConnectionConf(endpoint=" + this.endpoint + ", apiKey=" + this.apiKey + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AnonymousConnectionConf(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpoint");
                Intrinsics.checkNotNullParameter(str2, "apiKey");
                this.endpoint = str;
                this.apiKey = str2;
            }

            public final String getApiKey() {
                return this.apiKey;
            }

            public final String getEndpoint() {
                return this.endpoint;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf$UserConnectionConf;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$ConnectionConf;", "endpoint", "", "apiKey", "user", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/models/User;)V", "getApiKey", "()Ljava/lang/String;", "getEndpoint", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$ConnectionConf$UserConnectionConf */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class UserConnectionConf extends ConnectionConf {
            private final String apiKey;
            private final String endpoint;
            private final User user;

            public static /* synthetic */ UserConnectionConf copy$default(UserConnectionConf userConnectionConf, String str, String str2, User user2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userConnectionConf.endpoint;
                }
                if ((i & 2) != 0) {
                    str2 = userConnectionConf.apiKey;
                }
                if ((i & 4) != 0) {
                    user2 = userConnectionConf.user;
                }
                return userConnectionConf.copy(str, str2, user2);
            }

            public final String component1() {
                return this.endpoint;
            }

            public final String component2() {
                return this.apiKey;
            }

            public final User component3() {
                return this.user;
            }

            public final UserConnectionConf copy(String str, String str2, User user2) {
                Intrinsics.checkNotNullParameter(str, "endpoint");
                Intrinsics.checkNotNullParameter(str2, "apiKey");
                Intrinsics.checkNotNullParameter(user2, "user");
                return new UserConnectionConf(str, str2, user2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserConnectionConf)) {
                    return false;
                }
                UserConnectionConf userConnectionConf = (UserConnectionConf) obj;
                return Intrinsics.areEqual((Object) this.endpoint, (Object) userConnectionConf.endpoint) && Intrinsics.areEqual((Object) this.apiKey, (Object) userConnectionConf.apiKey) && Intrinsics.areEqual((Object) this.user, (Object) userConnectionConf.user);
            }

            public int hashCode() {
                String str = this.endpoint;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.apiKey;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i = user2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "UserConnectionConf(endpoint=" + this.endpoint + ", apiKey=" + this.apiKey + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserConnectionConf(String str, String str2, User user2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpoint");
                Intrinsics.checkNotNullParameter(str2, "apiKey");
                Intrinsics.checkNotNullParameter(user2, "user");
                this.endpoint = str;
                this.apiKey = str2;
                this.user = user2;
            }

            public final String getApiKey() {
                return this.apiKey;
            }

            public final String getEndpoint() {
                return this.endpoint;
            }

            public final User getUser() {
                return this.user;
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "", "()V", "Connected", "Connecting", "Disconnected", "DisconnectedPermanently", "NetworkDisconnected", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Connecting;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Connected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$NetworkDisconnected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Disconnected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$DisconnectedPermanently;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State */
    /* compiled from: ChatSocketServiceImpl.kt */
    public static abstract class State {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Connecting;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State$Connecting */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class Connecting extends State {
            public static final Connecting INSTANCE = new Connecting();

            private Connecting() {
                super((DefaultConstructorMarker) null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Connected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "(Lio/getstream/chat/android/client/events/ConnectedEvent;)V", "getEvent", "()Lio/getstream/chat/android/client/events/ConnectedEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State$Connected */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class Connected extends State {
            private final ConnectedEvent event;

            public static /* synthetic */ Connected copy$default(Connected connected, ConnectedEvent connectedEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    connectedEvent = connected.event;
                }
                return connected.copy(connectedEvent);
            }

            public final ConnectedEvent component1() {
                return this.event;
            }

            public final Connected copy(ConnectedEvent connectedEvent) {
                Intrinsics.checkNotNullParameter(connectedEvent, "event");
                return new Connected(connectedEvent);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Connected) && Intrinsics.areEqual((Object) this.event, (Object) ((Connected) obj).event);
                }
                return true;
            }

            public int hashCode() {
                ConnectedEvent connectedEvent = this.event;
                if (connectedEvent != null) {
                    return connectedEvent.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Connected(event=" + this.event + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Connected(ConnectedEvent connectedEvent) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(connectedEvent, "event");
                this.event = connectedEvent;
            }

            public final ConnectedEvent getEvent() {
                return this.event;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$NetworkDisconnected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State$NetworkDisconnected */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class NetworkDisconnected extends State {
            public static final NetworkDisconnected INSTANCE = new NetworkDisconnected();

            private NetworkDisconnected() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$Disconnected;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State$Disconnected */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class Disconnected extends State {
            public static final Disconnected INSTANCE = new Disconnected();

            private Disconnected() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State$DisconnectedPermanently;", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$State;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$State$DisconnectedPermanently */
        /* compiled from: ChatSocketServiceImpl.kt */
        public static final class DisconnectedPermanently extends State {
            public static final DisconnectedPermanently INSTANCE = new DisconnectedPermanently();

            private DisconnectedPermanently() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl$Companion;", "", "()V", "create", "Lio/getstream/chat/android/client/socket/ChatSocketServiceImpl;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "socketFactory", "Lio/getstream/chat/android/client/socket/SocketFactory;", "eventsParser", "Lio/getstream/chat/android/client/socket/EventsParser;", "networkStateProvider", "Lio/getstream/chat/android/client/network/NetworkStateProvider;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$Companion */
    /* compiled from: ChatSocketServiceImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatSocketServiceImpl create(TokenManager tokenManager, SocketFactory socketFactory, EventsParser eventsParser, NetworkStateProvider networkStateProvider) {
            Intrinsics.checkNotNullParameter(tokenManager, "tokenManager");
            Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
            Intrinsics.checkNotNullParameter(eventsParser, "eventsParser");
            Intrinsics.checkNotNullParameter(networkStateProvider, "networkStateProvider");
            ChatSocketServiceImpl chatSocketServiceImpl = new ChatSocketServiceImpl(tokenManager, socketFactory, networkStateProvider, (DefaultConstructorMarker) null);
            eventsParser.setSocketService(chatSocketServiceImpl);
            return chatSocketServiceImpl;
        }
    }
}
