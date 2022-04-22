package p015io.getstream.chat.android.client.utils.observable;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012)\b\u0002\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00050\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R/\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00050\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/observable/Subscription;", "", "observable", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "listener", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/events/ChatEvent;", "", "filters", "", "Lkotlin/ParameterName;", "name", "event", "", "firstOnly", "(Lio/getstream/chat/android/client/utils/observable/ChatObservable;Lkotlin/jvm/functions/Function1;Ljava/util/List;Z)V", "deliveredCounter", "", "deliver", "onNext", "unsubscribe", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "Use the subscribe methods on ChatClient or ChannelController directly instead of events()")
/* renamed from: io.getstream.chat.android.client.utils.observable.Subscription */
/* compiled from: Subscription.kt */
public final class Subscription {
    private int deliveredCounter;
    private final List<Function1<ChatEvent, Boolean>> filters;
    private final boolean firstOnly;
    private Function1<? super ChatEvent, Unit> listener;
    private final ChatObservable observable;

    public Subscription(ChatObservable chatObservable, Function1<? super ChatEvent, Unit> function1, List<Function1<ChatEvent, Boolean>> list, boolean z) {
        Intrinsics.checkNotNullParameter(chatObservable, "observable");
        Intrinsics.checkNotNullParameter(list, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        this.observable = chatObservable;
        this.listener = function1;
        this.filters = list;
        this.firstOnly = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Subscription(ChatObservable chatObservable, Function1 function1, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatObservable, function1, (i & 4) != 0 ? new ArrayList() : list, z);
    }

    public final void unsubscribe() {
        this.listener = null;
        this.filters.clear();
        this.observable.unsubscribe(this);
    }

    public final void onNext(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        if (this.filters.isEmpty()) {
            deliver(chatEvent);
            return;
        }
        for (Function1 invoke : this.filters) {
            if (((Boolean) invoke.invoke(chatEvent)).booleanValue()) {
                deliver(chatEvent);
                return;
            }
        }
    }

    private final void deliver(ChatEvent chatEvent) {
        if (!this.firstOnly) {
            this.deliveredCounter++;
            Function1<? super ChatEvent, Unit> function1 = this.listener;
            if (function1 != null) {
                Unit invoke = function1.invoke(chatEvent);
            }
        } else if (this.deliveredCounter == 0) {
            this.deliveredCounter = 1;
            Function1<? super ChatEvent, Unit> function12 = this.listener;
            if (function12 != null) {
                Unit invoke2 = function12.invoke(chatEvent);
            }
        }
    }
}
