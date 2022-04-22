package p015io.getstream.chat.android.core.internal.fsm;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo26107d2 = {"<anonymous>", "", "S", "", "E", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.core.internal.fsm.FiniteStateMachine$sendEvent$1", mo26808f = "FiniteStateMachine.kt", mo26809i = {0}, mo26810l = {87}, mo26811m = "invokeSuspend", mo26812n = {"$this$withLock$iv"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.core.internal.fsm.FiniteStateMachine$sendEvent$1 */
/* compiled from: FiniteStateMachine.kt */
final class FiniteStateMachine$sendEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $event;
    Object L$0;
    int label;
    final /* synthetic */ FiniteStateMachine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiniteStateMachine$sendEvent$1(FiniteStateMachine finiteStateMachine, Object obj, Continuation continuation) {
        super(2, continuation);
        this.this$0 = finiteStateMachine;
        this.$event = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FiniteStateMachine$sendEvent$1(this.this$0, this.$event, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FiniteStateMachine$sendEvent$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex access$getMutex$p = this.this$0.mutex;
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
            Object access$get_state$p = this.this$0._state;
            Map map = (Map) this.this$0.stateFunctions.get(Reflection.getOrCreateKotlinClass(access$get_state$p.getClass()));
            Function3 function3 = map != null ? (Function3) map.get(Reflection.getOrCreateKotlinClass(this.$event.getClass())) : null;
            if (function3 != null) {
                FiniteStateMachine finiteStateMachine = this.this$0;
                finiteStateMachine._state = function3.invoke(finiteStateMachine, access$get_state$p, this.$event);
            } else {
                this.this$0.defaultEventHandler.invoke(access$get_state$p, this.$event);
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
    }
}
