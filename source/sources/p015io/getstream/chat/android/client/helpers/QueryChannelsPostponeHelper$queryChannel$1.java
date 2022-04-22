package p015io.getstream.chat.android.client.helpers;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$queryChannel$1", mo26808f = "QueryChannelsPostponeHelper.kt", mo26809i = {}, mo26810l = {28}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$queryChannel$1 */
/* compiled from: QueryChannelsPostponeHelper.kt */
final class QueryChannelsPostponeHelper$queryChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Call<Channel>>, Object> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $channelType;
    final /* synthetic */ QueryChannelRequest $request;
    int label;
    final /* synthetic */ QueryChannelsPostponeHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsPostponeHelper$queryChannel$1(QueryChannelsPostponeHelper queryChannelsPostponeHelper, String str, String str2, QueryChannelRequest queryChannelRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = queryChannelsPostponeHelper;
        this.$channelType = str;
        this.$channelId = str2;
        this.$request = queryChannelRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new QueryChannelsPostponeHelper$queryChannel$1(this.this$0, this.$channelType, this.$channelId, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((QueryChannelsPostponeHelper$queryChannel$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.doSafeJob(new Function0<Call<Channel>>(this) {
                final /* synthetic */ QueryChannelsPostponeHelper$queryChannel$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final Call<Channel> invoke() {
                    return this.this$0.this$0.api.queryChannel(this.this$0.$channelType, this.this$0.$channelId, this.this$0.$request);
                }
            }, this);
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
