package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"io/getstream/chat/android/client/ChatClient$setAnonymousUser$1", "Lio/getstream/chat/android/client/socket/InitConnectionListener;", "onError", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onSuccess", "data", "Lio/getstream/chat/android/client/socket/InitConnectionListener$ConnectionData;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$setAnonymousUser$1 */
/* compiled from: ChatClient.kt */
public final class ChatClient$setAnonymousUser$1 extends InitConnectionListener {
    final /* synthetic */ InitConnectionListener $listener;
    final /* synthetic */ ChatClient this$0;

    ChatClient$setAnonymousUser$1(ChatClient chatClient, InitConnectionListener initConnectionListener) {
        this.this$0 = chatClient;
        this.$listener = initConnectionListener;
    }

    public void onSuccess(InitConnectionListener.ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(connectionData, "data");
        this.this$0.notifySetUser(connectionData.getUser());
        InitConnectionListener initConnectionListener = this.$listener;
        if (initConnectionListener != null) {
            initConnectionListener.onSuccess(connectionData);
        }
    }

    public void onError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        InitConnectionListener initConnectionListener = this.$listener;
        if (initConnectionListener != null) {
            initConnectionListener.onError(chatError);
        }
    }
}
