package p015io.getstream.chat.android.client.utils.observable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/events/ChatEvent;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.observable.ChatObservableImpl$filter$1 */
/* compiled from: ChatObservableImpl.kt */
final class ChatObservableImpl$filter$1 extends Lambda implements Function1<ChatEvent, Boolean> {
    final /* synthetic */ String $eventType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatObservableImpl$filter$1(String str) {
        super(1);
        this.$eventType = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((ChatEvent) obj));
    }

    public final boolean invoke(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "it");
        return Intrinsics.areEqual((Object) chatEvent.getType(), (Object) this.$eventType);
    }
}
