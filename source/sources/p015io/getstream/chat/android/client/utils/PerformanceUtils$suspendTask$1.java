package p015io.getstream.chat.android.client.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H@"}, mo26107d2 = {"suspendTask", "", "T", "taskName", "", "task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "continuation"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.utils.PerformanceUtils", mo26808f = "PerformanceUtils.kt", mo26809i = {0, 0, 0}, mo26810l = {68}, mo26811m = "suspendTask", mo26812n = {"taskName", "count", "startTime"}, mo26813s = {"L$0", "I$0", "J$0"})
/* renamed from: io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1 */
/* compiled from: PerformanceUtils.kt */
final class PerformanceUtils$suspendTask$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PerformanceUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PerformanceUtils$suspendTask$1(PerformanceUtils performanceUtils, Continuation continuation) {
        super(continuation);
        this.this$0 = performanceUtils;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.suspendTask((String) null, (Function1) null, this);
    }
}
