package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.livedata.ChatDomain;
import p015io.getstream.chat.android.livedata.service.sync.SyncProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomain$Builder$syncModule$2 */
/* compiled from: ChatDomain.kt */
final class ChatDomain$Builder$syncModule$2 extends Lambda implements Function0<SyncProvider> {
    final /* synthetic */ ChatDomain.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomain$Builder$syncModule$2(ChatDomain.Builder builder) {
        super(0);
        this.this$0 = builder;
    }

    public final SyncProvider invoke() {
        return new SyncProvider(this.this$0.appContext);
    }
}
