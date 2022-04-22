package p015io.getstream.chat.android.client;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo26107d2 = {"io/getstream/chat/android/client/ChatClient$lifecycleObserver$1", "Lio/getstream/chat/android/client/LifecycleHandler;", "resume", "", "stopped", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$lifecycleObserver$1 */
/* compiled from: ChatClient.kt */
public final class ChatClient$lifecycleObserver$1 implements LifecycleHandler {
    final /* synthetic */ ChatClient this$0;

    ChatClient$lifecycleObserver$1(ChatClient chatClient) {
        this.this$0 = chatClient;
    }

    public void resume() {
        this.this$0.reconnectSocket();
    }

    public void stopped() {
        this.this$0.disconnectSocket();
    }
}
