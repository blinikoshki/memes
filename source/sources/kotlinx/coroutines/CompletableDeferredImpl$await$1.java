package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, mo26107d2 = {"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 0})
@DebugMetadata(mo26807c = "kotlinx.coroutines.CompletableDeferredImpl", mo26808f = "CompletableDeferred.kt", mo26809i = {0}, mo26810l = {86}, mo26811m = "await", mo26812n = {"this"}, mo26813s = {"L$0"})
/* compiled from: CompletableDeferred.kt */
final class CompletableDeferredImpl$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CompletableDeferredImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompletableDeferredImpl$await$1(CompletableDeferredImpl completableDeferredImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = completableDeferredImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(this);
    }
}
