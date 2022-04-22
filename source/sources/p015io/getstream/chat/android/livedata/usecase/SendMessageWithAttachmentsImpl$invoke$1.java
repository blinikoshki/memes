package p015io.getstream.chat.android.livedata.usecase;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Message;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$invoke$1", mo26808f = "SendMessageWithAttachmentsImpl.kt", mo26809i = {}, mo26810l = {49, 54}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$invoke$1 */
/* compiled from: SendMessageWithAttachmentsImpl.kt */
final class SendMessageWithAttachmentsImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<Message>>, Object> {
    final /* synthetic */ Function2 $attachmentTransformer;
    final /* synthetic */ ChannelControllerImpl $channelController;
    final /* synthetic */ List $files;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ SendMessageWithAttachmentsImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SendMessageWithAttachmentsImpl$invoke$1(SendMessageWithAttachmentsImpl sendMessageWithAttachmentsImpl, ChannelControllerImpl channelControllerImpl, List list, Function2 function2, Message message, Continuation continuation) {
        super(1, continuation);
        this.this$0 = sendMessageWithAttachmentsImpl;
        this.$channelController = channelControllerImpl;
        this.$files = list;
        this.$attachmentTransformer = function2;
        this.$message = message;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SendMessageWithAttachmentsImpl$invoke$1(this.this$0, this.$channelController, this.$files, this.$attachmentTransformer, this.$message, continuation);
    }

    public final Object invoke(Object obj) {
        return ((SendMessageWithAttachmentsImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SendMessageWithAttachmentsImpl sendMessageWithAttachmentsImpl = this.this$0;
            ChannelControllerImpl channelControllerImpl = this.$channelController;
            List list = this.$files;
            Function2 function2 = this.$attachmentTransformer;
            this.label = 1;
            obj = sendMessageWithAttachmentsImpl.uploadFiles(channelControllerImpl, list, function2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (Result) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result result = (Result) obj;
        if (result.isError()) {
            return new Result(result.error());
        }
        this.$message.getAttachments().addAll((Collection) result.data());
        ChannelControllerImpl channelControllerImpl2 = this.$channelController;
        Message message = this.$message;
        this.label = 2;
        obj = ChannelControllerImpl.sendMessage$default(channelControllerImpl2, message, (Function2) null, this, 2, (Object) null);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (Result) obj;
    }
}
