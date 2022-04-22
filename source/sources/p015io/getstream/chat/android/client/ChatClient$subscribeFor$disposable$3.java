package p015io.getstream.chat.android.client;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "onEvent"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$subscribeFor$disposable$3 */
/* compiled from: ChatClient.kt */
final class ChatClient$subscribeFor$disposable$3<EventT extends ChatEvent> implements ChatEventListener<ChatEvent> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function1 $listener;

    ChatClient$subscribeFor$disposable$3(LifecycleOwner lifecycleOwner, Function1 function1) {
        this.$lifecycleOwner = lifecycleOwner;
        this.$listener = function1;
    }

    public final void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        Lifecycle lifecycle = this.$lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycleOwner.lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            this.$listener.invoke(chatEvent);
        }
    }
}
