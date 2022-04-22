package p015io.getstream.chat.android.client.utils.observable;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/EventSubscription;", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "onNext", "", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.observable.EventSubscription */
/* compiled from: Subscriptions.kt */
public interface EventSubscription extends Disposable {
    void onNext(ChatEvent chatEvent);
}
