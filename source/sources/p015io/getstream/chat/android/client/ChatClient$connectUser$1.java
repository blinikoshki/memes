package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.token.TokenProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "initListener", "Lio/getstream/chat/android/client/socket/InitConnectionListener;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$connectUser$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$connectUser$1 extends Lambda implements Function1<InitConnectionListener, Unit> {
    final /* synthetic */ TokenProvider $tokenProvider;
    final /* synthetic */ User $user;
    final /* synthetic */ ChatClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatClient$connectUser$1(ChatClient chatClient, User user, TokenProvider tokenProvider) {
        super(1);
        this.this$0 = chatClient;
        this.$user = user;
        this.$tokenProvider = tokenProvider;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InitConnectionListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InitConnectionListener initConnectionListener) {
        Intrinsics.checkNotNullParameter(initConnectionListener, "initListener");
        this.this$0.setUser(this.$user, this.$tokenProvider, initConnectionListener);
    }
}
