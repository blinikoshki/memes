package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/ReplayEventsForActiveChannelsImpl;", "Lio/getstream/chat/android/livedata/usecase/ReplayEventsForActiveChannels;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "cid", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.ReplayEventsForActiveChannelsImpl */
/* compiled from: ReplayEventsForActiveChannelsImpl.kt */
public final class ReplayEventsForActiveChannelsImpl implements ReplayEventsForActiveChannels {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domainImpl;

    public ReplayEventsForActiveChannelsImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<List<ChatEvent>> invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "cid");
        ValidationKt.validateCid(str);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new ReplayEventsForActiveChannelsImpl$invoke$1(this, str, (Continuation) null));
    }
}
