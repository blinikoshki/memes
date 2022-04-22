package p015io.getstream.chat.android.livedata.usecase;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/ShuffleGiphyImpl;", "Lio/getstream/chat/android/livedata/usecase/ShuffleGiphy;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "message", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.ShuffleGiphyImpl */
/* compiled from: ShuffleGiphyImpl.kt */
public final class ShuffleGiphyImpl implements ShuffleGiphy {
    private final ChatDomainImpl domainImpl;

    public ShuffleGiphyImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<Message> invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        String cid = message.getCid();
        ValidationKt.validateCid(cid);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new ShuffleGiphyImpl$invoke$1(this.domainImpl.channel$stream_chat_android_offline_release(cid), message, (Continuation) null));
    }
}
