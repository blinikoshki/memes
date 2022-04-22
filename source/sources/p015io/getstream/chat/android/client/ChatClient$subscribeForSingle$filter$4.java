package p015io.getstream.chat.android.client;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "T", "Lio/getstream/chat/android/client/events/ChatEvent;", "event", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$subscribeForSingle$filter$4 */
/* compiled from: ChatClient.kt */
final class ChatClient$subscribeForSingle$filter$4 extends Lambda implements Function1<ChatEvent, Boolean> {
    final /* synthetic */ Class $eventType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatClient$subscribeForSingle$filter$4(Class cls) {
        super(1);
        this.$eventType = cls;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((ChatEvent) obj));
    }

    public final boolean invoke(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        return this.$eventType.isInstance(chatEvent);
    }
}
