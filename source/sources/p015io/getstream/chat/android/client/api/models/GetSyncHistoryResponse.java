package p015io.getstream.chat.android.client.api.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/GetSyncHistoryResponse;", "", "events", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "(Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.GetSyncHistoryResponse */
/* compiled from: GetSyncHistoryResponse.kt */
public final class GetSyncHistoryResponse {
    private final List<ChatEvent> events;

    public static /* synthetic */ GetSyncHistoryResponse copy$default(GetSyncHistoryResponse getSyncHistoryResponse, List<ChatEvent> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getSyncHistoryResponse.events;
        }
        return getSyncHistoryResponse.copy(list);
    }

    public final List<ChatEvent> component1() {
        return this.events;
    }

    public final GetSyncHistoryResponse copy(List<? extends ChatEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        return new GetSyncHistoryResponse(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GetSyncHistoryResponse) && Intrinsics.areEqual((Object) this.events, (Object) ((GetSyncHistoryResponse) obj).events);
        }
        return true;
    }

    public int hashCode() {
        List<ChatEvent> list = this.events;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GetSyncHistoryResponse(events=" + this.events + ")";
    }

    public GetSyncHistoryResponse(List<? extends ChatEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        this.events = list;
    }

    public final List<ChatEvent> getEvents() {
        return this.events;
    }
}
