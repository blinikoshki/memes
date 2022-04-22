package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.network.NetworkStateProvider;
import p015io.getstream.chat.android.client.socket.ChatSocketServiceImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo26107d2 = {"io/getstream/chat/android/client/socket/ChatSocketServiceImpl$networkStateListener$1", "Lio/getstream/chat/android/client/network/NetworkStateProvider$NetworkStateListener;", "onConnected", "", "onDisconnected", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$networkStateListener$1 */
/* compiled from: ChatSocketServiceImpl.kt */
public final class ChatSocketServiceImpl$networkStateListener$1 implements NetworkStateProvider.NetworkStateListener {
    final /* synthetic */ ChatSocketServiceImpl this$0;

    ChatSocketServiceImpl$networkStateListener$1(ChatSocketServiceImpl chatSocketServiceImpl) {
        this.this$0 = chatSocketServiceImpl;
    }

    public void onConnected() {
        if (Intrinsics.areEqual((Object) this.this$0.getState$stream_chat_android_client_release(), (Object) ChatSocketServiceImpl.State.Disconnected.INSTANCE) || Intrinsics.areEqual((Object) this.this$0.getState$stream_chat_android_client_release(), (Object) ChatSocketServiceImpl.State.NetworkDisconnected.INSTANCE)) {
            this.this$0.logger.logI("network connected, reconnecting socket");
            ChatSocketServiceImpl chatSocketServiceImpl = this.this$0;
            chatSocketServiceImpl.reconnect(chatSocketServiceImpl.connectionConf);
        }
    }

    public void onDisconnected() {
        this.this$0.setState(ChatSocketServiceImpl.State.NetworkDisconnected.INSTANCE);
    }
}
