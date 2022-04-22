package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH@"}, mo26107d2 = {"loadMessageById", "", "messageId", "", "newerMessagesOffset", "", "olderMessagesOffset", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Message;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl", mo26808f = "ChannelControllerImpl.kt", mo26809i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, mo26810l = {1492, 1498, 1499}, mo26811m = "loadMessageById$stream_chat_android_offline_release", mo26812n = {"this", "messageId", "newerMessagesOffset", "olderMessagesOffset", "this", "messageId", "message", "olderMessagesOffset", "message"}, mo26813s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$loadMessageById$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$loadMessageById$1(ChannelControllerImpl channelControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadMessageById$stream_chat_android_offline_release((String) null, 0, 0, this);
    }
}
