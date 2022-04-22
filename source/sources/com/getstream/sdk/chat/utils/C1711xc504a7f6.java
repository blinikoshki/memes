package com.getstream.sdk.chat.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/getstream/sdk/chat/utils/StartStopBuffer$propagateData$1$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1$1$1", mo26808f = "StartStopBuffer.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.getstream.sdk.chat.utils.StartStopBuffer$propagateData$1$invokeSuspend$$inlined$let$lambda$1 */
/* compiled from: StartStopBuffer.kt */
final class C1711xc504a7f6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $it;
    int label;
    final /* synthetic */ StartStopBuffer$propagateData$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1711xc504a7f6(Object obj, Continuation continuation, StartStopBuffer$propagateData$1 startStopBuffer$propagateData$1) {
        super(2, continuation);
        this.$it = obj;
        this.this$0 = startStopBuffer$propagateData$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new C1711xc504a7f6(this.$it, continuation, this.this$0);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C1711xc504a7f6) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function1 access$getFunc$p = this.this$0.this$0.func;
            if (access$getFunc$p != null) {
                return (Unit) access$getFunc$p.invoke(this.$it);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
