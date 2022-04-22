package p015io.getstream.chat.android.livedata.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lio/getstream/chat/android/client/models/Message;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "io/getstream/chat/android/livedata/repository/RepositoryFacade$selectChannels$messagesMap$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$messagesMap$1$1", mo26808f = "RepositoryFacade.kt", mo26809i = {}, mo26810l = {55}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$$inlined$map$lambda$1 */
/* compiled from: RepositoryFacade.kt */
final class RepositoryFacade$selectChannels$$inlined$map$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends List<? extends Message>>>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ AnyChannelPaginationRequest $pagination$inlined;
    Object L$0;
    int label;
    final /* synthetic */ RepositoryFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepositoryFacade$selectChannels$$inlined$map$lambda$1(String str, Continuation continuation, RepositoryFacade repositoryFacade, AnyChannelPaginationRequest anyChannelPaginationRequest) {
        super(2, continuation);
        this.$cid = str;
        this.this$0 = repositoryFacade;
        this.$pagination$inlined = anyChannelPaginationRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RepositoryFacade$selectChannels$$inlined$map$lambda$1(this.$cid, continuation, this.this$0, this.$pagination$inlined);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RepositoryFacade$selectChannels$$inlined$map$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.$cid;
            RepositoryFacade repositoryFacade = this.this$0;
            AnyChannelPaginationRequest anyChannelPaginationRequest = this.$pagination$inlined;
            this.L$0 = str2;
            this.label = 1;
            Object selectMessagesForChannel = repositoryFacade.selectMessagesForChannel(str2, anyChannelPaginationRequest, this);
            if (selectMessagesForChannel == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str2;
            obj = selectMessagesForChannel;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return TuplesKt.m181to(str, obj);
    }
}
