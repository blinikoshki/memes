package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 0})
@DebugMetadata(mo26807c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", mo26808f = "Combine.kt", mo26809i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, mo26810l = {57, 79, 82}, mo26811m = "invokeSuspend", mo26812n = {"$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results"}, mo26813s = {"L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "B$0", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    byte B$0;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f450p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.f450p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: kotlinx.coroutines.internal.Symbol[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: kotlinx.coroutines.internal.Symbol[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: kotlinx.coroutines.internal.Symbol} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: kotlinx.coroutines.internal.Symbol[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0131 A[LOOP:1: B:24:0x0131->B:31:0x0152, LOOP_START, PHI: r2 r5 
      PHI: (r2v5 int) = (r2v4 int), (r2v6 int) binds: [B:23:0x012f, B:31:0x0152] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v5 kotlin.collections.IndexedValue) = (r5v4 kotlin.collections.IndexedValue), (r5v9 kotlin.collections.IndexedValue) binds: [B:23:0x012f, B:31:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r6 = r24
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r8 = 0
            r9 = 3
            r10 = 2
            r11 = 1
            if (r0 == 0) goto L_0x0099
            if (r0 == r11) goto L_0x0072
            if (r0 == r10) goto L_0x0049
            if (r0 != r9) goto L_0x0041
            java.lang.Object r0 = r6.L$6
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object r0 = r6.L$5
            kotlin.collections.IndexedValue r0 = (kotlin.collections.IndexedValue) r0
            int r0 = r6.I$2
            java.lang.Object r1 = r6.L$4
            byte[] r1 = (byte[]) r1
            int r2 = r6.I$1
            java.lang.Object r3 = r6.L$3
            java.util.concurrent.atomic.AtomicInteger r3 = (java.util.concurrent.atomic.AtomicInteger) r3
            java.lang.Object r4 = r6.L$2
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r5 = r6.L$1
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            int r8 = r6.I$0
            java.lang.Object r12 = r6.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlin.ResultKt.throwOnFailure(r25)
            r13 = r3
            r3 = r6
            r11 = r12
            r12 = r8
            r8 = r7
            r7 = r5
            goto L_0x01d4
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            java.lang.Object r0 = r6.L$6
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object r0 = r6.L$5
            kotlin.collections.IndexedValue r0 = (kotlin.collections.IndexedValue) r0
            int r0 = r6.I$2
            java.lang.Object r1 = r6.L$4
            byte[] r1 = (byte[]) r1
            int r2 = r6.I$1
            java.lang.Object r3 = r6.L$3
            java.util.concurrent.atomic.AtomicInteger r3 = (java.util.concurrent.atomic.AtomicInteger) r3
            java.lang.Object r4 = r6.L$2
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r5 = r6.L$1
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            int r8 = r6.I$0
            java.lang.Object r12 = r6.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlin.ResultKt.throwOnFailure(r25)
            r13 = r3
            r3 = r6
            goto L_0x018d
        L_0x0072:
            byte r0 = r6.B$0
            java.lang.Object r1 = r6.L$4
            byte[] r1 = (byte[]) r1
            int r2 = r6.I$1
            java.lang.Object r3 = r6.L$3
            java.util.concurrent.atomic.AtomicInteger r3 = (java.util.concurrent.atomic.AtomicInteger) r3
            java.lang.Object r4 = r6.L$2
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r5 = r6.L$1
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            int r8 = r6.I$0
            java.lang.Object r12 = r6.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlin.ResultKt.throwOnFailure(r25)
            r13 = r3
            r3 = r6
            r15 = r12
            r12 = r8
            r8 = r7
            r7 = r5
            r5 = r25
            goto L_0x012d
        L_0x0099:
            kotlin.ResultKt.throwOnFailure(r25)
            kotlinx.coroutines.CoroutineScope r12 = r6.f450p$
            kotlinx.coroutines.flow.Flow[] r0 = r6.$flows
            int r15 = r0.length
            if (r15 != 0) goto L_0x00a6
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00a6:
            java.lang.Object[] r14 = new java.lang.Object[r15]
            kotlinx.coroutines.internal.Symbol r17 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            r16 = r14
            kotlin.collections.ArraysKt.fill$default((java.lang.Object[]) r16, (java.lang.Object) r17, (int) r18, (int) r19, (int) r20, (java.lang.Object) r21)
            r0 = 6
            r1 = 0
            kotlinx.coroutines.channels.Channel r19 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r15, r1, r1, r0, r1)
            java.util.concurrent.atomic.AtomicInteger r13 = new java.util.concurrent.atomic.AtomicInteger
            r13.<init>(r15)
            r5 = 0
        L_0x00c3:
            if (r5 >= r15) goto L_0x00f8
            r16 = 0
            r17 = 0
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r18 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            r20 = 0
            r0 = r18
            r1 = r24
            r2 = r5
            r3 = r19
            r4 = r13
            r21 = r5
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 3
            r18 = 0
            r2 = r13
            r13 = r12
            r3 = r14
            r14 = r16
            r4 = r15
            r15 = r17
            r16 = r0
            r17 = r1
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r13, r14, r15, r16, r17, r18)
            int r5 = r21 + 1
            r13 = r2
            r14 = r3
            r15 = r4
            goto L_0x00c3
        L_0x00f8:
            r2 = r13
            r3 = r14
            r4 = r15
            byte[] r0 = new byte[r4]
            r2 = r4
            r15 = r2
            r3 = r6
            r1 = r19
        L_0x0102:
            int r8 = r8 + r11
            byte r4 = (byte) r8
            r5 = r1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            r3.L$0 = r12
            r3.I$0 = r15
            r3.L$1 = r14
            r3.L$2 = r1
            r3.L$3 = r13
            r3.I$1 = r2
            r3.L$4 = r0
            r3.B$0 = r4
            r3.label = r11
            java.lang.Object r5 = kotlinx.coroutines.channels.ChannelsKt.receiveOrNull(r5, r3)
            if (r5 != r7) goto L_0x0120
            return r7
        L_0x0120:
            r8 = r7
            r7 = r14
            r22 = r1
            r1 = r0
            r0 = r4
            r4 = r22
            r23 = r15
            r15 = r12
            r12 = r23
        L_0x012d:
            kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
            if (r5 == 0) goto L_0x01da
        L_0x0131:
            int r14 = r5.getIndex()
            r11 = r7[r14]
            java.lang.Object r16 = r5.getValue()
            r7[r14] = r16
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            if (r11 != r9) goto L_0x0143
            int r2 = r2 + -1
        L_0x0143:
            byte r9 = r1[r14]
            if (r9 != r0) goto L_0x0148
            goto L_0x0156
        L_0x0148:
            r1[r14] = r0
            java.lang.Object r9 = r4.poll()
            kotlin.collections.IndexedValue r9 = (kotlin.collections.IndexedValue) r9
            if (r9 == 0) goto L_0x0156
            r5 = r9
            r9 = 3
            r11 = 1
            goto L_0x0131
        L_0x0156:
            if (r2 != 0) goto L_0x01d3
            kotlin.jvm.functions.Function0 r9 = r3.$arrayFactory
            java.lang.Object r9 = r9.invoke()
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            if (r9 != 0) goto L_0x0194
            kotlin.jvm.functions.Function3 r11 = r3.$transform
            kotlinx.coroutines.flow.FlowCollector r14 = r3.$this_combineInternal
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r7, r10)
            r3.L$0 = r15
            r3.I$0 = r12
            r3.L$1 = r7
            r3.L$2 = r4
            r3.L$3 = r13
            r3.I$1 = r2
            r3.L$4 = r1
            r3.I$2 = r0
            r3.L$5 = r5
            r3.L$6 = r9
            r10 = 2
            r3.label = r10
            java.lang.Object r5 = r11.invoke(r14, r7, r3)
            if (r5 != r8) goto L_0x0189
            return r8
        L_0x0189:
            r5 = r7
            r7 = r8
            r8 = r12
            r12 = r15
        L_0x018d:
            r14 = r5
            r15 = r8
            r5 = 3
            r8 = r0
            r0 = r1
            r1 = r4
            goto L_0x01d6
        L_0x0194:
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.Array<T?>"
            java.util.Objects.requireNonNull(r7, r11)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 14
            r20 = 0
            r14 = r7
            r11 = r15
            r15 = r9
            kotlin.collections.ArraysKt.copyInto$default((java.lang.Object[]) r14, (java.lang.Object[]) r15, (int) r16, (int) r17, (int) r18, (int) r19, (java.lang.Object) r20)
            kotlin.jvm.functions.Function3 r14 = r3.$transform
            kotlinx.coroutines.flow.FlowCollector r15 = r3.$this_combineInternal
            r3.L$0 = r11
            r3.I$0 = r12
            r3.L$1 = r7
            r3.L$2 = r4
            r3.L$3 = r13
            r3.I$1 = r2
            r3.L$4 = r1
            r3.I$2 = r0
            r3.L$5 = r5
            r3.L$6 = r9
            r5 = 3
            r3.label = r5
            java.lang.Object r9 = r14.invoke(r15, r9, r3)
            if (r9 != r8) goto L_0x01cb
            return r8
        L_0x01cb:
            r14 = r7
            r7 = r8
            r15 = r12
            r8 = r0
            r0 = r1
            r1 = r4
            r12 = r11
            goto L_0x01d6
        L_0x01d3:
            r11 = r15
        L_0x01d4:
            r5 = 3
            goto L_0x01cb
        L_0x01d6:
            r9 = 3
            r11 = 1
            goto L_0x0102
        L_0x01da:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
