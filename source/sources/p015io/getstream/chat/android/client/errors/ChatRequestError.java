package p015io.getstream.chat.android.client.errors;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/errors/ChatRequestError;", "Ljava/io/IOException;", "message", "", "streamCode", "", "statusCode", "cause", "", "(Ljava/lang/String;IILjava/lang/Throwable;)V", "getStatusCode", "()I", "getStreamCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.errors.ChatRequestError */
/* compiled from: ChatRequestError.kt */
public final class ChatRequestError extends IOException {
    private final int statusCode;
    private final int streamCode;

    public final int getStreamCode() {
        return this.streamCode;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatRequestError(String str, int i, int i2, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i3 & 8) != 0 ? null : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatRequestError(String str, int i, int i2, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.streamCode = i;
        this.statusCode = i2;
    }

    public String toString() {
        return "streamCode: " + this.streamCode + ", statusCode: " + this.statusCode + ", message: " + getMessage();
    }
}
