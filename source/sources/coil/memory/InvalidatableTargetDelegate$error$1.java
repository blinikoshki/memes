package coil.memory;

import coil.request.ErrorResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"error", "", "result", "Lcoil/request/ErrorResult;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.memory.InvalidatableTargetDelegate", mo26808f = "TargetDelegate.kt", mo26809i = {0, 0}, mo26810l = {251}, mo26811m = "error", mo26812n = {"result", "eventListener$iv"}, mo26813s = {"L$0", "L$1"})
/* compiled from: TargetDelegate.kt */
final class InvalidatableTargetDelegate$error$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InvalidatableTargetDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvalidatableTargetDelegate$error$1(InvalidatableTargetDelegate invalidatableTargetDelegate, Continuation continuation) {
        super(continuation);
        this.this$0 = invalidatableTargetDelegate;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.error((ErrorResult) null, this);
    }
}
