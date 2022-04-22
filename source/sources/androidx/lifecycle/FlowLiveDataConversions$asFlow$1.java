package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", mo26808f = "FlowLiveData.kt", mo26809i = {0, 0, 0, 1, 1, 2, 2}, mo26810l = {96, 100, 101}, mo26811m = "invokeSuspend", mo26812n = {"$this$flow", "channel", "observer", "$this$flow", "observer", "$this$flow", "observer"}, mo26813s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: FlowLiveData.kt */
final class FlowLiveDataConversions$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData $this_asFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac A[Catch:{ all -> 0x00e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0054
            if (r1 == r4) goto L_0x0044
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r1 = r14.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r14.L$1
            androidx.lifecycle.Observer r4 = (androidx.lifecycle.Observer) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0040 }
            r15 = r1
            goto L_0x008f
        L_0x0024:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x002c:
            java.lang.Object r1 = r14.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r14.L$1
            androidx.lifecycle.Observer r4 = (androidx.lifecycle.Observer) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0040 }
            r7 = r6
            r6 = r4
            r4 = r1
            r1 = r14
            goto L_0x00a4
        L_0x0040:
            r15 = move-exception
        L_0x0041:
            r1 = r14
            goto L_0x00ed
        L_0x0044:
            java.lang.Object r1 = r14.L$2
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            java.lang.Object r4 = r14.L$1
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x008a
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r6 = r15
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            r15 = -1
            r1 = 6
            kotlinx.coroutines.channels.Channel r15 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r15, r5, r5, r1, r5)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1 r1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
            r1.<init>(r15)
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r7 = r7.getImmediate()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r8 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            r8.<init>(r14, r1, r5)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r14.L$0 = r6
            r14.L$1 = r15
            r14.L$2 = r1
            r14.label = r4
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r14)
            if (r4 != r0) goto L_0x0089
            return r0
        L_0x0089:
            r4 = r15
        L_0x008a:
            kotlinx.coroutines.channels.ChannelIterator r15 = r4.iterator()     // Catch:{ all -> 0x00e9 }
            r4 = r1
        L_0x008f:
            r1 = r14
        L_0x0090:
            r1.L$0 = r6     // Catch:{ all -> 0x00e7 }
            r1.L$1 = r4     // Catch:{ all -> 0x00e7 }
            r1.L$2 = r15     // Catch:{ all -> 0x00e7 }
            r1.label = r3     // Catch:{ all -> 0x00e7 }
            java.lang.Object r7 = r15.hasNext(r1)     // Catch:{ all -> 0x00e7 }
            if (r7 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r13 = r4
            r4 = r15
            r15 = r7
            r7 = r6
            r6 = r13
        L_0x00a4:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x00e4 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x00e4 }
            if (r15 == 0) goto L_0x00c3
            java.lang.Object r15 = r4.next()     // Catch:{ all -> 0x00e4 }
            r1.L$0 = r7     // Catch:{ all -> 0x00e4 }
            r1.L$1 = r6     // Catch:{ all -> 0x00e4 }
            r1.L$2 = r4     // Catch:{ all -> 0x00e4 }
            r1.label = r2     // Catch:{ all -> 0x00e4 }
            java.lang.Object r15 = r7.emit(r15, r1)     // Catch:{ all -> 0x00e4 }
            if (r15 != r0) goto L_0x00bf
            return r0
        L_0x00bf:
            r15 = r4
            r4 = r6
            r6 = r7
            goto L_0x0090
        L_0x00c3:
            kotlinx.coroutines.GlobalScope r15 = kotlinx.coroutines.GlobalScope.INSTANCE
            r7 = r15
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r15 = r15.getImmediate()
            r8 = r15
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            r9 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r15 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r15.<init>(r1, r6, r5)
            r10 = r15
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 2
            r12 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x00e4:
            r15 = move-exception
            r4 = r6
            goto L_0x00ed
        L_0x00e7:
            r15 = move-exception
            goto L_0x00ed
        L_0x00e9:
            r15 = move-exception
            r4 = r1
            goto L_0x0041
        L_0x00ed:
            kotlinx.coroutines.GlobalScope r0 = kotlinx.coroutines.GlobalScope.INSTANCE
            r6 = r0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r0 = r0.getImmediate()
            r7 = r0
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            r8 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r0 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r0.<init>(r1, r4, r5)
            r9 = r0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 2
            r11 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
