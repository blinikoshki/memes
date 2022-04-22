package p015io.getstream.chat.android.livedata;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$2 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$connectionRecovered$cids$2 extends Lambda implements Function1<Map.Entry<String, ChannelControllerImpl>, Boolean> {
    final /* synthetic */ Set $updatedChannelIds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$connectionRecovered$cids$2(Set set) {
        super(1);
        this.$updatedChannelIds = set;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Map.Entry<String, ChannelControllerImpl>) (Map.Entry) obj));
    }

    public final boolean invoke(Map.Entry<String, ChannelControllerImpl> entry) {
        Intrinsics.checkNotNullParameter(entry, "it");
        return this.$updatedChannelIds.contains(entry.getKey());
    }
}
