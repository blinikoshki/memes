package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo26107d2 = {"<anonymous>", "", "A", "", "B", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.call.ZipCall$enqueue$2", mo26808f = "ZipCall.kt", mo26809i = {0, 2}, mo26810l = {55, 58, 62, 64, 68}, mo26811m = "invokeSuspend", mo26812n = {"deferredB", "resultA"}, mo26813s = {"L$0", "L$0"})
/* renamed from: io.getstream.chat.android.client.call.ZipCall$enqueue$2 */
/* compiled from: ZipCall.kt */
final class ZipCall$enqueue$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZipCall$enqueue$1 $performCallback$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZipCall this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipCall$enqueue$2(ZipCall zipCall, ZipCall$enqueue$1 zipCall$enqueue$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zipCall;
        this.$performCallback$1 = zipCall$enqueue$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        ZipCall$enqueue$2 zipCall$enqueue$2 = new ZipCall$enqueue$2(this.this$0, this.$performCallback$1, continuation);
        zipCall$enqueue$2.L$0 = obj;
        return zipCall$enqueue$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ZipCall$enqueue$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 == r7) goto L_0x003b
            if (r2 == r6) goto L_0x0037
            if (r2 == r5) goto L_0x002c
            if (r2 == r4) goto L_0x0027
            if (r2 != r3) goto L_0x001f
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x00e0
        L_0x001f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x00be
        L_0x002c:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r9 = r2
            r2 = r17
            goto L_0x00a3
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x0095
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r9 = r17
            goto L_0x0075
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r10 = 0
            r11 = 0
            io.getstream.chat.android.client.call.ZipCall$enqueue$2$deferredA$1 r9 = new io.getstream.chat.android.client.call.ZipCall$enqueue$2$deferredA$1
            r9.<init>(r0, r8)
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            r9 = r2
            kotlinx.coroutines.Deferred r15 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r9, r10, r11, r12, r13, r14)
            io.getstream.chat.android.client.call.ZipCall$enqueue$2$deferredB$1 r9 = new io.getstream.chat.android.client.call.ZipCall$enqueue$2$deferredB$1
            r9.<init>(r0, r8)
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r9 = r2
            kotlinx.coroutines.Deferred r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r9, r10, r11, r12, r13, r14)
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r9 = r15.await(r0)
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x0075:
            io.getstream.chat.android.client.utils.Result r9 = (p015io.getstream.chat.android.client.utils.Result) r9
            boolean r10 = r9.isError()
            if (r10 == 0) goto L_0x0098
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r2, (java.util.concurrent.CancellationException) r8, (int) r7, (java.lang.Object) r8)
            io.getstream.chat.android.client.call.ZipCall$enqueue$1 r2 = r0.$performCallback$1
            io.getstream.chat.android.client.call.ZipCall r3 = r0.this$0
            io.getstream.chat.android.client.utils.Result r3 = r3.getErrorA(r9)
            r0.L$0 = r8
            r0.label = r6
            java.lang.Object r2 = r2.invoke(r3, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r2 != r1) goto L_0x0095
            return r1
        L_0x0095:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0098:
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r2 = r2.await(r0)
            if (r2 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            boolean r5 = r2.isError()
            if (r5 == 0) goto L_0x00c1
            io.getstream.chat.android.client.call.ZipCall$enqueue$1 r3 = r0.$performCallback$1
            io.getstream.chat.android.client.call.ZipCall r5 = r0.this$0
            io.getstream.chat.android.client.utils.Result r2 = r5.getErrorB(r2)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r2 = r3.invoke(r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r2 != r1) goto L_0x00be
            return r1
        L_0x00be:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00c1:
            io.getstream.chat.android.client.call.ZipCall$enqueue$1 r4 = r0.$performCallback$1
            io.getstream.chat.android.client.utils.Result r5 = new io.getstream.chat.android.client.utils.Result
            kotlin.Pair r6 = new kotlin.Pair
            java.lang.Object r7 = r9.data()
            java.lang.Object r2 = r2.data()
            r6.<init>(r7, r2)
            r5.<init>(r6)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r2 = r4.invoke(r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r2 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.call.ZipCall$enqueue$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
