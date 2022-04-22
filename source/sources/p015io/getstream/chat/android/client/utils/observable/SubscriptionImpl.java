package p015io.getstream.chat.android.client.utils.observable;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0004R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/SubscriptionImpl;", "Lio/getstream/chat/android/client/utils/observable/EventSubscription;", "filter", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/events/ChatEvent;", "", "listener", "Lio/getstream/chat/android/client/ChatEventListener;", "(Lkotlin/jvm/functions/Function1;Lio/getstream/chat/android/client/ChatEventListener;)V", "afterEventDelivered", "Lkotlin/Function0;", "", "getAfterEventDelivered", "()Lkotlin/jvm/functions/Function0;", "setAfterEventDelivered", "(Lkotlin/jvm/functions/Function0;)V", "isDisposed", "()Z", "setDisposed", "(Z)V", "dispose", "onNext", "event", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.observable.SubscriptionImpl */
/* compiled from: Subscriptions.kt */
public class SubscriptionImpl implements EventSubscription {
    private Function0<Unit> afterEventDelivered = SubscriptionImpl$afterEventDelivered$1.INSTANCE;
    private final Function1<ChatEvent, Boolean> filter;
    private boolean isDisposed;
    private ChatEventListener<ChatEvent> listener;

    public SubscriptionImpl(Function1<? super ChatEvent, Boolean> function1, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(function1, "filter");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.filter = function1;
        this.listener = chatEventListener;
    }

    public boolean isDisposed() {
        return this.isDisposed;
    }

    public void setDisposed(boolean z) {
        this.isDisposed = z;
    }

    public final Function0<Unit> getAfterEventDelivered() {
        return this.afterEventDelivered;
    }

    public final void setAfterEventDelivered(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.afterEventDelivered = function0;
    }

    public void dispose() {
        setDisposed(true);
        this.listener = null;
    }

    public final void onNext(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        if (!(!isDisposed())) {
            throw new IllegalStateException("Subscription already disposed, onNext should not be called on it".toString());
        } else if (this.filter.invoke(chatEvent).booleanValue()) {
            try {
                ChatEventListener<ChatEvent> chatEventListener = this.listener;
                Intrinsics.checkNotNull(chatEventListener);
                chatEventListener.onEvent(chatEvent);
            } finally {
                this.afterEventDelivered.invoke();
            }
        }
    }
}
