package p015io.getstream.chat.android.client;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "T", "Lio/getstream/chat/android/client/events/ChatEvent;", "event", "onEvent"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ClientExtensionsKt$subscribeFor$2 */
/* compiled from: ClientExtensions.kt */
public final class ClientExtensionsKt$subscribeFor$2<EventT extends ChatEvent> implements ChatEventListener<ChatEvent> {
    final /* synthetic */ ChatEventListener $listener;

    public ClientExtensionsKt$subscribeFor$2(ChatEventListener chatEventListener) {
        this.$listener = chatEventListener;
    }

    public final void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        ChatEventListener chatEventListener = this.$listener;
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        chatEventListener.onEvent(chatEvent);
    }
}
