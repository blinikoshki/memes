package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import p015io.getstream.chat.android.client.errors.ChatErrorCode;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.errors.ChatRequestError;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.token.TokenManager;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/TokenAuthInterceptor;", "Lokhttp3/Interceptor;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "isAnonymous", "Lkotlin/Function0;", "", "(Lio/getstream/chat/android/client/token/TokenManager;Lio/getstream/chat/android/client/parser/ChatParser;Lkotlin/jvm/functions/Function0;)V", "addTokenHeader", "Lokhttp3/Request;", "request", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.TokenAuthInterceptor */
/* compiled from: TokenAuthInterceptor.kt */
public final class TokenAuthInterceptor implements Interceptor {
    public static final String AUTH_HEADER = "Authorization";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Boolean> isAnonymous;
    private final ChatParser parser;
    private final TokenManager tokenManager;

    public TokenAuthInterceptor(TokenManager tokenManager2, ChatParser chatParser, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(tokenManager2, "tokenManager");
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        Intrinsics.checkNotNullParameter(function0, "isAnonymous");
        this.tokenManager = tokenManager2;
        this.parser = chatParser;
        this.isAnonymous = function0;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (this.isAnonymous.invoke().booleanValue()) {
            return chain.proceed(chain.request());
        }
        boolean hasTokenProvider = this.tokenManager.hasTokenProvider();
        boolean hasToken = this.tokenManager.hasToken();
        if (hasTokenProvider) {
            if (!hasToken) {
                this.tokenManager.loadSync();
            }
            Request addTokenHeader = addTokenHeader(chain.request());
            Response proceed = chain.proceed(addTokenHeader);
            if (proceed.isSuccessful()) {
                return proceed;
            }
            ChatNetworkError error = this.parser.toError(proceed);
            if (error.getStreamCode() == ChatErrorCode.TOKEN_EXPIRED.getCode()) {
                this.tokenManager.expireToken();
                this.tokenManager.loadSync();
                proceed.close();
                return chain.proceed(addTokenHeader);
            }
            throw new ChatRequestError(error.getDescription(), error.getStreamCode(), error.getStatusCode(), error.getCause());
        }
        throw new ChatRequestError(ChatErrorCode.UNDEFINED_TOKEN.getDescription(), ChatErrorCode.UNDEFINED_TOKEN.getCode(), -1, (Throwable) null, 8, (DefaultConstructorMarker) null);
    }

    private final Request addTokenHeader(Request request) {
        String token = this.tokenManager.getToken();
        try {
            return request.newBuilder().header("Authorization", token).build();
        } catch (Throwable th) {
            String description = ChatErrorCode.INVALID_TOKEN.getDescription();
            int code = ChatErrorCode.INVALID_TOKEN.getCode();
            throw new ChatRequestError(description + ": " + token, code, -1, th);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/TokenAuthInterceptor$Companion;", "", "()V", "AUTH_HEADER", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.TokenAuthInterceptor$Companion */
    /* compiled from: TokenAuthInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
