package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f448p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.f448p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0032
            if (r1 != r9) goto L_0x002a
            java.lang.Object r0 = r8.L$3
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            java.lang.Object r0 = r8.L$2
            kotlinx.coroutines.CompletableJob r0 = (kotlinx.coroutines.CompletableJob) r0
            java.lang.Object r0 = r8.L$1
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ AbortFlowException -> 0x0027 }
            goto L_0x00a6
        L_0x0024:
            r0 = move-exception
            goto L_0x00b8
        L_0x0027:
            r0 = move-exception
            goto L_0x00af
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r20)
            kotlinx.coroutines.CoroutineScope r11 = r8.f448p$
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r1.<init>(r8, r10)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 3
            r7 = 0
            r2 = r11
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.channels.ProduceKt.produce$default(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r7 = kotlinx.coroutines.JobKt.Job$default((kotlinx.coroutines.Job) r10, (int) r9, (java.lang.Object) r10)
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            java.util.Objects.requireNonNull(r12, r1)
            r1 = r12
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2 r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$2
            r2.<init>(r8, r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r1.invokeOnClose(r2)
            kotlin.coroutines.CoroutineContext r13 = r11.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(r13)     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            kotlin.coroutines.CoroutineContext r1 = r11.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r2 = r7
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            kotlin.coroutines.CoroutineContext r15 = r1.plus(r2)     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            kotlin.Unit r16 = kotlin.Unit.INSTANCE     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r17 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r18 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r6 = 0
            r1 = r18
            r2 = r19
            r3 = r13
            r4 = r14
            r5 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r4 = r18
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r6 = 4
            r18 = 0
            r8.L$0 = r11     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r8.L$1 = r12     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r8.L$2 = r7     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r8.L$3 = r13     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r8.L$4 = r14     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r8.label = r9     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r19
            r7 = r18
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x00ad, all -> 0x00aa }
            if (r1 != r0) goto L_0x00a5
            return r0
        L_0x00a5:
            r1 = r12
        L_0x00a6:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r1, (java.util.concurrent.CancellationException) r10, (int) r9, (java.lang.Object) r10)
            goto L_0x00b5
        L_0x00aa:
            r0 = move-exception
            r1 = r12
            goto L_0x00b8
        L_0x00ad:
            r0 = move-exception
            r1 = r12
        L_0x00af:
            kotlinx.coroutines.flow.FlowCollector r2 = r8.$this_unsafeFlow     // Catch:{ all -> 0x0024 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r2)     // Catch:{ all -> 0x0024 }
            goto L_0x00a6
        L_0x00b5:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b8:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r1, (java.util.concurrent.CancellationException) r10, (int) r9, (java.lang.Object) r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
