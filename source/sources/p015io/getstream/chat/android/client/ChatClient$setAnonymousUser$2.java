package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$setAnonymousUser$2 */
/* compiled from: ChatClient.kt */
final class ChatClient$setAnonymousUser$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChatClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatClient$setAnonymousUser$2(ChatClient chatClient) {
        super(0);
        this.this$0 = chatClient;
    }

    public final void invoke() {
        this.this$0.socket.connectAnonymously();
    }
}
