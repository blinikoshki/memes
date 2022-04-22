package p015io.getstream.chat.android.livedata.repository;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.model.ChannelConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH@"}, mo26107d2 = {"storeStateForChannels", "", "configs", "", "Lio/getstream/chat/android/livedata/model/ChannelConfig;", "users", "", "Lio/getstream/chat/android/client/models/User;", "channels", "Lio/getstream/chat/android/client/models/Channel;", "messages", "Lio/getstream/chat/android/client/models/Message;", "cacheForMessages", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.RepositoryFacade", mo26808f = "RepositoryFacade.kt", mo26809i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, mo26810l = {92, 93, 94, 95}, mo26811m = "storeStateForChannels$stream_chat_android_offline_release", mo26812n = {"this", "users", "channels", "messages", "cacheForMessages", "this", "channels", "messages", "cacheForMessages", "this", "messages", "cacheForMessages"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "Z$0"})
/* renamed from: io.getstream.chat.android.livedata.repository.RepositoryFacade$storeStateForChannels$1 */
/* compiled from: RepositoryFacade.kt */
final class RepositoryFacade$storeStateForChannels$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepositoryFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepositoryFacade$storeStateForChannels$1(RepositoryFacade repositoryFacade, Continuation continuation) {
        super(continuation);
        this.this$0 = repositoryFacade;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.storeStateForChannels$stream_chat_android_offline_release((Collection<ChannelConfig>) null, (List<User>) null, (Collection<Channel>) null, (List<Message>) null, false, this);
    }
}
