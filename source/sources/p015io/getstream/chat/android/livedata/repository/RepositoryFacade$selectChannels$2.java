package p015io.getstream.chat.android.livedata.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\bH@"}, mo26107d2 = {"selectChannels", "", "channelIds", "", "", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/Channel;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.RepositoryFacade", mo26808f = "RepositoryFacade.kt", mo26809i = {0, 0, 0, 1, 1}, mo26810l = {49, 122}, mo26811m = "selectChannels$stream_chat_android_offline_release", mo26812n = {"this", "channelIds", "pagination", "this", "channels"}, mo26813s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.RepositoryFacade$selectChannels$2 */
/* compiled from: RepositoryFacade.kt */
final class RepositoryFacade$selectChannels$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepositoryFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepositoryFacade$selectChannels$2(RepositoryFacade repositoryFacade, Continuation continuation) {
        super(continuation);
        this.this$0 = repositoryFacade;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectChannels$stream_chat_android_offline_release((List<String>) null, (AnyChannelPaginationRequest) null, this);
    }
}
