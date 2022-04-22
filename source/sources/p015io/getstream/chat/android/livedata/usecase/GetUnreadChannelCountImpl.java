package p015io.getstream.chat.android.livedata.usecase;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/GetUnreadChannelCountImpl;", "Lio/getstream/chat/android/livedata/usecase/GetUnreadChannelCount;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Landroidx/lifecycle/LiveData;", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.GetUnreadChannelCountImpl */
/* compiled from: GetUnreadChannelCountImpl.kt */
public final class GetUnreadChannelCountImpl implements GetUnreadChannelCount {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domainImpl;

    public GetUnreadChannelCountImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<LiveData<Integer>> invoke() {
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new GetUnreadChannelCountImpl$invoke$1(this, (Continuation) null));
    }
}
