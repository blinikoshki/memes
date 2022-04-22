package p015io.getstream.chat.android.client.channel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "Lio/getstream/chat/android/client/events/ChatEvent;", "event", "onEvent", "(Lio/getstream/chat/android/client/events/ChatEvent;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.channel.ChannelClient$filterRelevantEvents$1 */
/* compiled from: ChannelClient.kt */
final class ChannelClient$filterRelevantEvents$1<EventT extends ChatEvent> implements ChatEventListener<T> {
    final /* synthetic */ ChatEventListener $listener;
    final /* synthetic */ ChannelClient this$0;

    ChannelClient$filterRelevantEvents$1(ChannelClient channelClient, ChatEventListener chatEventListener) {
        this.this$0 = channelClient;
        this.$listener = chatEventListener;
    }

    public final void onEvent(T t) {
        Intrinsics.checkNotNullParameter(t, "event");
        if (this.this$0.isRelevantForChannel(t)) {
            this.$listener.onEvent(t);
        }
    }
}
