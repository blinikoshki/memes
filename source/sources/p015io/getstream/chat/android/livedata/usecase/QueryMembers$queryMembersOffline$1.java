package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\f0\u000bH@"}, mo26107d2 = {"queryMembersOffline", "", "cid", "", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Member;", "offset", "", "limit", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.QueryMembers", mo26808f = "QueryMembers.kt", mo26809i = {0, 0, 0}, mo26810l = {79}, mo26811m = "queryMembersOffline", mo26812n = {"sort", "clampedOffset", "clampedLimit"}, mo26813s = {"L$0", "I$0", "I$1"})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1 */
/* compiled from: QueryMembers.kt */
final class QueryMembers$queryMembersOffline$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryMembers this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryMembers$queryMembersOffline$1(QueryMembers queryMembers, Continuation continuation) {
        super(continuation);
        this.this$0 = queryMembers;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queryMembersOffline((String) null, (QuerySort<Member>) null, 0, 0, this);
    }
}
