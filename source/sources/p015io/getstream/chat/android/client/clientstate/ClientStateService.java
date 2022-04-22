package p015io.getstream.chat.android.client.clientstate;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.core.internal.fsm.FiniteStateMachine;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0013J\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService;", "", "()V", "state", "Lio/getstream/chat/android/client/clientstate/ClientState;", "getState$stream_chat_android_client_release", "()Lio/getstream/chat/android/client/clientstate/ClientState;", "stateMachine", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "getStateMachine", "()Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "stateMachine$delegate", "Lkotlin/Lazy;", "onConnected", "", "user", "Lio/getstream/chat/android/client/models/User;", "connectionId", "", "onDisconnectRequested", "onDisconnected", "onSetAnonymousUser", "onSetUser", "onTokenReceived", "token", "failedToHandleEvent", "", "event", "ClientStateEvent", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService */
/* compiled from: ClientStateService.kt */
public final class ClientStateService {
    private final Lazy stateMachine$delegate = LazyKt.lazy(new ClientStateService$stateMachine$2(this));

    private final FiniteStateMachine<ClientState, ClientStateEvent> getStateMachine() {
        return (FiniteStateMachine) this.stateMachine$delegate.getValue();
    }

    public final void onConnected(User user, String str) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "connectionId");
        getStateMachine().sendEvent(new ClientStateEvent.ConnectedEvent(user, str));
    }

    public final void onDisconnected() {
        getStateMachine().sendEvent(ClientStateEvent.DisconnectedEvent.INSTANCE);
    }

    public final void onSetUser(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        getStateMachine().sendEvent(new ClientStateEvent.SetUserEvent(user));
    }

    public final void onSetAnonymousUser() {
        getStateMachine().sendEvent(ClientStateEvent.SetAnonymousUserEvent.INSTANCE);
    }

    public final void onTokenReceived(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        getStateMachine().sendEvent(new ClientStateEvent.TokenReceivedEvent(str));
    }

    public final void onDisconnectRequested() {
        getStateMachine().sendEvent(ClientStateEvent.DisconnectRequestedEvent.INSTANCE);
    }

    public final ClientState getState$stream_chat_android_client_release() {
        return getStateMachine().getState();
    }

    /* access modifiers changed from: private */
    public final Void failedToHandleEvent(ClientState clientState, ClientStateEvent clientStateEvent) {
        throw new IllegalStateException(("Cannot handle event " + clientStateEvent + " while being in inappropriate state " + clientState).toString());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "", "()V", "ConnectedEvent", "DisconnectRequestedEvent", "DisconnectedEvent", "SetAnonymousUserEvent", "SetUserEvent", "TokenReceivedEvent", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$SetUserEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$SetAnonymousUserEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$TokenReceivedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$ConnectedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$DisconnectRequestedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$DisconnectedEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent */
    /* compiled from: ClientStateService.kt */
    private static abstract class ClientStateEvent {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$SetUserEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;)V", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$SetUserEvent */
        /* compiled from: ClientStateService.kt */
        public static final class SetUserEvent extends ClientStateEvent {
            private final User user;

            public static /* synthetic */ SetUserEvent copy$default(SetUserEvent setUserEvent, User user2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user2 = setUserEvent.user;
                }
                return setUserEvent.copy(user2);
            }

            public final User component1() {
                return this.user;
            }

            public final SetUserEvent copy(User user2) {
                Intrinsics.checkNotNullParameter(user2, "user");
                return new SetUserEvent(user2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof SetUserEvent) && Intrinsics.areEqual((Object) this.user, (Object) ((SetUserEvent) obj).user);
                }
                return true;
            }

            public int hashCode() {
                User user2 = this.user;
                if (user2 != null) {
                    return user2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "SetUserEvent(user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SetUserEvent(User user2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user2, "user");
                this.user = user2;
            }

            public final User getUser() {
                return this.user;
            }
        }

        private ClientStateEvent() {
        }

        public /* synthetic */ ClientStateEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$SetAnonymousUserEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$SetAnonymousUserEvent */
        /* compiled from: ClientStateService.kt */
        public static final class SetAnonymousUserEvent extends ClientStateEvent {
            public static final SetAnonymousUserEvent INSTANCE = new SetAnonymousUserEvent();

            private SetAnonymousUserEvent() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$TokenReceivedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$TokenReceivedEvent */
        /* compiled from: ClientStateService.kt */
        public static final class TokenReceivedEvent extends ClientStateEvent {
            private final String token;

            public static /* synthetic */ TokenReceivedEvent copy$default(TokenReceivedEvent tokenReceivedEvent, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = tokenReceivedEvent.token;
                }
                return tokenReceivedEvent.copy(str);
            }

            public final String component1() {
                return this.token;
            }

            public final TokenReceivedEvent copy(String str) {
                Intrinsics.checkNotNullParameter(str, "token");
                return new TokenReceivedEvent(str);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof TokenReceivedEvent) && Intrinsics.areEqual((Object) this.token, (Object) ((TokenReceivedEvent) obj).token);
                }
                return true;
            }

            public int hashCode() {
                String str = this.token;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "TokenReceivedEvent(token=" + this.token + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TokenReceivedEvent(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "token");
                this.token = str;
            }

            public final String getToken() {
                return this.token;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$ConnectedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "user", "Lio/getstream/chat/android/client/models/User;", "connectionId", "", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getConnectionId", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$ConnectedEvent */
        /* compiled from: ClientStateService.kt */
        public static final class ConnectedEvent extends ClientStateEvent {
            private final String connectionId;
            private final User user;

            public static /* synthetic */ ConnectedEvent copy$default(ConnectedEvent connectedEvent, User user2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    user2 = connectedEvent.user;
                }
                if ((i & 2) != 0) {
                    str = connectedEvent.connectionId;
                }
                return connectedEvent.copy(user2, str);
            }

            public final User component1() {
                return this.user;
            }

            public final String component2() {
                return this.connectionId;
            }

            public final ConnectedEvent copy(User user2, String str) {
                Intrinsics.checkNotNullParameter(user2, "user");
                Intrinsics.checkNotNullParameter(str, "connectionId");
                return new ConnectedEvent(user2, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConnectedEvent)) {
                    return false;
                }
                ConnectedEvent connectedEvent = (ConnectedEvent) obj;
                return Intrinsics.areEqual((Object) this.user, (Object) connectedEvent.user) && Intrinsics.areEqual((Object) this.connectionId, (Object) connectedEvent.connectionId);
            }

            public int hashCode() {
                User user2 = this.user;
                int i = 0;
                int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
                String str = this.connectionId;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "ConnectedEvent(user=" + this.user + ", connectionId=" + this.connectionId + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ConnectedEvent(User user2, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user2, "user");
                Intrinsics.checkNotNullParameter(str, "connectionId");
                this.user = user2;
                this.connectionId = str;
            }

            public final String getConnectionId() {
                return this.connectionId;
            }

            public final User getUser() {
                return this.user;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$DisconnectRequestedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$DisconnectRequestedEvent */
        /* compiled from: ClientStateService.kt */
        public static final class DisconnectRequestedEvent extends ClientStateEvent {
            public static final DisconnectRequestedEvent INSTANCE = new DisconnectRequestedEvent();

            private DisconnectRequestedEvent() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$DisconnectedEvent;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$ClientStateEvent$DisconnectedEvent */
        /* compiled from: ClientStateService.kt */
        public static final class DisconnectedEvent extends ClientStateEvent {
            public static final DisconnectedEvent INSTANCE = new DisconnectedEvent();

            private DisconnectedEvent() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
