package p015io.getstream.chat.android.client.helpers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bHP"}, mo26107d2 = {"doJob", "", "T", "attemptCount", "", "job", "Lkotlin/Function0;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper", mo26808f = "QueryChannelsPostponeHelper.kt", mo26809i = {0, 0, 0}, mo26810l = {52}, mo26811m = "doJob", mo26812n = {"this", "job", "attemptCount"}, mo26813s = {"L$0", "L$1", "I$0"})
/* renamed from: io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1 */
/* compiled from: QueryChannelsPostponeHelper.kt */
final class QueryChannelsPostponeHelper$doJob$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryChannelsPostponeHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsPostponeHelper$doJob$1(QueryChannelsPostponeHelper queryChannelsPostponeHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = queryChannelsPostponeHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doJob(0, (Function0) null, this);
    }
}
