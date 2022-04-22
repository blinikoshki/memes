package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/client/ChatEventListener;", "EventT", "Lio/getstream/chat/android/client/events/ChatEvent;", "", "onEvent", "", "event", "(Lio/getstream/chat/android/client/events/ChatEvent;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatEventListener */
/* compiled from: ChatEventListener.kt */
public interface ChatEventListener<EventT extends ChatEvent> {
    void onEvent(EventT eventt);
}
