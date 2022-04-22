package p015io.getstream.chat.android.livedata;

import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p015io.getstream.chat.android.client.models.TypingEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "p1", "Lio/getstream/chat/android/client/models/TypingEvent;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$addTypingChannel$1 */
/* compiled from: ChatDomainImpl.kt */
final /* synthetic */ class ChatDomainImpl$addTypingChannel$1 extends FunctionReferenceImpl implements Function1<TypingEvent, Unit> {
    ChatDomainImpl$addTypingChannel$1(MediatorLiveData mediatorLiveData) {
        super(1, mediatorLiveData, MediatorLiveData.class, "postValue", "postValue(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypingEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TypingEvent typingEvent) {
        ((MediatorLiveData) this.receiver).postValue(typingEvent);
    }
}
