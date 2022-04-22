package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/MarkAllReadImpl;", "Lio/getstream/chat/android/livedata/usecase/MarkAllRead;", "domain", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.MarkAllReadImpl */
/* compiled from: MarkAllReadImpl.kt */
public final class MarkAllReadImpl implements MarkAllRead {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domain;

    private final ChatDomainImpl component1() {
        return this.domain;
    }

    public static /* synthetic */ MarkAllReadImpl copy$default(MarkAllReadImpl markAllReadImpl, ChatDomainImpl chatDomainImpl, int i, Object obj) {
        if ((i & 1) != 0) {
            chatDomainImpl = markAllReadImpl.domain;
        }
        return markAllReadImpl.copy(chatDomainImpl);
    }

    public final MarkAllReadImpl copy(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domain");
        return new MarkAllReadImpl(chatDomainImpl);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MarkAllReadImpl) && Intrinsics.areEqual((Object) this.domain, (Object) ((MarkAllReadImpl) obj).domain);
        }
        return true;
    }

    public int hashCode() {
        ChatDomainImpl chatDomainImpl = this.domain;
        if (chatDomainImpl != null) {
            return chatDomainImpl.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MarkAllReadImpl(domain=" + this.domain + ")";
    }

    public MarkAllReadImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domain");
        this.domain = chatDomainImpl;
    }

    public Call<Boolean> invoke() {
        return new CoroutineCall<>(this.domain.getScope$stream_chat_android_offline_release(), new MarkAllReadImpl$invoke$1(this, (Continuation) null));
    }
}
