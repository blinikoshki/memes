package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, mo26107d2 = {"clearSource", "", "T", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "androidx.lifecycle.CoroutineLiveData", mo26808f = "CoroutineLiveData.kt", mo26809i = {0}, mo26810l = {234}, mo26811m = "clearSource$lifecycle_livedata_ktx_release", mo26812n = {"this"}, mo26813s = {"L$0"})
/* compiled from: CoroutineLiveData.kt */
final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineLiveData$clearSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
