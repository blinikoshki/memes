package com.memes.eventtracker.tracking;

import com.memes.eventtracker.trackers.EventTracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo26107d2 = {"send", "", "event", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "tracker", "Lcom/memes/eventtracker/trackers/EventTracker;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.eventtracker.tracking.EventRouter", mo26808f = "EventRouter.kt", mo26809i = {0, 0}, mo26810l = {91}, mo26811m = "send", mo26812n = {"event", "tracker"}, mo26813s = {"L$0", "L$1"})
/* compiled from: EventRouter.kt */
final class EventRouter$send$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRouter$send$3(EventRouter eventRouter, Continuation continuation) {
        super(continuation);
        this.this$0 = eventRouter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send((TrackableEvent) null, (EventTracker) null, this);
    }
}
