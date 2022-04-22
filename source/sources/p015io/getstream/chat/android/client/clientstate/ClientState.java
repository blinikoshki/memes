package p015io.getstream.chat.android.client.clientstate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0007J\u0011\u0010\b\u001a\u00060\tj\u0002`\nH\u0000¢\u0006\u0002\b\u000b\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState;", "", "()V", "connectionIdOrError", "", "connectionIdOrError$stream_chat_android_client_release", "tokenOrError", "tokenOrError$stream_chat_android_client_release", "userOrError", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "userOrError$stream_chat_android_client_release", "Anonymous", "Idle", "User", "Lio/getstream/chat/android/client/clientstate/ClientState$Idle;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous;", "Lio/getstream/chat/android/client/clientstate/ClientState$User;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.clientstate.ClientState */
/* compiled from: ClientState.kt */
public abstract class ClientState {

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Idle;", "Lio/getstream/chat/android/client/clientstate/ClientState;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Idle */
    /* compiled from: ClientState.kt */
    public static final class Idle extends ClientState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ClientState() {
    }

    public /* synthetic */ ClientState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous;", "Lio/getstream/chat/android/client/clientstate/ClientState;", "()V", "Authorized", "Pending", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous */
    /* compiled from: ClientState.kt */
    public static abstract class Anonymous extends ClientState {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous;", "()V", "WithToken", "WithoutToken", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending$WithoutToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending$WithToken;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Pending */
        /* compiled from: ClientState.kt */
        public static abstract class Pending extends Anonymous {

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending$WithoutToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Pending$WithoutToken */
            /* compiled from: ClientState.kt */
            public static final class WithoutToken extends Pending {
                public static final WithoutToken INSTANCE = new WithoutToken();

                private WithoutToken() {
                    super((DefaultConstructorMarker) null);
                }
            }

            private Pending() {
                super((DefaultConstructorMarker) null);
            }

            public /* synthetic */ Pending(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending$WithToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Pending;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Pending$WithToken */
            /* compiled from: ClientState.kt */
            public static final class WithToken extends Pending {
                private final String token;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WithToken(String str) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "token");
                    this.token = str;
                }

                public final String getToken() {
                    return this.token;
                }
            }
        }

        private Anonymous() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ Anonymous(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB#\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u0001\u0002\u0010\u0011¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous;", "anonymousUser", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "", "connectionId", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;)V", "getAnonymousUser", "()Lio/getstream/chat/android/client/models/User;", "getConnectionId", "()Ljava/lang/String;", "getToken", "Connected", "Disconnected", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized$Connected;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized$Disconnected;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Authorized */
        /* compiled from: ClientState.kt */
        public static abstract class Authorized extends Anonymous {
            private final p015io.getstream.chat.android.client.models.User anonymousUser;
            private final String connectionId;
            private final String token;

            public /* synthetic */ Authorized(p015io.getstream.chat.android.client.models.User user, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(user, str, str2);
            }

            public final p015io.getstream.chat.android.client.models.User getAnonymousUser() {
                return this.anonymousUser;
            }

            public final String getToken() {
                return this.token;
            }

            public final String getConnectionId() {
                return this.connectionId;
            }

            private Authorized(p015io.getstream.chat.android.client.models.User user, String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.anonymousUser = user;
                this.token = str;
                this.connectionId = str2;
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized$Connected;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized;", "connectionId", "", "anonymousUser", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Authorized$Connected */
            /* compiled from: ClientState.kt */
            public static final class Connected extends Authorized {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Connected(String str, p015io.getstream.chat.android.client.models.User user, String str2) {
                    super(user, str2, str, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "connectionId");
                    Intrinsics.checkNotNullParameter(user, "anonymousUser");
                    Intrinsics.checkNotNullParameter(str2, "token");
                }
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized$Disconnected;", "Lio/getstream/chat/android/client/clientstate/ClientState$Anonymous$Authorized;", "connectionId", "", "anonymousUser", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$Anonymous$Authorized$Disconnected */
            /* compiled from: ClientState.kt */
            public static final class Disconnected extends Authorized {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Disconnected(String str, p015io.getstream.chat.android.client.models.User user, String str2) {
                    super(user, str2, str, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "connectionId");
                    Intrinsics.checkNotNullParameter(user, "anonymousUser");
                    Intrinsics.checkNotNullParameter(str2, "token");
                }
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User;", "Lio/getstream/chat/android/client/clientstate/ClientState;", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "(Lio/getstream/chat/android/client/models/User;)V", "getUser", "()Lio/getstream/chat/android/client/models/User;", "Authorized", "Pending", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User */
    /* compiled from: ClientState.kt */
    public static abstract class User extends ClientState {
        private final p015io.getstream.chat.android.client.models.User user;

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005\u0001\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending;", "Lio/getstream/chat/android/client/clientstate/ClientState$User;", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "(Lio/getstream/chat/android/client/models/User;)V", "WithToken", "WithoutToken", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending$WithToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending$WithoutToken;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Pending */
        /* compiled from: ClientState.kt */
        public static abstract class Pending extends User {

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending$WithToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending;", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Pending$WithToken */
            /* compiled from: ClientState.kt */
            public static final class WithToken extends Pending {
                private final String token;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WithToken(p015io.getstream.chat.android.client.models.User user, String str) {
                    super(user, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(str, "token");
                    this.token = str;
                }

                public final String getToken() {
                    return this.token;
                }
            }

            private Pending(p015io.getstream.chat.android.client.models.User user) {
                super(user, (DefaultConstructorMarker) null);
            }

            public /* synthetic */ Pending(p015io.getstream.chat.android.client.models.User user, DefaultConstructorMarker defaultConstructorMarker) {
                this(user);
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending$WithoutToken;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Pending;", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "(Lio/getstream/chat/android/client/models/User;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Pending$WithoutToken */
            /* compiled from: ClientState.kt */
            public static final class WithoutToken extends Pending {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WithoutToken(p015io.getstream.chat.android.client.models.User user) {
                    super(user, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(user, "user");
                }
            }
        }

        private User(p015io.getstream.chat.android.client.models.User user2) {
            super((DefaultConstructorMarker) null);
            this.user = user2;
        }

        public /* synthetic */ User(p015io.getstream.chat.android.client.models.User user2, DefaultConstructorMarker defaultConstructorMarker) {
            this(user2);
        }

        public final p015io.getstream.chat.android.client.models.User getUser() {
            return this.user;
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB#\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u0001\u0002\u000e\u000f¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized;", "Lio/getstream/chat/android/client/clientstate/ClientState$User;", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "", "connectionId", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/lang/String;)V", "getConnectionId", "()Ljava/lang/String;", "getToken", "Connected", "Disconnected", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized$Connected;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized$Disconnected;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Authorized */
        /* compiled from: ClientState.kt */
        public static abstract class Authorized extends User {
            private final String connectionId;
            private final String token;

            private Authorized(p015io.getstream.chat.android.client.models.User user, String str, String str2) {
                super(user, (DefaultConstructorMarker) null);
                this.token = str;
                this.connectionId = str2;
            }

            public /* synthetic */ Authorized(p015io.getstream.chat.android.client.models.User user, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
                this(user, str, str2);
            }

            public final String getConnectionId() {
                return this.connectionId;
            }

            public final String getToken() {
                return this.token;
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized$Connected;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized;", "connectionId", "", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Authorized$Connected */
            /* compiled from: ClientState.kt */
            public static final class Connected extends Authorized {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Connected(String str, p015io.getstream.chat.android.client.models.User user, String str2) {
                    super(user, str2, str, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "connectionId");
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(str2, "token");
                }
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized$Disconnected;", "Lio/getstream/chat/android/client/clientstate/ClientState$User$Authorized;", "connectionId", "", "user", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/clientstate/UserModel;", "token", "(Ljava/lang/String;Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* renamed from: io.getstream.chat.android.client.clientstate.ClientState$User$Authorized$Disconnected */
            /* compiled from: ClientState.kt */
            public static final class Disconnected extends Authorized {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Disconnected(String str, p015io.getstream.chat.android.client.models.User user, String str2) {
                    super(user, str2, str, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "connectionId");
                    Intrinsics.checkNotNullParameter(user, "user");
                    Intrinsics.checkNotNullParameter(str2, "token");
                }
            }
        }
    }

    public final String tokenOrError$stream_chat_android_client_release() {
        if (this instanceof User.Pending.WithToken) {
            return ((User.Pending.WithToken) this).getToken();
        }
        if (this instanceof User.Authorized) {
            return ((User.Authorized) this).getToken();
        }
        if (this instanceof Anonymous.Pending.WithToken) {
            return ((Anonymous.Pending.WithToken) this).getToken();
        }
        if (this instanceof Anonymous.Authorized) {
            return ((Anonymous.Authorized) this).getToken();
        }
        throw new IllegalStateException("This state doesn't contain token!".toString());
    }

    public final p015io.getstream.chat.android.client.models.User userOrError$stream_chat_android_client_release() {
        if (this instanceof User) {
            return ((User) this).getUser();
        }
        if (this instanceof Anonymous.Authorized) {
            return ((Anonymous.Authorized) this).getAnonymousUser();
        }
        throw new IllegalStateException("This state doesn't contain user!".toString());
    }

    public final String connectionIdOrError$stream_chat_android_client_release() {
        if (this instanceof User.Authorized) {
            return ((User.Authorized) this).getConnectionId();
        }
        if (this instanceof Anonymous.Authorized) {
            return ((Anonymous.Authorized) this).getConnectionId();
        }
        throw new IllegalStateException("This state doesn't contain connectionId".toString());
    }
}
