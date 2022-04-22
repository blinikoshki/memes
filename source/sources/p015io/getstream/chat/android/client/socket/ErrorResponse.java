package p015io.getstream.chat.android.client.socket;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, mo26107d2 = {"Lio/getstream/chat/android/client/socket/ErrorResponse;", "", "code", "", "message", "", "statusCode", "(ILjava/lang/String;I)V", "getCode", "()I", "duration", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getStatusCode", "setStatusCode", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ErrorResponse */
/* compiled from: ErrorResponse.kt */
public final class ErrorResponse {
    private final int code;
    private String duration;
    private String message;
    @SerializedName("StatusCode")
    private int statusCode;

    public ErrorResponse() {
        this(0, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = errorResponse.code;
        }
        if ((i3 & 2) != 0) {
            str = errorResponse.message;
        }
        if ((i3 & 4) != 0) {
            i2 = errorResponse.statusCode;
        }
        return errorResponse.copy(i, str, i2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.statusCode;
    }

    public final ErrorResponse copy(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new ErrorResponse(i, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) obj;
        return this.code == errorResponse.code && Intrinsics.areEqual((Object) this.message, (Object) errorResponse.message) && this.statusCode == errorResponse.statusCode;
    }

    public int hashCode() {
        int i = this.code * 31;
        String str = this.message;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.statusCode;
    }

    public String toString() {
        return "ErrorResponse(code=" + this.code + ", message=" + this.message + ", statusCode=" + this.statusCode + ")";
    }

    public ErrorResponse(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.code = i;
        this.message = str;
        this.statusCode = i2;
        this.duration = "";
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorResponse(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? -1 : i2);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i) {
        this.statusCode = i;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.duration = str;
    }
}
