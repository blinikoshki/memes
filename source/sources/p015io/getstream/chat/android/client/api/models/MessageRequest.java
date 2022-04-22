package p015io.getstream.chat.android.client.api.models;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/MessageRequest;", "", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.MessageRequest */
/* compiled from: MessageRequest.kt */
public final class MessageRequest {
    private final Message message;

    public static /* synthetic */ MessageRequest copy$default(MessageRequest messageRequest, Message message2, int i, Object obj) {
        if ((i & 1) != 0) {
            message2 = messageRequest.message;
        }
        return messageRequest.copy(message2);
    }

    public final Message component1() {
        return this.message;
    }

    public final MessageRequest copy(Message message2) {
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new MessageRequest(message2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MessageRequest) && Intrinsics.areEqual((Object) this.message, (Object) ((MessageRequest) obj).message);
        }
        return true;
    }

    public int hashCode() {
        Message message2 = this.message;
        if (message2 != null) {
            return message2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MessageRequest(message=" + this.message + ")";
    }

    public MessageRequest(Message message2) {
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.message = message2;
    }

    public final Message getMessage() {
        return this.message;
    }
}
