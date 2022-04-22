package p015io.getstream.chat.android.livedata;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo26107d2 = {"handleEventsInternal", "", "events", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.EventHandlerImpl", mo26808f = "EventHandlerImpl.kt", mo26809i = {0, 0, 1, 1, 2, 2, 2, 3}, mo26810l = {445, 453, 460, 467}, mo26811m = "handleEventsInternal", mo26812n = {"this", "sortedEvents", "this", "sortedEvents", "this", "sortedEvents", "markAllRead", "sortedEvents"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1 */
/* compiled from: EventHandlerImpl.kt */
final class EventHandlerImpl$handleEventsInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHandlerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHandlerImpl$handleEventsInternal$1(EventHandlerImpl eventHandlerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = eventHandlerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleEventsInternal((List<? extends ChatEvent>) null, this);
    }
}
