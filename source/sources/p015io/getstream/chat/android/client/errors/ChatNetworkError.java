package p015io.getstream.chat.android.client.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/errors/ChatNetworkError;", "Lio/getstream/chat/android/client/errors/ChatError;", "description", "", "cause", "", "streamCode", "", "statusCode", "(Ljava/lang/String;Ljava/lang/Throwable;II)V", "getDescription", "()Ljava/lang/String;", "getStatusCode", "()I", "getStreamCode", "toString", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.errors.ChatNetworkError */
/* compiled from: ChatNetworkError.kt */
public final class ChatNetworkError extends ChatError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String description;
    private final int statusCode;
    private final int streamCode;

    public /* synthetic */ ChatNetworkError(String str, Throwable th, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, i, i2);
    }

    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ChatNetworkError(String str, Throwable th, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : th, i, i2);
    }

    public final int getStreamCode() {
        return this.streamCode;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    private ChatNetworkError(String str, Throwable th, int i, int i2) {
        super("Status code: " + i2 + ", with stream code: " + i + ", description: " + str, th);
        this.description = str;
        this.streamCode = i;
        this.statusCode = i2;
    }

    public String toString() {
        return "ChatNetworkError http status " + this.statusCode + ", stream error code " + this.streamCode + ": " + this.description;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nJ*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/errors/ChatNetworkError$Companion;", "", "()V", "create", "Lio/getstream/chat/android/client/errors/ChatNetworkError;", "code", "Lio/getstream/chat/android/client/errors/ChatErrorCode;", "cause", "", "statusCode", "", "streamCode", "description", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.errors.ChatNetworkError$Companion */
    /* compiled from: ChatNetworkError.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ChatNetworkError create$default(Companion companion, ChatErrorCode chatErrorCode, Throwable th, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return companion.create(chatErrorCode, th, i);
        }

        public final ChatNetworkError create(ChatErrorCode chatErrorCode, Throwable th, int i) {
            Intrinsics.checkNotNullParameter(chatErrorCode, "code");
            return new ChatNetworkError(chatErrorCode.getDescription(), th, chatErrorCode.getCode(), i, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ChatNetworkError create$default(Companion companion, int i, String str, int i2, Throwable th, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                th = null;
            }
            return companion.create(i, str, i2, th);
        }

        public final ChatNetworkError create(int i, String str, int i2, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "description");
            return new ChatNetworkError(str, th, i, i2, (DefaultConstructorMarker) null);
        }
    }
}
