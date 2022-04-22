package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.ConnectionData;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"io/getstream/chat/android/client/ChatClient$createInitListenerCall$1$enqueue$1", "Lio/getstream/chat/android/client/socket/InitConnectionListener;", "onError", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onSuccess", "data", "Lio/getstream/chat/android/client/socket/InitConnectionListener$ConnectionData;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$createInitListenerCall$1$enqueue$1 */
/* compiled from: ChatClient.kt */
public final class ChatClient$createInitListenerCall$1$enqueue$1 extends InitConnectionListener {
    final /* synthetic */ Call.Callback $callback;

    ChatClient$createInitListenerCall$1$enqueue$1(Call.Callback callback) {
        this.$callback = callback;
    }

    public void onSuccess(InitConnectionListener.ConnectionData connectionData) {
        Intrinsics.checkNotNullParameter(connectionData, "data");
        this.$callback.onResult(new Result(new ConnectionData(connectionData.getUser(), connectionData.getConnectionId())));
    }

    public void onError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        this.$callback.onResult(new Result(chatError));
    }
}
