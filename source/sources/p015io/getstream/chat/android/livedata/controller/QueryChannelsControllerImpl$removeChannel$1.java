package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"removeChannel", "", "cid", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl", mo26808f = "QueryChannelsControllerImpl.kt", mo26809i = {0, 0, 1, 1}, mo26810l = {286, 288}, mo26811m = "removeChannel$stream_chat_android_offline_release", mo26812n = {"this", "cid", "this", "cid"}, mo26813s = {"L$0", "L$1", "L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$removeChannel$1 */
/* compiled from: QueryChannelsControllerImpl.kt */
final class QueryChannelsControllerImpl$removeChannel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryChannelsControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsControllerImpl$removeChannel$1(QueryChannelsControllerImpl queryChannelsControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = queryChannelsControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeChannel$stream_chat_android_offline_release((String) null, this);
    }
}
