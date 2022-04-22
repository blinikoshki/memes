package p015io.getstream.chat.android.client.utils.observable;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00002!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H'J1\u0010\u0002\u001a\u00020\u00002\"\u0010\n\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f0\u000b\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\fH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH'J\b\u0010\u0010\u001a\u00020\u0000H'J\b\u0010\u0011\u001a\u00020\u0000H'J\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0004H'J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H'¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "", "filter", "predicate", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lkotlin/ParameterName;", "name", "event", "", "types", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "eventType", "", "first", "ignoreInitState", "subscribe", "Lio/getstream/chat/android/client/utils/observable/Subscription;", "listener", "", "unsubscribe", "subscription", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
/* renamed from: io.getstream.chat.android.client.utils.observable.ChatObservable */
/* compiled from: ChatObservable.kt */
public interface ChatObservable {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    ChatObservable filter(String str);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    ChatObservable filter(Function1<? super ChatEvent, Boolean> function1);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    ChatObservable filter(Class<? extends ChatEvent>... clsArr);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    ChatObservable first();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    ChatObservable ignoreInitState();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    Subscription subscribe(Function1<? super ChatEvent, Unit> function1);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
    void unsubscribe(Subscription subscription);
}
