package p015io.getstream.chat.android.livedata.controller;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.controller.ChannelController;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@¢\u0006\u0004\b\u0007\u0010\b"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "loading", "", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl$_messagesState$1", mo26808f = "ChannelControllerImpl.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$_messagesState$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$_messagesState$1 extends SuspendLambda implements Function3<Boolean, List<? extends Message>, Continuation<? super ChannelController.MessagesState>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ boolean Z$0;
    int label;

    ChannelControllerImpl$_messagesState$1(Continuation continuation) {
        super(3, continuation);
    }

    public final Continuation<Unit> create(boolean z, List<Message> list, Continuation<? super ChannelController.MessagesState> continuation) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        ChannelControllerImpl$_messagesState$1 channelControllerImpl$_messagesState$1 = new ChannelControllerImpl$_messagesState$1(continuation);
        channelControllerImpl$_messagesState$1.Z$0 = z;
        channelControllerImpl$_messagesState$1.L$0 = list;
        return channelControllerImpl$_messagesState$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((ChannelControllerImpl$_messagesState$1) create(((Boolean) obj).booleanValue(), (List) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            List list = (List) this.L$0;
            if (z) {
                return ChannelController.MessagesState.Loading.INSTANCE;
            }
            if (list.isEmpty()) {
                return ChannelController.MessagesState.OfflineNoResults.INSTANCE;
            }
            return new ChannelController.MessagesState.Result(list);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
