package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/socket/SocketListener;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$onSocketError$1 */
/* compiled from: ChatSocketServiceImpl.kt */
final class ChatSocketServiceImpl$onSocketError$1 extends Lambda implements Function1<SocketListener, Unit> {
    final /* synthetic */ ChatError $error;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSocketServiceImpl$onSocketError$1(ChatError chatError) {
        super(1);
        this.$error = chatError;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SocketListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, "it");
        socketListener.onError(this.$error);
    }
}
