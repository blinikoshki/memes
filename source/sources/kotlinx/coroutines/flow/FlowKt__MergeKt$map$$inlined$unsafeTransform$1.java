package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__MergeKt$map$$inlined$unsafeTransform$1 implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    public FlowKt__MergeKt$map$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined$1 = function2;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<T>() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00ad A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691
                    if (r0 == 0) goto L_0x0014
                    r0 = r12
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r12 = r0.label
                    int r12 = r12 - r2
                    r0.label = r12
                    goto L_0x0019
                L_0x0014:
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1
                    r0.<init>(r10, r12)
                L_0x0019:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x006a
                    if (r2 == r4) goto L_0x004c
                    if (r2 != r3) goto L_0x0044
                    java.lang.Object r11 = r0.L$6
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r11 = r0.L$5
                    java.lang.Object r11 = r0.L$4
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    java.lang.Object r11 = r0.L$3
                    java.lang.Object r11 = r0.L$2
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r11
                    java.lang.Object r11 = r0.L$1
                    java.lang.Object r11 = r0.L$0
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682) r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00ae
                L_0x0044:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x004c:
                    java.lang.Object r11 = r0.L$7
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r2 = r0.L$6
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    java.lang.Object r4 = r0.L$5
                    java.lang.Object r5 = r0.L$4
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    java.lang.Object r6 = r0.L$3
                    java.lang.Object r7 = r0.L$2
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r7
                    java.lang.Object r8 = r0.L$1
                    java.lang.Object r9 = r0.L$0
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682) r9
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x0097
                L_0x006a:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r3
                    r5 = r0
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1 r2 = r2
                    kotlin.jvm.functions.Function2 r2 = r2.$transform$inlined$1
                    r0.L$0 = r10
                    r0.L$1 = r11
                    r0.L$2 = r0
                    r0.L$3 = r11
                    r0.L$4 = r5
                    r0.L$5 = r11
                    r0.L$6 = r12
                    r0.L$7 = r12
                    r0.label = r4
                    java.lang.Object r2 = r2.invoke(r11, r0)
                    if (r2 != r1) goto L_0x008f
                    return r1
                L_0x008f:
                    r9 = r10
                    r4 = r11
                    r6 = r4
                    r8 = r6
                    r11 = r12
                    r7 = r0
                    r12 = r2
                    r2 = r11
                L_0x0097:
                    r0.L$0 = r9
                    r0.L$1 = r8
                    r0.L$2 = r7
                    r0.L$3 = r6
                    r0.L$4 = r5
                    r0.L$5 = r4
                    r0.L$6 = r2
                    r0.label = r3
                    java.lang.Object r11 = r11.emit(r12, r0)
                    if (r11 != r1) goto L_0x00ae
                    return r1
                L_0x00ae:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            public Object emit$$forInline(Object obj, Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ C22682 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = r3;
                Object invoke = this.$transform$inlined$1.invoke(obj, continuation);
                InlineMarker.mark(0);
                Object emit = flowCollector.emit(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public Object collect$$forInline(final FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__MergeKt$map$$inlined$unsafeTransform$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        InlineMarker.mark(0);
        this.$this_unsafeTransform$inlined.collect(new FlowCollector<T>() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691
                    if (r0 == 0) goto L_0x0014
                    r0 = r12
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r12 = r0.label
                    int r12 = r12 - r2
                    r0.label = r12
                    goto L_0x0019
                L_0x0014:
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1
                    r0.<init>(r10, r12)
                L_0x0019:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x006a
                    if (r2 == r4) goto L_0x004c
                    if (r2 != r3) goto L_0x0044
                    java.lang.Object r11 = r0.L$6
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r11 = r0.L$5
                    java.lang.Object r11 = r0.L$4
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    java.lang.Object r11 = r0.L$3
                    java.lang.Object r11 = r0.L$2
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r11
                    java.lang.Object r11 = r0.L$1
                    java.lang.Object r11 = r0.L$0
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682) r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00ae
                L_0x0044:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x004c:
                    java.lang.Object r11 = r0.L$7
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    java.lang.Object r2 = r0.L$6
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    java.lang.Object r4 = r0.L$5
                    java.lang.Object r5 = r0.L$4
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    java.lang.Object r6 = r0.L$3
                    java.lang.Object r7 = r0.L$2
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.C22691) r7
                    java.lang.Object r8 = r0.L$1
                    java.lang.Object r9 = r0.L$0
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682) r9
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x0097
                L_0x006a:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r3
                    r5 = r0
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1 r2 = r2
                    kotlin.jvm.functions.Function2 r2 = r2.$transform$inlined$1
                    r0.L$0 = r10
                    r0.L$1 = r11
                    r0.L$2 = r0
                    r0.L$3 = r11
                    r0.L$4 = r5
                    r0.L$5 = r11
                    r0.L$6 = r12
                    r0.L$7 = r12
                    r0.label = r4
                    java.lang.Object r2 = r2.invoke(r11, r0)
                    if (r2 != r1) goto L_0x008f
                    return r1
                L_0x008f:
                    r9 = r10
                    r4 = r11
                    r6 = r4
                    r8 = r6
                    r11 = r12
                    r7 = r0
                    r12 = r2
                    r2 = r11
                L_0x0097:
                    r0.L$0 = r9
                    r0.L$1 = r8
                    r0.L$2 = r7
                    r0.L$3 = r6
                    r0.L$4 = r5
                    r0.L$5 = r4
                    r0.L$6 = r2
                    r0.label = r3
                    java.lang.Object r11 = r11.emit(r12, r0)
                    if (r11 != r1) goto L_0x00ae
                    return r1
                L_0x00ae:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.C22682.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            public Object emit$$forInline(Object obj, Continuation continuation) {
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ C22682 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = flowCollector;
                Object invoke = this.$transform$inlined$1.invoke(obj, continuation);
                InlineMarker.mark(0);
                Object emit = flowCollector.emit(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                return emit;
            }
        }, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
