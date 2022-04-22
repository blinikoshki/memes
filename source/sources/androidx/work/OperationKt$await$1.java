package androidx.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HH"}, mo26107d2 = {"await", "", "Landroidx/work/Operation;", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/work/Operation$State$SUCCESS;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "androidx.work.OperationKt", mo26808f = "Operation.kt", mo26809i = {}, mo26810l = {39}, mo26811m = "await", mo26812n = {}, mo26813s = {})
/* compiled from: Operation.kt */
public final class OperationKt$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public OperationKt$await$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await((Operation) null, this);
    }
}
