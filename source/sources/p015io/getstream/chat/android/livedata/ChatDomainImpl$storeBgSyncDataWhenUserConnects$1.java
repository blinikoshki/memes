package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.socket.SocketListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"io/getstream/chat/android/livedata/ChatDomainImpl$storeBgSyncDataWhenUserConnects$1", "Lio/getstream/chat/android/client/socket/SocketListener;", "onConnected", "", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$storeBgSyncDataWhenUserConnects$1 */
/* compiled from: ChatDomainImpl.kt */
public final class ChatDomainImpl$storeBgSyncDataWhenUserConnects$1 extends SocketListener {
    final /* synthetic */ ChatDomainImpl this$0;

    ChatDomainImpl$storeBgSyncDataWhenUserConnects$1(ChatDomainImpl chatDomainImpl) {
        this.this$0 = chatDomainImpl;
    }

    public void onConnected(ConnectedEvent connectedEvent) {
        Intrinsics.checkNotNullParameter(connectedEvent, "event");
        this.this$0.storeBgSyncData();
        this.this$0.getClient$stream_chat_android_offline_release().removeSocketListener(this);
    }
}
