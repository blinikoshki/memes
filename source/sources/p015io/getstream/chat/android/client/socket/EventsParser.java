package p015io.getstream.chat.android.client.socket;

import androidx.core.app.NotificationCompat;
import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatErrorCode;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/EventsParser;", "Lokhttp3/WebSocketListener;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "(Lio/getstream/chat/android/client/parser/ChatParser;)V", "connectionEventReceived", "", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "service", "Lio/getstream/chat/android/client/socket/ChatSocketService;", "handleErrorEvent", "", "error", "Lio/getstream/chat/android/client/socket/ErrorResponse;", "handleEvent", "text", "", "onClosed", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "onClosing", "onFailure", "chatError", "Lio/getstream/chat/android/client/errors/ChatError;", "t", "", "response", "Lokhttp3/Response;", "onMessage", "onOpen", "setSocketService", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.EventsParser */
/* compiled from: EventsParser.kt */
public final class EventsParser extends WebSocketListener {
    private boolean connectionEventReceived;
    private final TaggedLogger logger = ChatLogger.Companion.get("Events");
    private final ChatParser parser;
    private ChatSocketService service;

    public void onClosing(WebSocket webSocket, int i, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
    }

    public EventsParser(ChatParser chatParser) {
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        this.parser = chatParser;
    }

    public final void setSocketService(ChatSocketService chatSocketService) {
        Intrinsics.checkNotNullParameter(chatSocketService, NotificationCompat.CATEGORY_SERVICE);
        this.service = chatSocketService;
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        this.logger.logI("onOpen");
        this.connectionEventReceived = false;
    }

    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        try {
            this.logger.logI(str);
            Result<SocketErrorMessage> fromJsonOrError = this.parser.fromJsonOrError(str, SocketErrorMessage.class);
            SocketErrorMessage data = fromJsonOrError.data();
            if (!fromJsonOrError.isSuccess() || data.getError() == null) {
                handleEvent(str);
            } else {
                handleErrorEvent(data.getError());
            }
        } catch (Throwable th) {
            this.logger.logE("onMessage", th);
            ChatSocketService chatSocketService = this.service;
            if (chatSocketService == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
            }
            chatSocketService.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.UNABLE_TO_PARSE_SOCKET_EVENT, (Throwable) null, 0, 6, (Object) null));
        }
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        onFailure(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.SOCKET_CLOSED, (Throwable) null, 0, 6, (Object) null));
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(th, "t");
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logE("onFailure: " + th, th);
        ChatSocketService chatSocketService = this.service;
        if (chatSocketService == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
        }
        chatSocketService.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.SOCKET_FAILURE, th, 0, 4, (Object) null));
    }

    private final void onFailure(ChatError chatError) {
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logE("onFailure " + chatError, chatError);
        ChatSocketService chatSocketService = this.service;
        if (chatSocketService == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
        }
        chatSocketService.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.SOCKET_FAILURE, chatError.getCause(), 0, 4, (Object) null));
    }

    private final void handleEvent(String str) {
        Result<ChatEvent> fromJsonOrError = this.parser.fromJsonOrError(str, ChatEvent.class);
        if (fromJsonOrError.isSuccess()) {
            ChatEvent data = fromJsonOrError.data();
            if (this.connectionEventReceived) {
                ChatSocketService chatSocketService = this.service;
                if (chatSocketService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
                }
                chatSocketService.onEvent(data);
            } else if (data instanceof ConnectedEvent) {
                this.connectionEventReceived = true;
                ChatSocketService chatSocketService2 = this.service;
                if (chatSocketService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
                }
                chatSocketService2.onConnectionResolved((ConnectedEvent) data);
            } else {
                ChatSocketService chatSocketService3 = this.service;
                if (chatSocketService3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
                }
                chatSocketService3.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.CANT_PARSE_CONNECTION_EVENT, (Throwable) null, 0, 6, (Object) null));
            }
        } else {
            ChatSocketService chatSocketService4 = this.service;
            if (chatSocketService4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
            }
            chatSocketService4.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.CANT_PARSE_EVENT, fromJsonOrError.error().getCause(), 0, 4, (Object) null));
        }
    }

    private final void handleErrorEvent(ErrorResponse errorResponse) {
        ChatSocketService chatSocketService = this.service;
        if (chatSocketService == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
        }
        chatSocketService.onSocketError(ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, errorResponse.getCode(), errorResponse.getMessage(), errorResponse.getStatusCode(), (Throwable) null, 8, (Object) null));
    }
}
