package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006H@"}, mo26107d2 = {"selectQueriesChannelsByIds", "", "ids", "", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl", mo26808f = "QueryChannelsRepository.kt", mo26809i = {}, mo26810l = {30}, mo26811m = "selectQueriesChannelsByIds", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1 */
/* compiled from: QueryChannelsRepository.kt */
final class QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryChannelsRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsRepositoryImpl$selectQueriesChannelsByIds$1(QueryChannelsRepositoryImpl queryChannelsRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = queryChannelsRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectQueriesChannelsByIds((List<String>) null, this);
    }
}
