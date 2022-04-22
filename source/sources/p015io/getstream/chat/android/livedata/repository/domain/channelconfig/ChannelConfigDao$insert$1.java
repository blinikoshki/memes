package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo26107d2 = {"insert", "", "channelConfigEntities", "", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigEntity;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao", mo26808f = "ChannelConfigDao.kt", mo26809i = {0, 0}, mo26810l = {39, 43}, mo26811m = "insert$suspendImpl", mo26812n = {"this", "channelConfigEntities"}, mo26813s = {"L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigDao$insert$1 */
/* compiled from: ChannelConfigDao.kt */
final class ChannelConfigDao$insert$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelConfigDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelConfigDao$insert$1(ChannelConfigDao channelConfigDao, Continuation continuation) {
        super(continuation);
        this.this$0 = channelConfigDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelConfigDao.insert$suspendImpl(this.this$0, (List) null, (Continuation) this);
    }
}
