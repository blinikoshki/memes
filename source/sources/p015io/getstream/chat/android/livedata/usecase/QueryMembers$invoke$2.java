package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/Member;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.QueryMembers$invoke$2", mo26808f = "QueryMembers.kt", mo26809i = {}, mo26810l = {40, 42}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryMembers$invoke$2 */
/* compiled from: QueryMembers.kt */
final class QueryMembers$invoke$2 extends SuspendLambda implements Function1<Continuation<? super Result<List<? extends Member>>>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ FilterObject $filter;
    final /* synthetic */ int $limit;
    final /* synthetic */ List $members;
    final /* synthetic */ int $offset;
    final /* synthetic */ QuerySort $sort;
    int label;
    final /* synthetic */ QueryMembers this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryMembers$invoke$2(QueryMembers queryMembers, String str, QuerySort querySort, int i, int i2, FilterObject filterObject, List list, Continuation continuation) {
        super(1, continuation);
        this.this$0 = queryMembers;
        this.$cid = str;
        this.$sort = querySort;
        this.$offset = i;
        this.$limit = i2;
        this.$filter = filterObject;
        this.$members = list;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new QueryMembers$invoke$2(this.this$0, this.$cid, this.$sort, this.$offset, this.$limit, this.$filter, this.$members, continuation);
    }

    public final Object invoke(Object obj) {
        return ((QueryMembers$invoke$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.domainImpl.isOffline()) {
                QueryMembers queryMembers = this.this$0;
                String str = this.$cid;
                QuerySort querySort = this.$sort;
                int i2 = this.$offset;
                int i3 = this.$limit;
                this.label = 1;
                obj = queryMembers.queryMembersOffline(str, querySort, i2, i3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                QueryMembers queryMembers2 = this.this$0;
                String str2 = this.$cid;
                int i4 = this.$offset;
                int i5 = this.$limit;
                FilterObject filterObject = this.$filter;
                QuerySort querySort2 = this.$sort;
                List list = this.$members;
                this.label = 2;
                obj = queryMembers2.queryMembersOnline(str2, i4, i5, filterObject, querySort2, list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (Result) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (Result) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (Result) obj;
    }
}
