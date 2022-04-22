package p015io.getstream.chat.android.livedata;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$3 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$connectionRecovered$cids$3 extends Lambda implements Function1<Map.Entry<String, ChannelControllerImpl>, String> {
    public static final ChatDomainImpl$connectionRecovered$cids$3 INSTANCE = new ChatDomainImpl$connectionRecovered$cids$3();

    ChatDomainImpl$connectionRecovered$cids$3() {
        super(1);
    }

    public final String invoke(Map.Entry<String, ChannelControllerImpl> entry) {
        Intrinsics.checkNotNullParameter(entry, "it");
        return entry.getKey();
    }
}
