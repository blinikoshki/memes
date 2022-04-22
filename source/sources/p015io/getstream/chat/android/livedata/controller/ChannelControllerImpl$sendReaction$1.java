package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0007H@"}, mo26107d2 = {"sendReaction", "", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "enforceUnique", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl", mo26808f = "ChannelControllerImpl.kt", mo26809i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 5}, mo26810l = {883, 886, 892, 896, 899, 912}, mo26811m = "sendReaction", mo26812n = {"this", "reaction", "enforceUnique", "online", "this", "reaction", "enforceUnique", "online", "this", "reaction", "enforceUnique", "online", "this", "reaction", "result", "result"}, mo26813s = {"L$0", "L$1", "Z$0", "Z$1", "L$0", "L$1", "Z$0", "Z$1", "L$0", "L$1", "Z$0", "Z$1", "L$0", "L$1", "L$0", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$sendReaction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$sendReaction$1(ChannelControllerImpl channelControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendReaction((Reaction) null, false, this);
    }
}
