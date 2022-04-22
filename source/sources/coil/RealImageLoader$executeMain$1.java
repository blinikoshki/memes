package coil;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo26107d2 = {"executeMain", "", "initialRequest", "Lcoil/request/ImageRequest;", "type", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcoil/request/ImageResult;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.RealImageLoader", mo26808f = "RealImageLoader.kt", mo26809i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6}, mo26810l = {290, 179, 298, 300, 311, 328, 339}, mo26811m = "executeMain", mo26812n = {"this", "request", "eventListener", "targetDelegate", "requestDelegate", "type", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "cached", "type", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "result", "this_$iv", "request$iv", "metadata$iv", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "result", "request$iv", "eventListener", "requestDelegate", "result", "request$iv"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: RealImageLoader.kt */
final class RealImageLoader$executeMain$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$executeMain$1(RealImageLoader realImageLoader, Continuation continuation) {
        super(continuation);
        this.this$0 = realImageLoader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeMain((ImageRequest) null, 0, this);
    }
}
