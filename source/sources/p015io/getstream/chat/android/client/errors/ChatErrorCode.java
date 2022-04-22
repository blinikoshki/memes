package p015io.getstream.chat.android.client.errors;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import okhttp3.internal.p021ws.WebSocketProtocol;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/client/errors/ChatErrorCode;", "", "code", "", "description", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "NETWORK_FAILED", "PARSER_ERROR", "SOCKET_CLOSED", "SOCKET_FAILURE", "CANT_PARSE_CONNECTION_EVENT", "CANT_PARSE_EVENT", "INVALID_TOKEN", "UNDEFINED_TOKEN", "UNABLE_TO_PARSE_SOCKET_EVENT", "NO_ERROR_BODY", "TOKEN_EXPIRED", "API_KEY_NOT_FOUND", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.errors.ChatErrorCode */
/* compiled from: ChatErrorCode.kt */
public enum ChatErrorCode {
    NETWORK_FAILED(1000, "Response is failed. See cause"),
    PARSER_ERROR(1001, "Unable to parse error"),
    SOCKET_CLOSED(PointerIconCompat.TYPE_HAND, "Server closed connection"),
    SOCKET_FAILURE(PointerIconCompat.TYPE_HELP, "See stack trace in logs. Intercept error in error handler of setUser"),
    CANT_PARSE_CONNECTION_EVENT(PointerIconCompat.TYPE_WAIT, "Unable to parse connection event"),
    CANT_PARSE_EVENT(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "Unable to parse event"),
    INVALID_TOKEN(PointerIconCompat.TYPE_CELL, "Invalid token"),
    UNDEFINED_TOKEN(PointerIconCompat.TYPE_CROSSHAIR, "No defined token. Check if client.setUser was called and finished"),
    UNABLE_TO_PARSE_SOCKET_EVENT(PointerIconCompat.TYPE_TEXT, "Socket event payload either invalid or null"),
    NO_ERROR_BODY(PointerIconCompat.TYPE_VERTICAL_TEXT, "No error body. See http status code"),
    TOKEN_EXPIRED(40, "Token expired, new one must be requested."),
    API_KEY_NOT_FOUND(2, "Api key is not found, verify it if it's correct or was created.");
    
    private final int code;
    private final String description;

    private ChatErrorCode(int i, String str) {
        this.code = i;
        this.description = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }
}
