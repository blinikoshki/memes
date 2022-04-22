package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H@"}, mo26107d2 = {"runChannelQueryOffline", "", "pagination", "Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/Channel;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl", mo26808f = "ChannelControllerImpl.kt", mo26809i = {0}, mo26810l = {541}, mo26811m = "runChannelQueryOffline", mo26812n = {"this"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$runChannelQueryOffline$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$runChannelQueryOffline$1(ChannelControllerImpl channelControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runChannelQueryOffline((QueryChannelPaginationRequest) null, this);
    }
}
