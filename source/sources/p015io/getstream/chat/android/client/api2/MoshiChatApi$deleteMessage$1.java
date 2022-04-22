package p015io.getstream.chat.android.client.api2;

import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api2.mapping.MessageMappingKt;
import p015io.getstream.chat.android.client.api2.model.response.MessageResponse;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Message;", "response", "Lio/getstream/chat/android/client/api2/model/response/MessageResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.MoshiChatApi$deleteMessage$1 */
/* compiled from: MoshiChatApi.kt */
final class MoshiChatApi$deleteMessage$1 extends Lambda implements Function1<MessageResponse, Message> {
    public static final MoshiChatApi$deleteMessage$1 INSTANCE = new MoshiChatApi$deleteMessage$1();

    MoshiChatApi$deleteMessage$1() {
        super(1);
    }

    public final Message invoke(MessageResponse messageResponse) {
        Intrinsics.checkNotNullParameter(messageResponse, Payload.RESPONSE);
        return MessageMappingKt.toDomain(messageResponse.getMessage());
    }
}
