package coil.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, mo26107d2 = {"await", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.request.ViewTargetDisposable", mo26808f = "Disposable.kt", mo26809i = {}, mo26810l = {75}, mo26811m = "await", mo26812n = {}, mo26813s = {})
/* compiled from: Disposable.kt */
final class ViewTargetDisposable$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewTargetDisposable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewTargetDisposable$await$1(ViewTargetDisposable viewTargetDisposable, Continuation continuation) {
        super(continuation);
        this.this$0 = viewTargetDisposable;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(this);
    }
}
