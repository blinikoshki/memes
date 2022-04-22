package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, mo26107d2 = {"cacheChannelConfigs", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl", mo26808f = "ChannelConfigRepository.kt", mo26809i = {}, mo26810l = {25}, mo26811m = "cacheChannelConfigs", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepositoryImpl$cacheChannelConfigs$1 */
/* compiled from: ChannelConfigRepository.kt */
final class ChannelConfigRepositoryImpl$cacheChannelConfigs$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelConfigRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelConfigRepositoryImpl$cacheChannelConfigs$1(ChannelConfigRepositoryImpl channelConfigRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelConfigRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cacheChannelConfigs(this);
    }
}
