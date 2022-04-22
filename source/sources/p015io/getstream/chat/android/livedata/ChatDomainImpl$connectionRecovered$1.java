package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"connectionRecovered", "", "recoverAll", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.ChatDomainImpl", mo26808f = "ChatDomainImpl.kt", mo26809i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5}, mo26810l = {631, 647, 649, 680, 685, 688, 693}, mo26811m = "connectionRecovered", mo26812n = {"this", "recoverAll", "this", "updatedChannelIds", "queriesToRetry", "queryChannelController", "pagination", "recoverAll", "this", "updatedChannelIds", "queriesToRetry", "response", "recoverAll", "this", "cids", "missingChannelIds", "online", "this", "cids", "online", "this", "online"}, mo26813s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "Z$0", "L$0", "Z$0"})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$connectionRecovered$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatDomainImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$connectionRecovered$1(ChatDomainImpl chatDomainImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = chatDomainImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.connectionRecovered(false, this);
    }
}
