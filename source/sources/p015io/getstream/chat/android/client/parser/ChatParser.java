package p015io.getstream.chat.android.client.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatErrorCode;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.socket.ErrorResponse;
import p015io.getstream.chat.android.client.utils.Result;
import retrofit2.Retrofit;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J-\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH&¢\u0006\u0002\u0010\fJ.\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000e\"\b\b\u0000\u0010\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0001H&R\u000b\u0010\u0002\u001a\u00020\u00038BX\u0004¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/ChatParser;", "", "TAG", "", "configRetrofit", "Lretrofit2/Retrofit$Builder;", "builder", "fromJson", "T", "raw", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "fromJsonOrError", "Lio/getstream/chat/android/client/utils/Result;", "toError", "Lio/getstream/chat/android/client/socket/ErrorResponse;", "body", "Lio/getstream/chat/android/client/errors/ChatNetworkError;", "okHttpResponse", "Lokhttp3/Response;", "toJson", "any", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.ChatParser */
/* compiled from: ChatParser.kt */
public interface ChatParser {
    Retrofit.Builder configRetrofit(Retrofit.Builder builder);

    <T> T fromJson(String str, Class<T> cls);

    <T> Result<T> fromJsonOrError(String str, Class<T> cls);

    ChatNetworkError toError(Response response);

    String toJson(Object obj);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.parser.ChatParser$DefaultImpls */
    /* compiled from: ChatParser.kt */
    public static final class DefaultImpls {
        private static String getTAG(ChatParser chatParser) {
            String simpleName = ChatParser.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "ChatParser::class.java.simpleName");
            return simpleName;
        }

        public static <T> Result<T> fromJsonOrError(ChatParser chatParser, String str, Class<T> cls) {
            Intrinsics.checkNotNullParameter(str, "raw");
            Intrinsics.checkNotNullParameter(cls, "clazz");
            try {
                return new Result<>(chatParser.fromJson(str, cls));
            } catch (Throwable th) {
                return new Result<>(new ChatError("fromJsonOrError error parsing of " + cls + " into " + str, th));
            }
        }

        public static ChatNetworkError toError(ChatParser chatParser, Response response) {
            Intrinsics.checkNotNullParameter(response, "okHttpResponse");
            int code = response.code();
            try {
                ErrorResponse error = toError(chatParser, response.peekBody(Long.MAX_VALUE).string());
                if (error == null) {
                    return ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.NO_ERROR_BODY, (Throwable) null, code, 2, (Object) null);
                }
                return ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, error.getCode(), error.getMessage(), code, (Throwable) null, 8, (Object) null);
            } catch (Throwable th) {
                ChatLogger.Companion.getInstance().logE((Object) getTAG(chatParser), th);
                return ChatNetworkError.Companion.create(ChatErrorCode.NETWORK_FAILED, th, code);
            }
        }

        private static ErrorResponse toError(ChatParser chatParser, String str) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return new ErrorResponse(0, "Body is null or empty", 0, 5, (DefaultConstructorMarker) null);
            }
            try {
                return (ErrorResponse) chatParser.fromJson(str, ErrorResponse.class);
            } catch (Throwable unused) {
                ErrorResponse errorResponse = new ErrorResponse(0, (String) null, 0, 7, (DefaultConstructorMarker) null);
                errorResponse.setMessage(str);
                return errorResponse;
            }
        }
    }
}
