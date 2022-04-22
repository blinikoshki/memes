package p015io.getstream.chat.android.client.utils.observable;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.ConnectingEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.events.ErrorEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.EventType;
import p015io.getstream.chat.android.client.socket.ChatSocket;
import p015io.getstream.chat.android.client.socket.SocketListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J*\u0010\u0016\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bJ*\u0010\u001c\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable;", "", "socket", "Lio/getstream/chat/android/client/socket/ChatSocket;", "client", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/socket/ChatSocket;Lio/getstream/chat/android/client/ChatClient;)V", "eventsMapper", "Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable$EventsMapper;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "subscriptions", "", "Lio/getstream/chat/android/client/utils/observable/EventSubscription;", "addSubscription", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "subscription", "checkIfEmpty", "", "onNext", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "subscribe", "filter", "Lkotlin/Function1;", "", "listener", "Lio/getstream/chat/android/client/ChatEventListener;", "subscribeSingle", "EventsMapper", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.observable.ChatEventsObservable */
/* compiled from: ChatEventsObservable.kt */
public final class ChatEventsObservable {
    private ChatClient client;
    private EventsMapper eventsMapper = new EventsMapper(this);
    private final TaggedLogger logger = ChatLogger.Companion.get("ChatEventsObservable");
    private final ChatSocket socket;
    private Set<? extends EventSubscription> subscriptions = SetsKt.emptySet();

    public ChatEventsObservable(ChatSocket chatSocket, ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatSocket, "socket");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        this.socket = chatSocket;
        this.client = chatClient;
    }

    /* access modifiers changed from: private */
    public final void onNext(ChatEvent chatEvent) {
        for (EventSubscription eventSubscription : this.subscriptions) {
            if (!eventSubscription.isDisposed()) {
                eventSubscription.onNext(chatEvent);
            }
        }
        if (chatEvent instanceof ConnectedEvent) {
            this.client.callConnectionListener$stream_chat_android_client_release((ConnectedEvent) chatEvent, (ChatError) null);
        } else if (chatEvent instanceof ErrorEvent) {
            this.client.callConnectionListener$stream_chat_android_client_release((ConnectedEvent) null, ((ErrorEvent) chatEvent).getError());
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.subscriptions) {
            if (!((Disposable) next).isDisposed()) {
                arrayList.add(next);
            }
        }
        this.subscriptions = CollectionsKt.toSet((List) arrayList);
        checkIfEmpty();
    }

    private final void checkIfEmpty() {
        if (this.subscriptions.isEmpty()) {
            this.socket.removeListener(this.eventsMapper);
        }
    }

    public static /* synthetic */ Disposable subscribe$default(ChatEventsObservable chatEventsObservable, Function1 function1, ChatEventListener chatEventListener, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ChatEventsObservable$subscribe$1.INSTANCE;
        }
        return chatEventsObservable.subscribe(function1, chatEventListener);
    }

    public final Disposable subscribe(Function1<? super ChatEvent, Boolean> function1, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(function1, "filter");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return addSubscription(new SubscriptionImpl(function1, chatEventListener));
    }

    public static /* synthetic */ Disposable subscribeSingle$default(ChatEventsObservable chatEventsObservable, Function1 function1, ChatEventListener chatEventListener, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ChatEventsObservable$subscribeSingle$1.INSTANCE;
        }
        return chatEventsObservable.subscribeSingle(function1, chatEventListener);
    }

    public final Disposable subscribeSingle(Function1<? super ChatEvent, Boolean> function1, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(function1, "filter");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SubscriptionImpl subscriptionImpl = new SubscriptionImpl(function1, chatEventListener);
        subscriptionImpl.setAfterEventDelivered(new ChatEventsObservable$subscribeSingle$2$1(subscriptionImpl));
        Unit unit = Unit.INSTANCE;
        return addSubscription(subscriptionImpl);
    }

    private final Disposable addSubscription(EventSubscription eventSubscription) {
        if (this.subscriptions.isEmpty()) {
            this.socket.addListener(this.eventsMapper);
        }
        this.subscriptions = SetsKt.plus(this.subscriptions, eventSubscription);
        return eventSubscription;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable$EventsMapper;", "Lio/getstream/chat/android/client/socket/SocketListener;", "observable", "Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable;", "(Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable;)V", "onConnected", "", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onConnecting", "onDisconnected", "onError", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.utils.observable.ChatEventsObservable$EventsMapper */
    /* compiled from: ChatEventsObservable.kt */
    private static final class EventsMapper extends SocketListener {
        private final ChatEventsObservable observable;

        public EventsMapper(ChatEventsObservable chatEventsObservable) {
            Intrinsics.checkNotNullParameter(chatEventsObservable, "observable");
            this.observable = chatEventsObservable;
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
