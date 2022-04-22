package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "T", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1 */
/* compiled from: Delay.kt */
final class C2243xcf1eaa61 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    final /* synthetic */ Ref.LongRef $timeoutMillis$inlined;
    final /* synthetic */ Ref.ObjectRef $values$inlined;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2243xcf1eaa61(Continuation continuation, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
        super(1, continuation);
        this.$lastValue$inlined = objectRef;
        this.$timeoutMillis$inlined = longRef;
        this.$downstream$inlined = flowCollector;
        this.$values$inlined = objectRef2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2243xcf1eaa61(continuation, this.$lastValue$inlined, this.$timeoutMillis$inlined, this.$downstream$inlined, this.$values$inlined);
    }

    public final Object invoke(Object obj) {
        return ((C2243xcf1eaa61) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.$downstream$inlined;
            T t = NullSurrogateKt.NULL;
            T t2 = this.$lastValue$inlined.element;
            if (t2 == t) {
                t2 = null;
            }
            this.label = 1;
            if (flowCollector.emit(t2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue$inlined.element = null;
        return Unit.INSTANCE;
    }
}
