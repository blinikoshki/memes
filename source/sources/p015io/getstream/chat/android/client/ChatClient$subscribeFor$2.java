package p015io.getstream.chat.android.client;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.utils.observable.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, mo26107d2 = {"io/getstream/chat/android/client/ChatClient$subscribeFor$2", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$subscribeFor$2 */
/* compiled from: ChatClient.kt */
public final class ChatClient$subscribeFor$2 implements LifecycleObserver {
    final /* synthetic */ Disposable $disposable;

    ChatClient$subscribeFor$2(Disposable disposable) {
        this.$disposable = disposable;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.$disposable.dispose();
    }
}
