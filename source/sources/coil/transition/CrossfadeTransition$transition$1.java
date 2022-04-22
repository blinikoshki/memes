package coil.transition;

import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo26107d2 = {"transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.transition.CrossfadeTransition", mo26808f = "CrossfadeTransition.kt", mo26809i = {0}, mo26810l = {100}, mo26811m = "transition", mo26812n = {"outerCrossfade"}, mo26813s = {"L$3"})
/* compiled from: CrossfadeTransition.kt */
final class CrossfadeTransition$transition$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CrossfadeTransition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CrossfadeTransition$transition$1(CrossfadeTransition crossfadeTransition, Continuation continuation) {
        super(continuation);
        this.this$0 = crossfadeTransition;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transition((TransitionTarget) null, (ImageResult) null, this);
    }
}
