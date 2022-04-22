package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.livedata.model.ChannelConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H&J\u0019\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigRepository;", "", "cacheChannelConfigs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearChannelConfigsCache", "insertChannelConfig", "config", "Lio/getstream/chat/android/livedata/model/ChannelConfig;", "(Lio/getstream/chat/android/livedata/model/ChannelConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertChannelConfigs", "configs", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectChannelConfig", "channelType", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigRepository */
/* compiled from: ChannelConfigRepository.kt */
public interface ChannelConfigRepository {
    Object cacheChannelConfigs(Continuation<? super Unit> continuation);

    void clearChannelConfigsCache();

    Object insertChannelConfig(ChannelConfig channelConfig, Continuation<? super Unit> continuation);

    Object insertChannelConfigs(Collection<ChannelConfig> collection, Continuation<? super Unit> continuation);

    ChannelConfig selectChannelConfig(String str);
}
