package p015io.getstream.chat.android.livedata;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo26107d2 = {"updateOfflineStorageFromEvents", "", "events", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.EventHandlerImpl", mo26808f = "EventHandlerImpl.kt", mo26809i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 10}, mo26810l = {204, 257, 260, 340, 355, 357, 415, 421, 424, 427, 428}, mo26811m = "updateOfflineStorageFromEvents$stream_chat_android_offline_release", mo26812n = {"this", "events", "this", "events", "batch", "this", "events", "batch", "this", "events", "batch", "this", "events", "batch", "event", "this", "events", "batch", "this", "events", "this", "this", "this", "event", "this"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1 */
/* compiled from: EventHandlerImpl.kt */
final class EventHandlerImpl$updateOfflineStorageFromEvents$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHandlerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHandlerImpl$updateOfflineStorageFromEvents$1(EventHandlerImpl eventHandlerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = eventHandlerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo69172xbc9d7433((List<? extends ChatEvent>) null, this);
    }
}
