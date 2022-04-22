package p015io.getstream.chat.android.livedata.controller;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOnlineJob$1", mo26808f = "QueryChannelsControllerImpl.kt", mo26809i = {}, mo26810l = {235}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQuery$queryOnlineJob$1 */
/* compiled from: QueryChannelsControllerImpl.kt */
final class QueryChannelsControllerImpl$runQuery$queryOnlineJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<List<? extends Channel>>>, Object> {
    final /* synthetic */ QueryChannelsPaginationRequest $pagination;
    int label;
    final /* synthetic */ QueryChannelsControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsControllerImpl$runQuery$queryOnlineJob$1(QueryChannelsControllerImpl queryChannelsControllerImpl, QueryChannelsPaginationRequest queryChannelsPaginationRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = queryChannelsControllerImpl;
        this.$pagination = queryChannelsPaginationRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new QueryChannelsControllerImpl$runQuery$queryOnlineJob$1(this.this$0, this.$pagination, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((QueryChannelsControllerImpl$runQuery$queryOnlineJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            QueryChannelsControllerImpl queryChannelsControllerImpl = this.this$0;
            QueryChannelsPaginationRequest queryChannelsPaginationRequest = this.$pagination;
            this.label = 1;
            obj = queryChannelsControllerImpl.runQueryOnline(queryChannelsPaginationRequest, this);
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
