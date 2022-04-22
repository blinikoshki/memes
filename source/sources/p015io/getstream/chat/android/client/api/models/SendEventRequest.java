package p015io.getstream.chat.android.client.api.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/SendEventRequest;", "", "event", "", "(Ljava/util/Map;)V", "getEvent", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.SendEventRequest */
/* compiled from: SendEventRequest.kt */
public final class SendEventRequest {
    private final Map<Object, Object> event;

    public static /* synthetic */ SendEventRequest copy$default(SendEventRequest sendEventRequest, Map<Object, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = sendEventRequest.event;
        }
        return sendEventRequest.copy(map);
    }

    public final Map<Object, Object> component1() {
        return this.event;
    }

    public final SendEventRequest copy(Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "event");
        return new SendEventRequest(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SendEventRequest) && Intrinsics.areEqual((Object) this.event, (Object) ((SendEventRequest) obj).event);
        }
        return true;
    }

    public int hashCode() {
        Map<Object, Object> map = this.event;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SendEventRequest(event=" + this.event + ")";
    }

    public SendEventRequest(Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "event");
        this.event = map;
    }

    public final Map<Object, Object> getEvent() {
        return this.event;
    }
}
