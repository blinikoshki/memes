package p015io.getstream.chat.android.client.utils.observable;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.ConnectingEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.events.ErrorEvent;
import p015io.getstream.chat.android.client.models.EventType;
import p015io.getstream.chat.android.client.socket.ChatSocketService;
import p015io.getstream.chat.android.client.socket.SocketListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0013\u001a\u00020\u00012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0016J1\u0010\u0013\u001a\u00020\u00012\"\u0010\u0015\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00170\u0016\"\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u000f\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\nJ\u001c\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c0\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl;", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "service", "Lio/getstream/chat/android/client/socket/ChatSocketService;", "(Lio/getstream/chat/android/client/socket/ChatSocketService;)V", "eventsMapper", "Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl$EventsMapper;", "filters", "", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lkotlin/ParameterName;", "name", "event", "", "first", "ignoreInitState", "subscriptions", "Lio/getstream/chat/android/client/utils/observable/Subscription;", "filter", "predicate", "types", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "eventType", "", "onNext", "", "subscribe", "listener", "unsubscribe", "subscription", "EventsMapper", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead")
/* renamed from: io.getstream.chat.android.client.utils.observable.ChatObservableImpl */
/* compiled from: ChatObservableImpl.kt */
public final class ChatObservableImpl implements ChatObservable {
    private EventsMapper eventsMapper = new EventsMapper(this);
    private final List<Function1<ChatEvent, Boolean>> filters = new ArrayList();
    private boolean first;
    private boolean ignoreInitState;
    private final ChatSocketService service;
    private final List<Subscription> subscriptions = new ArrayList();

    public ChatObservableImpl(ChatSocketService chatSocketService) {
        Intrinsics.checkNotNullParameter(chatSocketService, NotificationCompat.CATEGORY_SERVICE);
        this.service = chatSocketService;
    }

    public final void onNext(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        for (Subscription onNext : this.subscriptions) {
            onNext.onNext(chatEvent);
        }
    }

    public ChatObservable filter(String str) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        return filter((Function1<? super ChatEvent, Boolean>) new ChatObservableImpl$filter$1(str));
    }

    public ChatObservable filter(Function1<? super ChatEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        this.filters.add(function1);
        return this;
    }

    public ChatObservable filter(Class<? extends ChatEvent>... clsArr) {
        Intrinsics.checkNotNullParameter(clsArr, "types");
        return filter((Function1<? super ChatEvent, Boolean>) new ChatObservableImpl$filter$2(clsArr));
    }

    public ChatObservable first() {
        this.first = true;
        return this;
    }

    public ChatObservable ignoreInitState() {
        this.ignoreInitState = true;
        return this;
    }

    public Subscription subscribe(Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Subscription subscription = new Subscription(this, function1, this.filters, this.first);
        if (this.subscriptions.isEmpty()) {
            this.service.addListener(this.eventsMapper);
        }
        this.subscriptions.add(subscription);
        return subscription;
    }

    public void unsubscribe(Subscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        this.subscriptions.remove(subscription);
        if (this.subscriptions.isEmpty()) {
            this.service.removeListener(this.eventsMapper);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl$EventsMapper;", "Lio/getstream/chat/android/client/socket/SocketListener;", "observable", "Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl;", "(Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl;)V", "getObservable", "()Lio/getstream/chat/android/client/utils/observable/ChatObservableImpl;", "onConnected", "", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onConnecting", "onDisconnected", "onError", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.utils.observable.ChatObservableImpl$EventsMapper */
    /* compiled from: ChatObservableImpl.kt */
    private static final class EventsMapper extends SocketListener {
        private final ChatObservableImpl observable;

        public EventsMapper(ChatObservableImpl chatObservableImpl) {
            Intrinsics.checkNotNullParameter(chatObservableImpl, "observable");
            this.observable = chatObservableImpl;
        }

        public final ChatObservableImpl getObservable() {
            return this.observable;
        }

        public void onConnecting() {
            this.observable.onNext(new ConnectingEvent(EventType.CONNECTION_CONNECTING, new Date()));
        }

        public void onConnected(ConnectedEvent connectedEvent) {
            Intrinsics.checkNotNullParameter(connectedEvent, "event");
            this.observable.onNext(connectedEvent);
        }

        public void onDisconnected() {
            this.observable.onNext(new DisconnectedEvent(EventType.CONNECTION_DISCONNECTED, new Date()));
        }

        public void onEvent(ChatEvent chatEvent) {
            Intrinsics.checkNotNullParameter(chatEvent, "event");
            this.observable.onNext(chatEvent);
        }

        public void onError(ChatError chatError) {
            Intrinsics.checkNotNullParameter(chatError, "error");
            this.observable.onNext(new ErrorEvent(EventType.CONNECTION_ERROR, new Date(), chatError));
        }
    }
}
