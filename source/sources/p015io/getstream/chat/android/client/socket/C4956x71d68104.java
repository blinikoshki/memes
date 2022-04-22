package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, mo26107d2 = {"<anonymous>", "", "run", "io/getstream/chat/android/client/socket/ChatSocketServiceImpl$callListeners$1$1$1", "io/getstream/chat/android/client/socket/ChatSocketServiceImpl$$special$$inlined$forEach$lambda$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$callListeners$$inlined$synchronized$lambda$1 */
/* compiled from: ChatSocketServiceImpl.kt */
final class C4956x71d68104 implements Runnable {
    final /* synthetic */ Function1 $call$inlined;
    final /* synthetic */ SocketListener $listener;
    final /* synthetic */ ChatSocketServiceImpl this$0;

    C4956x71d68104(SocketListener socketListener, ChatSocketServiceImpl chatSocketServiceImpl, Function1 function1) {
        this.$listener = socketListener;
        this.this$0 = chatSocketServiceImpl;
        this.$call$inlined = function1;
    }

    public final void run() {
        this.$call$inlined.invoke(this.$listener);
    }
}
