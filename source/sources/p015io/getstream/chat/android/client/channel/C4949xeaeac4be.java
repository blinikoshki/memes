package p015io.getstream.chat.android.client.channel;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.channel.ChannelClient$sam$io_getstream_chat_android_client_ChatEventListener$0 */
/* compiled from: ChannelClient.kt */
final class C4949xeaeac4be implements ChatEventListener, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    C4949xeaeac4be(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ChatEventListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    public final /* synthetic */ void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(chatEvent), "invoke(...)");
    }
}
