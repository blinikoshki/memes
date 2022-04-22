package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__ZipKt$combine$$inlined$combine$1 implements Flow<R> {
    final /* synthetic */ Flow[] $flows$inlined;
    final /* synthetic */ Function5 $transform$inlined$1;

    public FlowKt__ZipKt$combine$$inlined$combine$1(Flow[] flowArr, Function5 function5) {
        this.$flows$inlined = flowArr;
        this.$transform$inlined$1 = function5;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object combineInternal = CombineKt.combineInternal(flowCollector, this.$flows$inlined, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object[] invoke() {
                return new Object[this.this$0.$flows$inlined.length];
            }
        }, new C23303((Continuation) null), continuation);
        if (combineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, mo26107d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$2"}, mo26108k = 3, mo26109mv = {1, 4, 0})
    @DebugMetadata(mo26807c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3", mo26808f = "Zip.kt", mo26809i = {0, 0, 0, 0, 1, 1}, mo26810l = {337, 337}, mo26811m = "invokeSuspend", mo26812n = {"$this$combineInternal", "it", "continuation", "args", "$this$combineInternal", "it"}, mo26813s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3 */
    /* compiled from: Zip.kt */
    public static final class C23303 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* renamed from: p$ */
        private FlowCollector f414p$;
        private Object[] p$0;

        public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            C23303 r0 = new C23303(continuation, this);
            r0.f414p$ = flowCollector;
            r0.p$0 = objArr;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C23303) create((FlowCollector) obj, (Object[]) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object[] objArr;
            FlowCollector flowCollector2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = this.f414p$;
                Object[] objArr2 = this.p$0;
                Function5 function5 = this.$transform$inlined$1;
                Object obj2 = objArr2[0];
                Object obj3 = objArr2[1];
                Object obj4 = objArr2[2];
                Object obj5 = objArr2[3];
                this.L$0 = flowCollector2;
                this.L$1 = objArr2;
                this.L$2 = flowCollector2;
                this.L$3 = this;
                this.L$4 = objArr2;
                this.label = 1;
                InlineMarker.mark(6);
                Object invoke = function5.invoke(obj2, obj3, obj4, obj5, this);
                InlineMarker.mark(7);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
                Object obj6 = invoke;
                objArr = objArr2;
                obj = obj6;
            } else if (i == 1) {
                Object[] objArr3 = (Object[]) this.L$4;
                Continuation continuation = (Continuation) this.L$3;
                flowCollector2 = (FlowCollector) this.L$2;
                objArr = (Object[]) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                Object[] objArr4 = (Object[]) this.L$1;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.L$0 = flowCollector;
            this.L$1 = objArr;
            this.label = 2;
            if (flowCollector2.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }
}
