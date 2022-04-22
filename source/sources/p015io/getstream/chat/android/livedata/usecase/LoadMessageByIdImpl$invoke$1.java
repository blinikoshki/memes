package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Message;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.LoadMessageByIdImpl$invoke$1", mo26808f = "LoadMessageByIdImpl.kt", mo26809i = {}, mo26810l = {39}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.LoadMessageByIdImpl$invoke$1 */
/* compiled from: LoadMessageByIdImpl.kt */
final class LoadMessageByIdImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<Message>>, Object> {
    final /* synthetic */ ChannelControllerImpl $channelController;
    final /* synthetic */ String $messageId;
    final /* synthetic */ int $newerMessagesOffset;
    final /* synthetic */ int $olderMessagesOffset;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadMessageByIdImpl$invoke$1(ChannelControllerImpl channelControllerImpl, String str, int i, int i2, Continuation continuation) {
        super(1, continuation);
        this.$channelController = channelControllerImpl;
        this.$messageId = str;
        this.$newerMessagesOffset = i;
        this.$olderMessagesOffset = i2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LoadMessageByIdImpl$invoke$1(this.$channelController, this.$messageId, this.$newerMessagesOffset, this.$olderMessagesOffset, continuation);
    }

    public final Object invoke(Object obj) {
        return ((LoadMessageByIdImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelControllerImpl channelControllerImpl = this.$channelController;
            String str = this.$messageId;
            int i2 = this.$newerMessagesOffset;
            int i3 = this.$olderMessagesOffset;
            this.label = 1;
            obj = channelControllerImpl.loadMessageById$stream_chat_android_offline_release(str, i2, i3, this);
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
