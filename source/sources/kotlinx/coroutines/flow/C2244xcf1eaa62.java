package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"<anonymous>", "", "T", "value", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 */
/* compiled from: Delay.kt */
final class C2244xcf1eaa62 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    final /* synthetic */ Ref.LongRef $timeoutMillis$inlined;
    final /* synthetic */ Ref.ObjectRef $values$inlined;
    Object L$0;
    int label;
    private Object p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2244xcf1eaa62(Continuation continuation, Ref.ObjectRef objectRef, Ref.LongRef longRef, FlowCollector flowCollector, Ref.ObjectRef objectRef2) {
        super(2, continuation);
        this.$lastValue$inlined = objectRef;
        this.$timeoutMillis$inlined = longRef;
        this.$downstream$inlined = flowCollector;
        this.$values$inlined = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C2244xcf1eaa62 flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 = new C2244xcf1eaa62(continuation, this.$lastValue$inlined, this.$timeoutMillis$inlined, this.$downstream$inlined, this.$values$inlined);
        flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2.p$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C2244xcf1eaa62) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            T t = this.p$0;
            if (t != null) {
                this.$lastValue$inlined.element = t;
                return Unit.INSTANCE;
            } else if (this.$lastValue$inlined.element != null) {
                FlowCollector flowCollector = this.$downstream$inlined;
                T t2 = NullSurrogateKt.NULL;
                T t3 = this.$lastValue$inlined.element;
                if (t3 == t2) {
                    t3 = null;
                }
                this.L$0 = t;
                this.label = 1;
                if (flowCollector.emit(t3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue$inlined.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
