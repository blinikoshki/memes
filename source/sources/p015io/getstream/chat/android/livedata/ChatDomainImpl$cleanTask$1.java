package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo26107d2 = {"io/getstream/chat/android/livedata/ChatDomainImpl$cleanTask$1", "Ljava/lang/Runnable;", "run", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$cleanTask$1 */
/* compiled from: ChatDomainImpl.kt */
public final class ChatDomainImpl$cleanTask$1 implements Runnable {
    final /* synthetic */ ChatDomainImpl this$0;

    ChatDomainImpl$cleanTask$1(ChatDomainImpl chatDomainImpl) {
        this.this$0 = chatDomainImpl;
    }

    public void run() {
        this.this$0.clean();
        this.this$0.mainHandler.postDelayed(this, 1000);
    }
}
