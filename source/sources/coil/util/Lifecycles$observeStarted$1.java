package coil.util;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, mo26107d2 = {"observeStarted", "", "Landroidx/lifecycle/Lifecycle;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.util.-Lifecycles", mo26808f = "Lifecycles.kt", mo26809i = {0, 0}, mo26810l = {44}, mo26811m = "observeStarted", mo26812n = {"$this$observeStarted", "observer"}, mo26813s = {"L$0", "L$1"})
/* renamed from: coil.util.-Lifecycles$observeStarted$1  reason: invalid class name */
/* compiled from: Lifecycles.kt */
final class Lifecycles$observeStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    Lifecycles$observeStarted$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Lifecycles.observeStarted((Lifecycle) null, this);
    }
}
