package p015io.getstream.chat.android.livedata.usecase;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Landroidx/lifecycle/LiveData;", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.GetUnreadChannelCountImpl$invoke$1", mo26808f = "GetUnreadChannelCountImpl.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.GetUnreadChannelCountImpl$invoke$1 */
/* compiled from: GetUnreadChannelCountImpl.kt */
final class GetUnreadChannelCountImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<LiveData<Integer>>>, Object> {
    int label;
    final /* synthetic */ GetUnreadChannelCountImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetUnreadChannelCountImpl$invoke$1(GetUnreadChannelCountImpl getUnreadChannelCountImpl, Continuation continuation) {
        super(1, continuation);
        this.this$0 = getUnreadChannelCountImpl;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new GetUnreadChannelCountImpl$invoke$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj) {
        return ((GetUnreadChannelCountImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new Result(this.this$0.domainImpl.getChannelUnreadCount());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
