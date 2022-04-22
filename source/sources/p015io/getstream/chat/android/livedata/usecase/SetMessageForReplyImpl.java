package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SetMessageForReplyImpl;", "Lio/getstream/chat/android/livedata/usecase/SetMessageForReply;", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "cid", "", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SetMessageForReplyImpl */
/* compiled from: SetMessageForReply.kt */
public final class SetMessageForReplyImpl implements SetMessageForReply {
    private final ChatDomainImpl chatDomain;

    public SetMessageForReplyImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "chatDomain");
        this.chatDomain = chatDomainImpl;
    }

    public Call<Unit> invoke(String str, Message message) {
        Intrinsics.checkNotNullParameter(str, "cid");
        ValidationKt.validateCid(str);
        return new CoroutineCall<>(this.chatDomain.getScope$stream_chat_android_offline_release(), new SetMessageForReplyImpl$invoke$1(this.chatDomain.channel$stream_chat_android_offline_release(str), message, (Continuation) null));
    }
}
