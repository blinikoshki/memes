package coil.intercept;

import coil.intercept.Interceptor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"intercept", "", "chain", "Lcoil/intercept/Interceptor$Chain;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcoil/request/ImageResult;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.intercept.EngineInterceptor", mo26808f = "EngineInterceptor.kt", mo26809i = {0, 0}, mo26810l = {108}, mo26811m = "intercept", mo26812n = {"this", "chain"}, mo26813s = {"L$0", "L$1"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$intercept$1(EngineInterceptor engineInterceptor, Continuation continuation) {
        super(continuation);
        this.this$0 = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.intercept((Interceptor.Chain) null, this);
    }
}
