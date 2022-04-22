package p015io.getstream.chat.android.livedata.usecase;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/LoadMessageByIdImpl;", "Lio/getstream/chat/android/livedata/usecase/LoadMessageById;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "cid", "", "messageId", "olderMessagesOffset", "", "newerMessagesOffset", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.LoadMessageByIdImpl */
/* compiled from: LoadMessageByIdImpl.kt */
public final class LoadMessageByIdImpl implements LoadMessageById {
    private final ChatDomainImpl domainImpl;

    public LoadMessageByIdImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<Message> invoke(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(str2, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        ValidationKt.validateCid(str);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new LoadMessageByIdImpl$invoke$1(this.domainImpl.channel$stream_chat_android_offline_release(str), str2, i2, i, (Continuation) null));
    }
}
