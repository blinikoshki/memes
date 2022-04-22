package p015io.getstream.chat.android.client.events;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ConnectingEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getCreatedAt", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ConnectingEvent */
/* compiled from: ChatEvent.kt */
public final class ConnectingEvent extends ChatEvent {
    private final Date createdAt;
    private final String type;

    public static /* synthetic */ ConnectingEvent copy$default(ConnectingEvent connectingEvent, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectingEvent.getType();
        }
        if ((i & 2) != 0) {
            date = connectingEvent.getCreatedAt();
        }
        return connectingEvent.copy(str, date);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final ConnectingEvent copy(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        return new ConnectingEvent(str, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectingEvent)) {
            return false;
        }
        ConnectingEvent connectingEvent = (ConnectingEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) connectingEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) connectingEvent.getCreatedAt());
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        if (createdAt2 != null) {
            i = createdAt2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ConnectingEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectingEvent(String str, Date date) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        this.type = str;
        this.createdAt = date;
    }
}
