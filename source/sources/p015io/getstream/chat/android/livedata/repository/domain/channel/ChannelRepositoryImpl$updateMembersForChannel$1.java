package p015io.getstream.chat.android.livedata.repository.domain.channel;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH@"}, mo26107d2 = {"updateMembersForChannel", "", "cid", "", "members", "", "Lio/getstream/chat/android/client/models/Member;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl", mo26808f = "ChannelRepository.kt", mo26809i = {0, 0}, mo26810l = {93, 96}, mo26811m = "updateMembersForChannel", mo26812n = {"this", "memberMap"}, mo26813s = {"L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.ChannelRepositoryImpl$updateMembersForChannel$1 */
/* compiled from: ChannelRepository.kt */
final class ChannelRepositoryImpl$updateMembersForChannel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelRepositoryImpl$updateMembersForChannel$1(ChannelRepositoryImpl channelRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateMembersForChannel((String) null, (List<Member>) null, this);
    }
}
