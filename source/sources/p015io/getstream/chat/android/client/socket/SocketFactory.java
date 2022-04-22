package p015io.getstream.chat.android.client.socket;

import com.facebook.AccessToken;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.token.TokenManager;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u001e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u001a\u001a\u00020\u0012*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/SocketFactory;", "", "eventsParser", "Lio/getstream/chat/android/client/socket/EventsParser;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "(Lio/getstream/chat/android/client/socket/EventsParser;Lio/getstream/chat/android/client/parser/ChatParser;Lio/getstream/chat/android/client/token/TokenManager;)V", "httpClient", "Lokhttp3/OkHttpClient;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "buildUrl", "", "endpoint", "apiKey", "user", "Lio/getstream/chat/android/client/models/User;", "isAnonymous", "", "buildUserDetailJson", "create", "Lio/getstream/chat/android/client/socket/Socket;", "createAnonymousSocket", "createNormalSocket", "reduceUserDetails", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.SocketFactory */
/* compiled from: SocketFactory.kt */
public final class SocketFactory {
    private static final String ANONYMOUS_USER_ID = "anon";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final EventsParser eventsParser;
    private final OkHttpClient httpClient = new OkHttpClient();
    private final TaggedLogger logger;
    private final ChatParser parser;
    private final TokenManager tokenManager;

    public SocketFactory(EventsParser eventsParser2, ChatParser chatParser, TokenManager tokenManager2) {
        Intrinsics.checkNotNullParameter(eventsParser2, "eventsParser");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        Intrinsics.checkNotNullParameter(tokenManager2, "tokenManager");
        this.eventsParser = eventsParser2;
        this.parser = chatParser;
        this.tokenManager = tokenManager2;
        ChatLogger.Companion companion = ChatLogger.Companion;
        String simpleName = SocketFactory.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SocketFactory::class.java.simpleName");
        this.logger = companion.get(simpleName);
    }

    public final Socket createAnonymousSocket(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "endpoint");
        Intrinsics.checkNotNullParameter(str4, "apiKey");
        return create(str3, str4, new User(ANONYMOUS_USER_ID, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null), true);
    }

    public final Socket createNormalSocket(String str, String str2, User user) {
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "apiKey");
        Intrinsics.checkNotNullParameter(user, "user");
        return create(str, str2, user, false);
    }

    private final Socket create(String str, String str2, User user, boolean z) {
        String buildUrl = buildUrl(str, str2, user, z);
        WebSocket newWebSocket = this.httpClient.newWebSocket(new Request.Builder().url(buildUrl).build(), this.eventsParser);
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI("new web socket: " + buildUrl);
        return new Socket(newWebSocket, this.parser);
    }

    private final String buildUrl(String str, String str2, User user, boolean z) {
        String buildUserDetailJson = buildUserDetailJson(user);
        try {
            String encode = URLEncoder.encode(buildUserDetailJson, StandardCharsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(json, …ardCharsets.UTF_8.name())");
            try {
                String str3 = str + "connect?json=" + encode + "&api_key=" + str2;
                if (z) {
                    return str3 + "&stream-auth-type=anonymous";
                }
                return str3 + "&authorization=" + this.tokenManager.getToken() + "&stream-auth-type=jwt";
            } catch (Throwable unused) {
                buildUserDetailJson = encode;
                throw new UnsupportedEncodingException("Unable to encode user details json: " + buildUserDetailJson);
            }
        } catch (Throwable unused2) {
            throw new UnsupportedEncodingException("Unable to encode user details json: " + buildUserDetailJson);
        }
    }

    private final String buildUserDetailJson(User user) {
        return this.parser.toJson(MapsKt.mapOf(TuplesKt.m181to("user_details", reduceUserDetails(user)), TuplesKt.m181to(AccessToken.USER_ID_KEY, user.getId()), TuplesKt.m181to("server_determines_connection_id", true), TuplesKt.m181to("X-STREAM-CLIENT", ChatClient.Companion.instance().getVersion())));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/SocketFactory$Companion;", "", "()V", "ANONYMOUS_USER_ID", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.socket.SocketFactory$Companion */
    /* compiled from: SocketFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final User reduceUserDetails(User user) {
        return User.copy$default(user, (String) null, (String) null, false, false, CollectionsKt.emptyList(), false, (Date) null, (Date) null, (Date) null, 0, 0, 0, CollectionsKt.emptyList(), (List) null, CollectionsKt.emptyList(), (Map) null, 45039, (Object) null);
    }
}
