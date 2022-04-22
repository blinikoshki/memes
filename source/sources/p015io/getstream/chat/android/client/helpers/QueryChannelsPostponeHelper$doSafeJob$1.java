package p015io.getstream.chat.android.client.helpers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0007H@"}, mo26107d2 = {"doSafeJob", "", "T", "job", "Lkotlin/Function0;", "Lio/getstream/chat/android/client/call/Call;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper", mo26808f = "QueryChannelsPostponeHelper.kt", mo26809i = {}, mo26810l = {37}, mo26811m = "doSafeJob", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1 */
/* compiled from: QueryChannelsPostponeHelper.kt */
final class QueryChannelsPostponeHelper$doSafeJob$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryChannelsPostponeHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsPostponeHelper$doSafeJob$1(QueryChannelsPostponeHelper queryChannelsPostponeHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = queryChannelsPostponeHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doSafeJob((Function0) null, this);
    }
}
