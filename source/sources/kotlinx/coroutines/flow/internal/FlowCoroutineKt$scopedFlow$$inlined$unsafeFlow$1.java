package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ Function3 $block$inlined;

    public FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1(Function3 function3) {
        this.$block$inlined = function3;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object flowScope = FlowCoroutineKt.flowScope(new FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1(flowCollector, (Continuation) null, this), continuation);
        if (flowScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return flowScope;
        }
        return Unit.INSTANCE;
    }
}
