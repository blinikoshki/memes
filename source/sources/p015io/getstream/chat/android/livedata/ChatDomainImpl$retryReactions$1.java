package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H@"}, mo26107d2 = {"retryReactions", "", "continuation", "Lkotlin/coroutines/Continuation;", "", "Lio/getstream/chat/android/client/models/Reaction;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.ChatDomainImpl", mo26808f = "ChatDomainImpl.kt", mo26809i = {0, 1, 2}, mo26810l = {756, 766, 769}, mo26811m = "retryReactions$stream_chat_android_offline_release", mo26812n = {"this", "this", "this"}, mo26813s = {"L$0", "L$0", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$retryReactions$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatDomainImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$retryReactions$1(ChatDomainImpl chatDomainImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = chatDomainImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retryReactions$stream_chat_android_offline_release(this);
    }
}
