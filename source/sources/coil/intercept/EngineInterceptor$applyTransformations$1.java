package coil.intercept;

import coil.EventListener;
import coil.decode.Options;
import coil.fetch.DrawableResult;
import coil.request.ImageRequest;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rHH"}, mo26107d2 = {"applyTransformations", "", "result", "Lcoil/fetch/DrawableResult;", "request", "Lcoil/request/ImageRequest;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "eventListener", "Lcoil/EventListener;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.intercept.EngineInterceptor", mo26808f = "EngineInterceptor.kt", mo26809i = {0, 0, 0, 0, 0, 0, 0}, mo26810l = {368}, mo26811m = "applyTransformations$coil_base_release", mo26812n = {"this", "result", "request", "size", "eventListener", "$this$foldIndices$iv", "i$iv"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
/* compiled from: EngineInterceptor.kt */
public final class EngineInterceptor$applyTransformations$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$applyTransformations$1(EngineInterceptor engineInterceptor, Continuation continuation) {
        super(continuation);
        this.this$0 = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.applyTransformations$coil_base_release((DrawableResult) null, (ImageRequest) null, (Size) null, (Options) null, (EventListener) null, this);
    }
}
