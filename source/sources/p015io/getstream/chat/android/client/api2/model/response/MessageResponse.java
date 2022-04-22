package p015io.getstream.chat.android.client.api2.model.response;

import com.facebook.share.internal.ShareConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/response/MessageResponse;", "", "message", "Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "(Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;)V", "getMessage", "()Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.response.MessageResponse */
/* compiled from: MessageResponse.kt */
public final class MessageResponse {
    private final DownstreamMessageDto message;

    public static /* synthetic */ MessageResponse copy$default(MessageResponse messageResponse, DownstreamMessageDto downstreamMessageDto, int i, Object obj) {
        if ((i & 1) != 0) {
            downstreamMessageDto = messageResponse.message;
        }
        return messageResponse.copy(downstreamMessageDto);
    }

    public final DownstreamMessageDto component1() {
        return this.message;
    }

    public final MessageResponse copy(DownstreamMessageDto downstreamMessageDto) {
        Intrinsics.checkNotNullParameter(downstreamMessageDto, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new MessageResponse(downstreamMessageDto);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MessageResponse) && Intrinsics.areEqual((Object) this.message, (Object) ((MessageResponse) obj).message);
        }
        return true;
    }

    public int hashCode() {
        DownstreamMessageDto downstreamMessageDto = this.message;
        if (downstreamMessageDto != null) {
            return downstreamMessageDto.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MessageResponse(message=" + this.message + ")";
    }

    public MessageResponse(DownstreamMessageDto downstreamMessageDto) {
        Intrinsics.checkNotNullParameter(downstreamMessageDto, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.message = downstreamMessageDto;
    }

    public final DownstreamMessageDto getMessage() {
        return this.message;
    }
}
