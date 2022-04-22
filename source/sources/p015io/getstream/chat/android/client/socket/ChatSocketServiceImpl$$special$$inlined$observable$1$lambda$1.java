package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.socket.ChatSocketServiceImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/socket/SocketListener;", "invoke", "io/getstream/chat/android/client/socket/ChatSocketServiceImpl$state$2$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$$special$$inlined$observable$1$lambda$1 */
/* compiled from: ChatSocketServiceImpl.kt */
final class ChatSocketServiceImpl$$special$$inlined$observable$1$lambda$1 extends Lambda implements Function1<SocketListener, Unit> {
    final /* synthetic */ ChatSocketServiceImpl.State $newState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSocketServiceImpl$$special$$inlined$observable$1$lambda$1(ChatSocketServiceImpl.State state) {
        super(1);
        this.$newState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SocketListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, "it");
        socketListener.onConnected(((ChatSocketServiceImpl.State.Connected) this.$newState).getEvent());
    }
}
