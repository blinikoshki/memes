package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.EventResponse;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/events/ChatEvent;", "it", "Lio/getstream/chat/android/client/api/models/EventResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$sendEvent$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$sendEvent$1 extends Lambda implements Function1<EventResponse, ChatEvent> {
    public static final GsonChatApi$sendEvent$1 INSTANCE = new GsonChatApi$sendEvent$1();

    GsonChatApi$sendEvent$1() {
        super(1);
    }

    public final ChatEvent invoke(EventResponse eventResponse) {
        Intrinsics.checkNotNullParameter(eventResponse, "it");
        return eventResponse.getEvent();
    }
}
