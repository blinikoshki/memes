package p015io.getstream.chat.android.core.internal.fsm;

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
import kotlinx.coroutines.sync.Mutex;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "S", "", "E", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.core.internal.fsm.FiniteStateMachine$state$1", mo26808f = "FiniteStateMachine.kt", mo26809i = {0}, mo26810l = {89}, mo26811m = "invokeSuspend", mo26812n = {"$this$withLock$iv$iv"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.core.internal.fsm.FiniteStateMachine$state$1 */
/* compiled from: FiniteStateMachine.kt */
final class FiniteStateMachine$state$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super S>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ FiniteStateMachine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiniteStateMachine$state$1(FiniteStateMachine finiteStateMachine, Continuation continuation) {
        super(2, continuation);
        this.this$0 = finiteStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FiniteStateMachine$state$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FiniteStateMachine$state$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex access$getMutex$p = this.this$0.mutex;
            if (access$getMutex$p.isLocked()) {
                return this.this$0._state;
            }
            this.L$0 = access$getMutex$p;
            this.label = 1;
            if (access$getMutex$p.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = access$getMutex$p;
        } else if (i == 1) {
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            return this.this$0._state;
        } finally {
            mutex.unlock((Object) null);
        }
    }
}
