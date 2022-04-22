package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo26107d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1 */
/* compiled from: Collect.kt */
public final class C2281x6e5ea3bc implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef $state$inlined;
    final /* synthetic */ CoroutineScope $this_launch$inlined;
    final /* synthetic */ FlowKt__ShareKt$launchSharingDeferred$1 this$0;

    public C2281x6e5ea3bc(FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1, CoroutineScope coroutineScope, Ref.ObjectRef objectRef) {
        this.this$0 = flowKt__ShareKt$launchSharingDeferred$1;
        this.$this_launch$inlined = coroutineScope;
        this.$state$inlined = objectRef;
    }

    public Object emit(Object obj, Continuation continuation) {
        Unit unit;
        MutableStateFlow mutableStateFlow = (MutableStateFlow) this.$state$inlined.element;
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(obj);
            unit = Unit.INSTANCE;
        } else {
            Ref.ObjectRef objectRef = this.$state$inlined;
            T MutableStateFlow = StateFlowKt.MutableStateFlow(obj);
            this.this$0.$result.complete(FlowKt.asStateFlow(MutableStateFlow));
            Unit unit2 = Unit.INSTANCE;
            objectRef.element = MutableStateFlow;
            unit = Unit.INSTANCE;
        }
        if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return unit;
        }
        return Unit.INSTANCE;
    }
}
