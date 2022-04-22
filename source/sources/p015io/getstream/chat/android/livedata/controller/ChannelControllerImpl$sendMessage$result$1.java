package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$result$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$sendMessage$result$1 extends Lambda implements Function0<Call<Message>> {
    final /* synthetic */ Message $newMessage;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$sendMessage$result$1(ChannelControllerImpl channelControllerImpl, Message message) {
        super(0);
        this.this$0 = channelControllerImpl;
        this.$newMessage = message;
    }

    public final Call<Message> invoke() {
        return this.this$0.channelClient.sendMessage(this.$newMessage);
    }
}
