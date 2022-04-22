package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.MessageResponse;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Message;", "it", "Lio/getstream/chat/android/client/api/models/MessageResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$deleteMessage$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$deleteMessage$1 extends Lambda implements Function1<MessageResponse, Message> {
    public static final GsonChatApi$deleteMessage$1 INSTANCE = new GsonChatApi$deleteMessage$1();

    GsonChatApi$deleteMessage$1() {
        super(1);
    }

    public final Message invoke(MessageResponse messageResponse) {
        Intrinsics.checkNotNullParameter(messageResponse, "it");
        return messageResponse.getMessage();
    }
}
