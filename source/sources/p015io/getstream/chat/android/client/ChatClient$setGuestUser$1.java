package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.GuestUser;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/GuestUser;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$setGuestUser$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$setGuestUser$1<T> implements Call.Callback<GuestUser> {
    final /* synthetic */ InitConnectionListener $listener;
    final /* synthetic */ ChatClient this$0;

    ChatClient$setGuestUser$1(ChatClient chatClient, InitConnectionListener initConnectionListener) {
        this.this$0 = chatClient;
        this.$listener = initConnectionListener;
    }

    public final void onResult(Result<GuestUser> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        if (result.isSuccess()) {
            this.this$0.setUser(result.data().getUser(), result.data().getToken(), this.$listener);
            return;
        }
        InitConnectionListener initConnectionListener = this.$listener;
        if (initConnectionListener != null) {
            initConnectionListener.onError(result.error());
        }
    }
}
