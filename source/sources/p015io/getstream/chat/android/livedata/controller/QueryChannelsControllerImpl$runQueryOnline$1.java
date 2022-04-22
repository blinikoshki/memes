package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0005H@"}, mo26107d2 = {"runQueryOnline", "", "pagination", "Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/Channel;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl", mo26808f = "QueryChannelsControllerImpl.kt", mo26809i = {0, 0, 0, 0, 1, 1, 1, 2}, mo26810l = {196, 199, 200}, mo26811m = "runQueryOnline", mo26812n = {"this", "pagination", "response", "channelsResponse", "this", "response", "channelsResponse", "response"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$runQueryOnline$1 */
/* compiled from: QueryChannelsControllerImpl.kt */
final class QueryChannelsControllerImpl$runQueryOnline$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryChannelsControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsControllerImpl$runQueryOnline$1(QueryChannelsControllerImpl queryChannelsControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = queryChannelsControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runQueryOnline((QueryChannelsPaginationRequest) null, this);
    }
}
