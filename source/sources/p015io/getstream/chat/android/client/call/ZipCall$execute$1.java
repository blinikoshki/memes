package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lkotlin/Pair;", "A", "B", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.call.ZipCall$execute$1", mo26808f = "ZipCall.kt", mo26809i = {0, 1}, mo26810l = {31, 37}, mo26811m = "invokeSuspend", mo26812n = {"deferredB", "resultA"}, mo26813s = {"L$0", "L$0"})
/* renamed from: io.getstream.chat.android.client.call.ZipCall$execute$1 */
/* compiled from: ZipCall.kt */
final class ZipCall$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<Pair<? extends A, ? extends B>>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZipCall this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipCall$execute$1(ZipCall zipCall, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zipCall;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        ZipCall$execute$1 zipCall$execute$1 = new ZipCall$execute$1(this.this$0, continuation);
        zipCall$execute$1.L$0 = obj;
        return zipCall$execute$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ZipCall$execute$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r12.L$0
            io.getstream.chat.android.client.utils.Result r0 = (p015io.getstream.chat.android.client.utils.Result) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007b
        L_0x0017:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001f:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005a
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            r6 = 0
            r7 = 0
            io.getstream.chat.android.client.call.ZipCall$execute$1$deferredA$1 r1 = new io.getstream.chat.android.client.call.ZipCall$execute$1$deferredA$1
            r1.<init>(r12, r4)
            r8 = r1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r5 = r13
            kotlinx.coroutines.Deferred r1 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r5, r6, r7, r8, r9, r10)
            io.getstream.chat.android.client.call.ZipCall$execute$1$deferredB$1 r5 = new io.getstream.chat.android.client.call.ZipCall$execute$1$deferredB$1
            r5.<init>(r12, r4)
            r8 = r5
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r5 = r13
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r5, r6, r7, r8, r9, r10)
            r12.L$0 = r13
            r12.label = r3
            java.lang.Object r1 = r1.await(r12)
            if (r1 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r11 = r1
            r1 = r13
            r13 = r11
        L_0x005a:
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            boolean r5 = r13.isError()
            if (r5 == 0) goto L_0x006e
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r1, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
            io.getstream.chat.android.client.call.ZipCall r0 = r12.this$0
            io.getstream.chat.android.client.utils.Result r13 = r0.getErrorA(r13)
            return r13
        L_0x006e:
            r12.L$0 = r13
            r12.label = r2
            java.lang.Object r1 = r1.await(r12)
            if (r1 != r0) goto L_0x0079
            return r0
        L_0x0079:
            r0 = r13
            r13 = r1
        L_0x007b:
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            boolean r1 = r13.isError()
            if (r1 == 0) goto L_0x008a
            io.getstream.chat.android.client.call.ZipCall r0 = r12.this$0
            io.getstream.chat.android.client.utils.Result r13 = r0.getErrorB(r13)
            return r13
        L_0x008a:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Object r0 = r0.data()
            java.lang.Object r13 = r13.data()
            r2.<init>(r0, r13)
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.call.ZipCall$execute$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
