package com.memes.eventtracker.tracking;

import com.memes.eventtracker.trackers.EventTracker;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.eventtracker.tracking.EventRouter$send$1", mo26808f = "EventRouter.kt", mo26809i = {}, mo26810l = {68}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EventRouter.kt */
final class EventRouter$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrackableEvent $event;
    Object L$0;
    int label;
    final /* synthetic */ EventRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRouter$send$1(EventRouter eventRouter, TrackableEvent trackableEvent, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eventRouter;
        this.$event = trackableEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EventRouter$send$1(this.this$0, this.$event, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EventRouter$send$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.this$0.trackers.iterator();
        } else if (i == 1) {
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            EventRouter eventRouter = this.this$0;
            TrackableEvent trackableEvent = this.$event;
            this.L$0 = it;
            this.label = 1;
            if (eventRouter.send(trackableEvent, (EventTracker) it.next(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
