package coil.intercept;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"proceed", "", "request", "Lcoil/request/ImageRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcoil/request/ImageResult;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.intercept.RealInterceptorChain", mo26808f = "RealInterceptorChain.kt", mo26809i = {0, 0}, mo26810l = {27}, mo26811m = "proceed", mo26812n = {"this", "interceptor"}, mo26813s = {"L$0", "L$1"})
/* compiled from: RealInterceptorChain.kt */
final class RealInterceptorChain$proceed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealInterceptorChain this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, Continuation continuation) {
        super(continuation);
        this.this$0 = realInterceptorChain;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.proceed((ImageRequest) null, this);
    }
}
