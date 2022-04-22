package p015io.getstream.chat.android.client.channel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "p1", "Lio/getstream/chat/android/client/events/ChatEvent;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.channel.ChannelClient$events$1 */
/* compiled from: ChannelClient.kt */
final /* synthetic */ class ChannelClient$events$1 extends FunctionReferenceImpl implements Function1<ChatEvent, Boolean> {
    ChannelClient$events$1(ChannelClient channelClient) {
        super(1, channelClient, ChannelClient.class, "isRelevantForChannel", "isRelevantForChannel(Lio/getstream/chat/android/client/events/ChatEvent;)Z", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((ChatEvent) obj));
    }

    public final boolean invoke(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "p1");
        return ((ChannelClient) this.receiver).isRelevantForChannel(chatEvent);
    }
}
