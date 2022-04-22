package p015io.getstream.chat.android.client.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/HealthEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "connectionId", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V", "getConnectionId", "()Ljava/lang/String;", "getCreatedAt", "()Ljava/util/Date;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.HealthEvent */
/* compiled from: ChatEvent.kt */
public final class HealthEvent extends ChatEvent {
    @SerializedName("connection_id")
    private final String connectionId;
    @SerializedName("created_at")
    private final Date createdAt;
    private final String type;

    public static /* synthetic */ HealthEvent copy$default(HealthEvent healthEvent, String str, Date date, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = healthEvent.getType();
        }
        if ((i & 2) != 0) {
            date = healthEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            str2 = healthEvent.connectionId;
        }
        return healthEvent.copy(str, date, str2);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final String component3() {
        return this.connectionId;
    }

    public final HealthEvent copy(String str, Date date, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        return new HealthEvent(str, date, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthEvent)) {
            return false;
        }
        HealthEvent healthEvent = (HealthEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) healthEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) healthEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.connectionId, (Object) healthEvent.connectionId);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        String str = this.connectionId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "HealthEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", connectionId=" + this.connectionId + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final String getConnectionId() {
        return this.connectionId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HealthEvent(String str, Date date, String str2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        this.type = str;
        this.createdAt = date;
        this.connectionId = str2;
    }
}
