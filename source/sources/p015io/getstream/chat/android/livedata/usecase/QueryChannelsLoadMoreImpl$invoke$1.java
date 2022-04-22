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
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/Channel;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.QueryChannelsLoadMoreImpl$invoke$1", mo26808f = "QueryChannelsLoadMoreImpl.kt", mo26809i = {}, mo26810l = {40}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannelsLoadMoreImpl$invoke$1 */
/* compiled from: QueryChannelsLoadMoreImpl.kt */
final class QueryChannelsLoadMoreImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<List<? extends Channel>>>, Object> {
    final /* synthetic */ FilterObject $filter;
    final /* synthetic */ int $limit;
    final /* synthetic */ int $messageLimit;
    final /* synthetic */ QuerySort $sort;
    int label;
    final /* synthetic */ QueryChannelsLoadMoreImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsLoadMoreImpl$invoke$1(QueryChannelsLoadMoreImpl queryChannelsLoadMoreImpl, FilterObject filterObject, QuerySort querySort, int i, int i2, Continuation continuation) {
        super(1, continuation);
        this.this$0 = queryChannelsLoadMoreImpl;
        this.$filter = filterObject;
        this.$sort = querySort;
        this.$limit = i;
        this.$messageLimit = i2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new QueryChannelsLoadMoreImpl$invoke$1(this.this$0, this.$filter, this.$sort, this.$limit, this.$messageLimit, continuation);
    }

    public final Object invoke(Object obj) {
        return ((QueryChannelsLoadMoreImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            QueryChannelsControllerImpl queryChannels = this.this$0.domainImpl.queryChannels(this.$filter, this.$sort);
            int i2 = this.$limit;
            int i3 = this.$messageLimit;
            this.label = 1;
            obj = queryChannels.loadMore(i2, i3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
