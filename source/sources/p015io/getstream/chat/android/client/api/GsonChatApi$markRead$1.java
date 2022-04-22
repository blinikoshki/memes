package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.api.models.EventResponse;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/api/models/EventResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$markRead$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$markRead$1 extends Lambda implements Function1<EventResponse, Unit> {
    public static final GsonChatApi$markRead$1 INSTANCE = new GsonChatApi$markRead$1();

    GsonChatApi$markRead$1() {
        super(1);
    }

    public final void invoke(EventResponse eventResponse) {
        Intrinsics.checkNotNullParameter(eventResponse, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EventResponse) obj);
        return Unit.INSTANCE;
    }
}
