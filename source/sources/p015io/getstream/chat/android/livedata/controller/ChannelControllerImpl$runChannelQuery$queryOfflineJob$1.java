package p015io.getstream.chat.android.livedata.controller;

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
import p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOfflineJob$1", mo26808f = "ChannelControllerImpl.kt", mo26809i = {}, mo26810l = {510}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOfflineJob$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$runChannelQuery$queryOfflineJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Channel>, Object> {
    final /* synthetic */ QueryChannelPaginationRequest $pagination;
    int label;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$runChannelQuery$queryOfflineJob$1(ChannelControllerImpl channelControllerImpl, QueryChannelPaginationRequest queryChannelPaginationRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelControllerImpl;
        this.$pagination = queryChannelPaginationRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelControllerImpl$runChannelQuery$queryOfflineJob$1(this.this$0, this.$pagination, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelControllerImpl$runChannelQuery$queryOfflineJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelControllerImpl channelControllerImpl = this.this$0;
            QueryChannelPaginationRequest queryChannelPaginationRequest = this.$pagination;
            this.label = 1;
            obj = channelControllerImpl.runChannelQueryOffline(queryChannelPaginationRequest, this);
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
