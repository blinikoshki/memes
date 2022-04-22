package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/SocketErrorMessage;", "", "error", "Lio/getstream/chat/android/client/socket/ErrorResponse;", "(Lio/getstream/chat/android/client/socket/ErrorResponse;)V", "getError", "()Lio/getstream/chat/android/client/socket/ErrorResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.SocketErrorMessage */
/* compiled from: SocketErrorMessage.kt */
public final class SocketErrorMessage {
    private final ErrorResponse error;

    public SocketErrorMessage() {
        this((ErrorResponse) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SocketErrorMessage copy$default(SocketErrorMessage socketErrorMessage, ErrorResponse errorResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            errorResponse = socketErrorMessage.error;
        }
        return socketErrorMessage.copy(errorResponse);
    }

    public final ErrorResponse component1() {
        return this.error;
    }

    public final SocketErrorMessage copy(ErrorResponse errorResponse) {
        return new SocketErrorMessage(errorResponse);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SocketErrorMessage) && Intrinsics.areEqual((Object) this.error, (Object) ((SocketErrorMessage) obj).error);
        }
        return true;
    }

    public int hashCode() {
        ErrorResponse errorResponse = this.error;
        if (errorResponse != null) {
            return errorResponse.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SocketErrorMessage(error=" + this.error + ")";
    }

    public SocketErrorMessage(ErrorResponse errorResponse) {
        this.error = errorResponse;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocketErrorMessage(ErrorResponse errorResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : errorResponse);
    }

    public final ErrorResponse getError() {
        return this.error;
    }
}
