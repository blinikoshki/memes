package p015io.getstream.chat.android.livedata.repository.domain.channel;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006H@"}, mo26107d2 = {"selectChannels", "", "channelCIDs", "", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/Channel;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl", mo26808f = "ChannelRepository.kt", mo26809i = {0, 0, 1, 1, 1}, mo26810l = {58, 58}, mo26811m = "selectChannels", mo26812n = {"this", "cachedChannels", "this", "cachedChannels", "destination$iv$iv"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$selectChannels$1 */
/* compiled from: ChannelRepository.kt */
final class ChannelRepositoryImpl$selectChannels$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelRepositoryImpl$selectChannels$1(ChannelRepositoryImpl channelRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectChannels((List<String>) null, this);
    }
}
