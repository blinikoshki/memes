package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/events/ChatEvent;", "onEvent"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$startListening$1 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$startListening$1<EventT extends ChatEvent> implements ChatEventListener<ChatEvent> {
    final /* synthetic */ ChatDomainImpl this$0;

    ChatDomainImpl$startListening$1(ChatDomainImpl chatDomainImpl) {
        this.this$0 = chatDomainImpl;
    }

    public final void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "it");
        this.this$0.getEventHandler$stream_chat_android_offline_release().handleEvents$stream_chat_android_offline_release(CollectionsKt.listOf(chatEvent));
    }
}
