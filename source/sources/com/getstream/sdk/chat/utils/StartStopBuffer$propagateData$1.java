package com.getstream.sdk.chat.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1", mo26808f = "StartStopBuffer.kt", mo26809i = {}, mo26810l = {33}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: StartStopBuffer.kt */
final class StartStopBuffer$propagateData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StartStopBuffer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartStopBuffer$propagateData$1(StartStopBuffer startStopBuffer, Continuation continuation) {
        super(2, continuation);
        this.this$0 = startStopBuffer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new StartStopBuffer$propagateData$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((StartStopBuffer$propagateData$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        r8.label = 1;
        r1 = kotlinx.coroutines.BuildersKt.withContext(p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider.INSTANCE.getMain(), new com.getstream.sdk.chat.utils.C1711xc504a7f6(r1, (kotlin.coroutines.Continuation) null, r8), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (r1 != r0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        r6 = r0;
        r0 = r8;
        r8 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[EDGE_INSN: B:21:0x0066->B:18:0x0066 ?: BREAK  
    EDGE_INSN: B:22:0x0066->B:18:0x0066 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r0
            r0 = r7
            goto L_0x0061
        L_0x0011:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
        L_0x001d:
            com.getstream.sdk.chat.utils.StartStopBuffer r1 = r8.this$0
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.active
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x0066
            com.getstream.sdk.chat.utils.StartStopBuffer r1 = r8.this$0
            java.util.Queue r1 = r1.events
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0066
            com.getstream.sdk.chat.utils.StartStopBuffer r1 = r8.this$0
            java.util.Queue r1 = r1.events
            java.lang.Object r1 = r1.poll()
            if (r1 == 0) goto L_0x001d
            io.getstream.chat.android.core.internal.coroutines.DispatcherProvider r3 = p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider.INSTANCE
            kotlinx.coroutines.CoroutineDispatcher r3 = r3.getMain()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1$invokeSuspend$$inlined$let$lambda$1 r4 = new com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1$invokeSuspend$$inlined$let$lambda$1
            r5 = 0
            r4.<init>(r1, r5, r8)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r8.label = r2
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r8)
            if (r1 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r6 = r0
            r0 = r8
            r8 = r1
            r1 = r6
        L_0x0061:
            kotlin.Unit r8 = (kotlin.Unit) r8
            r8 = r0
            r0 = r1
            goto L_0x001d
        L_0x0066:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
